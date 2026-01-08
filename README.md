# LegendaryMotorsSports — Java Swing + POO

Aplicação desktop desenvolvida em **Java Swing**, aplicando conceitos de **Programação Orientada a Objetos (POO)** para simular uma loja de veículos com **cadastro**, **login**, **listagem de veículos** e **visualização de detalhes**.

> Projeto acadêmico (POO + Interface Gráfica), com persistência simples em arquivo CSV.

---

## ✨ Funcionalidades

- Tela inicial com navegação
- Cadastro de cliente com validações (nome, email, senha numérica, CPF, etc.)
- Login por CPF + senha
- Tela da loja com listagem de veículos (carros/motos)
- Tela de detalhes do veículo e do cliente
- Persistência em arquivo **CSV** (`clientes.csv`) gerado automaticamente

---

## 🧱 Conceitos de POO utilizados

- **Abstração**: `Conta` (classe abstrata)
- **Herança**: `Veiculos` → `Carros` e `Motos`
- **Encapsulamento**: atributos privados + getters/setters
- **Interfaces**: `Venda` e `Informacoes` implementadas em `Cliente`
- **Separação por responsabilidade**:
  - `Tela*` (UI Swing)
  - classes de domínio (`Cliente`, `Veiculos`, `Carros`, `Motos`, etc.)

---

## 💾 Persistência (CSV)

O projeto salva e lê dados no arquivo:

- `clientes.csv` (criado na pasta onde o programa é executado)

Isso permite manter dados básicos do cliente e (quando aplicável) veículos associados.

> Dica: se quiser “resetar” os dados durante testes, basta apagar o arquivo `clientes.csv`.

---

## ▶️ Como executar

### Opção A) Pela IDE (mais simples)
1. Abra o projeto no IntelliJ / Eclipse / NetBeans
2. Execute a classe:
   - `POO3.Main`

### Opção B) Pelo terminal (sem Maven)
Dentro da pasta do projeto:

```bash
# compilar
javac -d out src/main/java/POO3/*.java

# executar
java -cp out POO3.Main
