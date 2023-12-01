/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corp.healthware.model.entity;

import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.dao.EntradaDAO;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author dilceu
 */
public class Entrada {
    private int cod_ent;
    private String data_ent;
    private double valor_ent;
    private String motivo_ent;
    private int resp_ent;

    public Entrada() {
    }

    public Entrada(int cod_ent) {
        this.cod_ent = cod_ent;
    }

    public Entrada(String data_ent, double valor_ent, String motivo_ent, int resp_ent) {
        this.data_ent = data_ent;
        this.valor_ent = valor_ent;
        this.motivo_ent = motivo_ent;
        this.resp_ent = resp_ent;
    }

    public int cadastrarEntrada(Entrada entrada) throws SQLException, DAOexception {
        return new EntradaDAO().insert(entrada);
    }
    
     public int updateEntrada(Entrada entrada) throws DAOexception, SQLException {
        return new EntradaDAO().update(entrada);
    }
    
    public int excluirEntrada(Entrada entrada)throws SQLException, DAOexception{
        return new EntradaDAO().delete(entrada);
    }
    
   public ArrayList<Entrada> findAllEntrada() throws DAOexception, SQLException {
       return new EntradaDAO().findAll();
    }
    
    public int getCod_ent() {
        return cod_ent;
    }

    public String getData_ent() {
        return data_ent;
    }

    public double getValor_ent() {
        return valor_ent;
    }

    public String getMotivo_ent() {
        return motivo_ent;
    }

    public int getResp_ent() {
        return resp_ent;
    }

    public void setCod_ent(int cod_ent) {
        this.cod_ent = cod_ent;
    }

    public void setData_ent(String data_ent) {
        this.data_ent = data_ent;
    }

    public void setValor_ent(double valor_ent) {
        this.valor_ent = valor_ent;
    }

    public void setMotivo_ent(String motivo_ent) {
        this.motivo_ent = motivo_ent;
    }

    public void setResp_ent(int resp_ent) {
        this.resp_ent = resp_ent;
    }

    
    
}
