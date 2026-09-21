package com.smarttask.model;

/**
 * Representa una tarea normal dentro de SmartTask.
 *
 * <p>Hereda los atributos y comportamientos básicos de Tarea.</p>
 */
public class TareaNormal extends Tarea {

    /**
     * Crea una nueva tarea normal.
     *
     * @param id identificador inicial de la tarea
     * @param nombre nombre de la tarea
     */
    public TareaNormal(int id, String nombre) {
        super(id, nombre);
    }

    /**
     * Representación textual de la tarea normal.
     *
     * @return información de la tarea
     */
    @Override
    public String toString() {
        return "[NORMAL] ID: " + getId()
                + " | Nombre: " + getNombre()
                + " | Completada: " + isCompletado();
    }
}