
package corp.healthware.model.entity;

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

    public Modalidade(int cod_m, int resp, String nome_m, int vezes_semana, double preco) {
        this.cod_m = cod_m;
        this.resp = resp;
        this.nome_m = nome_m;
        this.vezes_semana = vezes_semana;
        this.preco = preco;
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
    
    
}
