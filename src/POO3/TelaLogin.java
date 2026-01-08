package POO3;

import javax.swing.*;
import java.awt.*;

public class TelaLogin extends JFrame {

    public TelaLogin(TelaInicial telaInicial) {
        setTitle("Login");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Cores e fonte padrão
        Color fundoEscuro = new Color(30, 30, 30);
        Color textoClaro = new Color(230, 230, 230);
        Color vermelhoPrincipal = new Color(192, 0, 0);
        Font fonte = new Font("SansSerif", Font.PLAIN, 16);

        getContentPane().setBackground(fundoEscuro);

        // Painel principal com BoxLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(fundoEscuro);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Campos de CPF e senha
        JTextField txtCpf = new JTextField();
        JPasswordField txtSenha = new JPasswordField();
        Dimension tamanhoCampo = new Dimension(150, 30);
        txtCpf.setPreferredSize(tamanhoCampo);
        txtSenha.setPreferredSize(tamanhoCampo);
        txtCpf.setFont(fonte);
        txtSenha.setFont(fonte);

// Labels
        JLabel lblCpf = new JLabel("CPF:");
        JLabel lblSenha = new JLabel("Senha:");
        lblCpf.setForeground(textoClaro);
        lblSenha.setForeground(textoClaro);
        lblCpf.setFont(fonte);
        lblSenha.setFont(fonte);

// Painéis para encapsular os campos e evitar que o GridLayout os expanda
        JPanel painelCpf = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 30));
        painelCpf.setBackground(fundoEscuro);
        painelCpf.add(txtCpf);

        JPanel painelSenha = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 30));
        painelSenha.setBackground(fundoEscuro);
        painelSenha.add(txtSenha);

// Painel de formulário com GridLayout (2x2)
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        formPanel.setBackground(fundoEscuro);
        formPanel.add(lblCpf);
        formPanel.add(painelCpf);
        formPanel.add(lblSenha);
        formPanel.add(painelSenha);

        // Botão de entrar
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEntrar.setBackground(vermelhoPrincipal);
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setFocusPainted(false);
        btnEntrar.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnEntrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnEntrar.setMaximumSize(new Dimension(150, 40));

        // Adicionando tudo ao painel principal
        mainPanel.add(formPanel);
        mainPanel.add(Box.createVerticalStrut(25));
        mainPanel.add(btnEntrar);

        add(mainPanel);
        getRootPane().setDefaultButton(btnEntrar);
        setVisible(true);

        // Lógica do botão
        btnEntrar.addActionListener(e -> {
            String cpf = txtCpf.getText();
            String senha = new String(txtSenha.getPassword()).trim();

            if (TelaCadastro.mapaSenhas.containsKey(cpf) &&
                    TelaCadastro.mapaSenhas.get(cpf).equals(senha)) {

                JOptionPane.showMessageDialog(this, "Login bem-sucedido!");

                for (Cliente c : TelaCadastro.listaClientes) {
                    if (c.getCpf().equals(cpf)) {
                        new TelaLoja(c);
                        telaInicial.dispose();
                        break;
                    }
                }

                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "CPF ou senha incorretos!");
            }
        });
    }
}