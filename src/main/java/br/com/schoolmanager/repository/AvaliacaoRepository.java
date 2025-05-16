package br.com.schoolmanager.repository;

import br.com.schoolmanager.model.academico.Disciplina;
import br.com.schoolmanager.model.academico.atividade.AtividadeAvaliativa;
import br.com.schoolmanager.model.academico.atividade.AvaliacaoAluno;
import br.com.schoolmanager.model.pessoa.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AvaliacaoRepository {
    private final List<AvaliacaoAluno> avaliacoes = new ArrayList<>();

    public void registrarAvaliacao(Aluno aluno, AtividadeAvaliativa atividade, double nota) {
        AvaliacaoAluno avaliacao = new AvaliacaoAluno(aluno, atividade, nota);
        avaliacoes.add(avaliacao);
    }

    public List<AvaliacaoAluno> buscarAvaliacoesPorAluno(Aluno aluno) {
        return avaliacoes.stream()
                .filter(av -> av.getAluno().equals(aluno))
                .collect(Collectors.toList());
    }

    public List<AvaliacaoAluno> buscarAvaliacoesPorAlunoEmDisciplina(Aluno aluno, Disciplina disciplina) {
        return avaliacoes.stream()
                .filter(av -> av.getAluno().equals(aluno) &&
                        av.getAtividade().getDisciplina().equals(disciplina))
                .collect(Collectors.toList());
    }

    public double calcularMediaAlunoPorDisciplina(Aluno aluno, Disciplina disciplina) {
        List<AvaliacaoAluno> avaliacoesAluno = buscarAvaliacoesPorAlunoEmDisciplina(aluno, disciplina);

        if (avaliacoesAluno.isEmpty()) {
            return 0;
        }

        double somaNotas = 0;
        double somaPesos = 0;

        for (AvaliacaoAluno avaliacao : avaliacoesAluno) {
            double peso = avaliacao.getAtividade().calcularPeso();
            somaNotas += avaliacao.getNotaObtida() * peso;
            somaPesos += peso;
        }

        return somaNotas / somaPesos;
    }
}
