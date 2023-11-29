
package corp.healthware.model.entity;

import corp.healthware.model.dao.ModalidadeDAO;
import corp.healthware.model.dao.DAOexception;
import java.sql.SQLException;
import java.util.ArrayList;

public class Modalidade {
    private int cod_m;
    private int resp;
    private String nome_m;
    private int vezes_semana;
    private double preco;

    public Modalidade() {
    }

    public Modalidade(int cod_m) {
        this.cod_m = cod_m;
    }

    public Modalidade(int resp, String nome_m, int vezes_semana, double preco) {
        this.resp = resp;
        this.nome_m = nome_m;
        this.vezes_semana = vezes_semana;
        this.preco = preco;
    }
    
    public int cadastrarModalidade(Modalidade modalidade) throws SQLException, DAOexception {
        return new ModalidadeDAO().insert(modalidade);
    }
    
     public int updateModalidade(Modalidade modalidade) throws DAOexception, SQLException {
        return new ModalidadeDAO().update(modalidade);
    }
    
    public int excluirModalidade(Modalidade modalidade)throws SQLException, DAOexception{
        return new ModalidadeDAO().delete(modalidade);
    }
    
   public ArrayList<Modalidade> findAllModalidade() throws DAOexception, SQLException {
       return new ModalidadeDAO().findAll();
    }
    
    public int getCod_m() {
        return cod_m;
    }

    public void setCod_m(int cod_m) {
        this.cod_m = cod_m;
    }

    public int getResp() {
        return resp;
    }

    public void setResp(int resp) {
        this.resp = resp;
    }

    public String getNome_m() {
        return nome_m;
    }

    public void setNome_m(String nome_m) {
        this.nome_m = nome_m;
    }

    public int getVezes_semana() {
        return vezes_semana;
    }

    public void setVezes_semana(int vezes_semana) {
        this.vezes_semana = vezes_semana;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    /*public ArrayList<Modalidade> findAllModalidade() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
    
    
}
