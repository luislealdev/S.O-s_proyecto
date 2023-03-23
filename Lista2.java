
package exe;

public class Lista2 {
    Proceso2 start = null;
    int size = 0;
    int tiempoProceso = 0;

    public void PUSH(String nombre, int numero, int tamaño, int tiempo){
        Proceso2 nuevoProceso = new Proceso2(nombre, numero, tamaño, tiempo);
        if(start == null){
            start = nuevoProceso;
            calcularTiempos(nuevoProceso, null);
        }else{
            Proceso2 aux = start;
            while(aux.next != null){
                aux = aux.next;
            }aux.next = nuevoProceso;
            calcularTiempos(nuevoProceso, aux);
        }
        size++;
    }

    public void calcularTiempos(Proceso2 nuevoProceso, Proceso2 proceso){
        if(nuevoProceso == start){
            nuevoProceso.tiempoLlegada = 0;
            nuevoProceso.tiempoSalida = nuevoProceso.tiempo;
            nuevoProceso.tiempoEnEjecucion = nuevoProceso.tiempo;
        }else{
            nuevoProceso.tiempoLlegada = proceso.tiempoSalida;
            nuevoProceso.tiempoSalida = nuevoProceso.tiempoLlegada+nuevoProceso.tiempo;
            nuevoProceso.tiempoEnEjecucion = nuevoProceso.tiempoSalida;
        }
    }
    
    public void elimnarXnombre(String nombre){
        Proceso2 aux = start;
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
        Proceso2 auxInicioRelativo = start;
        Proceso2 auxMenor = start; 
        Proceso2 aux = start;
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
    }

    public void ordenarXtamaño(){
        Proceso2 auxInicioRelativo = start;
        Proceso2 auxMenor = start; 
        Proceso2 aux = start;
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
    }

    public void ordenarXtiempo(){
        Proceso2 auxInicioRelativo = start;
        Proceso2 auxMenor = start; 
        Proceso2 aux = start;
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
    }

    public void intercambioProceso(Proceso2 menor, Proceso2 inicioRelativo){
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

    
    
    public void mostrarDatos(){
        String matriz[][] = new String[size][7];
        matriz[0][0] = "   Nombre   ";
        matriz[0][1] = "   Número   ";
        matriz[0][2] = "   Tamaño   ";
        matriz[0][3] = "   Tiempo   ";
        matriz[0][4] = " Tiempo llegada ";
        matriz[0][5] = " Tiempo salida ";
        matriz[0][6] = " Tiempo en sistema ";
        Proceso2 aux = start;

        for (int c = 0; c < 7; c++) {
            System.out.print(matriz[0][c]);
        }
        
        
    }
    
    /*
    public void mostrarDatos(){
        Proceso2 aux = start;

        while(aux != null){
            System.out.println("Nombre: "+aux.nombre);
            System.out.println("Número: "+aux.numero);
            System.out.println("Tamaño: "+aux.tamaño);
            System.out.println("Tiempo: "+aux.tiempo+"\n");
            aux = aux.next;
        }
    }
    */
}

class Proceso2{
    String nombre;
    int numero;
    int tamaño;
    int tiempo;
    int tiempoLlegada;
    int tiempoSalida;
    int tiempoEnEjecucion;
    Proceso2 next;

    public Proceso2(String nombre, int numero, int tamaño, int tiempo){
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