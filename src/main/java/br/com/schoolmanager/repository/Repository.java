package br.com.schoolmanager.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    void salvar(T entidade);
    Optional<T> buscarPorId(String id);
    List<T> buscarTodos();
    void remover(String id);
}
