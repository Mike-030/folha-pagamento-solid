package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.util.ArrayList;
import java.util.List;

public class Entities {

    @Entity
    @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
    public static abstract class Funcionario {
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        private String nome;
        private double salarioBase;

        public Funcionario() {}

        public Funcionario(String nome, double salarioBase) {
            this.nome = nome;
            this.salarioBase = salarioBase;
        }

        public Long getId() { return id; }
        public String getNome() { return nome; }
        public double getSalarioBase() { return salarioBase; }
    }

    @Entity
    public static class FuncionarioCLT extends Funcionario implements Regras.ElegivelHoraExtra, Regras.ElegivelValeTransporte, Regras.ElegivelAdicionalNoturno, Regras.ElegivelINSS {
        private int horasExtras;
        private boolean turnoNoturno;

        public FuncionarioCLT() {}

        public FuncionarioCLT(String nome, double salarioBase, int horasExtras, boolean turnoNoturno) {
            super(nome, salarioBase);
            this.horasExtras = horasExtras;
            this.turnoNoturno = turnoNoturno;
        }

        @Override
        public int getHorasExtras() { return horasExtras; }
        
        @Override
        public boolean recebeValeTransporte() { return true; }
        
        @Override
        public boolean recebeAdicionalNoturno() { return turnoNoturno; }
        
        @Override
        public boolean pagaINSS() { return true; }
    }

    @Entity
    public static class FuncionarioPJ extends Funcionario {
        public FuncionarioPJ() {}
        
        public FuncionarioPJ(String nome, double salarioBase) {
            super(nome, salarioBase);
        }
    }

    public static class ItemHolerite {
        private String descricao;
        private double valor;
        private boolean provento;

        public ItemHolerite(String descricao, double valor, boolean provento) {
            this.descricao = descricao;
            this.valor = valor;
            this.provento = provento;
        }

        public String getDescricao() { return descricao; }
        public double getValor() { return valor; }
        public boolean isProvento() { return provento; }
    }

    public static class Holerite {
        private String nomeFuncionario;
        private List<ItemHolerite> itens;

        public Holerite(String nomeFuncionario) {
            this.nomeFuncionario = nomeFuncionario;
            this.itens = new ArrayList<>();
        }

        public void adicionarItem(String descricao, double valor, boolean provento) {
            if (valor > 0) {
                itens.add(new ItemHolerite(descricao, valor, provento));
            }
        }

        public List<ItemHolerite> getItens() { return itens; }
        public String getNomeFuncionario() { return nomeFuncionario; }
        
        public double calcularTotal() {
            double total = 0;
            for (ItemHolerite item : itens) {
                if (item.isProvento()) {
                    total += item.getValor();
                } else {
                    total -= item.getValor();
                }
            }
            return total;
        }
    }
}
