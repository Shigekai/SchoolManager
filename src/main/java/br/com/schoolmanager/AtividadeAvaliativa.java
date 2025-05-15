package br.com.schoolmanager;
    public class AtividadeAvaliativa {
        private String titulo;
        private double nota;

        public AtividadeAvaliativa(String titulo, double nota) {
            this.titulo = titulo;
            this.nota = nota;
        }

        public String getTituloAttividade() {
            return titulo;
        }

        public double getNotaAtividade() {
            return nota;
        }

        @Override
        public String toString() {
            return "Atividade: " + titulo + " - Nota: " + nota;
        }
    }
