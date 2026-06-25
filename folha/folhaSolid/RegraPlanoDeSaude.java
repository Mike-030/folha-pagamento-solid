package folhaSolid;

public class RegraPlanoDeSaude implements RegraDeCalculo {
    private double valorFixo;

    public RegraPlanoDeSaude(double valorFixo) {
        this.valorFixo = valorFixo;
    }

    @Override
    public String getDescricao() {
        return "Plano de Saúde";
    }

    @Override
    public double calcular(Funcionario funcionario) {
        return valorFixo;
    }

    @Override
    public boolean isProvento() {
        return false;
    }
}
