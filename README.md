Descripción del Proyecto: Problema de Uso de Recursos y Puente sobre un Río

El proyecto aborda dos problemas concurrentes comunes utilizando conceptos de concurrencia en Java. Estos problemas son:

    Problema de Uso de Recursos (Semáforo en Java):
        Enfrenta la competencia de n procesos por k unidades de un recurso.
        Define dos operaciones en el recurso: reserva(r) y libera(l).
        Utiliza semáforos binarios para garantizar un acceso seguro al recurso.

    Problema del Puente sobre un Río (Monitor en Java):
        Modela la situación en la que coches del norte y del sur intentan cruzar un puente sobre un río.
        Se asegura de que en un momento dado solo se pueda cruzar el puente en una dirección.
        Implementa un monitor para coordinar el acceso al puente.

Clases:

    Recurso.java:
        Descripción:
            Representa un recurso con una cantidad específica de unidades.
        Atributos:
            unidades: Cantidad total de unidades disponibles.
            semaforo: Semáforo binario para controlar el acceso a las unidades.
        Métodos Principales:
            Recurso(int unidades): Constructor que inicializa el recurso con la cantidad especificada de unidades.
            reserva(int r): Método para que un proceso reserve r unidades del recurso.
            libera(int l): Método para que un proceso libere l unidades del recurso.

    Proceso.java:
        Descripción:
            Representa un proceso que realiza operaciones en un recurso.
        Atributos:
            recurso: Referencia al recurso en el que opera el proceso.
        Métodos Principales:
            run(): Método de la interfaz Runnable que simula la ejecución del proceso.

    Main.java:
        Descripción:
            Contiene la función main que crea instancias de Recurso y Proceso y ejecuta los procesos.
        Métodos Principales:
            main(String[] args): Función principal que inicia el programa.

    Puente.java:
        Descripción:
            Modela un puente sobre un río utilizando un monitor para coordinar el acceso.
        Atributos:
            cocheNorteCruzando: Indica si hay un coche del norte cruzando el puente.
            cocheSurCruzando: Indica si hay un coche del sur cruzando el puente.
            lock: Objeto de bloqueo para garantizar la exclusión mutua.
            esperaNorte y esperaSur: Condiciones para esperar a que se libere el acceso desde el norte o el sur.
        Métodos Principales:
            Métodos para cruzar el puente desde el norte (cruzarPuenteDesdeNorte()), desde el sur (cruzarPuenteDesdeSur()), y para salir del puente (salirDelPuente()).

    Coche.java:
        Descripción:
            Representa un coche que cruza el puente desde el norte o el sur.
        Atributos:
            puente: Referencia al puente sobre el río.
            desdeNorte: Indica si el coche viene desde el norte.
        Métodos Principales:
            run(): Método de la interfaz Runnable que simula el cruce del puente por parte del coche.

    MainPuente.java:
        Descripción:
            Contiene la función main que crea instancias de Puente y Coche y ejecuta los coches que intentan cruzar el puente.
        Métodos Principales:
            main(String[] args): Función principal que inicia el programa del puente.

Estas clases trabajan en conjunto para simular y resolver los problemas concurrentes mencionados utilizando semáforos y monitores en Java.
Cada clase cumple un propósito específico para abordar los aspectos de concurrencia y coordinación necesarios.
