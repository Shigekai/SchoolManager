package br.com.schoolmanager;
import br.com.schoolmanager.model.pessoa.*;
import br.com.schoolmanager.service.GerenciadorPessoas;

public class Main {
    public static void main(String[] args) {
        // Polimorfismo de subtipo e uso do gerenciador
        GerenciadorPessoas gerenciador = new GerenciadorPessoas();

        Aluno aluno1 = new Aluno("Ana Silva", "A001", "ana@email.com");
        Aluno aluno2 = new Aluno("Carlos Souza", "A002");
        Professor professor = new Professor("João Lima", "P001", "joao@email.com");

        gerenciador.cadastrarAluno(aluno1);
        gerenciador.cadastrarAluno(aluno2);
        gerenciador.cadastrarProfessor(professor);

        Turma turma1 = new Turma("Turma 1º Ano", professor);
        turma1.adicionarAluno(aluno1);
        turma1.adicionarAluno(aluno2);

        Disciplina matematica = new Disciplina("Matemática", "MAT01");
        Disciplina portugues = new Disciplina("Português", "POR01");
        turma1.adicionarDisciplina(matematica);
        turma1.adicionarDisciplina(portugues);

        AtividadeAvaliativa prova1 = new AtividadeAvaliativa("Prova 1", 8.5);
        turma1.adicionarAtividade(prova1);

        // Exibir dados
        System.out.println(turma1);
        System.out.println("\nAlunos:");
        for (Aluno aluno : turma1.getAlunos()) {
            System.out.println("- " + aluno.getNome());
        }

        System.out.println("\nDisciplinas:");
        for (Disciplina d : turma1.getDisciplinas()) {
            System.out.println("- " + d);
        }

        System.out.println("\nAtividades:");
        for (AtividadeAvaliativa a : turma1.getAtividades()) {
            System.out.println("- " + a);
        }
    }
}