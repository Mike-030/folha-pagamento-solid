public class IRRF implements ItemFolha {

    public String getDescricao() {
        return "IRRF";
    }

    public double calcular(Funcionario funcionario) {

        double salario = funcionario.getSalarioBase();

        if (salario <= 2112) {
            return 0;
        }

        if (salario <= 2826.65) {
            return salario * 0.075;
        }

        if (salario <= 3751.05) {
            return salario * 0.15;
        }

        if (salario <= 4664.68) {
            return salario * 0.225;
        }

        return salario * 0.275;
    }

    public boolean isProvento() {
        return false;
    }
}