
package exe;

public class Lista {
    Proceso start = null;
    int size = 0;
    int tiempoProceso = 0;

    public void PUSH(String nombre, int numero, int tamaño, int tiempo){
        Proceso nuevoProceso = new Proceso(nombre, numero, tamaño, tiempo);
        if(start == null){
            start = nuevoProceso;
            calcularTiempos(nuevoProceso, null);
        }else{
            Proceso aux = start;
            while(aux.next != null){
                aux = aux.next;
            }aux.next = nuevoProceso;
            calcularTiempos(nuevoProceso, aux);
        }
        size++;
    }
    
    public void calcularTiempos(Proceso nuevoProceso, Proceso proceso){
        if(nuevoProceso == start){
            nuevoProceso.tiempoLlegada = 0;
            nuevoProceso.tiempoSalida = nuevoProceso.tiempo;
            nuevoProceso.tiempoEnEjecucion = nuevoProceso.tiempo;
        }else{
            nuevoProceso.tiempoLlegada = proceso.tiempoEnEjecucion;
            nuevoProceso.tiempoSalida = nuevoProceso.tiempoLlegada+nuevoProceso.tiempo;
            nuevoProceso.tiempoEnEjecucion = nuevoProceso.tiempoSalida;
        }
    }
    
    public void calcularTiemposDeNuevo(){
        Proceso aux = start;
        Proceso vigilante = aux;
        while(aux.next!= null){
             if(aux == start){
                 calcularTiempos(aux, null);
            }else{
                 calcularTiempos(aux, vigilante);
            }
             vigilante = aux;
             aux = aux.next;
        }calcularTiempos(aux, vigilante);
    }

    public void elimnarXnombre(String nombre){
        Proceso aux = start;
        if(aux.nombre.equals(nombre)){
            start = aux.next;
        }else{
            while(aux.next != null && !aux.next.nombre.equals(nombre)){
                aux = aux.next;
            }
        }

        if(aux.next != null){
            aux.next = aux.next.next;
        }else{
            System.out.println("EL proceso con el nombre "+ nombre+" no existe");
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


class Proceso{
    String nombre;
    int numero;
    int tamaño;
    int tiempo;
    int tiempoLlegada;
    int tiempoSalida;
    int tiempoEnEjecucion;
    Proceso next;

    public Proceso(String nombre, int numero, int tamaño, int tiempo){
        this.nombre = nombre;
        this.numero = numero;
        this.tamaño = tamaño;
        this.tiempo = tiempo;
        this.tiempoLlegada = 0;
        this.tiempoSalida = 0;
        this.tiempoEnEjecucion = 0;
        this.next = null;
    }
}

