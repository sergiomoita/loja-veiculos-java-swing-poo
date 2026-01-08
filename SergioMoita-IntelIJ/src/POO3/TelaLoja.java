package POO3;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaLoja extends JFrame {
    ArrayList<Veiculos> veiculos = new ArrayList<>();

    private int[][] estoque;
    private Cliente cliente;
    private JPanel painel;

    public TelaLoja(Cliente cliente) {
        this(cliente, null);
    }

    public TelaLoja(Cliente cliente, int[][] estoqueAntigo) {
        this.cliente = cliente;

        // Adiciona veículos
        veiculos.add(new Carros("Onix", "GTR3H92", "Branco", 2020, 59290, 45000, 123456789));
        veiculos.add(new Carros("Creta", "BNL9K04", "Prata", 2023, 128900, 12000, 987654321));
        veiculos.add(new Carros("Polo", "QWE6J88", "Preto", 2021, 97990, 30000, 222233344));
        veiculos.add(new Carros("Fastback", "MPX7F31", "Vermelho", 2022, 139990, 18000, 333444555));
        veiculos.add(new Carros("Celta", "JUZ4M20", "Vermelho", 2014, 26500, 85000, 464455666));
        veiculos.add(new Carros("Mobi", "TCL2A59", "Cinza", 2019, 42900, 60000, 555666777));

        veiculos.add(new Motos("Harley", "HKV5B17", "Preto", 2022, 58900, 7000, 111122333));
        veiculos.add(new Motos("Biz", "RXD1E73", "Vermelho", 2018, 10800, 28000, 111122333));
        veiculos.add(new Motos("Pop", "VMA8N60", "Branca", 2015, 7200, 42000, 666777888));

        // Inicializa ou reaproveita matriz de estoque
        if (estoqueAntigo == null) {
            estoque = new int[2][veiculos.size()];
            for (int i = 0; i < veiculos.size(); i++) {
                Veiculos v = veiculos.get(i);
                if (v instanceof Carros) {
                    estoque[0][i] = 1;
                } else {
                    estoque[1][i] = 1;
                }
            }
        } else {
            this.estoque = estoqueAntigo;
        }

        // Configuração da janela
        setTitle("LegendaryMotorsSports - Loja oficial ");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        String saldoFormatado = String.format("R$%.2f", cliente.getSaldo()).replace('.', ',');
        JButton clienteInfo = new JButton("Cliente: " + cliente.getNome() + " | Saldo: " + saldoFormatado);
        clienteInfo.setHorizontalAlignment(SwingConstants.RIGHT);
        clienteInfo.setFont(new Font("Arial", Font.BOLD, 16));
        clienteInfo.setBackground(Color.RED);
        clienteInfo.setForeground(Color.WHITE);
        clienteInfo.setFocusPainted(false);
        clienteInfo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));
        add(clienteInfo, BorderLayout.NORTH);
        clienteInfo.addActionListener(e -> new DetalhesCliente(cliente, this));

        painel = new JPanel(new GridLayout(0, 3, 15, 15));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        painel.setBackground(new Color(240, 240, 240));

        atualizarVitrine();

        JScrollPane scroll = new JScrollPane(painel);
        add(scroll, BorderLayout.CENTER);

        setVisible(true);
    }

    private void atualizarVitrine() {
        painel.removeAll();

        for (int i = 0; i < veiculos.size(); i++) {
            Veiculos v = veiculos.get(i);
            int tipo = (v instanceof Carros) ? 0 : 1;
            int qtd = estoque[tipo][i];

            JPanel painelVeiculo = new JPanel(new BorderLayout());
            painelVeiculo.setBackground(Color.WHITE);
            painelVeiculo.setBorder(BorderFactory.createLineBorder(Color.RED));

            String caminhoImagem = "/POO3/imagens/" + v.getModelo() + ".png";
            ImageIcon imagem = new ImageIcon(getClass().getResource(caminhoImagem));
            Image imgRedimensionada = imagem.getImage().getScaledInstance(300, 160, Image.SCALE_SMOOTH);
            imagem = new ImageIcon(imgRedimensionada);

            JLabel imgLabel = new JLabel(imagem);
            painelVeiculo.add(imgLabel, BorderLayout.CENTER);

            final int index = i;
            String precoFormatado = String.format("R$%.2f", v.getPreco()).replace('.', ',');
            JButton botao;

            if (qtd > 0) {
                botao = new JButton(v.getModelo() + " - " + precoFormatado + " | Qtd: " + qtd);
                botao.addActionListener(e -> new DetalhesVeiculo(v, cliente, this, index, tipo));
            } else {
                botao = new JButton(v.getModelo() + " - Indisponível");
                botao.setEnabled(false);
            }

            botao.setBackground(Color.RED);
            botao.setForeground(Color.WHITE);
            botao.setFocusPainted(false);
            botao.setFont(new Font("Arial", Font.BOLD, 14));

            painelVeiculo.add(botao, BorderLayout.SOUTH);
            painel.add(painelVeiculo);
        }

        painel.revalidate();
        painel.repaint();
    }

    public void atualizarEstoqueOuRemover(int index, int tipo) {
        estoque[tipo][index]--;
        atualizarVitrine();
    }

    public int[][] getEstoque() {
        return estoque;
    }
}