// Arquivo: Cliente.java (ajustado com leitura e escrita CSV)
package POO3;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Cliente extends Conta implements Venda, Informacoes {
    String senha;
    private ArrayList<Veiculos> veiculos = new ArrayList<>();

    public Cliente(String nome, String cpf, int celular, String email, double saldo, String senha) {
        super(nome, cpf, celular, email, saldo);
        this.senha = senha;
    }

    public void adicionarVeiculo(Veiculos v) {
        veiculos.add(v);
        salvarNoCSV(this, v); // Salva veículo junto com dados do cliente
    }

    public ArrayList<Veiculos> getVeiculos() {
        return veiculos;
    }

    @Override
    public void compraVenda(double preco) {
        double saldo  = getSaldo() - preco;
        setSaldo(saldo);
    }

    @Override
    public JPanel ExibirInformacoes() {
        carregarDoCSV();

        Color textoClaro = new Color(230, 230, 230);
        Font fonte = new Font("SansSerif", Font.PLAIN, 16);

        JPanel painel = new JPanel(new GridLayout(0, 1, 5, 15));
        painel.setBackground(new Color(30, 30, 30));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        JLabel[] labels = {
                new JLabel("Nome: " + getNome()),
                new JLabel("CPF: " + getCpf()),
                new JLabel("Celular: " + getCelular()),
                new JLabel("Email: " + getEmail()),
                new JLabel(String.format("Saldo: R$%.2f", getSaldo())),
                new JLabel("Senha: " + getSenha()),
        };

        for (JLabel lbl : labels) {
            lbl.setForeground(textoClaro);
            lbl.setFont(fonte);
            painel.add(lbl);
        }

        JLabel veiculosLabel = new JLabel("Veículos:");
        veiculosLabel.setForeground(textoClaro);
        veiculosLabel.setFont(fonte);
        painel.add(veiculosLabel);

        if (veiculos.isEmpty()) {
            JLabel vazio = new JLabel("Sem veículos");
            vazio.setForeground(textoClaro);
            vazio.setFont(fonte);
            painel.add(vazio);
        } else {
            for (Veiculos v : veiculos) {
                JLabel vLabel = new JLabel("- " + v.getModelo() + " (" + v.getPlaca() + ")");
                vLabel.setForeground(textoClaro);
                vLabel.setFont(fonte);
                painel.add(vLabel);
            }
        }

        return painel;
    }

    public String getSenha() {
        return senha;
    }

    public static void salvarNoCSV(Cliente cliente, Veiculos v) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("clientes.csv", true))) {
            writer.write(cliente.getNome() + "," + cliente.getEmail() + "," + cliente.getSenha() + "," +
                    cliente.getCpf() + "," + cliente.getCelular() + "," + cliente.getSaldo() + "," +
                    v.getModelo() + "," + v.getPlaca() + "," + v.getCor() + "," +
                    v.getAno() + "," + v.getPreco() + "," + v.getQuilometragem() + "," + v.getRenavam());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void salvarClienteSemVeiculo(Cliente cliente) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("clientes.csv", true))) {
            writer.write(cliente.getNome() + "," + cliente.getEmail() + "," + cliente.getSenha() + "," +
                    cliente.getCpf() + "," + cliente.getCelular() + "," + cliente.getSaldo() + ",,,,,,,");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarDoCSV() {
        veiculos.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("clientes.csv"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length >= 13 && partes[3].equals(this.getCpf())) {
                    this.setNome(partes[0]);
                    this.setEmail(partes[1]);
                    this.senha = partes[2];
                    this.setCpf(partes[3]);
                    this.setCelular(Integer.parseInt(partes[4]));
                    this.setSaldo(Double.parseDouble(partes[5]));

                    if (!partes[6].isEmpty()) {
                        String modelo = partes[6];
                        String placa = partes[7];
                        String cor = partes[8];
                        int ano = Integer.parseInt(partes[9]);
                        double preco = Double.parseDouble(partes[10]);
                        int km = Integer.parseInt(partes[11]);
                        int renavam = Integer.parseInt(partes[12]);

                        Veiculos veiculo = new Carros(modelo, placa, cor, ano, preco, km, renavam);
                        veiculos.add(veiculo);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
