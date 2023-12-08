/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corp.healthware.model.entity;

import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.dao.ServicoDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dilceu
 */
public class Servico {
    private int cod_s;
    private String nome_s;
    private double preco;
    private int resp;
    private String nomeResp;

    public Servico(int cod_s) {
        this.cod_s = cod_s;
    }

    public Servico(int cod_s, String nome_s, double preco, int resp) {
        this.cod_s = cod_s;
        this.nome_s = nome_s;
        this.preco = preco;
        this.resp = resp;
    }
    
    

    public Servico(String nome_s, double preco, int resp) {
        this.nome_s = nome_s;
        this.preco = preco;
        this.resp = resp;
    }

    public int cadastrarServico(Servico servico) throws SQLException, DAOexception{
        return new ServicoDAO().insert(servico);
    }
    
    public int updateServico(Servico servico) throws SQLException, DAOexception{
        return new ServicoDAO().update(servico);
    }
    
    public int excluirServico(Servico servico) throws SQLException, DAOexception{
        return new ServicoDAO().delete(servico);
    }
    
    public ArrayList<Servico> findAllServico() throws SQLException, DAOexception{
        return new ServicoDAO().findAll();
    }
    
    public Servico findOneServico(Servico servico) throws SQLException, DAOexception {
       return new ServicoDAO().findOne(servico);
    }
    
    public ArrayList<Servico> searchServico(String servico) throws SQLException, DAOexception {
        return new ServicoDAO().search(servico);
    }
    
    public Servico() {
    }

    public int getCod_s() {
        return cod_s;
    }

    public String getNome_s() {
        return nome_s;
    }

    public double getPreco() {
        return preco;
    }

    public int getResp() {
        return resp;
    }

    public String getNomeResp() {
        return nomeResp;
    }
    
    public void setCod_s(int cod_s) {
        this.cod_s = cod_s;
    }

    public void setNome_s(String nome_s) {
        this.nome_s = nome_s;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setResp(int resp) {
        this.resp = resp;
    }

    public void setNomeResp(String nomeResp) {
        this.nomeResp = nomeResp;
    }
    
    
}
