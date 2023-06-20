import java.io.IOException;

public class Main {

    static String PATH = "C:\\Users\\juan2\\Pictures\\E2.jpg";

    public static void main(String[] args) throws IOException {
        System.out.println("Ejecutando proyecto");

        Ventana ventana = new Ventana(PATH);
    }
}