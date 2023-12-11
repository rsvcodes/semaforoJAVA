public class Main {
    public static void main(String[] args) {
        Recurso recurso = new Recurso(10);

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new Proceso(recurso), "Proceso " + i);
            t.start();
        }
    }
}