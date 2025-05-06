package corp.healthware.controller;

import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.entity.Colaborador;
import java.sql.SQLException;
import java.util.ArrayList;

public class ColaboradorController {

    public int insert(String nome_c, String tel_c, String data_nasc_c, String esp, String email, String senha) throws DAOexception, SQLException {
        if (nome_c != null && tel_c != null && data_nasc_c != null && esp != null && email != null && senha != null) {
            Colaborador colaborador = new Colaborador(nome_c, tel_c, data_nasc_c, esp, email, senha);
            return colaborador.cadastrarColaborador(colaborador);
        }
        return 0;
    }

    public int update(int cod_c, String tel_c, String data_nasc_c, String esp, String email, String senha, int adm) throws DAOexception, SQLException {
        if (cod_c != -1 && tel_c != null && data_nasc_c != null && esp != null && email != null && senha != null && adm != -1) {
            Colaborador colaborador = new Colaborador(cod_c, tel_c, data_nasc_c, esp, email, senha, adm);
            return colaborador.updateColaborador(colaborador);
        }
        return 0;
    }

    public int delete(int cod_c) throws DAOexception, SQLException {
        if (cod_c != -1) {
            Colaborador func = new Colaborador(cod_c);
            return func.excluirColaborador(func);
        }
        return 0;
    }

    public ArrayList<Colaborador> findAll() throws DAOexception, SQLException {
        return new Colaborador().findAllColaborador();
    }

    public Colaborador findOne(int cod_c) throws DAOexception, SQLException {
        Colaborador colab = new Colaborador(cod_c);
        return colab.findOneColab(colab);
    }

    public boolean login(String email, String senha) throws DAOexception, SQLException {
        if (email.isBlank() == false && email.isEmpty() == false) {
            Colaborador colab = new Colaborador(email, senha);
            return colab.logarColaborador(colab);
        } else {
            return false;
        }
    }

    public int getCod_cLogin(String email, String senha) throws DAOexception, SQLException {
        Colaborador colab = new Colaborador(email, senha);
        return colab.getCod_cLoginColab(colab);
    }
}
