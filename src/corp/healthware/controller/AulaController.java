/*package corp.healthware.controller;

import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.entity.Aula;
import java.sql.SQLException;
import java.util.ArrayList;

public class AulaController {

    public int insert(String nome_a, int cod_endereco, String data_nasc_a, int dia_pag, String obs, 
            int status, String tel_a, String obj, String horario) throws DAOexception, SQLException {
        if (nome_a != null && cod_endereco != -1 && data_nasc_a != null && dia_pag != -1 
                && status != -1 && tel_a != null && horario != null) {
            Aula aluno = new Aula(nome_a, cod_endereco, data_nasc_a, dia_pag, obs, status, tel_a, obj, horario);
            return aluno.cadastrarAula(aluno);
        }
        return 0;
    }

    public int update(int cod_a, String nome_a, int cod_endereco, String data_nasc_a, int dia_pag, String obs, 
            int status, String tel_a, String obj, String horario) throws DAOexception, SQLException {
        if (cod_a != -1 && nome_a != null && cod_endereco != -1 && data_nasc_a != null && dia_pag != -1 
                && status != -1 && tel_a != null && horario != null) {
            Aula aluno = new Aula(cod_a, nome_a, cod_endereco, data_nasc_a, dia_pag, obs, status, tel_a, obj, horario);
            return aluno.updateAula(aluno);
        }
        return 0;
    }

    public int delete(int cod_a) throws DAOexception, SQLException {
        if (cod_a != -1) {
            Aula func = new Aula(cod_a);
            return func.excluirAluno(func);
        }
        return 0;
    }

    public ArrayList<Aula> findAll() throws DAOexception, SQLException {
        return new Aula().findAllAula();
    }
}*/
