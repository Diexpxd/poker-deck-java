/**
 * Programa de prueba para las clases Deck y Card.
 */
public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println("Deck creado con " + deck.size() + " cartas.");

        System.out.println("\n--- shuffle ---");
        deck.shuffle();

        System.out.println("\n--- head ---");
        deck.head();

        System.out.println("\n--- pick ---");
        deck.pick();

        System.out.println("\n--- hand ---");
        deck.hand();

        // Se reparten manos hasta que ya no alcanzan las cartas,
        // para comprobar el manejo de la excepción.
        System.out.println("\n--- repartiendo manos hasta vaciar el deck ---");
        try {
            while (true) {
                deck.hand();
            }
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
