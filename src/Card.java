/**
 * Representa una carta de poker con sus tres atributos: palo, color y valor.
 */
public class Card {

    private final String palo;
    private final String color;
    private final String valor;

    public Card(String palo, String color, String valor) {
        this.palo = palo;
        this.color = color;
        this.valor = valor;
    }

    public String getPalo() {
        return palo;
    }

    public String getColor() {
        return color;
    }

    public String getValor() {
        return valor;
    }

    // Formato pedido en la actividad: {Palo},{Color},{Valor}
    @Override
    public String toString() {
        return palo + "," + color + "," + valor;
    }
}
