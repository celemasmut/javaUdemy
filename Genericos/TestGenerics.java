package udemy.Genericos;

public class TestGenerics {

    public static void main(String[] args) {
        ClaseGenerica<Integer> objInteger = new ClaseGenerica<>(14);
        objInteger.obtenerTipo();

        ClaseGenerica<String> objString = new ClaseGenerica<>("Celes");
        objString.obtenerTipo();

    }
}
