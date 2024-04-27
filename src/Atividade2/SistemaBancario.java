package Atividade2;

public class SistemaBancario {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Loja loja1 = new Loja(0);
        Loja loja2 = new Loja(0);
        Funcionario[] funcionarios = {
            new Funcionario("Funcionário 1", loja1, 1400),
            new Funcionario("Funcionário 2", loja1, 1400),
            new Funcionario("Funcionário 3", loja2, 1400),
            new Funcionario("Funcionário 4", loja2, 1400)
        };
        Cliente[] clientes = {
            new Cliente("Cliente 1", 1000),
            new Cliente("Cliente 2", 1000),
            new Cliente("Cliente 3", 1000),
            new Cliente("Cliente 4", 1000),
            new Cliente("Cliente 5", 1000)
        };

        Thread[] funcionarioThreads = new Thread[funcionarios.length];
        for (int i = 0; i < funcionarios.length; i++) {
            funcionarioThreads[i] = new Thread(funcionarios[i]);
            funcionarioThreads[i].start();
        }

        Thread[] clienteThreads = new Thread[clientes.length];
        for (int i = 0; i < clientes.length; i++) {
            clienteThreads[i] = new Thread(clientes[i]);
            clienteThreads[i].start();
        }

    
        for (Thread clienteThread : clienteThreads) {
            try {
                clienteThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Saldo final das contas dos clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNome() + ": R$" + cliente.getConta().getSaldo());
        }

        System.out.println("Saldo final das contas dos funcionários:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome() + ": Salário - R$" + funcionario.getSalario().getSaldo() +
                    ", Investimentos - R$" + funcionario.getInvestimentos().getSaldo());
        }

        System.out.println("Total de vendas na Loja 1: R$" + loja1.getTotalVendas());
        System.out.println("Total de vendas na Loja 2: R$" + loja2.getTotalVendas());
        System.out.println("Saldo dos funcionários na Loja 1: R$" + loja1.getSaldoFuncionarios());
        System.out.println("Saldo dos funcionários na Loja 2: R$" + loja2.getSaldoFuncionarios());
    }
}