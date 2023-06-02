package exe;

public class Lista_Procesos{
    Proceso start = null;
    int size = 0;
    
    int tiempos[] = new int[3];

    public void PUSH(String nombre, int numero, int tamaño, int tiempo){
        Proceso nuevoProceso = new Proceso(nombre, numero, tamaño, tiempo);
        size++;
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
        }else{
                Proceso aux = start;
                while(aux.next != null){
                    aux = aux.next;
                }aux.next = nuevoProceso;
                calcularTiempos(nuevoProceso);
        }ordenarTiempos();
        
    }
    
    public void calcularTiempos(Proceso nuevoProceso){
        nuevoProceso.tiempoLlegada = tiempos[0];
        nuevoProceso.tiempoSalida = tiempos[0] + nuevoProceso.tiempo;
        tiempos[0] = nuevoProceso.tiempoSalida;
    } 

    public void calcularTiemposDeNuevo(){
        int numProceso = 1;
        Proceso aux = start;
        
        while(numProceso <= size){
            if(numProceso <= 3){
                aux.tiempoSalida = aux.tiempo;
                tiempos[numProceso-1] = aux.tiempo;
            }else{
                calcularTiempos(aux);
            }
            aux = aux.next;
            numProceso++;
            ordenarTiempos();
        }
    }
    
    public void ordenarXnumero(){
        Proceso auxInicioRelativo = start;
        Proceso auxMenor = start; 
        Proceso aux = start;
        int menorLista = start.numero;
        int vueltas = size;
        boolean cambioNecesario;


        while(auxInicioRelativo.next != null){
            cambioNecesario = false;
            for (int i = 0; i < vueltas; i++) {
                if(aux.numero < menorLista){
                    menorLista = aux.numero;
                    auxMenor = aux;
                    cambioNecesario = true;
                }aux = aux.next;
            }

            if(cambioNecesario){
                intercambioProceso(auxMenor, auxInicioRelativo);
            }
            auxInicioRelativo = auxInicioRelativo.next;
            auxMenor = aux = auxInicioRelativo;
            menorLista = auxInicioRelativo.numero;
            vueltas--;
        }
        calcularTiemposDeNuevo();
    }

    public void ordenarXtamaño(){
        Proceso auxInicioRelativo = start;
        Proceso auxMenor = start; 
        Proceso aux = start;
        int menorLista = start.tamaño;
        int vueltas = size;
        boolean cambioNecesario;

        while(auxInicioRelativo.next != null){
            cambioNecesario = false;
            for (int i = 0; i < vueltas; i++) {
                if(aux.tamaño < menorLista){
                    menorLista = aux.tamaño;
                    auxMenor = aux;
                    cambioNecesario = true;
                }aux = aux.next;
            }

            if(cambioNecesario){
                intercambioProceso(auxMenor, auxInicioRelativo);
            }
            auxInicioRelativo = auxInicioRelativo.next;
            auxMenor = aux = auxInicioRelativo;
            menorLista = auxInicioRelativo.tamaño;
            vueltas--;
        }
        
        calcularTiemposDeNuevo();
 
    }

    public void ordenarXtiempo(){
        Proceso auxInicioRelativo = start;
        Proceso auxMenor = start; 
        Proceso aux = start;
        int menorLista = start.tiempo;
        int vueltas = size;
        boolean cambioNecesario;

        while(auxInicioRelativo.next != null){
            cambioNecesario = false;
            for (int i = 0; i < vueltas; i++) {
                if(aux.tiempo < menorLista){
                    menorLista = aux.tiempo;
                    auxMenor = aux;
                    cambioNecesario = true;
                }aux = aux.next;
            }

            if(cambioNecesario){
                intercambioProceso(auxMenor, auxInicioRelativo);
            }
            auxInicioRelativo = auxInicioRelativo.next;
            auxMenor = aux = auxInicioRelativo;
            menorLista = auxInicioRelativo.tiempo;
            vueltas--;
        }
        calcularTiemposDeNuevo();
 
    }

    public void intercambioProceso(Proceso menor, Proceso inicioRelativo){
        String auxNombre = inicioRelativo.nombre;
        int auxNum = inicioRelativo.numero;
        int auxTam = inicioRelativo.tamaño;
        int auxTiempo = inicioRelativo.tiempo;

        inicioRelativo.nombre = menor.nombre;
        inicioRelativo.numero = menor.numero;
        inicioRelativo.tamaño = menor.tamaño;
        inicioRelativo.tiempo = menor.tiempo;

        menor.nombre = auxNombre;
        menor.numero = auxNum;
        menor.tamaño = auxTam;
        menor.tiempo = auxTiempo;
    }
    
    public void ordenarTiempos(){
        int menorIndex;
        int vuelta = 0;
        
        while(vuelta < 3){
            menorIndex = vuelta;
            int i=vuelta;
            for (; i < 3-vuelta; i++) {
                if(tiempos[i] < tiempos[menorIndex] && tiempos[i] != 0){
                    menorIndex = i;
                }
            }
            intercambio(vuelta, menorIndex);
            vuelta++;
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