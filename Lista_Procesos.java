
package exe;

public class Lista_Procesos{
    Proceso start = null;
    int size = 0;
    
    int tiempos[] = new int[3];

    public void PUSH(String nombre, int numero, int tamaño, int tiempo){
        Proceso nuevoProceso = new Proceso(nombre, numero, tamaño, tiempo);
        size++;
        
        //No deberán calcularse los tiempos de llegada de los primeros 3 procesos en pasar, 
        //ya que todos podrán ocupar un recurso que esté disponible
        if(size <= 3){
            if(size == 1){
                start = nuevoProceso;
            }else{
                Proceso aux = start;
                while(aux.next != null){
                    aux = aux.next;
                }aux.next = nuevoProceso;
            }
            nuevoProceso.tiempoSalida = nuevoProceso.tiempo;
            tiempos[size-1] = nuevoProceso.tiempo;
            ordenarTiempos();
        }else{
                Proceso aux = start;
                while(aux.next != null){
                    aux = aux.next;
                }aux.next = nuevoProceso;
                 calcularTiempos(nuevoProceso);
                  ordenarTiempos();
        }
    }
    
    public void calcularTiempos(Proceso nuevoProceso){
        nuevoProceso.tiempoLlegada = tiempos[0];
        nuevoProceso.tiempoSalida = tiempos[0] + nuevoProceso.tiempo;
        tiempos[0] = nuevoProceso.tiempoSalida;
    } 
    
    //Métoo burbuja porque tengo entendido que gasta menos recursos que los demás (en este caso que son solo 3 números
    public void ordenarTiempos() {
        int menorIndex;
        for (int j = 0; j < 3; j++) {
            menorIndex = j;
            for (int i = 0; i < 3; i++) {
                if (tiempos[i] < tiempos[menorIndex]) {
                    intercambio(i, menorIndex);
                    menorIndex = i;
                }
            }
        }
    }
    public void intercambio(int indexActual, int menorIndex) {
        int aux = tiempos[indexActual];
        tiempos[indexActual] = tiempos[menorIndex];
        tiempos[menorIndex] = aux;
    }
    
    public void mostrarDatosX() {
        Proceso aux = start;

        System.out.printf("%10s %8s %8s %8s  %16s  %15s %19s" , "NOMBRE", "NÚMERO", "TAMAÑO", "TIEMPO", "TIEMPO LLEGADA", "TIEMPO SALIDA", "TIEMPO EN EJECUCIÓN");
        System.out.println();
        System.out.println(
                "---------------------------------------------------------------------------------------------");

        while (aux != null) {
            System.out.format("%10s %8s %8s %8s  %16s  %15s %19s", aux.nombre, aux.numero, aux.tamaño, aux.tiempo, aux.tiempoLlegada, aux.tiempoSalida, aux.tiempoEnEjecucion);
            System.out.println();

            aux = aux.next;
        }

        System.out.println(
                "----------------------------------------------------------------------------------------------");
    }
    
}