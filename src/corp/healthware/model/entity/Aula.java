
package corp.healthware.model.entity;

import corp.healthware.model.dao.AulaDAO;
import corp.healthware.model.entity.Aluno;
import corp.healthware.model.dao.DAOexception;
import java.sql.SQLException;
import java.util.ArrayList;

public class Aula {
    private int cod_a;
    private String data_au;
    private String hora_au;
    private String descricao;

    public Aula() {
    }

    public Aula(int cod_a) {
        this.cod_a = cod_a;
    }

    public Aula(int cod_a, String data_au, String hora_au, String descricao) {
        this.cod_a = cod_a;
        this.data_au = data_au;
        this.hora_au = hora_au;
        this.descricao = descricao;
    }
    
    public int cadastrarAula(Aula aula) throws SQLException, DAOexception {
        return new AulaDAO().insert(aula);
    }
    
     public int updateAula(Aula aula) throws DAOexception, SQLException {
        return new AulaDAO().update(aula);
    }
    
    public int excluirAula(Aula aula)throws SQLException, DAOexception{
        return new AulaDAO().delete(aula);
    }
    
   public ArrayList<Aula> findAllAula() throws DAOexception, SQLException {
       return new AulaDAO().findAll();
    }
   
    public Aula findOneAula(Aula aula) throws SQLException, DAOexception {
       return new AulaDAO().findOne(aula);
    }
    
    public ArrayList<Aula> findAllAulas(Aluno a) throws SQLException, DAOexception {
        return new AulaDAO().findAll(a);
    }
    
    public int getCod_a() {
        return cod_a;
    }

    public void setCod_a(int cod_a) {
        this.cod_a = cod_a;
    }

    public String getData_au() {
        return data_au;
    }

    public void setData_au(String data_au) {
        this.data_au = data_au;
    }

    public String getHora_au() {
        return hora_au;
    }

    public void setHora_au(String hora_au) {
        this.hora_au = hora_au;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
