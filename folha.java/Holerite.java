import java.util.ArrayList;
import java.util.List;

public class Holerite {

    private String nomeFuncionario;
    private List<ItemResultado> itens;

    public Holerite(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String descricao, double valor, boolean provento) {
        itens.add(new ItemResultado(descricao, valor, provento));
    }

    public double calcularTotal() {

        double total = 0;

        for (ItemResultado item : itens) {
            total += item.getValor();
        }

        return total;
    }

    public void imprimir() {

        System.out.println("======== FOLHA DE PAGAMENTO ========");
        System.out.println();
        System.out.println("Funcionário: " + nomeFuncionario);
        System.out.println();

        System.out.println("PROVENTOS");

        for (ItemResultado item : itens) {
            if (item.isProvento()) {
                System.out.printf("%-20s R$ %8.2f%n",
                        item.getDescricao(),
                        item.getValor());
            }
        }

        System.out.println();
        System.out.println("DESCONTOS");

        for (ItemResultado item : itens) {
            if (!item.isProvento()) {
                System.out.printf("%-20s R$ %8.2f%n",
                        item.getDescricao(),
                        item.getValor());
            }
        }

        System.out.println();
        System.out.println("------------------------------------");

        System.out.printf("SALÁRIO FINAL       R$ %8.2f%n", calcularTotal());
    }
}