/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corp.healthware.model.entity;

import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.dao.RegistroServicoDAO;

/**
 *
 * @author dilce
 */
public class RegistroServico {
    private int cod_s;
    private String data;
    private String hora;
    private String nome_cliente;

    public RegistroServico() {
    }

    public RegistroServico(int cod_s) {
        this.cod_s = cod_s;
    }

    public RegistroServico(String data, String hora, String nome_cliente) {
        this.data = data;
        this.hora = hora;
        this.nome_cliente = nome_cliente;
    }

    public int cadastrarServico(RegistroServico registroservico) throws SQLException, DAOexception{
        return new RegistroServicoDAO().insert(registroservico);
    }
    
    public int updateServico(Servico servico) throws SQLException, DAOexception{
        return new RegistroServicoDAO().update(registroservico);
    }
    
    public int excluirServico(Servico servico) throws SQLException, DAOexception{
        return new RegistroServicoDAO().delete(registroservico);
    }
    
    public ArrayList<Servico> findAllServico() throws SQLException, DAOexception{
        return new RegistroServicoDAO().findAll();
    }
    
    
    
    
    public int getCod_s() {
        return cod_s;
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

    public void setCod_s(int cod_s) {
        this.cod_s = cod_s;
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
