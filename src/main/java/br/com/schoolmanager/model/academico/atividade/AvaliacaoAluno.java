package br.com.schoolmanager.model.academico.atividade;

import br.com.schoolmanager.model.pessoa.Aluno;

public class AvaliacaoAluno {
    private Aluno aluno;
    private AtividadeAvaliativa atividade;
    private double notaObtida;

    public AvaliacaoAluno(Aluno aluno, AtividadeAvaliativa atividade, double notaObtida) {
        this.aluno = aluno;
        this.atividade = atividade;
        this.notaObtida = notaObtida;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public AtividadeAvaliativa getAtividade() {
        return atividade;
    }

    public double getNotaObtida() {
        return notaObtida;
    }

    public void setNotaObtida(double notaObtida) {
        this.notaObtida = notaObtida;
    }


}
