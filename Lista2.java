
package exe;

public class Lista2 {
    Proceso start = null;
    int size = 0;
    int tiempoProceso = 0;

    public void PUSH(String nombre, int numero, int tamaño, int tiempo){
        Proceso nuevoProceso = new Proceso(nombre, numero, tamaño, tiempo);
        size++;
        
        //No deberán calcularse los tiempos de los primeros 3 procesos en pasar 
        if(size <= 3){
            
            if(size == 1){
                start = nuevoProceso;
            }else{
                Proceso aux = start;
                while(aux.next != null){
                    aux = aux.next;
                }aux.next = nuevoProceso;
            }
            
        }else{
                Proceso aux = start;
                while(aux.next != null){
                    aux = aux.next;
                }aux.next = nuevoProceso;
                //calcularTiempos(nuevoProceso, aux);
        }
        
        
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