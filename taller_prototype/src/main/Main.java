package main;

import model.Inventario;
import prototype.Personaje;
import registry.RegistroPrototipos;

public class Main {

    public static void main(String[] args) {
        RegistroPrototipos registro = new RegistroPrototipos();

        // 1. Registrar dos prototipos base
        Inventario invGuerrero = new Inventario();
        invGuerrero.agregarItem("Pocion de vida");
        registro.registrarPrototipo("Guerrero", new Personaje("Guerrero", "Guerrero", invGuerrero));

        Inventario invMago = new Inventario();
        invMago.agregarItem("Baston magico");
        registro.registrarPrototipo("Mago", new Personaje("Mago", "Mago", invMago));

        System.out.println("Prototipos originales");
        System.out.println(registro.consultarPrototipo("Guerrero"));
        System.out.println(registro.consultarPrototipo("Mago"));

        // 2. Clonar desde el registro (sin usar constructores)
        Personaje guerreroCopia = registro.obtenerCopia("Guerrero");
        guerreroCopia.setNombre("Guerrero-Copia");

        Personaje magoCopia = registro.obtenerCopia("Mago");
        magoCopia.setNombre("Mago-Copia");

        System.out.println("\nCopias recien clonadas");
        System.out.println(guerreroCopia);
        System.out.println(magoCopia);

        // 3. Modificar el inventario de las copias
        guerreroCopia.getInventario().agregarItem("Escudo");
        magoCopia.getInventario().agregarItem("Libro de hechizos");

        System.out.println("\nDespues de modificar los inventarios de las copias");
        System.out.println(guerreroCopia);
        System.out.println(magoCopia);

        // 4. Verificar que los originales no cambiaron
        System.out.println("\nPrototipos originales (sin cambios)");
        System.out.println(registro.consultarPrototipo("Guerrero"));
        System.out.println(registro.consultarPrototipo("Mago"));

        // 5. Prototipo inexistente
        System.out.println("\nPrueba con prototipo inexistente");
        Personaje inexistente = registro.obtenerCopia("Arquero");
        System.out.println("Resultado: " + inexistente);
    }
}
