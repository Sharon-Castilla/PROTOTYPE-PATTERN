package registry;

import prototype.Personaje;

import java.util.HashMap;
import java.util.Map;

public class RegistroPrototipos {

    private final Map<String, Personaje> prototipos = new HashMap<>();

    public void registrarPrototipo(String clave, Personaje personaje) {
        prototipos.put(clave, personaje);
    }

    public Personaje obtenerCopia(String clave) {
        Personaje prototipo = prototipos.get(clave);
        if (prototipo == null) {
            System.out.println("No existe el prototipo '" + clave + "'. No se puede clonar.");
            return null;
        }
        return prototipo.clonar();
    }

    public Personaje consultarPrototipo(String clave) {
        return prototipos.get(clave);
    }
}
