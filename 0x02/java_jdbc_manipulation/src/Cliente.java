public class Cliente {

    public Integer id;
    public String nome;
    public Integer idade;
    public String cpf;
    public String rg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

//    public Cliente(Integer id, String nome, Integer idade, String cpf, String rg) {
//        this.id = id;
//        this.nome = nome;
//        this.idade = idade;
//        this.cpf = cpf;
//        this.rg = rg;
//    }
}
