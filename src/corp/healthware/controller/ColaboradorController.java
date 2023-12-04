
package corp.healthware.controller;

import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.entity.Colaborador;
import java.sql.SQLException;
import java.util.ArrayList;

public class ColaboradorController {
    
    public int insert(String nome_c, String tel_c, String data_nasc_c, String esp, String email, String senha, boolean adm) throws DAOexception, SQLException {
        if (nome_c != null && tel_c != null && data_nasc_c != null && esp != null && email != null && senha != null && adm != false) {
            Colaborador colaborador = new Colaborador(nome_c, tel_c, data_nasc_c, esp, email, senha, adm);
            return colaborador.cadastrarColaborador(colaborador);
        }
        return 0;
    }

    public int update(String nome_c, String tel_c, String data_nasc_c, String esp, String email, String senha, boolean adm) throws DAOexception, SQLException {
        if (nome_c != null && tel_c != null && data_nasc_c != null && esp != null && email != null && senha != null && adm != false) {
            Colaborador colaborador = new Colaborador(nome_c, tel_c, data_nasc_c, esp, email, senha, adm);
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
}
