package loja;

public class Vendedor extends Funcionario{
    private double vendas;

    public Vendedor(String nome, String cpf, int matricula, double salario) {
        super(nome, cpf, matricula, salario);
    }

    public double getVendas() {
        return vendas;
    }

    public void setVendas(double vendas) {
        this.vendas = vendas;
    }
    
    @Override
    public double calcularPagamento(){
        double salarioFinal = 0;
        salarioFinal = getSalario()+(getVendas()*0.10);
        return salarioFinal;
    }
    
    @Override
    public String toString() {
        return "Vendedor{ " +super.toString()+ ", vendas= " + vendas + " }";
    }
    
}
