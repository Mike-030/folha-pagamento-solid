package folhaSolid;

public class RegraINSS implements RegraDeCalculo {

    @Override
    public String getDescricao() {
        return "INSS";
    }

    @Override
    public double calcular(Funcionario funcionario) {
        if (funcionario instanceof ElegivelINSS) {
            ElegivelINSS elegivel = (ElegivelINSS) funcionario;
            if (elegivel.pagaINSS()) {
                return funcionario.getSalarioBase() * 0.11;
            }
        }
        return 0;
    }

    @Override
    public boolean isProvento() {
        return false;
    }
}
