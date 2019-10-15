package loja;

import java.util.ArrayList;
import java.util.Scanner;

public class Loja {
    private Scanner input = new Scanner(System.in);
    private ArrayList<Pessoa> lista = new ArrayList<>();
    private int num = 0;
    
    public void menu(){
        int opcao = 0;
        do {
            System.out.println("\t\tMenu\n1 - Cadastrar pessoas\n2 - Remover pessoa\n3 - Buscar pessoa\n4 - Adicionar produtividade\n5 - Gerar folha de pagamento\n6 - Listar\n7 - Sair");
            System.out.println("Informe a opcao desejada: ");
            opcao = input.nextInt();
            switch(opcao){
                case 1:
                    cadastrar();
                    break;
                case 2:
                    remover();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    adicionarProdutividade();
                    break;
                case 5:
                    gerarPagamentos();
                    break;
                case 6:
                    listar();
                    break;
                case 7:
                    System.out.println("Saindo ...");
                    break;
                default:
                    System.out.println("Opcao invalida!!");
            }
        } while (opcao != 7);
        
    }
    
    private void cadastrar(){
        System.out.println("informe um cpf: ");
        String cpf = input.next();
        if(buscarCpf(cpf) == null){
            System.out.println("--------- MENU ----------\n1 - Cliente\n2 - Administrativo\n3 - Vendedor\n4 - Sair");
            System.out.println("informe o que deseja cadastrar: ");
            int opcao = input.nextInt();
            if(opcao == 1){
                System.out.println("informe o nome do cliente:");
                String name = input.next();
                lista.add(new Cliente(name, cpf, num++));
            }else if(opcao == 2){
                System.out.println("informe o nome do administrativo: ");
                String name = input.next();
                System.out.println("informe o salário base: ");
                double salario = input.nextDouble();
                lista.add(new Administrativo(name, cpf, num++, salario));
            }else if(opcao == 3){
                System.out.println("informe o nome do vendedor: ");
                String name = input.next();
                System.out.println("informe o salário base: ");
                double salario = input.nextDouble();
                lista.add(new Vendedor(name, cpf, num++, salario));
            }else{
                System.out.println("Saindo ...");
            }
        }else{
            System.out.println("CPF já cadastrado !!");
        }
    }
    private void remover(){
        System.out.println("informe o CPF: ");
        String cpf = input.next();
        if(buscarCpf(cpf) == null){
            System.out.println("Essa pessoa não está cadastrada !!");
        }else{
            lista.remove(lista.get(lista.indexOf(buscarCpf(cpf))));
            System.out.println("Removida do sistema com sucesso!!");
        }
        
    }
    private void buscar(){
        System.out.println("informe o CPF: ");
        String cpf = input.next();
        if(buscarCpf(cpf) == null){
            System.out.println("Pessoa inexistente");
        }else{
            System.out.println(lista.get(lista.indexOf(buscarCpf(cpf))).toString());
        }
    }
    private Pessoa buscarCpf(String cpf){
        for(Pessoa l : lista){
            if(cpf.equals(l.getCpf())){
                return l;
            }
        }
        return null;
    }
    private void listar(){
        for(Pessoa p : lista){
            System.out.println(p.toString());
        }
    }
    private void adicionarProdutividade(){
        System.out.println("informe um cpf: ");
        String cpf = input.next();
        if(buscarCpf(cpf) == null){
            System.out.println("Esse funcionário nãe existe");
        }else{
            if(lista.get(lista.indexOf(buscarCpf(cpf))) instanceof Administrativo){
                System.out.println("Informe as horas trabalhadas:");
                ((Administrativo) lista.get(lista.indexOf(buscarCpf(cpf)))).setHoras(input.nextDouble());
            }else if(lista.get(lista.indexOf(buscarCpf(cpf))) instanceof Vendedor){
                System.out.println("informe o numero de vendas");
                ((Vendedor) lista.get(lista.indexOf(buscarCpf(cpf)))).setVendas(input.nextDouble());
            }else{
                System.out.println("Essa pessoa é um cliente !");
            }
        }
    }
    private void gerarPagamentos(){
        for (Pessoa p : lista) {
            if(p instanceof Administrativo){
                double salario = ((Administrativo) p).calcularPagamento();
                System.out.println(p+", Salario final= "+salario);
            }else if(p instanceof Vendedor){
                double salario = ((Vendedor) p).calcularPagamento();
                System.out.println(p+", Salario final= "+salario);
            }
        }
    }
    public static void main(String[] args) {
        Loja americanas = new Loja();
        americanas.menu();
    }
}
