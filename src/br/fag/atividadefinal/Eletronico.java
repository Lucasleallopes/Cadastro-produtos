package br.fag.atividadefinal;

class Eletronico extends ProdutoBase {
    private String marca;
    private String modelo;
    private String tensao;
    
    public Eletronico(int codigo, String nome, double preco, String marca, String modelo, String tensao) {
        super(codigo, nome, preco);
        this.marca = marca;
        this.modelo = modelo;
        this.tensao = tensao;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTensao() {
        return tensao;
    }
    
    @Override
    public double calcularPreco() {
        // Exemplo: 5% de desconto para eletrônicos
        return getPreco() * 0.95;
    }
}
