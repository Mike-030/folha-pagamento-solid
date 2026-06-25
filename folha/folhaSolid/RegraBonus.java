package folhaSolid;

public class RegraBonus implements RegraDeCalculo {
    private double valorFixo;

    public RegraBonus(double valorFixo) {
        this.valorFixo = valorFixo;
    }

    @Override
    public String getDescricao() {
        return "Bônus";
    }

    @Override
    public double calcular(Funcionario funcionario) {
        return valorFixo;
    }

    @Override
    public boolean isProvento() {
        return true;
    }
}
