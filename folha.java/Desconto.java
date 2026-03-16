public class Desconto implements ItemFolha {

    private double valor;

    public Desconto(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return "Desconto";
    }

    public double calcular(Funcionario funcionario) {
        return valor;
    }

    public boolean isProvento() {
        return false;
    }
}