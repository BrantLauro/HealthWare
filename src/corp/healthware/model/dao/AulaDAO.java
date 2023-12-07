package corp.healthware.model.dao;

import com.mysql.jdbc.Connection;
import corp.healthware.model.entity.Aluno;
import corp.healthware.model.entity.Aula;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AulaDAO implements DAO<Aula> {

    private Connection conn;

    public AulaDAO() throws SQLException {
        conn = (Connection) Singleton.getInstancia().getConexao();
    }

    @Override
    public int insert(Aula a) throws DAOexception {
        int linhasGravadas = 0;
        try {
            String iQuery = "INSERT INTO aula (cod_a,data_au,hora_au,descricao) VALUES (?,?,?,?)";

            PreparedStatement st = conn.prepareStatement(iQuery);
            st.setInt(1, a.getCod_a());
            st.setString(2, a.getData_au());
            st.setString(3, a.getHora_au());
            st.setString(4, a.getDescricao());

            linhasGravadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrada");
        } catch (SQLException e) {
            if (e.getSQLState().equals("22001")) {
                JOptionPane.showMessageDialog(null, "Digite uma data válida!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (e.getSQLState().equals("23000")) {
                JOptionPane.showMessageDialog(null, "O Aluno já realizou um aula nesta data!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else
                System.out.println(e.getSQLState() +" " + e.getMessage());
        }
        return linhasGravadas;
    }

    @Override
    public int update(Aula entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String uQuery = "UPDATE aula SET hora_au = ?, descricao = ?"
                    + "where cod_a = ? and cod_a = ? and data_au = ?";

            PreparedStatement st = conn.prepareStatement(uQuery);
            st.setString(1, entidade.getHora_au());
            st.setString(2, entidade.getDescricao());
            st.setInt(3, entidade.getCod_a());
            st.setString(5, entidade.getData_au());

            linhasAfetadas = st.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar atualizar entidade Aula. SQLSTATE: " + ex.getMessage());
        }

        return linhasAfetadas;
    }

    @Override
    public int delete(Aula entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String delQuery = "DELETE from aula WHERE cod_a";

            PreparedStatement st = conn.prepareStatement(delQuery);
            st.setInt(1, entidade.getCod_a());

            linhasAfetadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Aula Removida!");

        } catch (SQLException ex) {
            if (ex.getSQLState().equals("23000")) {
                JOptionPane.showMessageDialog(null, "A Aula tem requisições pendentes!", "Erro", JOptionPane.ERROR_MESSAGE);
                return linhasAfetadas;
            }
            throw new DAOexception("Erro ao tentar deletar entidade Aula SQLSTATE: " + ex.getSQLState());
        }

        return linhasAfetadas;
    }

    @Override
    public ArrayList<Aula> findAll() throws DAOexception {
        ArrayList<Aula> funcs = null;
        PreparedStatement st = null;

        try {
            String query = "SELECT * FROM aula";
            st = conn.prepareStatement(query);
            ResultSet res = st.executeQuery();
            if (res != null) {
                funcs = new ArrayList<>();

                while (res.next()) {

                    Aula func = new Aula();

                    func.setCod_a(res.getInt("cod_a"));
                    func.setData_au(res.getString("data_au"));
                    func.setHora_au(res.getString("hora_au"));
                    func.setDescricao(res.getString("descricao"));

                    funcs.add(func);

                }
            }
        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar encontrar todas Aulas: " + ex.getMessage());
        }

        return funcs;
    }

    @Override
    public Aula findOne(Aula entidade) throws DAOexception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Aula> findAll(Aluno a) throws DAOexception {
        ArrayList<Aula> funcs = null;
        PreparedStatement st = null;

        try {
            String query = "SELECT * FROM aula WHERE cod_a = ? ORDER BY data_au DESC";
            //System.out.println(a.getCod_a());
            st = conn.prepareStatement(query);
            st.setInt(1, a.getCod_a());
            ResultSet res = st.executeQuery();
            if (res != null) {
                funcs = new ArrayList<>();

                while (res.next()) {

                    Aula func = new Aula();

                    func.setCod_a(res.getInt("cod_a"));
                    func.setData_au(res.getString("data_au"));
                    func.setHora_au(res.getString("hora_au"));
                    func.setDescricao(res.getString("descricao"));

                    funcs.add(func);

                }
            }
        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar encontrar todas Aulas: " + ex.getMessage());
        }

        return funcs;
    }

    private static class DBSingleton {

        public DBSingleton() {
        }
    }
}
