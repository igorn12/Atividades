package imobiliaria;

import java.util.ArrayList;
import java.util.Scanner;

public class Imobiliaria {
    private Scanner input = new Scanner(System.in);
    private ArrayList<Imovel> imoveis = new ArrayList<>();
    private int codigo=1;
    
    public void menu(){
        int opcao = 0;
        do {
            System.out.println("------- Menu Imobiliária -------\n1 - Cadastrar Imóvel\n2 - Alugar Imóvel\n3 - Sair\n--------------------------------");
            System.out.println("Usuário informe sua opção :");
            opcao = input.nextInt();
            switch(opcao){
                case 1:
                    cadastrarImoveis();
                    break;
                case 2:
                    alugarImoveis();
                    break;
                case 3:
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Opcao Inválida");
            }
        } while (opcao != 3);
    }
    
    private void alugarImoveis(){    
        listarImoveis();
        
        System.out.println("Informe o imóvel que deseja alugar");
        int cod = input.nextInt();
        
        if(imoveis.get(cod-1) == null){
            System.out.println("Imovel inexistente");
        }else{
            if(imoveis.get(cod-1).isDiponivel() == false){
                System.out.println("Imovel indisponivel");
            }else{
                imoveis.get(cod-1).setDiponivel(false);
                System.out.println("Imovel alugado com sucesso");
            }
        }
    }
    
    private boolean listarImoveis(){
        if(!imoveis.isEmpty()){
            for(Imovel i : imoveis){
                System.out.println(i.toString());
            }
        }
        return false;
    }
    
    private void cadastrarImoveis(){
        System.out.println("--------- Cadastrar Imóvel ---------\n1 - Residencial\n2 - Comercial\n-----------------------------------");
        System.out.println("qual imóvel deseja cadastrar:");
        int opcao = input.nextInt();
        System.out.println("Qual a região do imóvel:");
        String regiao = input.next();
        System.out.println("Qual o valor do imovel:");
        double valor = input.nextDouble();
        
        if(opcao == 1){
            System.out.println("Informe o numero de quartos:");
            int numQuartos = input.nextInt();
            imoveis.add(new Residencial(codigo++,regiao, valor, true, numQuartos));
        }else if(opcao == 2){
            System.out.println("Informe a area do imóvel:");
            double area = input.nextDouble();
            imoveis.add(new Comercial(codigo++, regiao, valor, true, area));
        }
    }
}