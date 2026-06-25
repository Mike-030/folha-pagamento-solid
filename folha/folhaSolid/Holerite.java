package folhaSolid;

import java.util.ArrayList;
import java.util.List;

public class Holerite {
    private String nomeFuncionario;
    private List<ItemHolerite> itens;

    public Holerite(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String descricao, double valor, boolean provento) {
        if (valor > 0) {
            itens.add(new ItemHolerite(descricao, valor, provento));
        }
    }

    public List<ItemHolerite> getItens() {
        return itens;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemHolerite item : itens) {
            if (item.isProvento()) {
                total += item.getValor();
            } else {
                total -= item.getValor();
            }
        }
        return total;
    }
}
