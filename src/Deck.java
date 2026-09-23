import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// Clase del deck, aqui estan las 52 cartas
public class Deck {

    private static final String[] VALORES = {
        "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"
    };
    private static final int CARTAS_POR_MANO = 5;

    // lista con las cartas que quedan
    private final List<Card> cartas;
    // cada palo con su color
    private final Map<String, String> coloresPorPalo;
    private final Random random = new Random();

    public Deck() {
        coloresPorPalo = new LinkedHashMap<>();
        coloresPorPalo.put("Tréboles", "Negro");
        coloresPorPalo.put("Corazones", "Rojo");
        coloresPorPalo.put("Picas", "Negro");
        coloresPorPalo.put("Diamantes", "Rojo");

        // se crean las 13 cartas de cada palo
        cartas = new ArrayList<>();
        for (Map.Entry<String, String> palo : coloresPorPalo.entrySet()) {
            for (String valor : VALORES) {
                cartas.add(new Card(palo.getKey(), palo.getValue(), valor));
            }
        }
    }

    public int size() {
        return cartas.size();
    }

    public void shuffle() {
        Collections.shuffle(cartas);
        System.out.println("Se mezcló el Deck.");
    }

    // saca la primera carta
    public Card head() {
        validarCartasDisponibles(1);
        Card carta = cartas.remove(0);
        System.out.println(carta);
        System.out.println("Quedan " + cartas.size());
        return carta;
    }

    // saca una carta al azar
    public Card pick() {
        validarCartasDisponibles(1);
        Card carta = cartas.remove(random.nextInt(cartas.size()));
        System.out.println(carta);
        System.out.println("Quedan " + cartas.size());
        return carta;
    }

    // saca 5 cartas y las regresa en un arreglo
    public Card[] hand() {
        validarCartasDisponibles(CARTAS_POR_MANO);
        Card[] mano = new Card[CARTAS_POR_MANO];
        for (int i = 0; i < CARTAS_POR_MANO; i++) {
            mano[i] = cartas.remove(0);
            System.out.println(mano[i]);
        }
        System.out.println("Quedan " + cartas.size());
        return mano;
    }

    // si ya no hay cartas suficientes lanza la excepcion
    private void validarCartasDisponibles(int necesarias) {
        if (cartas.size() < necesarias) {
            throw new IllegalStateException("No hay suficientes cartas en el deck (se necesitan "
                    + necesarias + " y quedan " + cartas.size() + ").");
        }
    }
}
