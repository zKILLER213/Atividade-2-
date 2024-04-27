package Atividade2;

class Funcionario implements Runnable {
    private Conta salario;
    private Conta investimentos;
    private String nome;
    private Loja loja;

    public Funcionario(String nome, Loja loja, double salarioInicial) {
        this.nome = nome;
        this.loja = loja;
        this.salario = new Conta("Salário " + nome, salarioInicial);
        this.investimentos = new Conta("Investimentos " + nome, 0);
    }

    @Override
    public void run() {
        receberSalario();
        investir();
    }

    private void receberSalario() {
        synchronized (loja) {
            loja.pagarFuncionarios();
            loja.transferirSalario(salario, this);
        }
    }

    private void investir() {
        double valorInvestimento = salario.getSaldo() * 0.2;
        salario.sacar(valorInvestimento);
        investimentos.depositar(valorInvestimento);
        System.out.println("Funcionário " + nome + " investiu R$" + valorInvestimento + " em investimentos.");
    }

    public Conta getSalario() {
        return salario;
    }

    public Conta getInvestimentos() {
        return investimentos;
    }

    public String getNome() {
        return nome;
    }
}