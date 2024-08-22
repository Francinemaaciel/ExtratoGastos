// importando array lista e data
import java.util.ArrayList;
import java.time.LocalDate;

public class Gastos {
    //definindo atributos
    String id;
    String descricao;
    double valor;
    LocalDate data;

    //definindo metodo de gastos
    public Gastos(String id, String descricao, double valor, LocalDate data) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }
    //metodo de acesso para retornar valores dos atributos
    public String getId() {
        return id;
    }
    public String getDescricao() {
        return descricao;
    }
    public double getValor() {
        return valor;
    }
    public LocalDate getData() {
        return data;
    }

    // declarando uma classe privada de lista de gastos
    private ArrayList<Gastos> gastos;

    public Gastos() {
        this.gastos = new ArrayList<>();
    }
    //criando metodo para adicionar gastos na lista
    public void adicionar(String id, String descricao, double valor, LocalDate data) {
        gastos.add(new Gastos(id, descricao, valor, data));
        System.out.println("Gastos adicionado com sucesso!");
    }
    //criando metodo para listar com opção de devolutiva se não houver gasto
    public void listar(){
        if (this.gastos.isEmpty()) {
            System.out.println("Não há gastos cadastrado!");
        }else {
            System.out.println("Lista de gastos.\n");
            for (Gastos gasto : this.gastos) {
                System.out.println("Id: " + gasto.getId() + " Descrição: " + gasto.getDescricao() +
                        " Valor: " + gasto.getValor() + " Data: " + gasto.getData());
            }
        }
    }
    //busca por ID na lista, retornando nulo se não tiver
    public Gastos buscarPorID(String id) {
        for (Gastos gasto : this.gastos) {
            if (gasto.getId().equalsIgnoreCase(id)) {
                return gasto;
            }
        }
        return null;
    }
    //removendo gasto pela busca pelo ID e retornando erro se não houver
    public void remover(String id) {
        for (Gastos gasto : this.gastos) {
            if (gasto.getId().equalsIgnoreCase(id)) {
                this.gastos.remove(gasto);
                System.out.println("Gasto removido com sucesso!\nID: " + gasto.getId() + " Descrição: "
                        + gasto.getDescricao() + " Valor: " + gasto.getValor() + " Data: " + gasto.getData());
                return;
            }
        }
        System.out.println("Gasto não encontrado!");
    }
}
