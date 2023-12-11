public class Proceso implements Runnable {
    private Recurso recurso;

    public Proceso(Recurso recurso) {
        this.recurso = recurso;
    }

    @Override
    public void run() {
        int unidades = (int) (Math.random() * 5) + 1; // Número aleatorio de unidades entre 1 y 5
        recurso.reserva(unidades);

        // Simular tiempo de ejecución
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        recurso.libera(unidades);
    }
}