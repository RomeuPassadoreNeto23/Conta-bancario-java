import java.util.Scanner;

/**
 * Classe principal do sistema bancário.
 * Permite ao usuário interagir com uma conta bancária, realizando operações como
 * consultar saldo, consultar cheque especial, depositar e sacar dinheiro.
 */
public class Main {
    // Scanner para entrada de dados do usuário
    private final static Scanner scanner = new Scanner(System.in);

    /**
     * Método principal que inicia o programa.
     * Solicita um depósito inicial válido e apresenta um menu de opções para o usuário.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        var depositoInicial = 0.0;

        // Solicita um depósito inicial maior que 0
        while (depositoInicial <= 0 ) {
            System.out.print("Digite o valor do depósito inicial (maior que 0): ");
            depositoInicial = scanner.nextDouble();
            if (depositoInicial <= 0) {
                System.out.println("Valor inválido. Tente novamente.");
            }
        }

        var option = -1;
        Conta conta = new Conta(depositoInicial);

        // Loop principal do menu
        do {
            System.out.println("\n=== Menu ===");
            System.out.println("0. Sair");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Consultar cheque especial");
            System.out.println("3. Depositar dinheiro");
            System.out.println("4. Sacar dinheiro");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            // Processa a opção escolhida pelo usuário
            switch (option) {
                case 0 -> {
                    System.out.println("Encerrando o programa. Obrigado por usar nosso sistema bancário!");
                    System.exit(0);
                }
                case 1 -> conta.consultarSaldo(); // Consulta o saldo da conta
                case 2 -> conta.consultarChequeEspecial(); // Consulta o cheque especial da conta
                case 3 -> deposit(conta); // Realiza um depósito
                case 4 -> withdraw(conta); // Realiza um saque
                default -> System.out.println("Opção inválida. Tente novamente."); // Opção inválida
            }

        } while (true);
    }

    /**
     * Realiza a operação de saque na conta.
     *
     * @param conta A conta bancária onde o saque será realizado.
     */
    private static void withdraw(Conta conta) {
        System.out.print("Digite o valor a ser sacado: ");
        double valorSaque = scanner.nextDouble();
        if (valorSaque > 0) {
            conta.sacar(valorSaque); // Realiza o saque se o valor for válido
        } else {
            System.out.println("Valor inválido para saque."); // Mensagem de erro para valor inválido
        }
    }

    /**
     * Realiza a operação de depósito na conta.
     *
     * @param conta A conta bancária onde o depósito será realizado.
     */
    private static void deposit(Conta conta) {
        System.out.print("Digite o valor a ser depositado: ");
        double valorDeposito = scanner.nextDouble();
        if (valorDeposito > 0) {
            conta.depositar(valorDeposito); // Realiza o depósito se o valor for válido
        } else {
            System.out.println("Valor inválido para depósito."); // Mensagem de erro para valor inválido
        }
    }
}