package usecase;

import java.util.List;

import domain.Entities;
import domain.Regras;

public class GerarFolhaUseCase {

    private List<Regras.RegraDeCalculo> regras;

    public GerarFolhaUseCase(List<Regras.RegraDeCalculo> regras) {
        this.regras = regras;
    }

    public Entities.Holerite executar(Entities.Funcionario funcionario) {
        Entities.Holerite holerite = new Entities.Holerite(funcionario.getNome());

        holerite.adicionarItem("Salário Base", funcionario.getSalarioBase(), true);

        for (Regras.RegraDeCalculo regra : regras) {
            double valor = regra.calcular(funcionario);
            if (valor > 0) {
                holerite.adicionarItem(regra.getDescricao(), valor, regra.isProvento());
            }
        }

        return holerite;
    }
}
