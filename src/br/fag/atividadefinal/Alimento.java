package br.fag.atividadefinal;

class Alimento extends ProdutoBase {
    private String dataValidade;
    private String lote;
    private String tipo;

    public Alimento(int codigo, String nome, double preco, String dataValidade, String lote, String tipo) {
        super(codigo, nome, preco);
        this.dataValidade = dataValidade;
        this.lote = lote;
        this.tipo = tipo;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public String getLote() {
        return lote;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public double calcularPreco() {
        // Exemplo: 15% de desconto para alimentos
        return getPreco() * 0.85;
    }
}
