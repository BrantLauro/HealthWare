/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corp.healthware.model.entity;

import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.dao.RegistroServicoDAO;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author dilceu
 */
public class RegistroServico {
    private int cod_rs;
    private String data;
    private String hora;
    private String nome_cliente;

    public RegistroServico() {
    }

    public RegistroServico(int cod_rs) {
        this.cod_rs = cod_rs;
    }
    
    

    public RegistroServico(int cod_rs, String data, String hora) {
        this.cod_rs = cod_rs;
        this.data = data;
        this.hora = hora;
    }

    public RegistroServico(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public RegistroServico(String nome_cliente, String data, String hora) {
        this.data = data;
        this.hora = hora;
        this.nome_cliente = nome_cliente;
    }

    public RegistroServico(int cod_rs, String nome_cliente, String data, String hora) {
        this.cod_rs = cod_rs;
        this.data = data;
        this.hora = hora;
        this.nome_cliente = nome_cliente;
    }

   

    public int cadastrarRegistroServico(RegistroServico registroservico) throws SQLException, DAOexception{
        return new RegistroServicoDAO().insert(registroservico);
    }
    
    public int updateRegistroServico(RegistroServico registroservico) throws SQLException, DAOexception{
        return new RegistroServicoDAO().update(registroservico);
    }
    
    public int excluirRegistroServico(RegistroServico registroservico) throws SQLException, DAOexception{
        return new RegistroServicoDAO().delete(registroservico);
    }
    
    public ArrayList<RegistroServico> findAllRegistroServico() throws SQLException, DAOexception{
        return new RegistroServicoDAO().findAll();
    }
    
    public RegistroServico findOneServico(RegistroServico registroservico) throws SQLException, DAOexception {
        return new RegistroServicoDAO().findOne(registroservico);
    }  
    
    public ArrayList<RegistroServico> searchRegistroServico(String pesquisa) throws SQLException, DAOexception {
        return new RegistroServicoDAO().search(pesquisa);
    }
    
    public int getCod_rs() {
        return cod_rs;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setCod_s(int cod_rs) {
        this.cod_rs = cod_rs;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }




    
}
