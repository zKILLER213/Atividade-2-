package Atividade2;

class Cliente implements Runnable {
    private Conta conta;
    private String nome;

    public Cliente(String nome, double saldoInicial) {
        this.nome = nome;
        this.conta = new Conta("Cliente " + nome, saldoInicial);
    }

    @Override
    public void run() {
        while (conta.getSaldo() >= 100) {
            double valorCompra = Math.random() < 0.5 ? 100 : 200;
            synchronized (conta) {
                if (conta.sacar(valorCompra)) {
                    System.out.println("Cliente " + nome + " realizou uma compra de R$" + valorCompra);
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Conta getConta() {
        return conta;
    }

    public String getNome() {
        return nome;
    }
}