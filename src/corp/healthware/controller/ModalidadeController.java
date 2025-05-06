package corp.healthware.controller;

import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.entity.Aluno;
import corp.healthware.model.entity.Modalidade;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModalidadeController {

    public int insert(int resp, String nome_m, int vezes_semana, double preco) throws DAOexception, SQLException {
        if (resp != -1 && nome_m != null && vezes_semana != -1 && preco != -1) {
            Modalidade modalidade = new Modalidade(resp, nome_m, vezes_semana, preco);
            return modalidade.cadastrarModalidade(modalidade);
        }
        return 0;
    }

    public int update(int cod_m, int resp, double preco) throws DAOexception, SQLException {
        if (cod_m != -1 && resp != -1 && preco != -1) {
            Modalidade modalidade = new Modalidade(cod_m, resp, preco);
            return modalidade.updateModalidade(modalidade);
        }
        return 0;
    }

    public int delete(int cod_m) throws DAOexception, SQLException {
        if (cod_m != -1) {
            Modalidade func = new Modalidade(cod_m);
            return func.excluirModalidade(func);
        }
        return 0;
    }
    
    public Modalidade findOne(int cod_m) throws DAOexception, SQLException {
        Modalidade mod = new Modalidade(cod_m);
        return mod.findOneModalidade(mod);
    }

    public ArrayList<Modalidade> findAll() throws DAOexception, SQLException {
        return new Modalidade().findAllModalidade();
    }
    
    public ArrayList<Modalidade> search(String nome) throws DAOexception, SQLException {
        return new Modalidade().searchModalidade(nome);
    }
}
