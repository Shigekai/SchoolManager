package br.com.schoolmanager.model.pessoa;

public abstract class Pessoa {
    private String nome;
    private String email;
    private String matricula;

    public Pessoa(String nome, String email, String matricula){
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
    }

    public Pessoa(String nome, String matricula){
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getMatricula(){
        return matricula;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\n Email: " + email +
                "\n Matricula: " + matricula;
    };

    public abstract String obterDadosAcademicos();
}
