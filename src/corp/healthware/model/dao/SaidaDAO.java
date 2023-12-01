/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corp.healthware.model.dao;

import com.mysql.jdbc.Connection;
import corp.healthware.model.entity.Saida;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SaidaDAO implements DAO<Saida>{
        private Connection conn;
    
    public SaidaDAO() throws SQLException {
        conn = (Connection) Singleton.getInstancia().getConexao();
    }

    @Override
    public int insert(Saida a) throws DAOexception {
        int linhasGravadas = 0;
        try {
            String iQuery = "INSERT INTO saida (cod_saida,data_saida,valor_saida,motivo_saida,resp_saida) VALUES (?,?,?,?,?)";

            PreparedStatement st = conn.prepareStatement(iQuery);
            st.setInt(1, a.getCod_saida());
            st.setString(2, a.getData_saida());
            st.setDouble(3, a.getValor_saida());
            st.setString(4, a.getMotivo_saida());
            st.setInt(5, a.getResp_saida());
            
            linhasGravadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado");
        } catch (SQLException e) {
            if (e.getSQLState().equals("23505") || e.getSQLState().equals("23000")) {
                int resultado = JOptionPane.showConfirmDialog(null, "Saida já cadastrado, deseja atualizar?", "Erro", JOptionPane.ERROR_MESSAGE);

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
    public int update(Saida entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String uQuery = "UPDATE aula SET data_saida = ?, valor_saida = ?, motivo_saida = ?, resp_saida = ?" + "where cod_saida = ?";

            PreparedStatement st = conn.prepareStatement(uQuery);
            st.setString(1, entidade.getData_saida());
            st.setDouble(2, entidade.getValor_saida());
            st.setString(3, entidade.getMotivo_saida());
            st.setInt(4, entidade.getResp_saida());
            st.setInt(5, entidade.getCod_saida());

            linhasAfetadas = st.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar atualizar entidade Saida. SQLSTATE: " + ex.getMessage());
        }

        return linhasAfetadas;
    }

    @Override
    public int delete(Saida entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String delQuery = "DELETE from saida WHERE cod_ent = ?";

            PreparedStatement st = conn.prepareStatement(delQuery);
            st.setInt(1, entidade.getCod_saida());
            
            linhasAfetadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saida Removido!");

        } catch (SQLException ex) {
            if(ex.getSQLState().equals("23000")) {
                JOptionPane.showMessageDialog(null, "O Saida tem requisições pendentes!", "Erro", JOptionPane.ERROR_MESSAGE);
                return linhasAfetadas;
            }
            throw new DAOexception("Erro ao tentar deletar entidade Saida SQLSTATE: " + ex.getSQLState());
        }

        return linhasAfetadas;
    }

    @Override
    public ArrayList<Saida> findAll() throws DAOexception {
        ArrayList<Saida> funcs = null;
        PreparedStatement st = null;

        try {
            String query = "SELECT * FROM saida";
            st = conn.prepareStatement(query);
            ResultSet res = st.executeQuery();
            if (res != null) {
                funcs = new ArrayList<>();

                while (res.next()) {

                    Saida func = new Saida();

                    func.setCod_saida(Integer.parseInt(res.getString("cod_saida")));
                    func.setData_saida(res.getString("data_saida"));
                    func.setValor_saida(res.getDouble("valor_saida"));
                    func.setMotivo_saida(res.getString("motivo_saida"));    
                    func.setResp_saida(res.getInt("resp_saida")); 
                    funcs.add(func);

                }
            }
        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar encontrar todas Saidas: " + ex.getMessage());
        }

        return funcs;
    }

    @Override
    public Saida findOne(Saida entidade) throws DAOexception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static class DBSingleton {

        public DBSingleton() {
        }
    }
}