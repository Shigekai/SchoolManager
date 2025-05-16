package br.com.schoolmanager.model.academico;

import br.com.schoolmanager.model.pessoa.Professor;

public class Disciplina {
    private String nome;
    private String codigo;
    private Professor professor;

    public Disciplina(String nome, String codigo, Professor professor) {
        this.nome = nome;
        this.codigo = codigo;
        this.professor = professor;
    }

    public String getNomeDisciplina() {
        return nome;
    }

    public String getCodigoDisciplina() {
        return codigo;
    }

    public Professor getProfessor() { return professor; }
}
