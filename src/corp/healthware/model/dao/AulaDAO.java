
package corp.healthware.model.dao;

import com.mysql.jdbc.Connection;
import corp.healthware.model.entity.Aula;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AulaDAO implements DAO<Aula>{
    private Connection conn;
    
    public AulaDAO() throws SQLException {
        conn = (Connection) Singleton.getInstancia().getConexao();
    }

    @Override
    public int insert(Aula a) throws DAOexception {
        int linhasGravadas = 0;
        try {
            String iQuery = "INSERT INTO aluno (cod_m,cod_a,data_a,hora_a,descricao) VALUES (?,?,?,?,?)";

            PreparedStatement st = conn.prepareStatement(iQuery);
            st.setInt(1, a.getCod_m());
            st.setInt(2, a.getCod_a());
            st.setString(3, a.getData_a());
            st.setString(4, a.getHora_a());
            st.setString(5, a.getDescricao());
            
            linhasGravadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado");
        } catch (SQLException e) {
            if (e.getSQLState().equals("23505") || e.getSQLState().equals("23000")) {
                int resultado = JOptionPane.showConfirmDialog(null, "Aula já cadastrado, deseja atualizar?", "Erro", JOptionPane.ERROR_MESSAGE);

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
    public int update(Aula entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String uQuery = "UPDATE aula SET hora_a = ?, descricao = ?"
                    + "where cod_m = ? and cod_a = ? and data_a = ?";

            PreparedStatement st = conn.prepareStatement(uQuery);
            st.setString(1, entidade.getHora_a());
            st.setString(2, entidade.getDescricao());
            st.setInt(3, entidade.getCod_m());
            st.setInt(4, entidade.getCod_a());
            st.setString(5, entidade.getData_a());

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
            String delQuery = "DELETE from aula WHERE cod_m = ? and cod_a = ?";

            PreparedStatement st = conn.prepareStatement(delQuery);
            st.setInt(1, entidade.getCod_m());
            st.setInt(2, entidade.getCod_a());
            
            linhasAfetadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Aula Removida!");

        } catch (SQLException ex) {
            if(ex.getSQLState().equals("23000")) {
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

                    func.setCod_a(Integer.parseInt(res.getString("id")));
                    func.setCod_m(res.getInt("cod_m"));
                    func.setCod_a(res.getInt("cod_a"));
                    func.setData_a(res.getString("data_a"));
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

    private static class DBSingleton {

        public DBSingleton() {
        }
    }
}