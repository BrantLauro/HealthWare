/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corp.healthware.model.dao;

import com.mysql.jdbc.Connection;
import corp.healthware.model.entity.Entrada;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EntradaDAO implements DAO<Entrada>{
        private Connection conn;
    
    public EntradaDAO() throws SQLException {
        conn = (Connection) Singleton.getInstancia().getConexao();
    }

    @Override
    public int insert(Entrada a) throws DAOexception {
        int linhasGravadas = 0;
        try {
            String iQuery = "INSERT INTO entrada (cod_ent,data_ent,valor_ent,motivo_ent,resp_ent) VALUES (?,?,?,?,?)";

            PreparedStatement st = conn.prepareStatement(iQuery);
            st.setInt(1, a.getCod_ent());
            st.setString(2, a.getData_ent());
            st.setDouble(3, a.getValor_ent());
            st.setString(4, a.getMotivo_ent());
            st.setInt(5, a.getResp_ent());
            
            linhasGravadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado");
        } catch (SQLException e) {
            if (e.getSQLState().equals("23505") || e.getSQLState().equals("23000")) {
                int resultado = JOptionPane.showConfirmDialog(null, "Entrada já cadastrado, deseja atualizar?", "Erro", JOptionPane.ERROR_MESSAGE);

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
    public int update(Entrada entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String uQuery = "UPDATE aula SET data_ent = ?, valor_ent = ?, motivo_ent = ?, resp_ent = ?" + "where cod_ent = ?";

            PreparedStatement st = conn.prepareStatement(uQuery);
            st.setString(1, entidade.getData_ent());
            st.setDouble(2, entidade.getValor_ent());
            st.setString(3, entidade.getMotivo_ent());
            st.setInt(4, entidade.getResp_ent());
            st.setInt(5, entidade.getCod_ent());

            linhasAfetadas = st.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar atualizar entidade Entrada. SQLSTATE: " + ex.getMessage());
        }

        return linhasAfetadas;
    }

    @Override
    public int delete(Entrada entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String delQuery = "DELETE from entrada WHERE cod_ent = ?";

            PreparedStatement st = conn.prepareStatement(delQuery);
            st.setInt(1, entidade.getCod_ent());
            
            linhasAfetadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Entrada Removido!");

        } catch (SQLException ex) {
            if(ex.getSQLState().equals("23000")) {
                JOptionPane.showMessageDialog(null, "O Entrada tem requisições pendentes!", "Erro", JOptionPane.ERROR_MESSAGE);
                return linhasAfetadas;
            }
            throw new DAOexception("Erro ao tentar deletar entidade Entrada SQLSTATE: " + ex.getSQLState());
        }

        return linhasAfetadas;
    }

    @Override
    public ArrayList<Entrada> findAll() throws DAOexception {
        ArrayList<Entrada> funcs = null;
        PreparedStatement st = null;

        try {
            String query = "SELECT * FROM entrada";
            st = conn.prepareStatement(query);
            ResultSet res = st.executeQuery();
            if (res != null) {
                funcs = new ArrayList<>();

                while (res.next()) {

                    Entrada func = new Entrada();

                    func.setCod_ent(Integer.parseInt(res.getString("cod_ent")));
                    func.setData_ent(res.getString("data_ent"));
                    func.setValor_ent(res.getDouble("valor_ent"));
                    func.setMotivo_ent(res.getString("motivo_ent"));    
                    func.setResp_ent(res.getInt("resp_ent")); 
                    funcs.add(func);

                }
            }
        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar encontrar todas Entradas: " + ex.getMessage());
        }

        return funcs;
    }

    @Override
    public Entrada findOne(Entrada entidade) throws DAOexception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



    private static class DBSingleton {

        public DBSingleton() {
        }
    }
}