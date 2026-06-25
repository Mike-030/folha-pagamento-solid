import java.util.Arrays;
import java.util.List;

import domain.Entities;
import domain.Regras;
import usecase.GerarFolhaUseCase;
import adapter.Presenters;

public class Main {
    public static void main(String[] args) {

        List<Regras.RegraDeCalculo> regras = Arrays.asList(
                new Regras.RegraHoraExtra(),
                new Regras.RegraBonus(500),
                new Regras.RegraINSS(),
                new Regras.RegraValeTransporte(),
                new Regras.RegraPlanoDeSaude(150),
                new Regras.RegraAdicionalNoturno());

        GerarFolhaUseCase gerarFolhaUseCase = new GerarFolhaUseCase(regras);

        Entities.Funcionario clt = new Entities.FuncionarioCLT("João Silva (CLT)", 3000, 10, true);
        Entities.Funcionario pj = new Entities.FuncionarioPJ("Empresa do Marcos (PJ)", 8000);

        Entities.Holerite holeriteCLT = gerarFolhaUseCase.executar(clt);
        Entities.Holerite holeritePJ = gerarFolhaUseCase.executar(pj);

        Presenters.HoleritePresenter presenter = new Presenters.ConsoleHoleritePresenter();

        presenter.apresentar(holeriteCLT);
        presenter.apresentar(holeritePJ);
    }
}
