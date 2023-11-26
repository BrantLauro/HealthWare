
package corp.healthware.controller;

import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoController {
        public int insert(int cod_a, String nome_a, int cod_endereco, String data_nasc_a, int dia_pag, String obs, int status,
                String tel_a, String obj, String horario) throws DAOexception, SQLException {
        int linhasGravadas = 0;
        if (cod_a != -1 && nome_a != null && cod_endereco != null && data_nasc_a != null && dia_pag != -1 && obs != null && status != -1
                && tel_a != null && obs != null && horario != null) {
            Aluno func = new Aluno(id, nome, email, datanascimento, cargo);
            func.cadastrarFuncionario(func);
        }
        return linhasGravadas;
    }
    
    
    public int update(String nome, String email, String datanascimento, String cargo, int id) throws DAOexception, SQLException {
        int linhasAfetadas = 0;
        if (id != -1 && nome != null && email != null && datanascimento != null && cargo != null) {
           Aluno func = new Aluno(id, nome, email, datanascimento, cargo);
           func.updateFuncionario(func);
        }
        return linhasAfetadas;
    }

    public int delete(int id) throws DAOexception, SQLException {
        int linhasAfetadas = 0;
        if (id != -1) {
            Aluno func = new Aluno(id);
            func.excluirFuncionario(func);
        }
        return linhasAfetadas;
    }

    public ArrayList<Aluno> findAll() throws DAOexception, SQLException {
        return new Aluno().findAll();
    }
}
