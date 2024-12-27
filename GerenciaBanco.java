
import java.util.Scanner;

public class GerenciaBanco {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
   	 
    	// Criando a conta e pedindo as informações pessoais do usuário
    	System.out.print("Digite seu nome: ");
    	String nome = scanner.nextLine();
   	 
    	System.out.print("Digite seu sobrenome: ");
    	String sobrenome = scanner.nextLine();
   	 
    	System.out.print("Digite seu CPF: ");
    	String cpf = scanner.nextLine();
   	 
    	// Inicializando a conta bancária
    	ContaBancaria conta = new ContaBancaria(nome, sobrenome, cpf);
   	 
    	int opcao;
    	do {
        	// Exibindo o menu de operações
        	exibirMenu();
        	System.out.print("Escolha uma opção: ");
        	opcao = scanner.nextInt();
       	 
        	switch (opcao) {
            	case 1:
                	System.out.println("Saldo atual: R$" + conta.consultarSaldo());
                	break;
            	case 2:
                	System.out.print("Digite o valor do depósito: R$");
                	double valorDeposito = scanner.nextDouble();
                	conta.depositar(valorDeposito);
                	break;
            	case 3:
                	System.out.print("Digite o valor do saque: R$");
                	double valorSaque = scanner.nextDouble();
                	conta.sacar(valorSaque);
                	break;
            	case 4:
                	System.out.println("Encerrando a aplicação. Obrigado!");
                	break;
            	default:
                	System.out.println("Opção inválida! Tente novamente.");
        	}
    	} while (opcao != 4);
   	 
    	scanner.close();
	}
    
	public static void exibirMenu() {
    	System.out.println("\n--- Menu de Operações ---");
    	System.out.println("1. Consultar Saldo");
    	System.out.println("2. Realizar Depósito");
    	System.out.println("3. Realizar Saque");
    	System.out.println("4. Sair");
	}
}

class ContaBancaria {
	private String nome;
	private String sobrenome;
	private String cpf;
	private double saldo;
    
	public ContaBancaria(String nome, String sobrenome, String cpf) {
    	this.nome = nome;
    	this.sobrenome = sobrenome;
    	this.cpf = cpf;
    	this.saldo = 0.0;
	}
    
	public double consultarSaldo() {
    	return saldo;
	}
    
	public void depositar(double valor) {
    	if (valor > 0) {
        	saldo += valor;
        	System.out.println("Depósito realizado com sucesso!");
    	} else {
        	System.out.println("Valor inválido para depósito.");
    	}
	}
    
	public void sacar(double valor) {
    	if (valor > 0 && valor <= saldo) {
        	saldo -= valor;
        	System.out.println("Saque realizado com sucesso!");
    	} else if (valor > saldo) {
        	System.out.println("Saldo insuficiente.");
    	} else {
        	System.out.println("Valor inválido para saque.");
    	}
	}
}