package corp.healthware.controller;

import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.entity.Aluno;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoController {

    public int insert(String nome_a, String data_nasc_a, int dia_pag, String obs, 
            int status, String tel_a, String obj, int modalidade, String endereco, String horario) throws DAOexception, SQLException {
        if (nome_a != null && endereco != null && data_nasc_a != null && dia_pag != -1 
                && status != -1 && tel_a != null && horario != null) {
            Aluno aluno = new Aluno(nome_a, data_nasc_a, dia_pag, obs, status, tel_a, obj, modalidade, endereco, horario);
            return aluno.cadastrarAluno(aluno);
        }
        return 0;
    }

    public int update(int cod_a, String data_nasc_a, int dia_pag, String obs, 
            int status, String tel_a, String obj, int modalidade, String endereco, String horario) throws DAOexception, SQLException {
        if (cod_a != -1 && endereco != null && data_nasc_a != null && dia_pag != -1 
                && status != -1 && tel_a != null && horario != null) {
            Aluno aluno = new Aluno(cod_a, data_nasc_a, dia_pag, obs, status, tel_a, obj, modalidade, endereco, horario);
            return aluno.updateAluno(aluno);
        }
        return 0;
    }

    public int delete(int cod_a) throws DAOexception, SQLException {
        if (cod_a != -1) {
            Aluno func = new Aluno(cod_a);
            return func.excluirAluno(func);
        }
        return 0;
    }

    public ArrayList<Aluno> findAll() throws DAOexception, SQLException {
        return new Aluno().findAllAluno();
    }
    
    public Aluno findOne(int cod_a) throws DAOexception, SQLException {
        Aluno aluno = new Aluno(cod_a);
        return aluno.findOneAluno(aluno);
    }
    
    public ArrayList<Aluno> search(String nome) throws DAOexception, SQLException {
        return new Aluno().searchAluno(nome);
    }
}
