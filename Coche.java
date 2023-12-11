public class Coche implements Runnable {
    private Puente puente;
    private boolean desdeNorte;

    public Coche(Puente puente, boolean desdeNorte) {
        this.puente = puente;
        this.desdeNorte = desdeNorte;
    }

    @Override
    public void run() {
        if (desdeNorte) {
            puente.cruzarPuenteDesdeNorte();
        } else {
            puente.cruzarPuenteDesdeSur();
        }

        // Simular tiempo de cruce
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        puente.salirDelPuente();
    }
}