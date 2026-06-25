package folhaSolid;

public class RegraHoraExtra implements RegraDeCalculo {

    @Override
    public String getDescricao() {
        return "Horas Extras";
    }

    @Override
    public double calcular(Funcionario funcionario) {

        if (funcionario instanceof ElegivelHoraExtra) {
            ElegivelHoraExtra elegivel = (ElegivelHoraExtra) funcionario;
            double valorHora = funcionario.getSalarioBase() / 220;
            return elegivel.getHorasExtras() * valorHora * 1.5;
        }
        return 0;
    }

    @Override
    public boolean isProvento() {
        return true;
    }
}
