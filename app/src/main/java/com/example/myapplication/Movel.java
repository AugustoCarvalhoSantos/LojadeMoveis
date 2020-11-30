package com.example.myapplication;

public class Movel {
}

    int cod;
    String tipo;
    String medida;
    String preco;
    String cor;
    String material;

    public Movel(){}

    public Movel(int _cod, String _tipo, String _medida, String _preco, String _cor, String _material){
        this.cod = _cod;
        this.tipo = _tipo;
        this.medida = _medida;
        this.preco = _preco;
        this.cor = _cor;
        this.material = _material;
    }

    public Movel(String _tipo, String _medida, String _preco, String _cor, String _material){
        this.tipo = _tipo;
        this.medida = _medida;
        this.preco = _preco;
        this.cor = _cor;
        this.material = _material;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String email) {
        this.preco = preco;
    }
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.preco = cor;
    }
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
