package corp.healthware.controller;

import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.entity.Aula;
import java.sql.SQLException;
import java.util.ArrayList;

public class AulaController {

    public int insert(int cod_a, String data_a, String hora_a, String descricao) throws DAOexception, SQLException {
        if (cod_a != -1 && data_a != null && hora_a != null && descricao != null) {
            Aula aula = new Aula(cod_a,data_a, hora_a, descricao);
            return aula.cadastrarAula(aula);
        }
        return 0;
    }

    public int update(int cod_a, String data_a, String hora_a, String descricao) throws DAOexception, SQLException {
        if (cod_a != -1 && data_a != null && hora_a != null && descricao != null) {
            Aula aula = new Aula(cod_a,data_a, hora_a, descricao);
            return aula.updateAula(aula);
        }
        return 0;
    }

    public int delete(int cod_a) throws DAOexception, SQLException {
        if (cod_a != -1) {
            Aula func = new Aula(cod_a);
            return func.excluirAula(func);
        }
        return 0;
    }

    public ArrayList<Aula> findAll() throws DAOexception, SQLException {
        return new Aula().findAllAula();
    }
}
