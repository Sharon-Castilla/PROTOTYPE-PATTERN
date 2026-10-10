package model;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<String> items;

    public Inventario() {
        this.items = new ArrayList<>();
    }

    public Inventario(Inventario otro) {
        this.items = new ArrayList<>(otro.items);
    }

    public void agregarItem(String item) {
        items.add(item);
    }

    public List<String> getItems() {
        return new ArrayList<>(items);
    }

    public Inventario copiar() {
        return new Inventario(this);
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
