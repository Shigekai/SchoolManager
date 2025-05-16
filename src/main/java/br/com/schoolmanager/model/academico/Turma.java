package br.com.schoolmanager.model.academico;

import br.com.schoolmanager.model.academico.atividade.AtividadeAvaliativa;
import br.com.schoolmanager.model.pessoa.Aluno;
import br.com.schoolmanager.model.pessoa.Professor;
import java.util.ArrayList;
import java.util.List;

public class Turma {

    private String nomeTurma;
    private String codigo;
    private Professor professor;
    private final List<Aluno> alunos; // Relação 1:N
    private final List<Disciplina> disciplinas; // Relação 1:N
    private final List<AtividadeAvaliativa> atividades; // 1:N

    public Turma(String nomeTurma, String codigo, Professor professor) {
        this.nomeTurma = nomeTurma;
        this.codigo = codigo;
        this.professor = professor;
        this.alunos = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.atividades = new ArrayList<>();
    }
    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }
    public void adicionarAtividade(AtividadeAvaliativa atividade) {
        atividades.add(atividade);
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public String getCodigo() {
        return codigo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public List<AtividadeAvaliativa> getAtividades() {
        return atividades;
    }

    @Override
    public String toString() {
        return "Turma: " + nomeTurma + "\nProfessor: " + professor.getNome() +
                "\nAlunos: " + alunos.size() +
                "\nDisciplinas: " + disciplinas.size();
    }
}
