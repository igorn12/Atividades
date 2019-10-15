package banco;

import java.util.ArrayList;
import java.util.Scanner;

public class Agencia {
    private Scanner input = new Scanner(System.in);
    private ArrayList<Conta> contas = new ArrayList<>();
    private int numero = 0;
    
    public void menu(){
        int opcao = 0, opcao2 = 0;
        do {
            System.out.println("----- MENU -----\n1- Criar conta\n2- Acessar conta\n3- Sair do aplicativo");
            System.out.println("Usuário qual opção deseja: ");
            opcao = input.nextInt();
            switch(opcao){
                case 1:
                    System.out.println("----- CRIAR CONTA -----\n1- Conta Corrente\n2- Conta poupança\n3- Voltar");
                    opcao2 = input.nextInt();
                    switch(opcao2){
                        case 1:
                            criarContaCorrente();
                            break;
                        case 2:
                            criarContaPoupanca();
                            break;
                        case 3:
                            System.out.println("Voltando ...");
                            break;
                        default:
                            System.out.println("Opção inválida!!");
                    }
                    break;
                case 2:
                    System.out.println("Digite o numero da conta: ");
                    existeConta(opcao = input.nextInt());
                    do {
                        System.out.println("---- OPCOES ----\n1- Saldo\n2- Deposito\n3- Saque\n4- Manutencao de Contas\n5- Sair");
                        System.out.println("Digite sua opção : ");
                        opcao2 = input.nextInt();
                        switch(opcao2){
                            case 1:
                                System.out.println(contas.get(opcao-1).getSaldo());
                                break;
                            case 2:
                                System.out.println("informe o valor para deposito: ");
                                double valor = input.nextDouble();
                                contas.get(numero-1).deposito(valor);
                                break;
                            case 3:
                                System.out.println("informe o valor do saque: ");
                                valor = input.nextDouble();
                                System.out.println("Valor do saque: "+contas.get(numero-1).saque(valor));
                                break;
                            case 4:
                                manutencaoDeContas();
                                break;
                            case 5:
                                System.out.println("Saindo ...");
                                break;
                            default:
                                System.out.println("Opção inválida !!");
                        }
                    } while (opcao2 != 5);
                    
                    break;
                case 3:
                    System.out.println("Saindo do aplicativo ...");
                    break;
                default:
                    System.out.println("Opção inválida !!");
            }
        } while (opcao != 3);
        
    }
    
    public void criarContaCorrente(){
        System.out.println("Jogador informe o valor do saldo inicial da conta: ");
        double saldo = input.nextDouble();
        numero++;
        contas.add(new Corrente(numero, saldo, 0.10));
        System.out.println(contas.get(numero-1).toString());
    }
    
    public void criarContaPoupanca(){
        System.out.println("usuário informe o saldo inicial da conta: ");
        double saldo = input.nextDouble();
        numero++;
        contas.add(new Poupanca(numero, saldo, 0.05));
        System.out.println(contas.get(numero-1).toString());
    }
    
    public Conta existeConta(int numero){
        if(contas.get(numero-1) == null){
            return null;
        }
        return contas.get(numero-1);
    }
    
    public void manutencaoDeContas(){
        for (int i = 0; i < contas.size(); i++) {
            if(contas.get(i) instanceof Corrente){
                Corrente.class.cast(contas.get(i)).debitaTarifa();
            }else if(contas.get(i) instanceof Poupanca){
                Poupanca.class.cast(contas.get(i)).creditaRendimento();
            }
        }
    }
    
    public static void main(String[] args) {
        Agencia ag1 = new Agencia();
        ag1.menu();
    }
}
