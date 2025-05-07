package br.com.schoolmanager.model.pessoa;

public class Aluno extends Pessoa{

    public Aluno(String nome, String matricula) {
        super(nome, matricula);
    }

    public Aluno(String nome, String matricula, String email){
        super(nome, matricula, email);
    }

    @Override
    public String obterDadosAcademicos(){
        return "Aluno: " + getNome();
    }
}
