package br.fag.atividadefinal;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {

    // Método de busca de produtos por código
    public static ProdutoBase buscarProdutoPorCodigo(List<ProdutoBase> produtos, int codigo) {
        for (ProdutoBase produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null; // Retorna null se nenhum produto for encontrado com o código fornecido
    }

    public static void main(String[] args) {
        List<ProdutoBase> produtos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("==================================");
        	System.out.println("Selecione uma opção:");
            System.out.println("[1] - Adicionar produto");
            System.out.println("[2] - Visualizar produtos");
            System.out.println("[3] - Editar produto");
            System.out.println("[4] - Excluir produto");
            System.out.println("[5] - Buscar produto");
            System.out.println("[6] - Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            try {
            switch (opcao) {
                case 1:
                    while (true) {
                        System.out.println("Digite as informações do produto: ");
                        System.out.print("Código: ");
                        int codigo = scanner.nextInt();
                        scanner.nextLine();
                        
                        boolean codigoEmUso = false;
                        for (ProdutoBase produto : produtos) {
                            if (produto.getCodigo() == codigo) {
                                codigoEmUso = true;
                                break;
                            }
                        }

                        if (codigoEmUso) {
                            System.out.println("Código já em uso. Por favor, digite um código diferente.");
                            continue; // Volta ao início do loop para solicitar um novo código
                        }
                        
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Preço  Bruto: ");
                        double preco = scanner.nextDouble();
                        scanner.nextLine(); // Limpar o buffer

                        System.out.print("Tipo (L/Livro, E/Eletrônico, A/Alimento, ou qualquer outra tecla para Produto): ");
                        String tipo = scanner.nextLine().toUpperCase();

                        ProdutoBase produto;

                        switch (tipo) {
                            case "L":
                                System.out.print("Autor: ");
                                String autor = scanner.nextLine();
                                System.out.print("Editora: ");
                                String editora = scanner.nextLine();
                                System.out.print("Ano de publicação: ");
                                int anoPublicacao = scanner.nextInt();
                                scanner.nextLine(); // Limpar o buffer
                                produto = new Livro(codigo, nome, preco, autor, editora, anoPublicacao);
                                break;
                            case "E":
                                System.out.print("Marca: ");
                                String marca = scanner.nextLine();
                                System.out.print("Modelo: ");
                                String modelo = scanner.nextLine();
                                System.out.print("Tensão: ");
                                String tensao = scanner.nextLine();
                                produto = new Eletronico(codigo, nome, preco, marca, modelo, tensao);
                                break;
                            case "A":
                                System.out.print("Data de validade: ");
                                String dataValidade = scanner.nextLine();
                                System.out.print("Lote: ");
                                String lote = scanner.nextLine();
                                System.out.print("Tipo: ");
                                String tipoAlimento = scanner.nextLine();
                                produto = new Alimento(codigo, nome, preco, dataValidade, lote, tipoAlimento);
                                break;
                            default:
                                System.out.print("Tamanho: ");
                                String tamanho = scanner.nextLine();
                                System.out.print("Peso: ");
                                String peso = scanner.nextLine();
                                produto = new Produto(codigo, nome, preco, tamanho, peso);
                                break;
                        }

                        produtos.add(produto);

                        System.out.print("Deseja adicionar outro produto? (s/n): ");
                        String resposta = scanner.nextLine();
                        if (resposta.equalsIgnoreCase("n")) {
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("\nLista de produtos:");
                    for (ProdutoBase produto : produtos) {
                        System.out.println("Nome: " + produto.getNome());
                        System.out.println("Codigo: " + produto.getCodigo());
                        
                        double preco = produto.calcularPreco();
                        System.out.println("Preço liquido: " + preco);

                        if (produto instanceof Livro) {
                            Livro livro = (Livro) produto;
                            System.out.println("Tipo: Livro");
                            System.out.println("Autor: " + livro.getAutor());
                            System.out.println("Editora: " + livro.getEditora());
                            System.out.println("Ano de publicacao: " + livro.getAnoPublicacao());
                        } else if (produto instanceof Eletronico) {
                            Eletronico eletronico = (Eletronico) produto;
                            System.out.println("Tipo: Eletronico");
                            System.out.println("Marca: " + eletronico.getMarca());
                            System.out.println("Modelo: " + eletronico.getModelo());
                            System.out.println("Tensao: " + eletronico.getTensao());
                        } else if (produto instanceof Alimento) {
                            Alimento alimento = (Alimento) produto;
                            System.out.println("Tipo: Alimento");
                            System.out.println("Data de validade: " + alimento.getDataValidade());
                            System.out.println("Lote: " + alimento.getLote());
                            System.out.println("Tipo: " + alimento.getTipo());
                        } else if (produto instanceof Produto) {
                            Produto produtoGenerico = (Produto) produto;
                            System.out.println("Tipo: Produto");
                            System.out.println("Tamanho: " + produtoGenerico.getTamanho());
                            System.out.println("Peso: " + produtoGenerico.getPeso());
                        }

                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.print("\nDigite o código do produto a ser editado: ");
                    int codigoEditar = scanner.nextInt();
                    //double precoli = produto.calcularPreco();
                    scanner.nextLine(); // Limpar o buffer
                    ProdutoBase produtoEditar = buscarProdutoPorCodigo(produtos, codigoEditar);
                    System.out.println();
                    
                    if (produtoEditar != null) {
                        System.out.println("Produto encontrado: " + produtoEditar.getNome());
                        System.out.println("Preço atual: " + produtoEditar.getPreco());

                        // Verificar o tipo do produto e exibir informações específicas
                        if (produtoEditar instanceof Produto) {
                            Produto produto = (Produto) produtoEditar;
                            System.out.println("Tamanho: " + produto.getTamanho());
                            System.out.println("Peso: " + produto.getPeso()+ "\n");
                            
                            while(true) {
                            	System.out.print("Digite o novo código: ");
                                int novoCodigo = scanner.nextInt();
                                scanner.nextLine(); // Limpar o buffer
                                
                                boolean codigoEmUso = false;
                                for (ProdutoBase produtoo : produtos) {
                                    if (produtoo.getCodigo() == novoCodigo) {
                                        codigoEmUso = true;
                                        break;
                                    }
                                }
                                
                                if (codigoEmUso) {
                                    System.out.println("Código já em uso. Por favor, digite um código diferente.");
                                    continue; // Volta ao início do loop para solicitar um novo código
                                }
                                
                                System.out.print("Digite o novo nome: ");
                                String novoNome = scanner.nextLine();

                                System.out.print("Digite o novo preço: ");
                                double novoPreco = scanner.nextDouble();
                                scanner.nextLine(); // Limpar o buffer

                                System.out.print("Digite o novo peso: ");
                                String novoPeso = scanner.nextLine();

                                System.out.print("Digite o novo tamanho: ");
                                String novoTamanho = scanner.nextLine();

                                produto = new Produto(novoCodigo, novoNome, novoPreco, novoTamanho, novoPeso);
                                produtos.set(produtos.indexOf(produtoEditar), produto);
                                break;
                            }                        
                        } else if (produtoEditar instanceof Livro) {
                            Livro livro = (Livro) produtoEditar;
                            System.out.println("Autor: " + livro.getAutor());
                            System.out.println("Editora: " + livro.getEditora());
                            System.out.println("Ano de publicação: " + livro.getAnoPublicacao()+ "\n");
                            
                            while(true) {
                            	 System.out.print("Digite o novo código: ");
                                 int novoCodigo = scanner.nextInt();
                                 scanner.nextLine(); // Limpar o buffer
                                 
                                 boolean codigoEmUso = false;
                                 for (ProdutoBase produto : produtos) {
                                     if (produto.getCodigo() == novoCodigo) {
                                         codigoEmUso = true;
                                         break;
                                     }
                                 }
                                 
                         if (codigoEmUso) {
                           System.out.println("Código já em uso. Por favor, digite um código diferente.");
                           continue; // Volta ao início do loop para solicitar um novo código
                                 }
                                 System.out.print("Digite o novo nome: ");
                                 String novoNome = scanner.nextLine();

                                 System.out.print("Digite o novo preço: ");
                                 double novoPreco = scanner.nextDouble();
                                 scanner.nextLine(); // Limpar o buffer

                                 System.out.print("Novo autor: ");
                                 String novoAutor = scanner.nextLine();
                                 System.out.print("Nova editora: ");
                                 String novaEditora = scanner.nextLine();

                                 System.out.print("Novo ano de publicação: ");
                                 int novoAnoPublicacao = scanner.nextInt();
                                 scanner.nextLine(); // Limpar o buffer

                                 livro = new Livro(novoCodigo, novoNome, novoPreco, novoAutor, novaEditora, novoAnoPublicacao);
                                 produtos.set(produtos.indexOf(produtoEditar), livro);
                                 break;
                            }
                                                                                 
                        } else if (produtoEditar instanceof Eletronico) {
                            
                        	Eletronico eletronico = (Eletronico) produtoEditar;
                            System.out.println("Marca: " + eletronico.getMarca());
                            System.out.println("Modelo: " + eletronico.getModelo());
                            System.out.println("Tensão: " + eletronico.getTensao()+ "\n");
                            
                            while(true) {
                            	System.out.print("Digite o novo código: ");
                                int novoCodigo = scanner.nextInt();
                                scanner.nextLine(); // Limpar o buffer
                                
                                boolean codigoEmUso = false;
                                for (ProdutoBase produto : produtos) {
                                    if (produto.getCodigo() == novoCodigo) {
                                        codigoEmUso = true;
                                        break;
                                    }
                                }

                                if (codigoEmUso) {
                                    System.out.println("Código já em uso. Por favor, digite um código diferente.");
                                    continue; // Volta ao início do loop para solicitar um novo código
                                }

                                System.out.print("Digite o novo nome: ");
                                String novoNome = scanner.nextLine();

                                System.out.print("Digite o novo preço: ");
                                double novoPreco = scanner.nextDouble();
                                scanner.nextLine(); // Limpar o buffer

                                System.out.print("Nova marca: ");
                                String novaMarca = scanner.nextLine();

                                System.out.print("Novo modelo: ");
                                String novoModelo = scanner.nextLine();

                                System.out.print("Nova tensão: ");
                                String novaTensao = scanner.nextLine();

                                eletronico = new Eletronico(novoCodigo, novoNome, novoPreco, novaMarca, novoModelo, novaTensao);
                                produtos.set(produtos.indexOf(produtoEditar), eletronico);
                                break;
                            }
                                                        
                        } else if (produtoEditar instanceof Alimento) {
                            Alimento alimento = (Alimento) produtoEditar;
                            System.out.println("Data de validade: " + alimento.getDataValidade());
                            System.out.println("Lote: " + alimento.getLote());
                            System.out.println("Tipo: " + alimento.getTipo() + "\n");
                            
                            while(true) {
                            	 System.out.print("Digite o novo código: ");
                                 int novoCodigo = scanner.nextInt();
                                 scanner.nextLine(); // Limpar o buffer
                                 
                                 boolean codigoEmUso = false;
                                 for (ProdutoBase produto : produtos) {
                                     if (produto.getCodigo() == novoCodigo) {
                                         codigoEmUso = true;
                                         break;
                                     }
                                 }

                                 if (codigoEmUso) {
                                     System.out.println("Código já em uso. Por favor, digite um código diferente.");
                                     continue; // Volta ao início do loop para solicitar um novo código
                                 }

                                 System.out.print("Digite o novo nome: ");
                                 String novoNome = scanner.nextLine();

                                 System.out.print("Digite o novo preço: ");
                                 double novoPreco = scanner.nextDouble();
                                 scanner.nextLine(); // Limpar o buffer

                                 System.out.print("Nova data de validade: ");
                                 String novaDataValidade = scanner.nextLine();

                                 System.out.print("Novo lote: ");
                                 String novoLote = scanner.nextLine();

                                 System.out.print("Novo tipo: ");
                                 String novoTipo = scanner.nextLine();

                                 alimento = new Alimento(novoCodigo, novoNome, novoPreco, novaDataValidade, novoLote, novoTipo);
                                 produtos.set(produtos.indexOf(produtoEditar), alimento);
                                 break;
                             }
                        }
                        System.out.println("--- Produto editado com sucesso ---");
                    } else {
                        System.out.println("Produto não encontrado");
                    }
                    break;

                case 4:
                    System.out.print("\nDigite o código do produto a ser excluído: ");
                    int codigoExcluir = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    ProdutoBase produtoExcluir = buscarProdutoPorCodigo(produtos, codigoExcluir);
                    if (produtoExcluir != null) {
                        produtos.remove(produtoExcluir);
                        System.out.println("--- Produto removido com sucesso ---");
                    } else {
                        System.out.println("Produto não encontrado");
                    }
                    break;
                case 5:
                	System.out.print("\nDigite o código do produto para encontra-lo: ");
                     codigoEditar = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    ProdutoBase produtoEncontrado = buscarProdutoPorCodigo(produtos, codigoEditar);
                    System.out.println();
                    if (produtoEncontrado != null) {
                        System.out.println("Produto encontrado: " + produtoEncontrado.getNome());
                        System.out.println("Preço: " + produtoEncontrado.calcularPreco());

                        // Verificar o tipo do produto e exibir informações específicas
                        if (produtoEncontrado instanceof Produto) {
                            Produto produto = (Produto) produtoEncontrado;
                            System.out.println("Tamanho: " + produto.getTamanho());
                            System.out.println("Peso: " + produto.getPeso());
                            
                        } else if (produtoEncontrado instanceof Livro) {
                            Livro livro = (Livro) produtoEncontrado;
                            System.out.println("Autor: " + livro.getAutor());
                            System.out.println("Editora: " + livro.getEditora());
                            System.out.println("Ano de publicação: " + livro.getAnoPublicacao());
                            
                        } else if (produtoEncontrado instanceof Eletronico) {
                            Eletronico eletronico = (Eletronico) produtoEncontrado;
                            System.out.println("Marca: " + eletronico.getMarca());
                            System.out.println("Modelo: " + eletronico.getModelo());
                            System.out.println("Tensão: " + eletronico.getTensao());
                            
                        } else if (produtoEncontrado instanceof Alimento) {
                            Alimento alimento = (Alimento) produtoEncontrado;
                            System.out.println("Data de validade: " + alimento.getDataValidade());
                            System.out.println("Lote: " + alimento.getLote());
                            System.out.println("Tipo: " + alimento.getTipo());
                        }
                    } else {
                        System.out.println("Produto não encontrado");
                    }
                    break;
                case 6:
                	continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um valor válido.");
                scanner.nextLine(); // Limpar o buffer
            }
        }

        System.out.println("Encerrando o programa...");
        scanner.close();
    }
}
