
package exe;

public class Lista {
    Proceso start = null;
    int size = 0;
    int tiempoProceso = 0;

    public void PUSH(String nombre, int numero, int tamaño, int tiempo){
        Proceso nuevoProceso = new Proceso(nombre, numero, tamaño, tiempo);
        if(start == null){
            start = nuevoProceso;
        }else{
            Proceso aux = start;
            while(aux.next != null){
                aux = aux.next;
            }aux.next = nuevoProceso;
        }
        size++;
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

    public void mostrarDatos(){
        Proceso aux = start;

        while(aux != null){
            System.out.println("Nombre: "+aux.nombre);
            System.out.println("Número: "+aux.numero);
            System.out.println("Tamaño: "+aux.tamaño);
            System.out.println("Tiempo: "+aux.tiempo+"\n");
            aux = aux.next;
        }
    }
}


class Proceso{
    String nombre;
    int numero;
    int tamaño;
    int tiempo;
    Proceso next;

    public Proceso(String nombre, int numero, int tamaño, int tiempo){
        this.nombre = nombre;
        this.numero = numero;
        this.tamaño = tamaño;
        this.tiempo = tiempo;
        this.next = null;
    }
}

