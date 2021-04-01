import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    private static List<Cozinha> cozinhas;
    public static void main(String[] args) throws ParseException {

        cozinhas = new ArrayList<>();

        SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy");

        Prato macarronada= new Prato("Macarronada",
                Arrays.asList(new Ingredientes("macarrão",parser.parse("10-01-2021")),
                new Ingredientes("sal", parser.parse("10-10-2021")),
                new Ingredientes("oleo", parser.parse("10-10-2021"))),
                30, 10.50);

        Prato feijoada = new Prato("Feijoada",
                Arrays.asList(new Ingredientes("Feijão preto", parser.parse("10-10-2021")),
                        new Ingredientes("Miudos de porco", parser.parse("10-02-2022")),
                        new Ingredientes("Sal",parser.parse("31-12-2030")),
                        new Ingredientes("Bacon", parser.parse("25-12-2021"))),
                6,42.35);

        Prato linguica = new Prato("Linguiça frita com queijo e bacon",
                Arrays.asList(new Ingredientes("Linguiça de porco", parser.parse("10-10-2021")),
                        new Ingredientes("Queijo Mozzarella", parser.parse("10-02-2022")),
                        new Ingredientes("Bacon", parser.parse("25-12-2021"))),
                6,30);

        Prato yakissoba = new Prato("Yakissoba",
                Arrays.asList(new Ingredientes("Lámen", parser.parse("10-01-2021")),
                        new Ingredientes("Tomate", parser.parse("10-02-2021")),
                        new Ingredientes("Pimentão", parser.parse("25-12-2021")),
                        new Ingredientes("Carne", parser.parse("12-04-2021")),
                        new Ingredientes("Champingnon", parser.parse("25-10-2021"))),
                6,30);

        Cozinha mineira = new Cozinha(14,20,"Mineira", feijoada);
        mineira.adicionarPrato(linguica);
        mineira.adicionarCozinheiro(new Cozinheiro("Antonio", 1970, "Feijoada"));
        mineira.adicionarCozinheiro(new Cozinheiro("André",1980,"Linguiceiro"));
        mineira.adicionarCozinheiro(new Cozinheiro("Vito", 1985, "lavar de pratos"));
        mineira.adicionarCozinheiro(new Cozinheiro("James",1950,"Garçom"));
        cozinhas.add(mineira);

        Cozinha chinesa = new Cozinha(10,21,"Chinesa", yakissoba);
        chinesa.adicionarPrato(yakissoba);
        chinesa.adicionarCozinheiro(new Cozinheiro("kin jon un", 1970, "Yakissoba"));
        chinesa.adicionarCozinheiro(new Cozinheiro("ou in di", 1985, "lavar de pratos"));
        chinesa.adicionarCozinheiro(new Cozinheiro("jei hei nei",1950,"Garçom"));
        cozinhas.add(chinesa);

        Cozinha italiana = new Cozinha(10,21,"Italiana", macarronada);
        italiana.adicionarPrato(macarronada);
        italiana.adicionarCozinheiro(new Cozinheiro("joão", 1970, "Macarronada"));
        italiana.adicionarCozinheiro(new Cozinheiro("leonardo", 1985, "lavar de pratos"));
        italiana.adicionarCozinheiro(new Cozinheiro("Chellini",1950,"Garçom"));
        cozinhas.add(italiana);

        menuPrincipal();
    }

    public static void menuPrincipal(){
        int cond;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Digite a opção");
            System.out.println(
                    """
                            -------------------------------------
                            | (0) PARA SAIR                       |
                            | (1) PARA VER TODAS COZINHAS         |
                            | (2) PARA MENU COZINHA               |
                            --------------------------------------""");
            System.out.print("---  Informe a opção: ");
            cond = scan.nextInt();
            switch (cond) {
                case 1 -> System.out.println(cozinhas);
                case 2 -> menuGeralCozinha();
                case 0 -> {}
                default -> System.out.println("Opção inválida!");
            }
        }while (cond != 0);
    }

    public static void menuGeralCozinha(){
        int cond;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("===================MENU COZINHA=============================");
            System.out.println("Digite a opção");
            System.out.println(
                    """
                            -------------------------------------
                            | (0) PARA VOLTAR AO MENU PRINCIPAL   |
                            | (1) PARA LISTAR COZINHAS            |
                            | (2) PARA SELECIONAR COZINHA         |
                            --------------------------------------""");
            System.out.print("---  Informe a opção: ");
            cond = scan.nextInt();
            switch (cond){
                case 1:
                    for(Cozinha c : cozinhas){
                        System.out.println(c.getCod()+" --- "+c.getTipo());
                    }
                    break;
                case 2:
                    System.out.println("Entre com o código da cozinha ");
                    detalheCozinha(scan.nextInt());
                    break;
                case 0:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while (cond != 0);
    }

    public static void detalheCozinha(int cod){
        int cond;
        Scanner scan = new Scanner(System.in);
        Cozinha coz = null;
        for (Cozinha c : cozinhas){
            if(c.getCod() == cod){
                coz = c;
            }
        }
        do {
            System.out.println("===================DETALHES COZINHA=============================");
            System.out.println("Digite a opção");
            System.out.println(
                    """
                            -------------------------------------
                            | (0) PARA VOLTAR AO MENU ANTERIOR    |
                            | (1) PARA LISTAR PRATOS              |
                            | (2) PARA LISTAR FUNCIONÁRIOS        |
                            | (3) PARA LISTAR TODOS INGREDIENTES  |
                            --------------------------------------""");
            System.out.print("---  Informe a opção: ");
            cond = scan.nextInt();
            switch (cond){
                case 1:
                    assert coz != null;
                    System.out.println(coz.listarPratos());
                    break;
                case 2:
                    assert coz != null;
                    System.out.println(coz.listarCozinheiros());
                    break;
                case 3:
                    assert coz != null;
                    for (Prato p: coz.getMenu()){
                        System.out.println("Utilizado no prato: "+p.getNome());
                        System.out.println(p.getIngredientes());
                    }
                    break;
                case 0:

                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while (cond != 0);
    }
}
