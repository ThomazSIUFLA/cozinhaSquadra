import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static java.time.LocalTime.now;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy");
        Prato macarronada= new Prato("Macarronada",
                Arrays.asList(new Ingredientes("macarrão",new Date()),
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

        Cozinha chinesa = new Cozinha(10,21,"Chinesa", yakissoba);
        chinesa.adicionarPrato(yakissoba);
        chinesa.adicionarCozinheiro(new Cozinheiro("kin jon un", 1970, "Yakissoba"));
        chinesa.adicionarCozinheiro(new Cozinheiro("ou in di", 1985, "lavar de pratos"));
        chinesa.adicionarCozinheiro(new Cozinheiro("jei hei nei",1950,"Garçom"));

        Cozinha italiana = new Cozinha(10,21,"Italiana", yakissoba);
        chinesa.adicionarPrato(macarronada);
        chinesa.adicionarCozinheiro(new Cozinheiro("joão", 1970, "Macarronada"));
        chinesa.adicionarCozinheiro(new Cozinheiro("leonardo", 1985, "lavar de pratos"));
        chinesa.adicionarCozinheiro(new Cozinheiro("Chellini",1950,"Garçom"));


    }
}
