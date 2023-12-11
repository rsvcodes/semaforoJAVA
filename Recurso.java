import java.util.concurrent.Semaphore;

public class Recurso {
    private int unidades;
    private Semaphore semaforo;

    public Recurso(int unidades) {
        this.unidades = unidades;
        this.semaforo = new Semaphore(unidades, true);
    }

    public void reserva(int r) {
        try {
            semaforo.acquire(r);
            unidades -= r;
            System.out.println(Thread.currentThread().getName() + " reservó " + r + " unidades. Unidades disponibles: " + unidades);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void libera(int l) {
        unidades += l;
        semaforo.release(l);
        System.out.println(Thread.currentThread().getName() + " liberó " + l + " unidades. Unidades disponibles: " + unidades);
    }
}