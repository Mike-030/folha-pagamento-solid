package folhaSolid;

import java.util.List;

public class CalculadoraDeFolha {

    private List<RegraDeCalculo> regras;

    public CalculadoraDeFolha(List<RegraDeCalculo> regras) {
        this.regras = regras;
    }

    public Holerite gerarFolha(Funcionario funcionario) {
        Holerite holerite = new Holerite(funcionario.getNome());

        holerite.adicionarItem("Salário Base", funcionario.getSalarioBase(), true);

        for (RegraDeCalculo regra : regras) {
            double valor = regra.calcular(funcionario);
            if (valor > 0) {
                holerite.adicionarItem(regra.getDescricao(), valor, regra.isProvento());
            }
        }

        return holerite;
    }
}
