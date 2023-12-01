/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corp.healthware.model.dao;

import com.mysql.jdbc.Connection;
import corp.healthware.model.entity.Colaborador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ColaboradorDAO implements DAO<Colaborador>{
        private Connection conn;
    
    public ColaboradorDAO() throws SQLException {
        conn = (Connection) Singleton.getInstancia().getConexao();
    }

    @Override
    public int insert(Colaborador a) throws DAOexception {
        int linhasGravadas = 0;
        try {
            String iQuery = "INSERT INTO colaborador (cod_c,nome_c,tel_c,data_nasc_c,esp,email,senha,adm) VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement st = conn.prepareStatement(iQuery);
            st.setInt(1, a.getCod_c());
            st.setString(2, a.getNome_c());
            st.setString(3, a.getTel_c());
            st.setString(4, a.getData_nasc_c());
            st.setString(5, a.getEsp());
            st.setString(6, a.getEmail());
            st.setString(7, a.getSenha());
            st.setBoolean(8, a.getAdm());
            
            linhasGravadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado");
        } catch (SQLException e) {
            if (e.getSQLState().equals("23505") || e.getSQLState().equals("23000")) {
                int resultado = JOptionPane.showConfirmDialog(null, "Colaborador já cadastrado, deseja atualizar?", "Erro", JOptionPane.ERROR_MESSAGE);

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
    public int update(Colaborador entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String uQuery = "UPDATE aula SET nome_c = ?, tel_c = ?, data_nasc_c = ?, esp = ?, email = ?, senha = ?, adm = ?"
                    + "where cod_c = ?";

            PreparedStatement st = conn.prepareStatement(uQuery);
            st.setString(1, entidade.getNome_c());
            st.setString(2, entidade.getTel_c());
            st.setString(3, entidade.getData_nasc_c());
            st.setString(4, entidade.getEsp());
            st.setString(5, entidade.getEmail());
            st.setString(6, entidade.getSenha());
            st.setBoolean(7, entidade.getAdm());
            st.setInt(8, entidade.getCod_c());

            linhasAfetadas = st.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar atualizar entidade Colaborador. SQLSTATE: " + ex.getMessage());
        }

        return linhasAfetadas;
    }

    @Override
    public int delete(Colaborador entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String delQuery = "DELETE from colaborador WHERE cod_c = ?";

            PreparedStatement st = conn.prepareStatement(delQuery);
            st.setInt(1, entidade.getCod_c());
            
            linhasAfetadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Colaborador Removido!");

        } catch (SQLException ex) {
            if(ex.getSQLState().equals("23000")) {
                JOptionPane.showMessageDialog(null, "O Colaborador tem requisições pendentes!", "Erro", JOptionPane.ERROR_MESSAGE);
                return linhasAfetadas;
            }
            throw new DAOexception("Erro ao tentar deletar entidade Colaborador SQLSTATE: " + ex.getSQLState());
        }

        return linhasAfetadas;
    }

    @Override
    public ArrayList<Colaborador> findAll() throws DAOexception {
        ArrayList<Colaborador> funcs = null;
        PreparedStatement st = null;

        try {
            String query = "SELECT * FROM colaborador";
            st = conn.prepareStatement(query);
            ResultSet res = st.executeQuery();
            if (res != null) {
                funcs = new ArrayList<>();

                while (res.next()) {

                    Colaborador func = new Colaborador();

                    func.setCod_c(Integer.parseInt(res.getString("cod_c")));
                    func.setNome_c(res.getString("nome_c"));
                    func.setTel_c(res.getString("tel_c"));
                    func.setData_nasc_c(res.getString("data_nasc_c"));
                    func.setEsp(res.getString("esp"));
                    func.setEmail(res.getString("email"));
                    func.setSenha(res.getString("senha"));
                    func.setAdm(res.getBoolean("adm"));
                    
                    funcs.add(func);

                }
            }
        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar encontrar todos Colaboradores: " + ex.getMessage());
        }

        return funcs;
    }

    @Override
    public Colaborador findOne(Colaborador entidade) throws DAOexception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static class DBSingleton {

        public DBSingleton() {
        }
    }
}