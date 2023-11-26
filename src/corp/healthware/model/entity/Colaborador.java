
package corp.healthware.model.entity;

public class Colaborador {
    private int cod_c;
    private String nome_c;
    private String tel_c;
    private String data_nasc_c;
    private String esp;
    private String email;
    private String senha;
    private boolean adm;

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
