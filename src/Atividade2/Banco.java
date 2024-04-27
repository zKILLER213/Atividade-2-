package Atividade2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Banco {
    private Lock lock = new ReentrantLock();

    public void transferir(Conta origem, Conta destino, double valor) {
        lock.lock();
        try {
            if (origem.sacar(valor)) {
                destino.depositar(valor);
                System.out.println("Transferência de R$" + valor + " realizada de " + origem.getNome() + " para " + destino.getNome());
            } else {
                System.out.println("Transferência de R$" + valor + " falhou de " + origem.getNome() + " para " + destino.getNome());
            }
        } finally {
            lock.unlock();
        }
    }
}