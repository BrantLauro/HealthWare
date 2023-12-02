
package corp.healthware.model.entity;

import corp.healthware.model.dao.AlunoDAO;
import corp.healthware.model.dao.DAOexception;
import java.sql.SQLException;
import java.util.ArrayList;

public class Aluno {
    private int cod_a;
    private String nome_a;
    private String data_nasc_a;
    private int dia_pag;
    private String obs;
    private int status;
    private String tel_a;
    private String obj;
    private int modalidade;
    private String endereco;
    private String horario;
    private String nomeModalidade;

    public Aluno() {
    }

    public Aluno(int cod_a) {
        this.cod_a = cod_a;
    }

    public Aluno(String nome_a, String data_nasc_a, int dia_pag, String obs, int status, String tel_a, String obj, int modalidade, String endereco, String horario) {
        this.nome_a = nome_a;
        this.data_nasc_a = data_nasc_a;
        this.dia_pag = dia_pag;
        this.obs = obs;
        this.status = status;
        this.tel_a = tel_a;
        this.obj = obj;
        this.modalidade = modalidade;
        this.endereco = endereco;
        this.horario = horario;
    }

    public Aluno(int cod_a, String nome_a, int cod_endereco, String data_nasc_a, int dia_pag, String obs, int status, String tel_a, int modalidade, String endereco, String obj, String horario) {
        this.cod_a = cod_a;
        this.nome_a = nome_a;
        this.data_nasc_a = data_nasc_a;
        this.dia_pag = dia_pag;
        this.obs = obs;
        this.status = status;
        this.tel_a = tel_a;
        this.obj = obj;
        this.modalidade = modalidade;
        this.endereco = endereco;
        this.horario = horario;
    }

    public Aluno(int cod_a, String data_nasc_a, int dia_pag, String obs, int status, String tel_a, String obj, int modalidade, String endereco, String horario) {
        this.cod_a = cod_a;
        this.data_nasc_a = data_nasc_a;
        this.dia_pag = dia_pag;
        this.obs = obs;
        this.status = status;
        this.tel_a = tel_a;
        this.obj = obj;
        this.modalidade = modalidade;
        this.endereco = endereco;
        this.horario = horario;
    }

    public int cadastrarAluno(Aluno aluno) throws SQLException, DAOexception {
        return new AlunoDAO().insert(aluno);
    }
    
     public int updateAluno(Aluno aluno) throws DAOexception, SQLException {
        return new AlunoDAO().update(aluno);
    }
    
    public int excluirAluno(Aluno aluno)throws SQLException, DAOexception{
        return new AlunoDAO().delete(aluno);
    }
    
   public ArrayList<Aluno> findAllAluno() throws DAOexception, SQLException {
       return new AlunoDAO().findAll();
    }
   
    public Aluno findOneAluno(Aluno aluno) throws SQLException, DAOexception {
       return new AlunoDAO().findOne(aluno);
    }
    
    public ArrayList<Aluno> searchAluno(String nome) throws SQLException, DAOexception {
        return new AlunoDAO().search(nome);
    }
    
    public int getCod_a() {
        return cod_a;
    }

    public void setCod_a(int cod_a) {
        this.cod_a = cod_a;
    }

    public String getNome_a() {
        return nome_a;
    }

    public void setNome_a(String nome_a) {
        this.nome_a = nome_a;
    }

    public String getData_nasc_a() {
        return data_nasc_a;
    }

    public void setData_nasc_a(String data_nasc_a) {
        this.data_nasc_a = data_nasc_a;
    }

    public int getDia_pag() {
        return dia_pag;
    }

    public void setDia_pag(int dia_pag) {
        this.dia_pag = dia_pag;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public int getStatus() {
        return status;
    }
    
    public String getStatusNome() {
        if(status == 1) return "Ativo";
        else if(status == 2) return "Inativo";
        else return "Devendo";
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTel_a() {
        return tel_a;
    }

    public void setTel_a(String tel_a) {
        this.tel_a = tel_a;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }
    
    public int getModalidade() {
        return modalidade;
    }
    
    public void setModalidade(int modalidade) {
        this.modalidade = modalidade;
    }
    
    public void setNomeModalidade(String nomeModalidade) {
        this.nomeModalidade = nomeModalidade;
    }
    
    public String getNomeModalidade() {
        return nomeModalidade;
    }

    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
