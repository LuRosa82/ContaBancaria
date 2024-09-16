import java.util.Scanner;

public class ContaBancaria {
    private String nome;
    private String tipoConta;
    private double saldo;

    public ContaBancaria(String nome, String tipoConta, double saldoInicial) {
        this.nome = nome;
        this.tipoConta = tipoConta;
        this.saldo = saldoInicial;
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: R$ " + saldo);
    }

    public void receberValor(double valor) {
        saldo += valor;
        System.out.println("Saldo atualizado: R$ " + saldo);
    }

    public void transferirValor(double valor) {
        if (valor > saldo) {
            System.out.println("Não há saldo suficiente para fazer essa transferência.");
        } else {
            saldo -= valor;
            System.out.println("Saldo atualizado: R$ " + saldo);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBancaria conta = new ContaBancaria("Jacqueline Oliveira", "Corrente", 2500.00);

        while (true) {
            System.out.println("***********************");
            System.out.println("Operações");
            System.out.println("1- Consultar saldos");
            System.out.println("2- Receber valor");
            System.out.println("3- Transferir valor");
            System.out.println("4- Sair");
            System.out.print("Digite a opção desejada: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Informe o valor a receber: ");
                    double valorReceber = scanner.nextDouble();
                    conta.receberValor(valorReceber);
                    break;
                case 3:
                    System.out.print("Informe o valor que deseja transferir: ");
                    double valorTransferir = scanner.nextDouble();
                    conta.transferirValor(valorTransferir);
                    break;
                case 4:
                    System.out.println("Encerrando aplicação.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
