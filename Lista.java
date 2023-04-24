
package exe;

//Esta lista la vamos a pcupar para almacenar los valroes de los tiempos de los procesos que se vayan insertando
//Deberán acomodarse de menor a mayor (menor al princiopio), de forma que podamos tener el control de cuál proceso (hipotéticamente)
//termina de usar recursos primero y deja un espacio vacío para que otro proceso empiece su ejecución
public class Lista {
    Nodo start = null;
    int menor;
    
    public void PUSH(int valor){
        Nodo newNodo = new Nodo(valor);
        if(start == null){
            newNodo = start;
        }else{
            //Caso 1: Es menor que el de el inicio, entonces desplaza al del inicio 

            //Caso 2: Busca su lugar en la lista
        }
    }
    
}

class Nodo{
    Nodo nodo;
    int valor;
    
    Nodo(int valor){
        this.nodo = null;
        this.valor = valor;
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
    
    public Proceso(Proceso proceso){
        this.nombre = proceso.nombre;
        this.numero = proceso.numero;
        this.tamaño = proceso.tamaño;
        this.tiempo = proceso.tiempo;
        this.tiempoLlegada = 0;
        this.tiempoSalida = 0;
        this.tiempoEnEjecucion = 0;
        this.next = null;
    }
}

/*public void elimnarXnombre(String nombre){
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
    }*/