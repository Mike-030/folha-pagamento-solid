package folhaSolid;

public class FuncionarioCLT extends Funcionario implements ElegivelHoraExtra, ElegivelValeTransporte, ElegivelAdicionalNoturno, ElegivelINSS {
    private int horasExtras;
    private boolean turnoNoturno;

    public FuncionarioCLT(String nome, double salarioBase, int horasExtras, boolean turnoNoturno) {
        super(nome, salarioBase);
        this.horasExtras = horasExtras;
        this.turnoNoturno = turnoNoturno;
    }

    @Override
    public int getHorasExtras() {
        return horasExtras;
    }

    @Override
    public boolean recebeValeTransporte() {
        return true;
    }

    @Override
    public boolean recebeAdicionalNoturno() {
        return turnoNoturno;
    }

    @Override
    public boolean pagaINSS() {
        return true;
    }
}
