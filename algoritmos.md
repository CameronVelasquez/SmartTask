# Algoritmos de SmartTask

## Agregar tarea

```text
INICIO

    Solicitar nombre de la tarea
    Leer nombre

    Crear tarea con el nombre recibido
    Agregar tarea a la lista

    Mostrar "Tarea agregada correctamente"

FIN

## Listar Tarea

INICIO

    SI la lista de tareas está vacía ENTONCES
        Mostrar "No hay tareas registradas"
    SI NO
        PARA cada tarea de la lista
            Mostrar tarea
        FIN PARA
    FIN SI

FIN

## Eliminar Tarea

INICIO

    Solicitar posición de la tarea
    Leer posición

    SI la posición existe ENTONCES
        Eliminar tarea de esa posición
        Mostrar "Tarea eliminada correctamente"
    SI NO
        Mostrar "Tarea no encontrada"
    FIN SI

FIN


### Aclaración:

En este documento usamos **posición** para eliminar porque la implementación de esta lección trabaja con `List<String>` , temporalmente.

En la versión final del proyecto **NO** vamos a conservar ese diseño: la consigna final establece que las tareas tendrán `id` y que `GestorTareas` administrará IDs autoincrementales desde 1, sin reutilizarlos. :contentReference[oaicite:1]{index=1}

Eso significa que estamos haciendo exactamente lo que busca la progresión del curso: **primero** resolver la lógica sencilla; **después** evolucionarla con clases, POO y una arquitectura más apropiada.

