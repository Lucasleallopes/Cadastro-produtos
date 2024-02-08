package br.fag.atividadefinal;

class Livro extends ProdutoBase {
    private String autor;
    private String editora;
    private int anoPublicacao;

    public Livro(int codigo, String nome, double preco, String autor, String editora, int anoPublicacao) {
        super(codigo, nome, preco);
        this.autor = autor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    @Override
    public double calcularPreco() {
        // Exemplo: 10% de desconto para livros
        return getPreco() * 0.9;
    }
}
