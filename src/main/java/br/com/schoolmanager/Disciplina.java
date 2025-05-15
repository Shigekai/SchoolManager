package br.com.schoolmanager;

public class Disciplina {
    private String nome;
    private String codigo;

    public Disciplina(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNomeDisciplina() {
        return nome;
    }

    public String getCodigoDisciplina() {
        return codigo;
    }
}
