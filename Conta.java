public abstract class Conta implements IConta {
    // atributos
    protected int numero;
    protected int agencia;
    protected double saldo;
    protected Cliente cliente;

    //constantes
    protected static int SEQUENCIAL = 1;
    protected static final int AGENCIA = 1;

    //constructor
    public Conta(Cliente cliente) {
        this.numero = SEQUENCIAL++;
        this.agencia = AGENCIA;
        this.cliente = cliente;
    }

    //getters
    public int getNumero() {
        return numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Numero da Conta: %d", this.getNumero()));
        System.out.println(String.format("Numero da Agencia: %d", this.getAgencia()));
        System.out.println(String.format("Saldo: %.2f", this.getSaldo()));
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            this.saldo -= valor;
        } else {
            System.out.println("!!! Tentativa de SAQUE falhada: Saldo em conta insuficiente !!!");
        }
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (valor <= saldo) {
            this.sacar(valor);
            contaDestino.depositar(valor);
        } else {
            System.out.println("!!! Tentativa de TRANSFERENCIA falhada: Saldo em conta insuficiente !!!");
        }

    }
}
