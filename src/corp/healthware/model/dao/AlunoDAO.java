
package corp.healthware.model.dao;

import java.sql.*;
import com.mysql.jdbc.Connection;
import corp.healthware.model.entity.Aluno;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AlunoDAO implements DAO<Aluno>{
    
    private Connection conn;
    
    public AlunoDAO() throws SQLException {
        conn = (Connection) Singleton.getInstancia().getConexao();
    }

    public int insert(Aluno a) throws DAOexception {
        int linhasGravadas = 0;
        try {
            String iQuery = "INSERT INTO aluno (nome_a,cod_endereco,data_nasc_a,dia_pag,obs,status,tel_a,obj,horario) VALUES (?,?,?,?,?,?,?,?,?)";

            PreparedStatement st = conn.prepareStatement(iQuery);
            st.setString(1, a.getNome_a());
            st.setInt(2, a.getCod_endereco());
            st.setString(3, a.getData_nasc_a());
            st.setInt(4, a.getDia_pag());
            st.setString(5, a.getObs());
            st.setInt(6, a.getStatus());
            st.setString(7, a.getTel_a());
            st.setString(8, a.getObj());
            st.setString(9, a.getHorario());
            
            linhasGravadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Aluno Cadastrado com Sucesso");
        } catch (SQLException e) {
            if (e.getSQLState().equals("23505") || e.getSQLState().equals("23000")) {
                int resultado = JOptionPane.showConfirmDialog(null, "Aluno já cadastrado, deseja atualizar?", "Erro", JOptionPane.ERROR_MESSAGE);

                if(resultado == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Atualizado");
                    return update(a);
                }
                else return 0;
            }
            //System.out.println("sim" + e.getMessage());
        }
        return linhasGravadas;
    }

    @Override
    public int update(Aluno entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String uQuery = "UPDATE aluno SET nome_a = ?, cod_endereco = ?, data_nasc_a = ? , dia_pag = ?, obs = ?, status = ?, tel_a = ?, obj = ?, horario = ?"
                    + "where cod_a = ?";

            PreparedStatement st = conn.prepareStatement(uQuery);
            st.setString(1, entidade.getNome_a());
            st.setInt(2, entidade.getCod_endereco());
            st.setString(3, entidade.getData_nasc_a());
            st.setInt(4, entidade.getDia_pag());
            st.setString(5, entidade.getObs());
            st.setInt(6, entidade.getStatus());
            st.setString(7, entidade.getTel_a());
            st.setString(8, entidade.getObj());
            st.setString(9, entidade.getHorario());
            st.setInt(10, entidade.getCod_a());

            linhasAfetadas = st.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar atualizar entidade Aluno. SQLSTATE: " + ex.getMessage());
        }

        return linhasAfetadas;
    }

    @Override
    public int delete(Aluno entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String delQuery = "DELETE from aluno WHERE cod_a = ? ";

            PreparedStatement st = conn.prepareStatement(delQuery);
            st.setInt(1, entidade.getCod_a());

            linhasAfetadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Aluno Removido!");

        } catch (SQLException ex) {
            if(ex.getSQLState().equals("23000")) {
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
            String query = "SELECT * FROM aluno";
            st = conn.prepareStatement(query);
            ResultSet res = st.executeQuery();
            if (res != null) {
                funcs = new ArrayList<>();

                while (res.next()) {

                    Aluno func = new Aluno();

                    func.setCod_a(Integer.parseInt(res.getString("cod_a")));
                    func.setNome_a(res.getString("nome_a"));
                    func.setCod_endereco(res.getInt("cod_endereco"));
                    func.setData_nasc_a(res.getString("data_nasc_a"));
                    func.setDia_pag(res.getInt("dia_pag"));
                    func.setObs(res.getString("obs"));
                    func.setStatus(res.getInt("status"));
                    func.setTel_a(res.getString("tel_a"));
                    func.setObj(res.getString("obj"));
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
    public Aluno findOne(Aluno entidade) throws DAOexception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
