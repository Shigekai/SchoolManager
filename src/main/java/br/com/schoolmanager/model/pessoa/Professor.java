package br.com.schoolmanager.model.pessoa;

public class Professor extends Pessoa {

    public Professor(String nome, String matricula){
        super(nome, matricula);
    }

    public Professor(String nome, String matricula, String email){
        super(nome, matricula, email);
    }

    @Override
    public String obterDadosAcademicos(){
        return "Professor: " + getNome();
    }
}
