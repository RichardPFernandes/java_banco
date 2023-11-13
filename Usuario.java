public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String senha;

    public Usuario() {
    }

    public Usuario(int id, String nome, String email, String senha){
        this.setId(id);
        this.setNome(nome);
        this.setEmail(email);
        this.setSenha(senha);
    }

    public Usuario(String nome, String email, String senha) {
        this.setNome(nome);
        this.setEmail(email);
        this.setSenha(senha);
    }
    
    public Usuario(String email, String senha) {
        this.setEmail(email);
        this.setSenha(senha);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    private void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return this.senha;
    }

    public String toString() {
        return "Id: "+ this.getId() + " Nome: " + this.getNome() + " Email: " + this.getEmail() + " Senha: " + this.getSenha();
    }

}