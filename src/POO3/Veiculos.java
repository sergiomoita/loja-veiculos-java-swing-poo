package POO3;

import javax.swing.*;
import java.awt.*;

abstract class Veiculos implements Informacoes{
    private String modelo;
    private String placa;
    private String cor;
    private int ano;
    private double preco;
    private int quilometragem;
    private int renavam;

    public Veiculos(String modelo, String placa, String cor, int ano, double preco, int quilometragem, int renavam) {
        this.modelo = modelo;
        this.placa = placa;
        this.cor = cor;
        this.ano = ano;
        this.preco = preco;
        this.quilometragem = quilometragem;
        this.renavam = renavam;
    }

    @Override
    public JPanel ExibirInformacoes() {
        Color textoClaro = new Color(230, 230, 230);
        Font fonte = new Font("SansSerif", Font.PLAIN, 16);

        JPanel painel = new JPanel(new GridLayout(0, 1, 5, 10));
        painel.setBackground(new Color(30, 30, 30));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        JLabel[] labels = {
                new JLabel("Modelo: " + getModelo()),
                new JLabel("Placa: " + getPlaca()),
                new JLabel("Ano: " + getAno()),
                new JLabel("Cor: " + getCor()),
                new JLabel("Quilometragem: " + getQuilometragem() + " km"),
                new JLabel("Renavam: " + getRenavam()),
                new JLabel(String.format("Preço: R$%.2f", getPreco()))
        };

        for (JLabel lbl : labels) {
            lbl.setForeground(textoClaro);
            lbl.setFont(fonte);
            painel.add(lbl);
        }

        return painel;
    }



    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public int getRenavam() {
        return renavam;
    }

    public void setRenavam(int renavam) {
        this.renavam = renavam;
    }
}
