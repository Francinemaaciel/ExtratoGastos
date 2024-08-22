//importando scanner e formatador de data
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class ExtratoGastos {
    public static void main(String[] args) {
        Gastos meusGastos = new Gastos();
        Scanner sc = new Scanner(System.in);

        //verificando a condição
        while(true){

            System.out.println("1 - Cadastrar um gasto");
            System.out.println("2 - Listar gastos");
            System.out.println("3 - Buscar um gasto");
            System.out.println("4 - Excluir um gasto");
            System.out.println("0 - Sair");

            System.out.println("Escolha uma opção: ");
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o ID do gasto: ");
                    String id = sc.next();
                    System.out.println("Digite o valor do gasto: R$ ");
                    double valor = sc.nextDouble();
                    System.out.println("Digite a descrição do gasto: ");
                    String descricao = sc.next();
                    System.out.println("Digite a data do gastos (dd/MM/yyyy): ");
                    String dataStr = sc.next();
                    LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    meusGastos.adicionar(id, descricao, valor, data);
                    break;
                case 2:
                    meusGastos.listar();
                    break;
                case 3:
                    System.out.println("Digite o ID do gasto que deseja buscar: ");
                    String idBuscar = sc.next();
                    Gastos gastos = meusGastos.buscarPorID(idBuscar);
                    if (gastos != null) {
                        System.out.println("Gasto encontrado\nId: " + gastos.getId() +  " Descrição: " + gastos.getDescricao() +
                                " Valor: " + gastos.getValor() + " Data: " + gastos.getData());
                    } else {
                        System.out.println("Gasto não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Digite o ID do gasto que deseja remover: ");
                    String idRemover = sc.next();
                    meusGastos.remover(idRemover);
                    break;
                case 0:
                    System.out.println("Sessão Finalizada.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente Novamente.");
            }
        }
    }
}
