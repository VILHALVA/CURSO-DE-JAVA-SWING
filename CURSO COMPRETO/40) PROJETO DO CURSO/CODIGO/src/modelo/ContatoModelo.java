package modelo;

public class ContatoModelo {

    private int id;
    private String Descricao;
    private String Apelido;
    private String Email;
    private String Ddd;
    private String Telefone;
    private Integer IdCidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getApelido() {
        return Apelido;
    }

    public void setApelido(String Apelido) {
        this.Apelido = Apelido;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public String getDdd() {
        return Ddd;
    }

    public void setDdd(String Ddd) {
        this.Ddd = Ddd;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public Integer getIdCidade() {
        return IdCidade;
    }

    public void setIdCidade(Integer IdCidade) {
        this.IdCidade = IdCidade;
    }
       
}
