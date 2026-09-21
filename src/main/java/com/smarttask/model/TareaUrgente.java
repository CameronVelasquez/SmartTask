package com.smarttask.model;

/**
 * Representa una tarea urgente dentro de SmartTask.
 *
 * <p>Hereda los atributos y comportamientos básicos de Tarea
 * y agrega un límite de días.</p>
 */
public class TareaUrgente extends Tarea {

    private int diasLimite;

    /**
     * Crea una nueva tarea urgente.
     *
     * @param id identificador inicial de la tarea
     * @param nombre nombre de la tarea
     * @param diasLimite cantidad de días límite
     */
    public TareaUrgente(int id, String nombre, int diasLimite) {
        super(id, nombre);
        this.diasLimite = diasLimite;
    }

    /**
     * Obtiene la cantidad de días límite.
     *
     * @return días límite
     */
    public int getDiasLimite() {
        return diasLimite;
    }

    /**
     * Modifica la cantidad de días límite.
     *
     * @param diasLimite nuevo límite de días
     */
    public void setDiasLimite(int diasLimite) {
        this.diasLimite = diasLimite;
    }

    /**
     * Determina si la tarea está vencida.
     *
     * @return true si los días límite son menores o iguales a cero
     */
    public boolean estaVencida() {
        return diasLimite <= 0;
    }

    /**
     * Representación textual de la tarea urgente.
     *
     * @return información de la tarea
     */
    @Override
    public String toString() {
        return "[URGENTE] ID: " + getId()
                + " | Nombre: " + getNombre()
                + " | Completada: " + isCompletado()
                + " | Días límite: " + diasLimite;
    }
}