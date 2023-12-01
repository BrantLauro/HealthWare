/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corp.healthware.model.entity;

import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.dao.ColaboradorDAO;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author dilceu
 */
public class Colaborador {
    private int cod_c;
    private String nome_c;
    private String tel_c;
    private String data_nasc_c;
    private String esp;
    private String email;
    private String senha;
    private boolean adm;

    public Colaborador() {
        
    }

    public Colaborador(int cod_c) {
        this.cod_c = cod_c;
    }

    public Colaborador(String nome_c, String tel_c, String data_nasc_c, String esp, String email, String senha, boolean adm) {
        this.nome_c = nome_c;
        this.tel_c = tel_c;
        this.data_nasc_c = data_nasc_c;
        this.esp = esp;
        this.email = email;
        this.senha = senha;
        this.adm = adm;
    }
    
    public int cadastrarColaborador(Colaborador colaborador) throws SQLException, DAOexception {
        return new ColaboradorDAO().insert(colaborador);
    }
    
     public int updateColaborador(Colaborador colaborador) throws DAOexception, SQLException {
        return new ColaboradorDAO().update(colaborador);
    }
    
    public int excluirColaborador(Colaborador colaborador)throws SQLException, DAOexception{
        return new ColaboradorDAO().delete(colaborador);
    }
    
   public ArrayList<Colaborador> findAllColaborador() throws DAOexception, SQLException {
       return new ColaboradorDAO().findAll();
    }
    
    public int getCod_c() {
        return cod_c;
    }

    public void setCod_c(int cod_c) {
        this.cod_c = cod_c;
    }

    public String getNome_c() {
        return nome_c;
    }

    public void setNome_c(String nome_c) {
        this.nome_c = nome_c;
    }

    public String getTel_c() {
        return tel_c;
    }

    public void setTel_c(String tel_c) {
        this.tel_c = tel_c;
    }

    public String getData_nasc_c() {
        return data_nasc_c;
    }

    public void setData_nasc_c(String data_nasc_c) {
        this.data_nasc_c = data_nasc_c;
    }

    public String getEsp() {
        return esp;
    }

    public void setEsp(String esp) {
        this.esp = esp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean getAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }

    
}
