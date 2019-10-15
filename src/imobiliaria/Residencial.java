package imobiliaria;

public class Residencial extends Imovel{
    private int numeroQuartos;

    public Residencial(int codigo, String regiao, double valor, boolean diponivel, int numeroQuartos) {
        super(codigo,regiao, valor, diponivel);
        this.numeroQuartos = numeroQuartos;
    }

    public int getNumeroQuartos() {
        return numeroQuartos;
    }

    public void setNumeroQuartos(int numeroQuartos) {
        this.numeroQuartos = numeroQuartos;
    }

    @Override
    public String toString() {
        return "Residencial {" + "Numeros de quartos = " + numeroQuartos + "}" +super.toString() ;
    }
    
}