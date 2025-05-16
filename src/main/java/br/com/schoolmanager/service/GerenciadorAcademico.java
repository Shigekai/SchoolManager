package br.com.schoolmanager.service;

import br.com.schoolmanager.model.academico.*;
import br.com.schoolmanager.model.academico.atividade.AtividadeAvaliativa;
import br.com.schoolmanager.model.academico.atividade.AvaliacaoAluno;
import br.com.schoolmanager.model.pessoa.*;
import br.com.schoolmanager.repository.AvaliacaoRepository;
import br.com.schoolmanager.repository.DisciplinaRepository;
import br.com.schoolmanager.repository.TurmaRepository;

import java.util.List;
import java.util.Optional;

public class GerenciadorAcademico {
    private final DisciplinaRepository disciplinaRepository;
    private final TurmaRepository turmaRepository;
    private final AvaliacaoRepository avaliacaoRepository;
    private final GerenciadorPessoas gerenciadorPessoas;

    public GerenciadorAcademico(GerenciadorPessoas gerenciadorPessoas) {
        this.disciplinaRepository = new DisciplinaRepository();
        this.turmaRepository = new TurmaRepository();
        this.avaliacaoRepository = new AvaliacaoRepository();
        this.gerenciadorPessoas = gerenciadorPessoas;
    }

    public void cadastrarDisciplina(Disciplina disciplina) {
        disciplinaRepository.salvar(disciplina);
    }

    public Optional<Disciplina> buscarDisciplinaPorCodigo(String codigo) {
        return disciplinaRepository.buscarPorId(codigo);
    }

    public List<Disciplina> buscarTodasDisciplinas() {
        return disciplinaRepository.buscarTodos();
    }


    public void cadastrarTurma(Turma turma) {
        turmaRepository.salvar(turma);
    }

    public List<Turma> buscarTodasTurmas() {
        return turmaRepository.buscarTodos();
    }


    public boolean matricularAlunoEmTurma(String matriculaAluno, Turma turma) {
        Optional<Aluno> alunoOpt = gerenciadorPessoas.buscarAlunoPorId(matriculaAluno);
        if (alunoOpt.isPresent()) {
            turma.adicionarAluno(alunoOpt.get());
            return true;
        }
        return false;
    }

    public void registrarAvaliacao(Aluno aluno, AtividadeAvaliativa atividade, double nota) {
        avaliacaoRepository.registrarAvaliacao(aluno, atividade, nota);
    }

    public List<AvaliacaoAluno> buscarAvaliacoesPorAluno(Aluno aluno) {
        return avaliacaoRepository.buscarAvaliacoesPorAluno(aluno);
    }

    public List<AvaliacaoAluno> buscarAvaliacoesPorAlunoEmDisciplina(Aluno aluno, Disciplina disciplina) {
        return avaliacaoRepository.buscarAvaliacoesPorAlunoEmDisciplina(aluno, disciplina);
    }

    public double calcularMediaAlunoPorDisciplina(Aluno aluno, Disciplina disciplina) {
        return avaliacaoRepository.calcularMediaAlunoPorDisciplina(aluno, disciplina);
    }


}