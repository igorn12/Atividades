package banco;

public class Corrente extends Conta{
    private double tarifa;

    public Corrente(int NUMERO, double saldo, double tarifa) {
        super(NUMERO, saldo);
        this.tarifa = tarifa;
    }
    
    public void debitaTarifa(){
        setSaldo(getSaldo()-tarifa);
    }
    
    @Override
    public String toString() {
        return super.toString() + "{ tarifa=" + tarifa +"}";
    }
    
}
