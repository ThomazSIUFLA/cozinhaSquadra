import java.util.List;

public class Prato {
    private String nome;
    private List<Ingredientes> ingredientes;
    private int tempoPreparo;
    private double valor;

    public Prato(String nome, List<Ingredientes> ingredientes, int tempoPreparo, double valor) {
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.tempoPreparo = tempoPreparo;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Ingredientes> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingredientes> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String listaIngredientes(){
        StringBuilder retBuilder = new StringBuilder();
        for (Ingredientes i: ingredientes) {
            retBuilder.append(", ").append(i.getNome());
        }
        String ret = retBuilder.toString();
        ret= ret.replaceFirst(", ","");
        return ret;
    }

    @Override
    public String toString() {
        return "O prato "+nome+" utiliza os ingredientes\n"+ listaIngredientes() +",\n"
                + "e possui um tempo de preparo de "+ tempoPreparo + " custando R$"
                + String.format("%.2f", valor) +"\n---------------------------------------------------------\n";
    }
}
