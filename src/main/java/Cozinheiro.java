import static java.time.LocalTime.now;

public class Cozinheiro {
    private String nome;
    private int anoNasc;
    private String especialidade;

    public Cozinheiro(String nome, int anoNasc, String especialidade) {
        this.nome = nome;
        this.anoNasc = anoNasc;
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoNasc() {
        return anoNasc;
    }

    public void setAnoNasc(int anoNasc) {
        this.anoNasc = anoNasc;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return " O cozinheiro < " + nome + " > possui " + (now().getNano() - anoNasc) +
                " anos de idade, e sua especialidade é " + especialidade+"\n";
    }
}
