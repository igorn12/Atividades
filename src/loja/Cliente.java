package loja;

public class Cliente extends Pessoa{
    private int codigo;
    
    public Cliente(String nome, String cpf, int codigo) {
        super(nome, cpf);
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Cliente{ " +super.toString()+ ", codigo= " + codigo + " }";
    }
    
}
