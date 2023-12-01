/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corp.healthware.model.dao;

import com.mysql.jdbc.Connection;
import corp.healthware.model.entity.RegistroServico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RegistroServicoDAO implements DAO<RegistroServico>{
        private Connection conn;
    
    public RegistroServicoDAO() throws SQLException {
        conn = (Connection) Singleton.getInstancia().getConexao();
    }

    @Override
    public int insert(RegistroServico a) throws DAOexception {
        int linhasGravadas = 0;
        try {
            String iQuery = "INSERT INTO registroservico (cod_c,data,hora,nome_cliente) VALUES (?,?,?,?)";

            PreparedStatement st = conn.prepareStatement(iQuery);
            st.setInt(1, a.getCod_s());
            st.setString(2, a.getData());
            st.setString(3, a.getHora());
            st.setString(4, a.getNome_cliente());
            
            linhasGravadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado");
        } catch (SQLException e) {
            if (e.getSQLState().equals("23505") || e.getSQLState().equals("23000")) {
                int resultado = JOptionPane.showConfirmDialog(null, "Registro do Servico já cadastrado, deseja atualizar?", "Erro", JOptionPane.ERROR_MESSAGE);

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
    public int update(RegistroServico entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String uQuery = "UPDATE aula SET nome_cliente = ?" + "where cod_s = ? and where data = ? and hora = ?";

            PreparedStatement st = conn.prepareStatement(uQuery);
            st.setString(1, entidade.getNome_cliente());  
            st.setInt(2, entidade.getCod_s());
            st.setString(3, entidade.getData());
            st.setString(4, entidade.getHora());


            linhasAfetadas = st.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar atualizar entidade RegistroServico. SQLSTATE: " + ex.getMessage());
        }

        return linhasAfetadas;
    }

    @Override
    public int delete(RegistroServico entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String delQuery = "DELETE from registroservico WHERE cod_s = ? and where data = ? and hora = ?";

            PreparedStatement st = conn.prepareStatement(delQuery);
            st.setInt(1, entidade.getCod_s());
            
            linhasAfetadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro de Servico Removido!");

        } catch (SQLException ex) {
            if(ex.getSQLState().equals("23000")) {
                JOptionPane.showMessageDialog(null, "O Registro de Servico tem requisições pendentes!", "Erro", JOptionPane.ERROR_MESSAGE);
                return linhasAfetadas;
            }
            throw new DAOexception("Erro ao tentar deletar entidade RegistroServico SQLSTATE: " + ex.getSQLState());
        }

        return linhasAfetadas;
    }

    @Override
    public ArrayList<RegistroServico> findAll() throws DAOexception {
        ArrayList<RegistroServico> funcs = null;
        PreparedStatement st = null;

        try {
            String query = "SELECT * FROM registroservico";
            st = conn.prepareStatement(query);
            ResultSet res = st.executeQuery();
            if (res != null) {
                funcs = new ArrayList<>();

                while (res.next()) {

                    RegistroServico func = new RegistroServico();

                    func.setCod_s(Integer.parseInt(res.getString("cod_s")));
                    func.setData(res.getString("data"));
                    func.setHora(res.getString("hora"));
                    func.setNome_cliente(res.getString("nome_cliente"));                    
                    funcs.add(func);

                }
            }
        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar encontrar todos Servicos: " + ex.getMessage());
        }

        return funcs;
    }

    @Override
    public RegistroServico findOne(RegistroServico entidade) throws DAOexception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static class DBSingleton {

        public DBSingleton() {
        }
    }
}