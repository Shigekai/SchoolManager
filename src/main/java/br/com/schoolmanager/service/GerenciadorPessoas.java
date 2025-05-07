package br.com.schoolmanager.service;

import br.com.schoolmanager.model.pessoa.Aluno;
import br.com.schoolmanager.model.pessoa.PessoaRepository;
import br.com.schoolmanager.model.pessoa.Professor;

import java.util.List;
import java.util.Optional;

public class GerenciadorPessoas {
    private final PessoaRepository<Aluno> alunoRepository;
    private final PessoaRepository<Professor> professorRepository;

    public GerenciadorPessoas() {
        this.alunoRepository = new PessoaRepository<>();
        this.professorRepository = new PessoaRepository<>();
    }

    public void cadastrarAluno(Aluno aluno){
        alunoRepository.salvar(aluno);
    }

    public void cadastrarProfessor(Professor professor){
        professorRepository.salvar(professor);
    }

    public Optional<Aluno> buscarAlunoPorId(String matricula){
        return alunoRepository.buscarPorId(matricula);
    }

    public Optional<Professor> buscarProfessorPorId(String matricula){
        return professorRepository.buscarPorId(matricula);
    }

    public List<Aluno> buscarTodosAlunos() {
        return alunoRepository.buscarTodos();
    }

    public List<Professor> buscarTodosProfessores() {
        return professorRepository.buscarTodos();
    }

}
