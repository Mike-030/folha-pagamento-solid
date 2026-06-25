package folhaSolid;

public class RegraAdicionalNoturno implements RegraDeCalculo {

    @Override
    public String getDescricao() {
        return "Adicional Noturno";
    }

    @Override
    public double calcular(Funcionario funcionario) {
        if (funcionario instanceof ElegivelAdicionalNoturno) {
            ElegivelAdicionalNoturno elegivel = (ElegivelAdicionalNoturno) funcionario;
            if (elegivel.recebeAdicionalNoturno()) {
                return funcionario.getSalarioBase() * 0.20;
            }
        }
        return 0;
    }

    @Override
    public boolean isProvento() {
        return true;
    }
}
