package br.com.schoolmanager.model.academico.atividade;

import br.com.schoolmanager.enums.TipoTrabalho;
import br.com.schoolmanager.model.academico.Disciplina;
import br.com.schoolmanager.model.pessoa.Professor;

public class Trabalho extends AtividadeAvaliativa{
    private TipoTrabalho tipoTrabalho;

    public Trabalho(String codigo, String nome, double notaMaxima, Professor professor,
                    Disciplina disciplina, TipoTrabalho tipoTrabalho) {
        super(codigo, nome, notaMaxima, professor, disciplina);
        this.tipoTrabalho = tipoTrabalho;
    }

    public TipoTrabalho getTipoTrabalho() {
        return tipoTrabalho;
    }

    public void setTipoTrabalho(TipoTrabalho tipoTrabalho) {
        this.tipoTrabalho = tipoTrabalho;
    }

    @Override
    public String obterTipoAvaliacao(){
        return "Trabalho - " + tipoTrabalho;
    }

    @Override
    public double calcularPeso(){
        return switch(tipoTrabalho){
            case PROJETO -> 1.2;
            case PESQUISA -> 1.0;
        };
    }

}
