// Arquivo: DetalhesVeiculo.java (adaptação para gravar no CSV ao comprar)
package POO3;

import javax.swing.*;
import java.awt.*;

public class DetalhesVeiculo extends JFrame {

    public DetalhesVeiculo(Veiculos v, Cliente cliente, TelaLoja loja, int index, int tipo) {
        setTitle("Detalhes do Veículo");
        setSize(400, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(30, 30, 30));

        add(v.ExibirInformacoes(), BorderLayout.CENTER);

        JButton comprar = new JButton("Comprar");
        JButton fechar = new JButton("Fechar");

        Font fonteBotao = new Font("SansSerif", Font.BOLD, 14);
        Color vermelho = new Color(192, 0, 0);

        comprar.setFont(fonteBotao);
        comprar.setBackground(vermelho);
        comprar.setForeground(Color.WHITE);
        comprar.setFocusPainted(false);
        comprar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        comprar.setPreferredSize(new Dimension(120, 35));

        fechar.setFont(fonteBotao);
        fechar.setBackground(Color.GRAY);
        fechar.setForeground(Color.WHITE);
        fechar.setFocusPainted(false);
        fechar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        fechar.setPreferredSize(new Dimension(120, 35));

        comprar.addActionListener(e -> {
            if (cliente.getSaldo() >= v.getPreco()) {
                cliente.compraVenda(v.getPreco());
                cliente.adicionarVeiculo(v); // <<< já grava no CSV internamente
                loja.atualizarEstoqueOuRemover(index, tipo);

                JOptionPane.showMessageDialog(this,
                        String.format("Compra realizada.\nNovo saldo: R$ %.2f", cliente.getSaldo()),
                        "Compra Confirmada", JOptionPane.INFORMATION_MESSAGE);

                dispose();
                loja.dispose();
                new TelaLoja(cliente, loja.getEstoque());
            } else {
                JOptionPane.showMessageDialog(this,
                        "Saldo insuficiente para comprar esse veículo.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        fechar.addActionListener(e -> dispose());

        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(new Color(30, 30, 30));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        painelBotoes.add(comprar);
        painelBotoes.add(fechar);

        add(painelBotoes, BorderLayout.SOUTH);
        setVisible(true);
    }
}
