package imobiliaria;

public class Imovel {
    private int codigo;
    private String regiao;
    private double valor;
    private boolean diponivel;

    public Imovel(int codigo, String regiao, double valor, boolean diponivel) {
        this.codigo = codigo;
        this.regiao = regiao;
        this.valor = valor;
        this.diponivel = diponivel;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isDiponivel() {
        return diponivel;
    }

    public void setDiponivel(boolean diponivel) {
        this.diponivel = diponivel;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Imovel other = (Imovel) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return " Imovel {" + "codigo= " + codigo + ", regiao= " + regiao + ", valor= " + valor + ", diponivel= " + diponivel + "}";
    }
    
}