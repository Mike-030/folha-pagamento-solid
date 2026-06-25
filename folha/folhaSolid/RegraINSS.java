package folhaSolid;

public class RegraINSS implements RegraDeCalculo {

    @Override
    public String getDescricao() {
        return "INSS";
    }

    @Override
    public double calcular(Funcionario funcionario) {
        return funcionario.getSalarioBase() * 0.11;
    }

    @Override
    public boolean isProvento() {
        return false;
    }
}
