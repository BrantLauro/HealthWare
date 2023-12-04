
package corp.healthware.model.dao;

import com.mysql.jdbc.Connection;
import corp.healthware.model.entity.Endereco;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EnderecoDAO implements DAO<Endereco>{
    private Connection conn;
    
    public EnderecoDAO() throws SQLException {
        conn = (Connection) Singleton.getInstancia().getConexao();
    }

    @Override
    public int insert(Endereco a) throws DAOexception {
        int linhasGravadas = 0;
        try {
            String iQuery = "INSERT INTO endereco (cod_e,rua,numero,bairro,cidade) VALUES (?,?,?,?,?)";

            PreparedStatement st = conn.prepareStatement(iQuery);
            st.setInt(1, a.getCod_e());
            st.setString(2, a.getRua());
            st.setInt(3, a.getNumero());
            st.setString(4, a.getBairro());
            st.setString(5, a.getCidade());
            
            linhasGravadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado");
        } catch (SQLException e) {
            if (e.getSQLState().equals("23505") || e.getSQLState().equals("23000")) {
                int resultado = JOptionPane.showConfirmDialog(null, "Endereço já cadastrado, deseja atualizar?", "Erro", JOptionPane.ERROR_MESSAGE);

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
    public int update(Endereco entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String uQuery = "UPDATE aula SET rua = ?, numero = ?, bairro = ?, cidade = ?"
                    + "where cod_e = ?";

            PreparedStatement st = conn.prepareStatement(uQuery);
            st.setString(1, entidade.getRua());
            st.setInt(2, entidade.getNumero());
            st.setString(3, entidade.getBairro());
            st.setString(4, entidade.getCidade());
            st.setInt(5, entidade.getCod_e());

            linhasAfetadas = st.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar atualizar entidade Endereco. SQLSTATE: " + ex.getMessage());
        }

        return linhasAfetadas;
    }

    @Override
    public int delete(Endereco entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String delQuery = "DELETE from endereco WHERE cod_e = ?";

            PreparedStatement st = conn.prepareStatement(delQuery);
            st.setInt(1, entidade.getCod_e());
            
            linhasAfetadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Endereço Removida!");

        } catch (SQLException ex) {
            if(ex.getSQLState().equals("23000")) {
                JOptionPane.showMessageDialog(null, "O Endereço tem requisições pendentes!", "Erro", JOptionPane.ERROR_MESSAGE);
                return linhasAfetadas;
            }
            throw new DAOexception("Erro ao tentar deletar entidade Endereco SQLSTATE: " + ex.getSQLState());
        }

        return linhasAfetadas;
    }

    @Override
    public ArrayList<Endereco> findAll() throws DAOexception {
        ArrayList<Endereco> funcs = null;
        PreparedStatement st = null;

        try {
            String query = "SELECT * FROM endereco";
            st = conn.prepareStatement(query);
            ResultSet res = st.executeQuery();
            if (res != null) {
                funcs = new ArrayList<>();

                while (res.next()) {

                    Endereco func = new Endereco();

                    func.setCod_e(Integer.parseInt(res.getString("cod_e")));
                    func.setRua(res.getString("rua"));
                    func.setNumero(res.getInt("numero"));
                    func.setBairro(res.getString("bairro"));
                    func.setCidade(res.getString("cidade"));
                    
                    funcs.add(func);

                }
            }
        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar encontrar todos Endereços: " + ex.getMessage());
        }

        return funcs;
    }

    @Override
    public Endereco findOne(Endereco entidade) throws DAOexception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static class DBSingleton {

        public DBSingleton() {
        }
    }
}
