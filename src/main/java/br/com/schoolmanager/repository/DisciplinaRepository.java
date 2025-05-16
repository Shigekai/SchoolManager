package br.com.schoolmanager.repository;

import br.com.schoolmanager.model.academico.Disciplina;

import java.util.*;

public class DisciplinaRepository implements Repository<Disciplina> {
    private final Map<String, Disciplina> disciplinas = new HashMap<>();

    @Override
    public void salvar(Disciplina disciplina) {
        disciplinas.put(disciplina.getCodigoDisciplina(), disciplina);
    }

    @Override
    public Optional<Disciplina> buscarPorId(String codigo){
        return Optional.ofNullable(disciplinas.get(codigo));
    }

    @Override
    public List<Disciplina> buscarTodos(){
        return new ArrayList<>(disciplinas.values());
    }

    @Override
    public void remover(String codigo){
        disciplinas.remove(codigo);
    }
}
