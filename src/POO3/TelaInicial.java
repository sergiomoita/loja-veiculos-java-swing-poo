package POO3;
import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JFrame {

    public TelaInicial() {
        setTitle("LegendaryMotorsSports - Loja oficial");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Color vermelhoPrincipal = new Color(192, 0, 0);
        Color fundoEscuro = new Color(30, 30, 30);
        Color textoClaro = new Color(230, 230, 230);

        getContentPane().setBackground(fundoEscuro);

        ImageIcon imagem = new ImageIcon(getClass().getResource("/POO3/imagens/LogoLegendaryMotorsSports.png"));
        JLabel imagemLabel = new JLabel(imagem);
        imagemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imagemLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        JLabel label = new JLabel("<html><div style='text-align: center;'>Legendary Motors - Loja oficial<br>Seja Bem-Vindo!</div></html>", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 24));
        label.setForeground(textoClaro);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));

        JButton btnLogin = new JButton("Login");
        JButton btnCadastro = new JButton("Cadastro");

        Dimension botaoTamanho = new Dimension(80, 45);
        Font fonteBotao = new Font("SansSerif", Font.BOLD, 25);

        JButton[] botoes = {btnLogin, btnCadastro};
        for (JButton btn : botoes) {
            btn.setPreferredSize(botaoTamanho);
            btn.setBackground(vermelhoPrincipal);
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setFont(fonteBotao);
            btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        JPanel botoesPanel = new JPanel();
        botoesPanel.setLayout(new BoxLayout(botoesPanel, BoxLayout.Y_AXIS));
        botoesPanel.setBackground(fundoEscuro);

        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCadastro.setAlignmentX(Component.CENTER_ALIGNMENT);

        botoesPanel.add(btnLogin);
        botoesPanel.add(Box.createVerticalStrut(15));
        botoesPanel.add(btnCadastro);
        botoesPanel.add(Box.createVerticalStrut(40));

        setLayout(new BorderLayout());
        add(imagemLabel, BorderLayout.NORTH);
        add(label, BorderLayout.CENTER);
        add(botoesPanel, BorderLayout.SOUTH);

        btnCadastro.addActionListener(e -> new TelaCadastro());
        btnLogin.addActionListener(e -> new TelaLogin(this));

        setVisible(true);
    }
}
