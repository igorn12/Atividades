package imobiliaria;

public class Comercial extends Imovel{
    private double areaUtil;

    public Comercial(int codigo, String regiao, double valor, boolean diponivel, double areaUtil) {
        super(codigo, regiao, valor, diponivel);
        this.areaUtil = areaUtil;
    }

    public double getAreaUtil() {
        return areaUtil;
    }

    public void setAreaUtil(double areaUtil) {
        this.areaUtil = areaUtil;
    }

    @Override
    public String toString() {
        return "Comercial {" + "Area util = " + areaUtil + "m}" +super.toString();
    }
    
    
}