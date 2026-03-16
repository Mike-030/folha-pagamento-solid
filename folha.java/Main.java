import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Funcionario funcionario = new Funcionario("Michel", 3000, 10);

        List<ItemFolha> itens = new ArrayList<>();

        itens.add(new HoraExtra());
        itens.add(new INSS());
        itens.add(new IRRF());
        itens.add(new Bonus(500));
        itens.add(new Desconto(200));

        FolhaPagamentoService folha = new FolhaPagamentoService();

        Holerite holerite = folha.gerarFolha(funcionario, itens);

        holerite.imprimir();
    }
}