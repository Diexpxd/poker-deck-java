// Clase que representa una carta
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

    // para que se imprima como Palo,Color,Valor
    @Override
    public String toString() {
        return palo + "," + color + "," + valor;
    }
}
