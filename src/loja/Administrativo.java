package loja;

public class Administrativo extends Funcionario{
    private double horas;

    public Administrativo(String nome, String cpf, int matricula, double salario) {
        super(nome, cpf, matricula, salario);
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }
    
    @Override
    public double calcularPagamento(){
        double salarioFinal = 0;
        salarioFinal = getSalario() + (getHoras()*0.01);
        return salarioFinal;
    }
    @Override
    
    public String toString() {
        return "Administrativo{ " +super.toString()+ ", horas= " + horas + " }";
    }
    
}
