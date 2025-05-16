package br.com.schoolmanager.model.academico.atividade;

import br.com.schoolmanager.enums.TipoProva;
import br.com.schoolmanager.model.academico.Disciplina;
import br.com.schoolmanager.model.pessoa.Professor;

public class Prova extends AtividadeAvaliativa {
    private TipoProva tipoProva;

    public Prova(String codigo, String nome, double notaMaxima, Professor professor,
                 Disciplina disciplina, TipoProva tipoProva) {
        super(codigo, nome, notaMaxima, professor, disciplina);
        this.tipoProva = tipoProva;
    }

    public TipoProva getTipoProva() {
        return tipoProva;
    }

    public void setTipoProva(TipoProva tipoProva) {
        this.tipoProva = tipoProva;
    }

    @Override
    public String obterTipoAvaliacao() {
        return "Prova - " + tipoProva;
    }

    @Override
    public double calcularPeso() {
        switch (tipoProva) {
            case FINAL:
                return 2.0;
            case PARCIAL:
                return 1.5;
            case RECUPERACAO:
                return 1.0;
            default:
                return 1.0;
        }
    }
}
