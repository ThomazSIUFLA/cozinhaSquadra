import java.text.SimpleDateFormat;
import java.util.Date;

public class Ingredientes {
    private String nome;
    private Date dataValidade;

    public Ingredientes(String nome, Date dataValidade) {
        this.nome = nome;
        this.dataValidade = dataValidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        return "\n O ingrediente "+nome+" e data de validade "+ dataValidade;
    }
}
