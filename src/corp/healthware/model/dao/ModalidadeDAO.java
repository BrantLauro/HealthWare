package corp.healthware.model.dao;

import com.mysql.jdbc.Connection;
import corp.healthware.model.entity.Aluno;
import corp.healthware.model.entity.Modalidade;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ModalidadeDAO implements DAO<Modalidade> {

    private Connection conn;

    public ModalidadeDAO() throws SQLException {
        conn = (Connection) Singleton.getInstancia().getConexao();
    }

    @Override
    public int insert(Modalidade a) throws DAOexception {
        int linhasGravadas = 0;
        try {
            String iQuery = "INSERT INTO modalidade (resp,nome_m,vezes_semana,preco) VALUES (?,?,?,?)";

            PreparedStatement st = conn.prepareStatement(iQuery);
            st.setInt(1, a.getResp());
            st.setString(2, a.getNome_m());
            st.setInt(3, a.getVezes_semana());
            st.setDouble(4, a.getPreco());

            linhasGravadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modalidade cadastrada com Sucesso!");
        } catch (SQLException ex) {
            if (ex.getSQLState().equals("S1009")) {
                JOptionPane.showMessageDialog(null, "O preço deve ter no máximo 3 dígitos!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                throw new DAOexception("Erro ao tentar atualizar entidade Modalidade. SQLSTATE: " + ex.getSQLState());
            }
        }
        return linhasGravadas;
    }

    @Override
    public int update(Modalidade entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String uQuery = "UPDATE modalidade SET resp = ?, preco = ?"
                    + "where cod_m = ?";

            PreparedStatement st = conn.prepareStatement(uQuery);
            st.setInt(1, entidade.getResp());
            st.setDouble(2, entidade.getPreco());
            st.setInt(3, entidade.getCod_m());

            linhasAfetadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modalidade editada com sucesso!");

        } catch (SQLException ex) {
            if (ex.getSQLState().equals("S1009") || ex.getSQLState().equals("22001")) {
                JOptionPane.showMessageDialog(null, "O preço deve ter no máximo 3 dígitos!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                throw new DAOexception("Erro ao tentar atualizar entidade Modalidade. SQLSTATE: " + ex.getSQLState());
            }

        }

        return linhasAfetadas;
    }

    @Override
    public int delete(Modalidade entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String delQuery = "DELETE from modalidade WHERE cod_m = ?";
            String upQuery = "UPDATE aluno set modalidade = null WHERE modalidade = ?";

            PreparedStatement st2 = conn.prepareStatement(upQuery);
            PreparedStatement st = conn.prepareStatement(delQuery);

            st2.setInt(1, entidade.getCod_m());
            st.setInt(1, entidade.getCod_m());

            linhasAfetadas += st2.executeUpdate();
            linhasAfetadas += st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modalidade Removida!");

        } catch (SQLException ex) {
            if (ex.getSQLState().equals("23000")) {
                JOptionPane.showMessageDialog(null, "A Modalidade tem alunos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return linhasAfetadas;
            }
            throw new DAOexception("Erro ao tentar deletar entidade Modalidade SQLSTATE: " + ex.getMessage());
        }

        return linhasAfetadas;
    }

    @Override
    public ArrayList<Modalidade> findAll() throws DAOexception {
        ArrayList<Modalidade> funcs = null;
        PreparedStatement st = null;

        try {
            String query = "SELECT cod_m, resp, nome_c, nome_m, vezes_semana, preco FROM modalidade, colaborador WHERE (resp = cod_c  OR resp IS NULL) GROUP BY cod_m ORDER BY nome_m";
            st = conn.prepareStatement(query);
            ResultSet res = st.executeQuery();
            if (res != null) {
                funcs = new ArrayList<>();

                while (res.next()) {

                    Modalidade func = new Modalidade();

                    func.setCod_m(Integer.parseInt(res.getString("cod_m")));
                    func.setNomeResp(res.getString("nome_c"));
                    func.setNome_m(res.getString("nome_m"));
                    func.setVezes_semana(Integer.parseInt(res.getString("vezes_semana")));
                    func.setPreco(Double.parseDouble(res.getString("preco")));

                    if (res.getInt("resp") != 0) {
                        func.setResp(res.getInt("resp"));
                        func.setNomeResp(res.getString("nome_c"));
                    } else {
                        func.setNomeResp("Sem Responsável");
                        func.setResp(-1);
                    }

                    funcs.add(func);
                }
            }
        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar encontrar todas Modalidades: " + ex.getMessage());
        }

        return funcs;
    }

    @Override
    public Modalidade findOne(Modalidade a) throws DAOexception {
        try {
            String query = "SELECT cod_m, nome_m, resp, nome_c, vezes_semana, preco FROM modalidade, colaborador WHERE (resp = cod_c  OR resp IS NULL) AND cod_m = ? GROUP BY cod_m";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, a.getCod_m());
            ResultSet res = st.executeQuery();
            res.next();
            Modalidade mod = new Modalidade();
            mod.setCod_m(Integer.parseInt(res.getString("cod_m")));
            mod.setNome_m(res.getString("nome_m"));
            mod.setVezes_semana(res.getInt("vezes_semana"));
            mod.setPreco(res.getDouble("preco"));

            if (res.getInt("resp") != 0) {
                mod.setResp(res.getInt("resp"));
                mod.setNomeResp(res.getString("nome_c"));
            } else {
                mod.setNomeResp("Sem Responsável");
                mod.setResp(-1);
            }

            return mod;
        } catch (SQLException ex) {
            System.out.println("aqui" + ex.getMessage());
        }
        return null;
    }

    public ArrayList<Modalidade> search(String nome) throws DAOexception {
        ArrayList<Modalidade> mods = null;
        PreparedStatement st = null;
        try {
            String query = "SELECT cod_m, resp, nome_m, vezes_semana, preco, nome_c FROM modalidade, colaborador WHERE (resp = cod_c  OR resp IS NULL) AND nome_m LIKE '%" + nome + "%' GROUP BY cod_m ORDER BY nome_m";

            st = conn.prepareStatement(query);
            ResultSet res = st.executeQuery();
            if (res != null) {
                mods = new ArrayList<>();
                while (res.next()) {
                    Modalidade func = new Modalidade();
                    func.setCod_m(Integer.parseInt(res.getString("cod_m")));
                    func.setNome_m(res.getString("nome_m"));
                    func.setVezes_semana(Integer.parseInt(res.getString("vezes_semana")));
                    func.setPreco(Double.parseDouble(res.getString("preco")));
                    
                    if (res.getInt("resp") != 0) {
                        func.setResp(res.getInt("resp"));
                        func.setNomeResp(res.getString("nome_c"));
                    } else {
                        func.setNomeResp("Sem Responsável");
                        func.setResp(-1);
                    }
                    mods.add(func);

                }
            }
        } catch (SQLException e) {
            throw new DAOexception("Erro ao tentar achar modalidade : SQLState : " + e.getMessage());
        }
        return mods;
    }
}
