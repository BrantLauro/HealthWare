
package corp.healthware.model.entity;

public class Aluno {
    private int cod_a;
    private String nome_a;
    private int cod_endereco;
    private String data_nasc_a;
    private int dia_pag;
    private String obs;
    private int status;
    private String tel_a;
    private String obj;
    private String horario;

    public Aluno() {
    }

    public Aluno(int cod_a) {
        this.cod_a = cod_a;
    }

    public Aluno(int cod_a, String nome_a, int cod_endereco, String data_nasc_a, int dia_pag, String obs, int status, String tel_a, String obj, String horario) {
        this.cod_a = cod_a;
        this.nome_a = nome_a;
        this.cod_endereco = cod_endereco;
        this.data_nasc_a = data_nasc_a;
        this.dia_pag = dia_pag;
        this.obs = obs;
        this.status = status;
        this.tel_a = tel_a;
        this.obj = obj;
        this.horario = horario;
    }
    
    public int getCod_a() {
        return cod_a;
    }

    public void setCod_a(int cod_a) {
        this.cod_a = cod_a;
    }

    public String getNome_a() {
        return nome_a;
    }

    public void setNome_a(String nome_a) {
        this.nome_a = nome_a;
    }

    public int getCod_endereco() {
        return cod_endereco;
    }

    public void setCod_endereco(int cod_endereco) {
        this.cod_endereco = cod_endereco;
    }

    public String getData_nasc_a() {
        return data_nasc_a;
    }

    public void setData_nasc_a(String data_nasc_a) {
        this.data_nasc_a = data_nasc_a;
    }

    public int getDia_pag() {
        return dia_pag;
    }

    public void setDia_pag(int dia_pag) {
        this.dia_pag = dia_pag;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTel_a() {
        return tel_a;
    }

    public void setTel_a(String tel_a) {
        this.tel_a = tel_a;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCod_endereco_a() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
