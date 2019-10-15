package banco;

public class Conta {
    private final int NUMERO;
    private double saldo;

    public Conta(int NUMERO, double saldo) {
        this.NUMERO = NUMERO;
        this.saldo = saldo;
    }
    public int getNUMERO() {
        return NUMERO;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void deposito(double valor){
        saldo += valor;
    }
    
    public double saque(double valor){
        if (saldo >= valor)
            return valor;
        return saldo;
    }

    @Override
    public String toString() {
        return "Conta{ " + "NUMERO = " + NUMERO + ", saldo = " + saldo + " }";
    }
    
    
}
