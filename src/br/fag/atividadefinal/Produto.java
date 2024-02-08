package br.fag.atividadefinal;

class Produto extends ProdutoBase {
    private String tamanho;
    private String peso;

    public Produto(int codigo, String nome, double preco, String tamanho, String peso) {
        super(codigo, nome, preco);
        this.tamanho = tamanho;
        this.peso = peso;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getPeso() {
        return peso;
    }

    @Override
    public double calcularPreco() {
        // Neste exemplo, não há desconto para produtos genéricos
        return getPreco();
    }
}

