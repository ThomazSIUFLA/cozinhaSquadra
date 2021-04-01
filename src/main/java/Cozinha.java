import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cozinha {
    private int horaAbertura;
    private int horaFechamento;
    private String tipo;
    private Prato pratoPricipal;
    private List<Prato> menu;
    private List<Cozinheiro> cozinheiros;

    public Cozinha(int horaAbertura, int horaFechamento, String tipo, Prato princ) {
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
        this.tipo = tipo;
        this.pratoPricipal = princ;
        this.menu = new ArrayList<>();
        this.cozinheiros = new ArrayList<>();
        adicionarPrato(princ);
    }

    public void adicionarCozinheiro(Cozinheiro coz){
        cozinheiros.add(coz);
    }

    public boolean removerCozinheiroPeloNome(String nome){
        for (Cozinheiro c : cozinheiros) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                cozinheiros.remove(c);
                return true;
            }
        }
        return false;
    }

    public int getNumeroCozinheiros(){
        return cozinheiros.size();
    }

    public String listarCozinheiros(){
        String ret = "";
        for(Cozinheiro c : cozinheiros){
            ret += c;
        }
        return ret+"\n";
    }

    public void adicionarPrato(Prato prato){
        menu.add(prato);
    }

    public boolean removerPratoPeloNome(String nome){
        for (Prato c : menu) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                menu.remove(c);
                return true;
            }
        }
        return false;
    }

    public int getNumeroPratos(){
        return menu.size();
    }

    public String listarPratos(){
        String ret = "";
        for(Prato c : menu){
            ret += c;
        }
        return ret+"\n";
    }

    public int getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(int horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public int getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(int horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Cozinha do tipo "+ tipo +"\n---------------------------------------------"
                +"\nabre as "+horaAbertura+" e fecha as"+horaFechamento
                +"\ntem como prato principal "+ pratoPricipal
                +"\n possui "+getNumeroCozinheiros()+" sendo eles:"
                +"\n"+listarCozinheiros()
                +"\nE serve "+getNumeroPratos()+" pratos diferentes"
                +"\n********************MENU***********************"
                +"\n"+listarPratos();
    }
}
