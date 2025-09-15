/**
 * Classe que representa uma conta bancária.
 * Permite realizar operações como consultar saldo, consultar cheque especial,
 * depositar e sacar dinheiro, além de verificar o uso do cheque especial.
 */
public class Conta {
    private double saldo; // Saldo atual da conta
    private double chequeEspecial; // Valor disponível do cheque especial
    private final double limiteChequeEspecial; // Limite total do cheque especial
    private double valorUsadoChequeEspecial; // Valor do cheque especial já utilizado

    /**
     * Construtor da classe Conta.
     * Inicializa a conta com um depósito inicial e define o limite do cheque especial
     * com base no valor do depósito.
     *
     * @param depositoInicial Valor inicial depositado na conta.
     */
    public Conta(double depositoInicial) {
        this.saldo = depositoInicial;

        if (depositoInicial <= 500.0) {
            this.limiteChequeEspecial = 50.0;
        } else {
            this.limiteChequeEspecial = depositoInicial * 0.5;
        }

        this.chequeEspecial = limiteChequeEspecial;
        this.valorUsadoChequeEspecial = 0.0;
    }

    /**
     * Exibe o saldo atual da conta.
     */
    public void consultarSaldo() {
        System.out.println("Saldo atual: R$ " + saldo);
    }

    /**
     * Exibe informações sobre o cheque especial, incluindo o limite total
     * e o valor disponível.
     */
    public void consultarChequeEspecial() {
        System.out.println("Limite do cheque especial: R$ " + limiteChequeEspecial);
        System.out.println("Valor disponível do cheque especial: R$ " + chequeEspecial);
    }

    /**
     * Realiza um depósito na conta. Caso haja valor pendente no cheque especial,
     * o depósito é usado para quitá-lo antes de ser adicionado ao saldo.
     *
     * @param valor Valor a ser depositado.
     */
    public void depositar(double valor) {
        if (valorUsadoChequeEspecial > 0) {
            double taxa = valorUsadoChequeEspecial * 0.2;
            double totalDivida = valorUsadoChequeEspecial + taxa;

            if (valor >= totalDivida) {
                valor -= totalDivida;
                chequeEspecial += valorUsadoChequeEspecial;
                valorUsadoChequeEspecial = 0;
                System.out.println("Taxa de R$ " + taxa + " aplicada por uso do cheque especial.");
            } else {
                valorUsadoChequeEspecial -= valor / 1.2;
                chequeEspecial += valor / 1.2;
                System.out.println("Parte do cheque especial foi quitada com taxa proporcional.");
                return;
            }
        }

        saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
    }

    /**
     * Realiza um saque na conta. Caso o saldo não seja suficiente, o cheque especial
     * é utilizado para cobrir o valor restante, se disponível.
     *
     * @param valor Valor a ser sacado.
     */
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado.");
        } else if (valor <= saldo + chequeEspecial) {
            double restante = valor - saldo;
            saldo = 0;
            chequeEspecial -= restante;
            valorUsadoChequeEspecial += restante;
            System.out.println("Saque de R$ " + valor + " realizado usando cheque especial.");
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

}