package br.com.schoolmanager.repository;

import br.com.schoolmanager.model.academico.Turma;

import java.util.*;

public class TurmaRepository implements Repository<Turma> {
    private final Map<String, Turma> turmas = new HashMap<>();

    public void salvar(Turma turma){
        turmas.put(turma.getCodigo(), turma);
    }

    @Override
    public Optional<Turma> buscarPorId(String codigo){
        return Optional.ofNullable(turmas.get(codigo));
    }

    @Override
    public List<Turma> buscarTodos(){
        return new ArrayList<>(turmas.values());
    }

    @Override
    public void remover(String codigo){
        turmas.remove(codigo);
    }
}
