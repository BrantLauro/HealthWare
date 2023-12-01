package corp.healthware.model.dao;

import java.sql.*;
import com.mysql.jdbc.Connection;
import corp.healthware.model.entity.Aluno;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AlunoDAO implements DAO<Aluno> {

    private Connection conn;

    public AlunoDAO() throws SQLException {
        conn = (Connection) Singleton.getInstancia().getConexao();
    }

    public int insert(Aluno a) throws DAOexception {
        int linhasGravadas = 0;
        try {
            String iQuery = "INSERT INTO aluno (nome_a,data_nasc_a,dia_pag,obs,status,tel_a,obj,modalidade,endereco,horario) VALUES (?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement st = conn.prepareStatement(iQuery);
            st.setString(1, a.getNome_a());
            st.setString(2, a.getData_nasc_a());
            st.setInt(3, a.getDia_pag());
            st.setString(4, a.getObs());
            st.setInt(5, a.getStatus());
            st.setString(6, a.getTel_a());
            st.setString(7, a.getObj());
            st.setInt(8, a.getModalidade());
            st.setString(9, a.getEndereco());
            st.setString(10, a.getHorario());

            linhasGravadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Aluno Cadastrado com Sucesso");
        } catch (SQLException e) {
//        if (e.getSQLState().equals("23505") || e.getSQLState().equals("23000")) {
//                int resultado = JOptionPane.showConfirmDialog(null, "Aluno já cadastrado, deseja atualizar?", "Erro", JOptionPane.ERROR_MESSAGE);
//
//                if(resultado == JOptionPane.YES_OPTION) {
//                    JOptionPane.showMessageDialog(null, "Atualizado");
//                    return update(a);
//                }
//                else return 0;
//           }
            if (e.getSQLState().equals("22001")) {
                JOptionPane.showMessageDialog(null, "Digite uma data válida!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
//            System.out.println("sim" + e.getMessage());
        }
        return linhasGravadas;
    }

    @Override
    public int update(Aluno a) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String uQuery = "UPDATE aluno SET status = ?, data_nasc_a = ?, tel_a = ?, modalidade = ?, horario = ? , endereco = ?, obj = ?, dia_pag = ?, obs = ?"
                    + "where cod_a = ?";

            PreparedStatement st = conn.prepareStatement(uQuery);
            st.setInt(1, a.getStatus());
            st.setString(2, a.getData_nasc_a());
            st.setString(3, a.getTel_a());
            st.setInt(4, a.getModalidade());
            st.setString(5, a.getHorario());
            st.setString(6, a.getEndereco());
            st.setString(7, a.getObj());
            st.setInt(8, a.getDia_pag());
            st.setString(9, a.getObs());
            linhasAfetadas = st.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar atualizar entidade Aluno. SQLSTATE: " + ex.getMessage());
        }

        return linhasAfetadas;
    }

    @Override
    public int delete(Aluno a) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String delQuery = "DELETE from aluno WHERE cod_a = ? ";
            String delQueryAulas = "DELETE from aulas WHERE cod_a = ? ";

            PreparedStatement st = conn.prepareStatement(delQuery);
            PreparedStatement stAulas = conn.prepareStatement(delQueryAulas);
            st.setInt(1, a.getCod_a());
            stAulas.setInt(1, a.getCod_a());

            linhasAfetadas += stAulas.executeUpdate();
            linhasAfetadas += st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Aluno Removido!");

        } catch (SQLException ex) {
            if (ex.getSQLState().equals("23000")) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar deletar entidade Aluno", "Erro", JOptionPane.ERROR_MESSAGE);
                return linhasAfetadas;
            }
            throw new DAOexception("Erro ao tentar deletar entidade Aluno SQLSTATE: " + ex.getSQLState());
        }

        return linhasAfetadas;
    }

    @Override
    public ArrayList<Aluno> findAll() throws DAOexception {
        ArrayList<Aluno> funcs = null;
        PreparedStatement st = null;

        try {
            String query = "SELECT cod_a, nome_a, data_nasc_a, dia_pag, obs, status, tel_a, obj, nome_m, endereco, horario FROM aluno JOIN modalidade ON modalidade = cod_m";
            st = conn.prepareStatement(query);
            ResultSet res = st.executeQuery();
            if (res != null) {
                funcs = new ArrayList<>();

                while (res.next()) {

                    Aluno func = new Aluno();

                    func.setCod_a(Integer.parseInt(res.getString("cod_a")));
                    func.setNome_a(res.getString("nome_a"));
                    func.setData_nasc_a(res.getString("data_nasc_a"));
                    func.setDia_pag(res.getInt("dia_pag"));
                    func.setObs(res.getString("obs"));
                    func.setStatus(res.getInt("status"));
                    func.setTel_a(res.getString("tel_a"));
                    func.setObj(res.getString("obj"));
                    func.setNomeModalidade(res.getString("nome_m"));
                    func.setEndereco(res.getString("endereco"));
                    func.setHorario(res.getString("horario"));

                    funcs.add(func);

                }
            }
        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar encontrar todos Alunos: " + ex.getMessage());
        }

        return funcs;
    }

    @Override
    public Aluno findOne(Aluno a) throws DAOexception {
        try {
            String query = "SELECT * FROM aluno WHERE cod_a = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, a.getCod_a());
            ResultSet res = st.executeQuery();
            res.next();
            Aluno func = new Aluno();
            func.setCod_a(Integer.parseInt(res.getString("cod_a")));
            func.setNome_a(res.getString("nome_a"));
            func.setData_nasc_a(res.getString("data_nasc_a"));
            func.setDia_pag(res.getInt("dia_pag"));
            func.setObs(res.getString("obs"));
            func.setStatus(res.getInt("status"));
            func.setTel_a(res.getString("tel_a"));
            func.setObj(res.getString("obj"));
            func.setModalidade(res.getInt("modalidade"));
            func.setEndereco(res.getString("endereco"));
            func.setHorario(res.getString("horario"));
            return func;
        } catch (SQLException ex) {
            System.out.println("sim" + ex.getMessage());
        }
        return null;
    }
}
