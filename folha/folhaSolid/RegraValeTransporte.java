package folhaSolid;

public class RegraValeTransporte implements RegraDeCalculo {

    @Override
    public String getDescricao() {
        return "Vale Transporte";
    }

    @Override
    public double calcular(Funcionario funcionario) {
        if (funcionario instanceof ElegivelValeTransporte) {
            ElegivelValeTransporte elegivel = (ElegivelValeTransporte) funcionario;
            if (elegivel.recebeValeTransporte()) {
                return funcionario.getSalarioBase() * 0.06;
            }
        }
        return 0;
    }

    @Override
    public boolean isProvento() {
        return false;
    }
}
