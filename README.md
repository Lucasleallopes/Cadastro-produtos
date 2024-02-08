# Sistema de Gerenciamento de Produtos

Este projeto Java é um sistema de gerenciamento de produtos que demonstra a aplicação de conceitos fundamentais da Programação Orientada a Objetos (POO), como herança, polimorfismo, interfaces e classes abstratas. Ele permite adicionar, visualizar, editar, excluir e buscar produtos no sistema.

## Estrutura do Código

O sistema é composto por várias classes representando diferentes tipos de produtos, além de uma classe base abstrata e uma interface para definir comportamentos comuns.

### Classes do Projeto

- **ProdutoBase**: Classe abstrata que serve como base para todos os produtos, implementando a interface `Vendavel`.
- **Alimento, Eletronico, Livro**: Subclasses de `ProdutoBase`, representando diferentes categorias de produtos, cada uma com atributos específicos.
- **Produto**: Classe que representa produtos genéricos que não se encaixam nas categorias específicas.
- **Vendavel**: Interface que define o método `calcularPreco`, obrigatório para todas as classes de produto.

### Funcionalidades Principais

- **Adicionar Produto**: Permite inserir novos produtos no sistema, especificando detalhes como tipo, código, nome, preço, entre outros atributos específicos de cada categoria.
- **Visualizar Produtos**: Exibe a lista de todos os produtos cadastrados, mostrando suas informações detalhadas.
- **Editar Produto**: Permite modificar os atributos de um produto existente, identificando-o por seu código.
- **Excluir Produto**: Remove um produto do sistema, baseando-se em seu código.
- **Buscar Produto**: Encontra um produto por seu código, exibindo suas informações.

## Instruções de Uso
1. Clone esse repositório
2. Execute a classe `Principal` para iniciar o programa.
3. Siga os prompts no console para interagir com o sistema, escolhendo a ação desejada.
   
```
git clone https://github.com/Lucasleallopes/Cadastro-produtos.git

```

