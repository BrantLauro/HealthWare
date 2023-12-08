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
            String iQuery = "INSERT INTO registro_servico (cod_rs,data_s,hora_s,nome_cliente) VALUES (?,?,?,?)";

            PreparedStatement st = conn.prepareStatement(iQuery);
            st.setInt(1, a.getCod_rs());
            st.setString(2, a.getData());
            st.setString(3, a.getHora());
            st.setString(4, a.getNome_cliente());
            
            linhasGravadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado");
        } catch (SQLException e) {
            /*if (e.getSQLState().equals("23505") || e.getSQLState().equals("23000")) {
                int resultado = JOptionPane.showConfirmDialog(null, "Registro do Servico já cadastrado, deseja atualizar?", "Erro", JOptionPane.ERROR_MESSAGE);

                if(resultado == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Atualizado");
                    return update(a);
                }
                else return 0;
            }*/
            System.out.println("sim" + e.getMessage());
        }
        return linhasGravadas;
    }

    @Override
    public int update(RegistroServico entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String uQuery = "UPDATE registro_servico SET nome_cliente = ? WHERE cod_rs = ? AND data_s = ? AND hora_s = ?";

        System.out.println("Executando Consulta SQL: " + uQuery);

        PreparedStatement st = conn.prepareStatement(uQuery);
        st.setString(1, entidade.getNome_cliente());
        st.setInt(2, entidade.getCod_rs());
        st.setString(3, entidade.getData());
        st.setString(4, entidade.getHora());

        linhasAfetadas = st.executeUpdate();

        System.out.println("Atualização deu certo" + linhasAfetadas);

    } catch (SQLException ex) {
        System.out.println("Erro durante a atualização: " + ex.getMessage());

        throw new DAOexception("Erro ao tentar atualizar entidade RegistroServico. SQLSTATE: " + ex.getMessage());
    }

        return linhasAfetadas;
    }

    @Override
    public int delete(RegistroServico entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String delQuery = "DELETE from registro_servico WHERE cod_rs = ? and data_s = ? and hora_s = ?";

            PreparedStatement st = conn.prepareStatement(delQuery);
            st.setInt(1, entidade.getCod_rs());
            st.setString(2, entidade.getData());
            st.setString(3, entidade.getHora());
            
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
            String query = "SELECT * FROM registro_servico";
            st = conn.prepareStatement(query);
            ResultSet res = st.executeQuery();
            if (res != null) {
                funcs = new ArrayList<>();

                while (res.next()) {

                    RegistroServico func = new RegistroServico();

                    func.setCod_s(Integer.parseInt(res.getString("cod_rs")));
                    func.setData(res.getString("data_s"));
                    func.setHora(res.getString("hora_s"));
                    func.setNome_cliente(res.getString("nome_cliente"));                    
                    funcs.add(func);

                }
            }
        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar encontrar todos Servicos: " + ex.getMessage());
        }

        return funcs;
    }
    
        public ArrayList<RegistroServico> findAll(RegistroServico rs) throws DAOexception {
        ArrayList<RegistroServico> funcs = null;
        PreparedStatement st = null;

        try {
            String query = "SELECT * FROM registro_servico WHERE cod_rs = ?";
            st = conn.prepareStatement(query);
            st.setInt(1, rs.getCod_rs());
            ResultSet res = st.executeQuery();
            if (res != null) {
                funcs = new ArrayList<>();

                while (res.next()) {

                    RegistroServico func = new RegistroServico();

                    func.setCod_s(Integer.parseInt(res.getString("cod_rs")));
                    func.setData(res.getString("data_s"));
                    func.setHora(res.getString("hora_s"));
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
    public RegistroServico findOne(RegistroServico r) throws DAOexception {
        try {
            String query = "SELECT cod_rs,data_s,hora_s,nome_cliente FROM registro_servico JOIN servico ON cod_rs = cod_s WHERE cod_s = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, r.getCod_rs());
            ResultSet res = st.executeQuery();
            res.next();
            RegistroServico func = new RegistroServico();
            func.setCod_s(Integer.parseInt(res.getString("cod_rs")));
            func.setData(res.getString("data_s"));
            func.setHora(res.getString("hora_s"));
            func.setNome_cliente(res.getString("nome_cliente"));
            if (res.getString("cod_rs") != null) {
                func.setCod_s(res.getInt("cod_rs"));
                
            } else {
                
                func.setCod_s(-1);
            }
            return func;
        } catch (SQLException ex) {
            System.out.println("sim" + ex.getMessage());
        }
        return null;
    }


    public ArrayList<RegistroServico> search(String pesquisa) throws DAOexception {
        ArrayList<RegistroServico> reg = null;
        PreparedStatement st = null;
        try {
            String query = "SELECT cod_rs, data_s, hora_s, nome_cliente FROM registro_servico JOIN servico ON cod_rs = cod_s WHERE nome_cliente LIKE '%" + pesquisa + "%' order by nome_cliente";

            st = conn.prepareStatement(query);
            ResultSet res = st.executeQuery();
            if (res != null) {
                reg = new ArrayList<>();
                while (res.next()) {
                    RegistroServico func = new RegistroServico();
                    func.setCod_s(Integer.parseInt(res.getString("cod_rs")));
                    func.setData(res.getString("data_s"));
                    func.setHora(res.getString("hora_s"));
                    func.setNome_cliente(res.getString("nome_cliente"));
                    if (res.getString("cod_rs") != null) {
                        func.setCod_s(res.getInt("cod_rs"));
                    } else {
                        func.setCod_s(-1);
                    }
                    reg.add(func);

                }
            }
        } catch (SQLException e) {
            throw new DAOexception("Erro ao tentar achar Registro : SQLState : " + e.getMessage());
        }
        return reg;
    }



    private static class DBSingleton {

        public DBSingleton() {
        }
    }
}