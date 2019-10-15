package banco;

public class Poupanca extends Conta{
    private double rendimento;
    
    public Poupanca(int NUMERO, double saldo, double rendimento) {
        super(NUMERO, saldo);
        this.rendimento = rendimento;
    }
    
    public void creditaRendimento(){
        setSaldo(getSaldo()+rendimento);
    }

    @Override
    public String toString() {
        return super.toString() + "{ Rendimento = " + rendimento+" }" ;
    }
    
}
