import java.util.List;

public class FolhaPagamentoService {

    public Holerite gerarFolha(Funcionario funcionario, List<ItemFolha> itens) {

        Holerite holerite = new Holerite(funcionario.getNome());

        holerite.adicionarItem("Salário Base", funcionario.getSalarioBase(), true);

        for (ItemFolha item : itens) {

            double valor = item.calcular(funcionario);

            if (!item.isProvento()) {
                valor = -valor;
            }

            holerite.adicionarItem(item.getDescricao(), valor, item.isProvento());
        }

        return holerite;
    }
}