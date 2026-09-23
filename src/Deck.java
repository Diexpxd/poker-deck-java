import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Representa el deck (baraja) de 52 cartas de poker.
 * Usa dos atributos del Collection Framework:
 *  - cartas: List<Card> (ArrayList) con las cartas que quedan en el deck.
 *  - coloresPorPalo: Map<String, String> (LinkedHashMap) que relaciona cada palo con su color.
 */
public class Deck {

    private static final String[] VALORES = {
        "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"
    };
    private static final int CARTAS_POR_MANO = 5;

    private final List<Card> cartas;
    private final Map<String, String> coloresPorPalo;
    private final Random random = new Random();

    public Deck() {
        coloresPorPalo = new LinkedHashMap<>();
        coloresPorPalo.put("Tréboles", "Negro");
        coloresPorPalo.put("Corazones", "Rojo");
        coloresPorPalo.put("Picas", "Negro");
        coloresPorPalo.put("Diamantes", "Rojo");

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

    /** Mezcla el deck. */
    public void shuffle() {
        Collections.shuffle(cartas);
        System.out.println("Se mezcló el Deck.");
    }

    /** Muestra y remueve la primera carta del deck. */
    public Card head() {
        validarCartasDisponibles(1);
        Card carta = cartas.remove(0);
        System.out.println(carta);
        System.out.println("Quedan " + cartas.size());
        return carta;
    }

    /** Selecciona una carta al azar, la muestra y la remueve del deck. */
    public Card pick() {
        validarCartasDisponibles(1);
        Card carta = cartas.remove(random.nextInt(cartas.size()));
        System.out.println(carta);
        System.out.println("Quedan " + cartas.size());
        return carta;
    }

    /** Regresa un arreglo de cinco cartas, las muestra y las remueve del deck. */
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

    private void validarCartasDisponibles(int necesarias) {
        if (cartas.size() < necesarias) {
            throw new IllegalStateException("No hay suficientes cartas en el deck (se necesitan "
                    + necesarias + " y quedan " + cartas.size() + ").");
        }
    }
}
