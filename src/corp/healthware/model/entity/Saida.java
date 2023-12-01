/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corp.healthware.model.entity;

import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.dao.SaidaDAO;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author dilceu
 */
public class Saida {
    private int cod_saida;
    private String data_saida;
    private double valor_saida;
    private String motivo_saida;
    private int resp_saida;

    public Saida() {
    }

    public Saida(int cod_saida) {
        this.cod_saida = cod_saida;
    }

    public Saida(String data_saida, double valor_saida, String motivo_saida, int resp_saida) {
        this.data_saida = data_saida;
        this.valor_saida = valor_saida;
        this.motivo_saida = motivo_saida;
        this.resp_saida = resp_saida;
    }

    public int cadastrarSaida(Saida saida) throws SQLException, DAOexception {
        return new SaidaDAO().insert(saida);
    }
    
     public int updateSaida(Saida saida) throws DAOexception, SQLException {
        return new SaidaDAO().update(saida);
    }
    
    public int excluirSaida(Saida saida)throws SQLException, DAOexception{
        return new SaidaDAO().delete(saida);
    }
    
   public ArrayList<Saida> findAllSaida() throws DAOexception, SQLException {
       return new SaidaDAO().findAll();
    }
    
    public int getCod_saida() {
        return cod_saida;
    }

    public String getData_saida() {
        return data_saida;
    }

    public double getValor_saida() {
        return valor_saida;
    }

    public String getMotivo_saida() {
        return motivo_saida;
    }

    public int getResp_saida() {
        return resp_saida;
    }

    public void setCod_saida(int cod_saida) {
        this.cod_saida = cod_saida;
    }

    public void setData_saida(String data_saida) {
        this.data_saida = data_saida;
    }

    public void setValor_saida(double valor_saida) {
        this.valor_saida = valor_saida;
    }

    public void setMotivo_saida(String motivo_saida) {
        this.motivo_saida = motivo_saida;
    }

    public void setResp_saida(int resp_saida) {
        this.resp_saida = resp_saida;
    }
    
    
}
