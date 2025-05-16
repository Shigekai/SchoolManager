package br.com.schoolmanager;

import br.com.schoolmanager.enums.TipoProva;
import br.com.schoolmanager.enums.TipoTrabalho;
import br.com.schoolmanager.model.academico.Disciplina;
import br.com.schoolmanager.model.academico.Turma;
import br.com.schoolmanager.model.academico.atividade.AvaliacaoAluno;
import br.com.schoolmanager.model.academico.atividade.Prova;
import br.com.schoolmanager.model.academico.atividade.Trabalho;
import br.com.schoolmanager.model.pessoa.Aluno;
import br.com.schoolmanager.model.pessoa.Professor;
import br.com.schoolmanager.service.GerenciadorAcademico;
import br.com.schoolmanager.service.GerenciadorPessoas;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        GerenciadorPessoas gerenciadorPessoas = new GerenciadorPessoas();
        GerenciadorAcademico gerenciadorAcademico = new GerenciadorAcademico(gerenciadorPessoas);

        System.out.println("\n=== PESSOAS (Alunos e Professores) ===");
        //ALUNOS
        // Cadastro de Alunos
        Aluno aluno1 = new Aluno("Maria Silva", "A001", "maria@email.com");
        Aluno aluno2 = new Aluno("João Santos", "A002", "joao@email.com");
        Aluno aluno3 = new Aluno("Ana Oliveira", "A003", "ana@email.com");

        gerenciadorPessoas.cadastrarAluno(aluno1);
        gerenciadorPessoas.cadastrarAluno(aluno2);
        gerenciadorPessoas.cadastrarAluno(aluno3);

        // Listagem de Alunos
        List<Aluno> todosAlunos = gerenciadorPessoas.buscarTodosAlunos();
        for (Aluno aluno : todosAlunos) {
            System.out.println("Aluno cadastrado: " + aluno.getNome() + " - Matrícula: " + aluno.getMatricula());
        }


        String matriculaBusca = "A001";

        Optional<Aluno> alunoEncontrado = gerenciadorPessoas.buscarAlunoPorId(matriculaBusca);
        if (alunoEncontrado.isPresent()) {
            Aluno aluno = alunoEncontrado.get();
            System.out.println("Aluno encontrado: " + aluno.getNome());
        } else {
            System.out.println("Aluno com matrícula " + matriculaBusca + " não encontrado");
        }

        //PROFESSORES
        // Cadastro de Professores
        System.out.println("\n");
        Professor professor1 = new Professor("Professor John Snow", "P001", "john@email.com");
        Professor professor2 = new Professor("Professora Arya Stark", "P002", "arya@email.com");
        Professor professor3 = new Professor("Professor Jaime Lannister", "P003", "jaime@email.com");

        gerenciadorPessoas.cadastrarProfessor(professor1);
        gerenciadorPessoas.cadastrarProfessor(professor2);
        gerenciadorPessoas.cadastrarProfessor(professor3);

        // Listagem de Professores
        List<Professor> todosProfessores = gerenciadorPessoas.buscarTodosProfessores();
        for (Professor professor : todosProfessores) {
            System.out.println("Professor cadastrado: " + professor.getNome() + " - Matrícula: " + professor.getMatricula());
        }

        String matriculaBuscaProfessor = "P003";

        Optional<Professor> professorEncontrado = gerenciadorPessoas.buscarProfessorPorId(matriculaBuscaProfessor);
        if (professorEncontrado.isPresent()) {
            Professor professor = professorEncontrado.get();
            System.out.println("Professor encontrado: " + professor.getNome());
        } else {
            System.out.println("Professor com matrícula " + matriculaBuscaProfessor + " não encontrado");
        }

        //DISCIPLINAS
        System.out.println("\n=== DISCIPLINAS ===");
        //Criação de disciplinas
        Disciplina matematica = new Disciplina("Matemática", "MAT101", professor1);
        Disciplina historia = new Disciplina("História", "HIS201", professor2);
        Disciplina ciencias = new Disciplina("Ciências", "CIE301", professor3);

        gerenciadorAcademico.cadastrarDisciplina(matematica);
        gerenciadorAcademico.cadastrarDisciplina(historia);
        gerenciadorAcademico.cadastrarDisciplina(ciencias);

        List<Disciplina> todasDisciplinas = gerenciadorAcademico.buscarTodasDisciplinas();

        for (Disciplina disciplina : todasDisciplinas) {
            System.out.println(
                    "\nDados da disciplina: \n" +
                            "-Nome: " + disciplina.getNomeDisciplina() + "\n" +
                            "-Código: " + disciplina.getCodigoDisciplina() + "\n" +
                            "-Dados Professor: " + disciplina.getProfessor() + "\n"
            );
        }

        String codigoDisciplina = "MAT101";
        Optional<Disciplina> disciplinaEncontrada = gerenciadorAcademico.buscarDisciplinaPorCodigo("MAT101");
        if (disciplinaEncontrada.isPresent()) {
            Disciplina disciplina = disciplinaEncontrada.get();
            System.out.println("Disciplina encontrada: " + disciplina.getNomeDisciplina());
        } else {
            System.out.println("Disciplina com código:  " + codigoDisciplina + "não encontrado");
        }

        //TURMAS
        System.out.println("\n=== TURMAS ===");
        //Cadastro de Turmas
        Turma turma1 = new Turma("Turma A - Matemática Básica", "TA001", professor1);
        Turma turma2 = new Turma("Turma B - História Medieval", "TB001", professor2);
        Turma turma3 = new Turma("Turma C - Ciências Naturais", "TC001", professor3);

        gerenciadorAcademico.cadastrarTurma(turma1);
        gerenciadorAcademico.cadastrarTurma(turma2);
        gerenciadorAcademico.cadastrarTurma(turma3);

        //Matricula de Alunos em Turma
        gerenciadorAcademico.matricularAlunoEmTurma("A001", turma1);
        gerenciadorAcademico.matricularAlunoEmTurma("A002", turma1);
        gerenciadorAcademico.matricularAlunoEmTurma("A003", turma2);

        // Adicionar disciplinas às turmas
        turma1.adicionarDisciplina(matematica);
        turma2.adicionarDisciplina(historia);
        turma3.adicionarDisciplina(ciencias);
        //Listar todas as turmas
        List<Turma> todasTurmas = gerenciadorAcademico.buscarTodasTurmas();
        System.out.println("Total de turmas cadastradas: " + todasTurmas.size());

        // Exibir detalhes de cada turma
        for (Turma turma : todasTurmas) {
            System.out.println("\nDados da turma:" +
                    "\n-Nome: " + turma.getNomeTurma() +
                    "\n-Código: " + turma.getCodigo() +
                    "\n-Professor: " + turma.getProfessor().getNome() +
                    "\n-Quantidade de Alunos: " + turma.getAlunos().size() +
                    "\n-Quantidade de Disciplinas: " + turma.getDisciplinas().size());

            // Exibir alunos da turma
            if (!turma.getAlunos().isEmpty()) {
                System.out.println("Lista de Alunos:");
                for (Aluno aluno : turma.getAlunos()) {
                    System.out.println("  - " + aluno.getNome());
                }
            }
        }

        //ATIVIDADES AVALIATIVAS
        System.out.println("\n=== ATIVIDADES AVALIATIVAS ===");

        // Criação de Provas
        Prova prova1 = new Prova("P001", "Prova de Álgebra", 10.0, professor1, matematica, TipoProva.PARCIAL);
        Prova prova2 = new Prova("P002", "Prova Final de Matemática", 10.0, professor1, matematica, TipoProva.FINAL);
        Prova prova3 = new Prova("P003", "Prova de História Antiga", 10.0, professor2, historia, TipoProva.PARCIAL);

        // Criação de Trabalhos
        Trabalho trabalho1 = new Trabalho("T001", "Projeto de Estatística", 10.0, professor1, matematica, TipoTrabalho.PROJETO);
        Trabalho trabalho2 = new Trabalho("T002", "Pesquisa sobre Revolução Francesa", 10.0, professor2, historia, TipoTrabalho.PESQUISA);

        System.out.println("Atividades criadas:");
        System.out.println("1. " + prova1.getNome() + " - " + prova1.obterTipoAvaliacao() + " - Peso: " + prova1.calcularPeso());
        System.out.println("2. " + prova2.getNome() + " - " + prova2.obterTipoAvaliacao() + " - Peso: " + prova2.calcularPeso());
        System.out.println("3. " + trabalho1.getNome() + " - " + trabalho1.obterTipoAvaliacao() + " - Peso: " + trabalho1.calcularPeso());

        // Registrando notas para os alunos
        // Aluno 1 - Maria (Matemática)
        gerenciadorAcademico.registrarAvaliacao(aluno1, prova1, 8.5);
        gerenciadorAcademico.registrarAvaliacao(aluno1, prova2, 9.0);
        gerenciadorAcademico.registrarAvaliacao(aluno1, trabalho1, 7.5);
        gerenciadorAcademico.registrarAvaliacao(aluno1, trabalho2, 5.5);

        // Aluno 2 - João (Matemática)
        gerenciadorAcademico.registrarAvaliacao(aluno2, prova1, 7.0);
        gerenciadorAcademico.registrarAvaliacao(aluno2, prova2, 6.5);
        gerenciadorAcademico.registrarAvaliacao(aluno2, trabalho1, 8.0);

        // Aluno 3 - Ana (História)
        gerenciadorAcademico.registrarAvaliacao(aluno3, prova3, 9.5);
        gerenciadorAcademico.registrarAvaliacao(aluno3, trabalho2, 9.0);

        System.out.println("\nMédias dos alunos por disciplina:");
        double mediaAluno1Matematica = gerenciadorAcademico.calcularMediaAlunoPorDisciplina(aluno1, matematica);
        double mediaAluno2Matematica = gerenciadorAcademico.calcularMediaAlunoPorDisciplina(aluno2, matematica);
        double mediaAluno3Historia = gerenciadorAcademico.calcularMediaAlunoPorDisciplina(aluno3, historia);

        System.out.println(aluno1.getNome() + " em Matemática: " + mediaAluno1Matematica);
        System.out.println(aluno2.getNome() + " em Matemática: " + mediaAluno2Matematica);
        System.out.println(aluno3.getNome() + " em História: " + mediaAluno3Historia);


        //Busca de Avaliações
        // Buscando e exibindo avaliações por aluno
        System.out.println("\nAvaliações do aluno: " + aluno1.getNome());
        List<AvaliacaoAluno> avaliacoesAluno1 = gerenciadorAcademico.buscarAvaliacoesPorAluno(aluno1);
        for (AvaliacaoAluno avaliacao : avaliacoesAluno1) {
            System.out.println("- " + avaliacao.getAtividade().getNome() +
                    ": Nota " + avaliacao.getNotaObtida() +
                    " (Disciplina: " + avaliacao.getAtividade().getDisciplina().getNomeDisciplina() + ")");
        }

        // Buscando avaliações por aluno em disciplina específica
        System.out.println("\nAvaliações do aluno " + aluno1.getNome() + " em Matemática:");
        List<AvaliacaoAluno> avaliacoesAluno1Matematica =
                gerenciadorAcademico.buscarAvaliacoesPorAlunoEmDisciplina(aluno1, matematica);
        for (AvaliacaoAluno avaliacao : avaliacoesAluno1Matematica) {
            System.out.println("- " + avaliacao.getAtividade().getNome() + ": Nota " + avaliacao.getNotaObtida());
        }

    }
}