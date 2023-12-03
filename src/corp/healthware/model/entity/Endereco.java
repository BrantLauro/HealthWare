
package corp.healthware.model.entity;

public class Endereco {
    private int cod_e;
    private String rua;
    private String bairro;
    private String cidade;
    private int numero;

    public Endereco() {
    }

    public Endereco(int cod_e) {
        this.cod_e = cod_e;
    }

    public Endereco(int cod_e, String rua, String bairro, String cidade, int numero) {
        this.cod_e = cod_e;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero = numero;
    }
    
    public int getCod_e() {
        return cod_e;
    }

    public void setCod_e(int cod_e) {
        this.cod_e = cod_e;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
}
