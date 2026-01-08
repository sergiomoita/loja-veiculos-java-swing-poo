// Arquivo: TelaCadastro.java (adaptado para gravar no CSV)
package POO3;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelaCadastro extends JFrame {

    public static List<Cliente> listaClientes = new ArrayList<>();
    public static Map<String, String> mapaSenhas = new HashMap<>();

    static {
        Cliente clienteTeste = new Cliente("Usuário Teste", "12345678900", 999999999, "teste@email.com", 1000000.0, "1234");
        listaClientes.add(clienteTeste);
        mapaSenhas.put("12345678900", "1234");
    }

    public TelaCadastro() {
        setTitle("Cadastro de Usuário");
        setSize(450, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Color fundoEscuro = new Color(30, 30, 30);
        Color textoClaro = new Color(230, 230, 230);
        Color vermelhoPrincipal = new Color(192, 0, 0);
        Font fonte = new Font("SansSerif", Font.PLAIN, 16);

        getContentPane().setBackground(fundoEscuro);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(fundoEscuro);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.setBackground(fundoEscuro);

        JLabel lblNome = new JLabel("Nome:");
        JLabel lblEmail = new JLabel("Email:");
        JLabel lblSenha = new JLabel("Senha:");
        JLabel lblCpf = new JLabel("CPF:");
        JLabel lblCelular = new JLabel("Celular:");
        JLabel lblSaldo = new JLabel("Saldo:");

        JTextField txtNome = new JTextField(12);
        JTextField txtEmail = new JTextField(12);
        JPasswordField txtSenha = new JPasswordField(12);
        JTextField txtCpf = new JTextField(12);
        JTextField txtCelular = new JTextField(12);
        JTextField txtSaldo = new JTextField(12);

        JLabel[] labels = {lblNome, lblEmail, lblSenha, lblCpf, lblCelular, lblSaldo};
        JTextField[] fields = {txtNome, txtEmail, txtSenha, txtCpf, txtCelular, txtSaldo};

        for (JLabel lbl : labels) {
            lbl.setForeground(textoClaro);
            lbl.setFont(fonte);
        }

        for (JTextField field : fields) {
            field.setFont(fonte);
        }

        for (int i = 0; i < labels.length; i++) {
            formPanel.add(labels[i]);
            formPanel.add(fields[i]);
        }

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBackground(vermelhoPrincipal);
        btnSalvar.setForeground(Color.WHITE);
        btnSalvar.setFocusPainted(false);
        btnSalvar.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSalvar.setMaximumSize(new Dimension(150, 40));
        btnSalvar.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(formPanel);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(btnSalvar);

        add(mainPanel);
        getRootPane().setDefaultButton(btnSalvar);
        setVisible(true);

        btnSalvar.addActionListener(e -> {
            try {
                String nome = txtNome.getText().trim();
                String email = txtEmail.getText().trim();
                String senha = new String(txtSenha.getPassword()).trim();
                String cpf = txtCpf.getText().trim();
                String celularStr = txtCelular.getText().trim();
                String saldoStr = txtSaldo.getText().trim();

                if (nome.isEmpty()) throw new Exception("Nome não pode estar vazio");
                if (nome.matches(".*\\d.*")) throw new Exception("Nome não pode conter números");
                if (!email.contains("@") || !email.contains(".")) throw new Exception("Email inválido");
                if (senha.length() < 4) throw new Exception("Senha muito curta");
                if (!senha.matches("\\d+")) throw new Exception("A senha deve conter apenas números");
                if (cpf.length() != 11) throw new Exception("CPF inválido");
                if (!celularStr.matches("\\d{9}")) throw new Exception("Celular deve ter entre 9 dígitos numéricos");
                if (!saldoStr.matches("\\d+(\\.\\d+)?")) throw new Exception("Saldo inválido");

                if (mapaSenhas.containsKey(cpf)) {
                    throw new Exception("CPF já cadastrado!");
                }

                int celular = Integer.parseInt(celularStr);
                double saldo = Double.parseDouble(saldoStr);

                Cliente novoCliente = new Cliente(nome, cpf, celular, email, saldo, senha);
                listaClientes.add(novoCliente);
                mapaSenhas.put(cpf, senha);

                Cliente.salvarClienteSemVeiculo(novoCliente); // <<< Grava no CSV

                JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        });
    }
}
