package domain;

public class Regras {

    public interface RegraDeCalculo {
        String getDescricao();

        double calcular(Entities.Funcionario funcionario);

        boolean isProvento();
    }

    public interface ElegivelHoraExtra {
        int getHorasExtras();
    }

    public interface ElegivelValeTransporte {
        boolean recebeValeTransporte();
    }

    public interface ElegivelAdicionalNoturno {
        boolean recebeAdicionalNoturno();
    }

    public interface ElegivelINSS {
        boolean pagaINSS();
    }

    public static class RegraHoraExtra implements RegraDeCalculo {
        @Override
        public String getDescricao() {
            return "Horas Extras";
        }

        @Override
        public double calcular(Entities.Funcionario funcionario) {
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

    public static class RegraBonus implements RegraDeCalculo {
        private double valorFixo;

        public RegraBonus(double valorFixo) {
            this.valorFixo = valorFixo;
        }

        @Override
        public String getDescricao() {
            return "Bônus";
        }

        @Override
        public double calcular(Entities.Funcionario funcionario) {
            return valorFixo;
        }

        @Override
        public boolean isProvento() {
            return true;
        }
    }

    public static class RegraINSS implements RegraDeCalculo {
        @Override
        public String getDescricao() {
            return "INSS";
        }

        @Override
        public double calcular(Entities.Funcionario funcionario) {
            if (funcionario instanceof ElegivelINSS) {
                ElegivelINSS elegivel = (ElegivelINSS) funcionario;
                if (elegivel.pagaINSS()) {
                    return funcionario.getSalarioBase() * 0.11;
                }
            }
            return 0;
        }

        @Override
        public boolean isProvento() {
            return false;
        }
    }

    public static class RegraValeTransporte implements RegraDeCalculo {
        @Override
        public String getDescricao() {
            return "Vale Transporte";
        }

        @Override
        public double calcular(Entities.Funcionario funcionario) {
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

    public static class RegraPlanoDeSaude implements RegraDeCalculo {
        private double valorFixo;

        public RegraPlanoDeSaude(double valorFixo) {
            this.valorFixo = valorFixo;
        }

        @Override
        public String getDescricao() {
            return "Plano de Saúde";
        }

        @Override
        public double calcular(Entities.Funcionario funcionario) {
            return valorFixo;
        }

        @Override
        public boolean isProvento() {
            return false;
        }
    }

    public static class RegraAdicionalNoturno implements RegraDeCalculo {
        @Override
        public String getDescricao() {
            return "Adicional Noturno";
        }

        @Override
        public double calcular(Entities.Funcionario funcionario) {
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
}
