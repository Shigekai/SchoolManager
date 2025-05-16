package br.com.schoolmanager.model.pessoa;

public class Aluno extends Pessoa{

    public Aluno(String nome, String matricula) {
        super(nome, matricula);
    }

    public Aluno(String nome, String email, String matricula){
        super(nome, email, matricula);
    }

    @Override
    public String obterDadosAcademicos(){
        return "Aluno: " + getNome();
    }
}
