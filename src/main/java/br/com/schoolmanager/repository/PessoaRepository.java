package br.com.schoolmanager.repository;

import br.com.schoolmanager.model.pessoa.Pessoa;

import java.util.*;

public class PessoaRepository<T extends Pessoa> implements Repository<T> {
    protected final Map<String, T> pessoas = new HashMap<>();

    @Override
    public void salvar(T pessoa){
        pessoas.put(pessoa.getMatricula(), pessoa);
    }

    @Override
    public Optional<T> buscarPorId(String matricula) {
        return Optional.ofNullable(pessoas.get(matricula));
    }

    @Override
    public List<T> buscarTodos() {
        return new ArrayList<>(pessoas.values());
    }

    @Override
    public void remover(String matricula) {
        pessoas.remove(matricula);
    }
}
