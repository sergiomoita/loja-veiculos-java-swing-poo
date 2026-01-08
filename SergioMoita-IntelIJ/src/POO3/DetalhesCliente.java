package POO3;

import javax.swing.*;
import java.awt.*;

public class DetalhesCliente extends JFrame {

    public DetalhesCliente(Cliente cliente, TelaLoja loja) {
        setTitle("Detalhes do Cliente");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(30, 30, 30));
        setLayout(new BorderLayout());

        // Painel com informações
        JScrollPane scrollPane = new JScrollPane(cliente.ExibirInformacoes());
        scrollPane.setBorder(null); // opcional: remove a borda do scroll
        scrollPane.getVerticalScrollBar().setUnitIncrement(10); // suaviza a rolagem
        add(scrollPane, BorderLayout.CENTER);

        // Botão fechar estilizado
        JButton fechar = new JButton("Fechar");
        fechar.setBackground(new Color(192, 0, 0));
        fechar.setForeground(Color.WHITE);
        fechar.setFocusPainted(false);
        fechar.setFont(new Font("SansSerif", Font.BOLD, 14));
        fechar.setPreferredSize(new Dimension(100, 35));
        fechar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        fechar.addActionListener(e -> dispose());

        JPanel painelBotao = new JPanel();
        painelBotao.setBackground(new Color(30, 30, 30));
        painelBotao.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        painelBotao.add(fechar);

        add(painelBotao, BorderLayout.SOUTH);
        getRootPane().setDefaultButton(fechar);
        setVisible(true);
    }
}
