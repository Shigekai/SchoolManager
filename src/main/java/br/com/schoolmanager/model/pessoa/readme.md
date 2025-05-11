# Classe Pessoa

## Características Principais

### Classe Abstrata
- **Não pode ser implementada diretamente**

### Encapsulamento
- **Atributos privados**
    - Podem ser acessados diretamente apenas na classe Pessoa, e com acesso controlado nas classes filhas.
- **Getters e Setters**
    - Garantem acesso controlado

### Polimorfismo
- **Sobrecarga de construtores (Polimorfismo estático)**
    - A classe tem dois construtores:
        - Um com os atributos essenciais (nome, matricula)
        - Outro com todos os atributos possíveis

- **Método toString()**
    - Ele sobrescreve um método padrão em Java chamado Object
    - Esse tipo de sobrescrita caracteriza um tipo de **Polimorfismo Dinâmico** (em tempo de execução)

### Abstração
- **Método obterDadosAcademicos()**
    - Um método abstrato, cujo corpo deve ser implementado na classe filha