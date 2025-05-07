package br.com.schoolmanager.model.pessoa;

import br.com.schoolmanager.repository.Repository;
import java.util.*;

//PessoaRepository recebe um tipo generic T
//Esse T é um herdeiro de pessoa (Relação simples e direcionada)
//O repositório implementa a interface Repository (Polimorfismo de Subtipo)
public class PessoaRepository<T extends Pessoa> implements Repository<T> {
    //relação 1:N
    protected final Map<String, T> pessoas = new HashMap<>();

    @Override
    public void salvar(T pessoa){
        pessoas.put(pessoa.getMatricula(), pessoa);
    }

    //Optional porque o método pode retornar nulo
    //Se não for tratado com Optional, o Java iria lançar
    //NullPointerException
    @Override
    public Optional<T> buscarPorId(String matricula) {
        return Optional.ofNullable(pessoas.get(matricula));
    }

    //Retornar um novo array garante que os dados
    //Originais não estejam disponíveis fora
    //Para quem chamar esse método
    @Override
    public List<T> buscarTodos() {
        return new ArrayList<>(pessoas.values());
    }

    @Override
    public void remover(String matricula) {
        pessoas.remove(matricula);
    }
}
