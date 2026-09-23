# Deck de poker en Java

Actividad 3 de Computación en Java. Simula un deck de 52 cartas de poker con las clases `Card` y `Deck`.

- `Card`: palo, color y valor de una carta.
- `Deck`: guarda las cartas en una `List<Card>` y la relación palo-color en un `Map<String, String>`. Tiene los métodos `shuffle`, `head`, `pick` y `hand`.
- `Main`: prueba los cuatro métodos.

## Cómo ejecutarlo

```
javac -encoding UTF-8 -d out src/*.java
java -Dfile.encoding=UTF-8 -cp out Main
```
