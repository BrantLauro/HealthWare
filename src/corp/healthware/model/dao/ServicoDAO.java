/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corp.healthware.model.dao;

import com.mysql.jdbc.Connection;
import corp.healthware.model.entity.Servico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ServicoDAO implements DAO<Servico>{
        private Connection conn;
    
    public ServicoDAO() throws SQLException {
        conn = (Connection) Singleton.getInstancia().getConexao();
    }

    @Override
    public int insert(Servico a) throws DAOexception {
        int linhasGravadas = 0;
        try {
            String iQuery = "INSERT INTO servico (cod_s,nome_s,preco,resp) VALUES (?,?,?,?)";

            PreparedStatement st = conn.prepareStatement(iQuery);
            st.setString(2, a.getNome_s());
            st.setDouble(3, a.getPreco());
            st.setInt(4, a.getResp());
            st.setInt(1, a.getCod_s());
            
            linhasGravadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado");
        } catch (SQLException e) {
            if (e.getSQLState().equals("23505") || e.getSQLState().equals("23000")) {
                int resultado = JOptionPane.showConfirmDialog(null, "Servico já cadastrado, deseja atualizar?", "Erro", JOptionPane.ERROR_MESSAGE);

                if(resultado == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Atualizado");
                    return update(a);
                }
                else return 0;
            }
            System.out.println("sim" + e.getMessage());
        }
        return linhasGravadas;
    }

    @Override
    public int update(Servico entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String uQuery = "UPDATE aula SET nome_s = ?, preco = ?, resp = ?" + "where cod_s = ?";

            PreparedStatement st = conn.prepareStatement(uQuery);
            st.setString(1, entidade.getNome_s());
            st.setDouble(2, entidade.getPreco());
            st.setInt(3, entidade.getResp());
            st.setInt(4, entidade.getCod_s());

            linhasAfetadas = st.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar atualizar entidade Servico. SQLSTATE: " + ex.getMessage());
        }

        return linhasAfetadas;
    }

    @Override
    public int delete(Servico entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String delQuery = "DELETE from servico WHERE cod_s = ?";

            PreparedStatement st = conn.prepareStatement(delQuery);
            st.setInt(1, entidade.getCod_s());
            
            linhasAfetadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Servico Removido!");

        } catch (SQLException ex) {
            if(ex.getSQLState().equals("23000")) {
                JOptionPane.showMessageDialog(null, "O Servico tem requisições pendentes!", "Erro", JOptionPane.ERROR_MESSAGE);
                return linhasAfetadas;
            }
            throw new DAOexception("Erro ao tentar deletar entidade Servico SQLSTATE: " + ex.getSQLState());
        }

        return linhasAfetadas;
    }

    @Override
    public ArrayList<Servico> findAll() throws DAOexception {
        ArrayList<Servico> funcs = null;
        PreparedStatement st = null;

        try {
            String query = "SELECT * FROM servico";
            st = conn.prepareStatement(query);
            ResultSet res = st.executeQuery();
            if (res != null) {
                funcs = new ArrayList<>();

                while (res.next()) {

                    Servico func = new Servico();

                    func.setCod_s(Integer.parseInt(res.getString("cod_s")));
                    func.setNome_s(res.getString("nome_s"));
                    func.setPreco(res.getDouble("preco"));
                    func.setResp(res.getInt("resp"));                    
                    funcs.add(func);

                }
            }
        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar encontrar todos Servicos: " + ex.getMessage());
        }

        return funcs;
    }

    @Override
    public Servico findOne(Servico s) throws DAOexception {
        try {
            String query = "SELECT cod_s, nome_s, preco, resp FROM servico JOIN colaborador ON colaborador = cod_c WHERE cod_s = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, s.getCod_s());
            ResultSet res = st.executeQuery();
            res.next();
            Servico func = new Servico();
            func.setCod_s(Integer.parseInt(res.getString("cod_s")));
            func.setNome_s(res.getString("nome_s"));
            func.setPreco(res.getDouble("preco"));
            func.setResp(Integer.parseInt(res.getString("resp")));
            if (res.getString("colaborador") != null) {
                func.setResp(res.getInt("colaborador"));
                
            } else {
                
                func.setResp(-1);
            }
            return func;
        } catch (SQLException ex) {
            System.out.println("sim" + ex.getMessage());
        }
        return null;
    }

    public ArrayList<Servico> search(String nome) throws DAOexception {
        ArrayList<Servico> servicos = null;
        PreparedStatement st = null;
        try {
            String query = "SELECT cod_s, nome_s, preco, resp FROM servico JOIN colaborador ON colaborador = cod_c WHERE nome_s LIKE '%" + nome + "%' order by nome_s";

            st = conn.prepareStatement(query);
            ResultSet res = st.executeQuery();
            if (res != null) {
                servicos = new ArrayList<>();
                while (res.next()) {
                    Servico func = new Servico();
                    func.setCod_s(Integer.parseInt(res.getString("cod_s")));
                    func.setNome_s(res.getString("nome_s"));
                    func.setPreco(res.getDouble("preco"));
                    func.setResp(Integer.parseInt(res.getString("resp")));
                    if (res.getString("modalidade") != null) {
                        func.setResp(res.getInt("modalidade"));
                    } else {
                        func.setResp(-1);
                    }
                    servicos.add(func);

                }
            }
        } catch (SQLException e) {
            throw new DAOexception("Erro ao tentar achar Aluno : SQLState : " + e.getMessage());
        }
        return servicos;
    }

    private static class DBSingleton {

        public DBSingleton() {
        }
    }
}