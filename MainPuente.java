public class MainPuente {
    public static void main(String[] args) {
        Puente puente = new Puente();

        for (int i = 0; i < 5; i++) {
            Thread tNorte = new Thread(new Coche(puente, true), "CocheNorte" + i);
            Thread tSur = new Thread(new Coche(puente, false), "CocheSur" + i);
            tNorte.start();
            tSur.start();
        }
    }
}