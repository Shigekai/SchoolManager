package br.com.schoolmanager.model.pessoa;

public class Professor extends Pessoa {

    public Professor(String nome, String matricula){
        super(nome, matricula);
    }

    public Professor(String nome, String matricula, String email){
        super(nome, email, matricula);
    }

    @Override
    public String obterDadosAcademicos(){
        return "Professor: " + getNome();
    }
}
