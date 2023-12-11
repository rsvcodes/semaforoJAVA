import java.util.concurrent.locks.*;

public class Puente {
    private boolean cocheNorteCruzando;
    private boolean cocheSurCruzando;
    private Lock lock;
    private Condition esperaNorte;
    private Condition esperaSur;

    public Puente() {
        cocheNorteCruzando = false;
        cocheSurCruzando = false;
        lock = new ReentrantLock();
        esperaNorte = lock.newCondition();
        esperaSur = lock.newCondition();
    }

    public void cruzarPuenteDesdeNorte() {
        lock.lock();
        try {
            while (cocheSurCruzando) {
                esperaNorte.await();
            }

            cocheNorteCruzando = true;
            System.out.println(Thread.currentThread().getName() + " cruzando el puente desde el Norte");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void cruzarPuenteDesdeSur() {
        lock.lock();
        try {
            while (cocheNorteCruzando) {
                esperaSur.await();
            }

            cocheSurCruzando = true;
            System.out.println(Thread.currentThread().getName() + " cruzando el puente desde el Sur");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void salirDelPuente() {
        lock.lock();
        try {
            if (cocheNorteCruzando) {
                cocheNorteCruzando = false;
                System.out.println(Thread.currentThread().getName() + " saliendo del puente hacia el Sur");
                esperaSur.signal();
            } else if (cocheSurCruzando) {
                cocheSurCruzando = false;
                System.out.println(Thread.currentThread().getName() + " saliendo del puente hacia el Norte");
                esperaNorte.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}