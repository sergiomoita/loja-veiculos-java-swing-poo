package POO3;

abstract class Conta {
    private String nome;
    private String cpf;
    private int celular;
    private String email;
    private double saldo = 0;

    public Conta(String nome, String cpf, int celular, String email, double saldo) {
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
        this.email = email;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
