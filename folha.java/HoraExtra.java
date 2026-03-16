public class HoraExtra implements ItemFolha {

    public String getDescricao() {
        return "Horas Extras";
    }

    public double calcular(Funcionario funcionario) {

        double valorHora = funcionario.getSalarioBase() / 220;

        return funcionario.getHorasExtras() * valorHora * 1.5;
    }

    public boolean isProvento() {
        return true;
    }
}