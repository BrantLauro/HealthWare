
package corp.healthware.model.dao;

import com.mysql.jdbc.Connection;
import corp.healthware.model.entity.Modalidade;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ModalidadeDAO implements DAO<Modalidade>{
        private Connection conn;
    
    public ModalidadeDAO() throws SQLException {
        conn = (Connection) Singleton.getInstancia().getConexao();
    }

    @Override
    public int insert(Modalidade a) throws DAOexception {
        int linhasGravadas = 0;
        try {
            String iQuery = "INSERT INTO modalidade (resp,nome_m,vezes_semana,preco) VALUES (?,?,?,?,?)";

            PreparedStatement st = conn.prepareStatement(iQuery);
            st.setInt(2, a.getResp());
            st.setString(3, a.getNome_m());
            st.setInt(4, a.getVezes_semana());
            st.setDouble(5, a.getPreco());
            
            linhasGravadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado");
        } catch (SQLException e) {
            if (e.getSQLState().equals("23505") || e.getSQLState().equals("23000")) {
                int resultado = JOptionPane.showConfirmDialog(null, "Modalidade já cadastrada, deseja atualizar?", "Erro", JOptionPane.ERROR_MESSAGE);

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
    public int update(Modalidade entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String uQuery = "UPDATE modalidade SET resp = ?, nome_m = ?, vezes_semana = ?, preco = ?"
                    + "where cod_m = ?";

            PreparedStatement st = conn.prepareStatement(uQuery);
            st.setInt(1, entidade.getResp());
            st.setString(2, entidade.getNome_m());
            st.setInt(3, entidade.getVezes_semana());
            st.setDouble(4, entidade.getPreco());
            st.setInt(5, entidade.getCod_m());

            linhasAfetadas = st.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar atualizar entidade Modalidade. SQLSTATE: " + ex.getMessage());
        }

        return linhasAfetadas;
    }

    @Override
    public int delete(Modalidade entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String delQuery = "DELETE from modalidade WHERE cod_m = ?";

            PreparedStatement st = conn.prepareStatement(delQuery);
            st.setInt(1, entidade.getCod_m());
            
            linhasAfetadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modalidade Removida!");

        } catch (SQLException ex) {
            if(ex.getSQLState().equals("23000")) {
                JOptionPane.showMessageDialog(null, "A Modalidade tem requisições pendentes!", "Erro", JOptionPane.ERROR_MESSAGE);
                return linhasAfetadas;
            }
            throw new DAOexception("Erro ao tentar deletar entidade Modalidade SQLSTATE: " + ex.getSQLState());
        }

        return linhasAfetadas;
    }

    @Override
    public ArrayList<Modalidade> findAll() throws DAOexception {
        ArrayList<Modalidade> funcs = null;
        PreparedStatement st = null;

        try {
            String query = "SELECT * FROM modalidade";
            st = conn.prepareStatement(query);
            ResultSet res = st.executeQuery();
            if (res != null) {
                funcs = new ArrayList<>();

                while (res.next()) {

                    Modalidade func = new Modalidade();

                    func.setCod_m(Integer.parseInt(res.getString("cod_m")));
                    func.setResp(Integer.parseInt(res.getString("resp")));
                    func.setNome_m(res.getString("nome_m"));
                    func.setVezes_semana(Integer.parseInt(res.getString("vezes_semana")));
                    func.setPreco(Double.parseDouble(res.getString("preco")));
                    
                    funcs.add(func);

                }
            }
        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar encontrar todas Modalidades: " + ex.getMessage());
        }

        return funcs;
    }

    @Override
    public Modalidade findOne(Modalidade entidade) throws DAOexception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static class DBSingleton {

        public DBSingleton() {
        }
    }
}
