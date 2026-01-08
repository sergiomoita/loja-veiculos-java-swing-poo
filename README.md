# LegendaryMotorsSports — Java Swing & POO

Aplicação desktop desenvolvida em **Java Swing**, aplicando conceitos de **Programação Orientada a Objetos (POO)** para simular uma loja de veículos.  
O sistema possui fluxo de **cadastro**, **login**, **listagem de veículos** e **visualização de detalhes**, com persistência simples em arquivo CSV.

> Projeto acadêmico desenvolvido para fins educacionais, com foco em POO e interfaces gráficas em Java.

---

## ✨ Funcionalidades

- Tela inicial com navegação
- Cadastro de clientes com validações básicas
- Login utilizando CPF e senha
- Tela da loja com exibição de veículos (carros e motos)
- Tela de detalhes do veículo
- Tela de detalhes do cliente
- Persistência de dados em arquivo CSV (`clientes.csv`)

---

## 🧠 Conceitos de Programação Orientada a Objetos

O projeto aplica os principais pilares de POO:

- **Abstração**  
  - Classe abstrata `Conta`

- **Herança**  
  - Classe base `Veiculos`  
  - Classes derivadas `Carros` e `Motos`

- **Encapsulamento**  
  - Atributos privados com métodos getters e setters

- **Interfaces**  
  - Interfaces `Venda` e `Informacoes`, implementadas pela classe `Cliente`

- **Separação de responsabilidades**  
  - Classes de interface gráfica (`Tela*`)
  - Classes de domínio (Cliente, Veiculos, Conta, etc.)

---

## 💾 Persistência de dados

Os dados dos clientes são armazenados em um arquivo:

clientes.csv

Esse arquivo é criado automaticamente na primeira execução do programa e utilizado para leitura e gravação dos dados.

> Para reiniciar os dados durante testes, basta apagar o arquivo `clientes.csv`.

---

## 📁 Estrutura do projeto

O projeto utiliza a seguinte organização de pastas:

src/
└─ POO3/
├─ Main.java
├─ TelaInicial.java
├─ TelaLogin.java
├─ TelaCadastro.java
├─ TelaLoja.java
├─ DetalhesVeiculo.java
├─ DetalhesCliente.java
├─ Cliente.java
├─ Conta.java
├─ Veiculos.java
├─ Carros.java
├─ Motos.java
├─ Venda.java
├─ Informacoes.java
└─ imagens/
└─ LogoLegendaryMotorsSports.png


As imagens são carregadas utilizando `getResource()` com o caminho:

/POO3/imagens/LogoLegendaryMotorsSports.png


---

## ▶️ Como executar o projeto

### Pela IDE (recomendado)

1. Abra o projeto em uma IDE Java (IntelliJ IDEA, Eclipse ou NetBeans)
2. Certifique-se de que a pasta `src` está marcada como **Source Root**
3. Execute a classe:
   - `POO3.Main`

---

## 🛠 Tecnologias utilizadas

- Java
- Java Swing
- Programação Orientada a Objetos
- Arquivo CSV para persistência simples

---

## 🚀 Possíveis melhorias futuras

- Persistência utilizando banco de dados (SQLite ou MySQL)
- Organização do projeto seguindo o padrão MVC
- Validações mais robustas (CPF, senha, campos obrigatórios)
- Testes unitários com JUnit
- Geração de arquivo `.jar` executável

---

## 👤 Autor

**Sérgio Moita**  
Projeto acadêmico — Java e Programação Orientada a Objetos  
Ano: 2026
