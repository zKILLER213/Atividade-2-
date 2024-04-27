package Atividade2;

class Loja {
    private Conta conta;
    private double totalVendas = 0;
    private double saldoFuncionarios = 0;

    public Loja(double saldoInicial) {
        this.conta = new Conta("Loja", saldoInicial);
    }

    public void realizarVenda(double valor) {
        conta.depositar(valor);
        totalVendas += valor;
    }

    public void pagarFuncionarios() {
        if (conta.getSaldo() >= 1400 * 2) {
            saldoFuncionarios += 1400 * 2;
            conta.sacar(1400 * 2);
            System.out.println("Pagamento de funcionários realizado.");
        } else {
            System.out.println("Não há saldo suficiente para pagar os funcionários.");
        }
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public double getSaldoFuncionarios() {
        return saldoFuncionarios;
    }
}