package br.com.schoolmanager.model.academico.atividade;

import br.com.schoolmanager.model.academico.Disciplina;
import br.com.schoolmanager.model.pessoa.Professor;

public abstract class AtividadeAvaliativa {
    private String codigo;
    private String nome;
    private double notaMaxima;
    private Professor professor;
    private Disciplina disciplina;

    public AtividadeAvaliativa(String codigo, String nome, double notaMaxima, Professor professor, Disciplina disciplina) {
        this.codigo = codigo;
        this.nome = nome;
        this.notaMaxima = notaMaxima;
        this.professor = professor;
        this.disciplina = disciplina;
    }

    public AtividadeAvaliativa(String codigo, String nome, double notaMaxima, Disciplina disciplina) {
        this.codigo = codigo;
        this.nome = nome;
        this.notaMaxima = notaMaxima;
        this.disciplina = disciplina;
        this.professor = disciplina.getProfessor();
    }

    public String getCodigo(){
        return codigo;
    }


    public String getNome() {
        return nome;
    }

    public double getNotaMaxima() {
        return notaMaxima;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setNotaMaxima(double notaMaxima) {
        this.notaMaxima = notaMaxima;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return "Atividade: " + nome +
                "\nCódigo: " + codigo +
                "\nNota Máxima: " + notaMaxima +
                "\nDisciplina: " + disciplina.getNomeDisciplina();
    }

    public abstract String obterTipoAvaliacao();
    public abstract double calcularPeso();

}