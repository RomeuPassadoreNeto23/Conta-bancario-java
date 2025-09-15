# 💳 Sistema Bancário em Java

Este projeto é um sistema bancário simples desenvolvido em Java, com foco educacional. Ele permite ao usuário realizar operações básicas como consultar saldo, verificar cheque especial, depositar e sacar dinheiro, tudo por meio de um menu interativo no terminal.

---

## 📁 Estrutura do Projetosrc/ 
├── Main.java // Classe principal com o menu de interação.    
└── Conta.java // Classe que representa a conta bancária e suas operações
## 🧭 Funcionalidades
Solicitação de depósito inicial obrigatório (maior que R$ 0)


Menu interativo com as opções:

0: Sair

1: Consultar saldo

2: Consultar cheque especial

3: Depositar dinheiro

4: Sacar dinheiro

Cheque especial com limite dinâmico e taxa de 20% sobre o valor utilizado

Depósitos futuros são usados para quitar o cheque especial antes de serem adicionados ao saldo

## Como executar

1. Clone este repositório:
2. git clone https://github.com/RomeuPassadoreNeto23/Conta-bancario-java.git
3. Compile o projeto: javac src/*.java
4. Execute o programa: java -cp src Main
## Estrutura do Projeto

- `src/Main.java`: Classe principal com o menu de interação.
- `src/Conta.java`: Classe que representa a conta bancária e suas operações.

## Requisitos

- Java 8 ou superior

## 👤 Autor
Romeu Passadore Neto

---

Este projeto é apenas para fins educacionais.
