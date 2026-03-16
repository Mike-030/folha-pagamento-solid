public class INSS implements ItemFolha {

    public String getDescricao() {
        return "INSS";
    }

    public double calcular(Funcionario funcionario) {

        double salario = funcionario.getSalarioBase();

        if (salario <= 1320) {
            return salario * 0.075;
        }

        if (salario <= 2571.29) {
            return salario * 0.09;
        }

        if (salario <= 3856.94) {
            return salario * 0.12;
        }

        return salario * 0.14;
    }

    public boolean isProvento() {
        return false;
    }
}