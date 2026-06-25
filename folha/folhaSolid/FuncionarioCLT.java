package folhaSolid;

public class FuncionarioCLT extends Funcionario implements ElegivelHoraExtra {
    private int horasExtras;

    public FuncionarioCLT(String nome, double salarioBase, int horasExtras) {
        super(nome, salarioBase);
        this.horasExtras = horasExtras;
    }

    @Override
    public int getHorasExtras() {
        return horasExtras;
    }
}
