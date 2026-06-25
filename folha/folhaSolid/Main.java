package folhaSolid;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<RegraDeCalculo> regras = Arrays.asList(
                new RegraHoraExtra(),
                new RegraBonus(500),
                new RegraINSS(),
                new RegraValeTransporte(),
                new RegraPlanoDeSaude(150),
                new RegraAdicionalNoturno());

        CalculadoraDeFolha calculadora = new CalculadoraDeFolha(regras);

        Funcionario clt = new FuncionarioCLT("João Silva (CLT)", 3000, 10, true);
        Funcionario pj = new FuncionarioPJ("Empresa do Marcos (PJ)", 8000);

        Holerite holeriteCLT = calculadora.gerarFolha(clt);
        Holerite holeritePJ = calculadora.gerarFolha(pj);

        ImpressoraDeHolerite impressora = new ImpressoraDeHolerite();

        impressora.imprimir(holeriteCLT);
        impressora.imprimir(holeritePJ);
    }
}
