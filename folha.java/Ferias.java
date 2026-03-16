public class Ferias implements ItemFolha {

    public String getDescricao() {
        return "Férias";
    }

    public double calcular(Funcionario funcionario) {

        double salario = funcionario.getSalarioBase();

        return salario + (salario / 3);
    }

    public boolean isProvento() {
        return true;
    }
}