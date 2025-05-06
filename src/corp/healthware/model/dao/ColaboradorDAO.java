package corp.healthware.model.dao;

import com.mysql.jdbc.Connection;
import corp.healthware.model.entity.Colaborador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ColaboradorDAO implements DAO<Colaborador> {

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
            st.setBoolean(8, false);

            linhasGravadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Colaborador Cadastrado com Sucesso!");
        } catch (SQLException e) {
            if (e.getSQLState().equals("22001")) {
                JOptionPane.showMessageDialog(null, "Digite uma data válida!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                System.out.println("sim" + e.getMessage());
            }
        }
        return linhasGravadas;
    }

    @Override
    public int update(Colaborador entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String uQuery = "UPDATE colaborador SET tel_c = ?, data_nasc_c = ?, esp = ?, email = ?, senha = ?, adm = ? where cod_c = ?";

            PreparedStatement st = conn.prepareStatement(uQuery);
            st.setString(1, entidade.getTel_c());
            st.setString(2, entidade.getData_nasc_c());
            st.setString(3, entidade.getEsp());
            st.setString(4, entidade.getEmail());
            st.setString(5, entidade.getSenha());
            st.setInt(6, entidade.getAdm());
            st.setInt(7, entidade.getCod_c());

            linhasAfetadas = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Colaborador editado com Sucesso!");
        } catch (SQLException ex) {
            if (ex.getSQLState().equals("22001")) {
                JOptionPane.showMessageDialog(null, "Digite uma data válida!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                System.out.println("sim" + ex.getMessage());
            }
        }

        return linhasAfetadas;
    }

    @Override
    public int delete(Colaborador entidade) throws DAOexception {
        int linhasAfetadas = 0;

        try {
            String delQuery = "DELETE from colaborador WHERE cod_c = ?";
            String upQueryMods = "UPDATE modalidade SET resp = null WHERE resp = ?";

            PreparedStatement stMods = conn.prepareStatement(upQueryMods);
            PreparedStatement st = conn.prepareStatement(delQuery);

            stMods.setInt(1, entidade.getCod_c());
            st.setInt(1, entidade.getCod_c());

            linhasAfetadas += stMods.executeUpdate();
            linhasAfetadas += st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Colaborador Removido!");

        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar deletar entidade Colaborador SQLSTATE: " + ex.getSQLState() + " " + ex.getMessage());
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
        try {
            String query = "SELECT * FROM colaborador WHERE cod_c = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, entidade.getCod_c());
            ResultSet res = st.executeQuery();

            res.next();

            Colaborador func = new Colaborador();

            func.setCod_c(Integer.parseInt(res.getString("cod_c")));
            func.setNome_c(res.getString("nome_c"));
            func.setTel_c(res.getString("tel_c"));
            func.setData_nasc_c(res.getString("data_nasc_c"));
            func.setEsp(res.getString("esp"));
            func.setEmail(res.getString("email"));
            func.setSenha(res.getString("senha"));
            func.setAdm(res.getInt("adm"));
            return func;

        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar encontrar todos Colaboradores: " + ex.getMessage());
        }
    }

    public boolean login(Colaborador entidade) throws DAOexception {
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM colaborador WHERE email = ? AND senha = ?");
            st.setString(1, entidade.getEmail());
            st.setString(2, entidade.getSenha());
            ResultSet res = st.executeQuery();
            if (res.next()) {
                String emailTemp = res.getString("email");
                String senhaTemp = res.getString("senha");

                if (senhaTemp.equals(entidade.getSenha()) && emailTemp.equals(entidade.getEmail())) {
                    return true;
                }
            }
            return false;
        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar logar Adm na ADMdao : SQLState : " + ex.getSQLState());
        }
    }
    
    public int getCod_cLogin(Colaborador entidade) throws DAOexception {
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM colaborador WHERE email = ? AND senha = ?");
            st.setString(1, entidade.getEmail());
            st.setString(2, entidade.getSenha());
            ResultSet res = st.executeQuery();
            if (res.next()) {
                String emailTemp = res.getString("email");
                String senhaTemp = res.getString("senha");

                if (senhaTemp.equals(entidade.getSenha()) && emailTemp.equals(entidade.getEmail())) {
                    return res.getInt("cod_c");
                }
            }
            return -1;
        } catch (SQLException ex) {
            throw new DAOexception("Erro ao tentar logar Adm na ADMdao : SQLState : " + ex.getSQLState());
        }
    }
}
