package exe;

import javax.swing.JOptionPane;

public class Exe {

    static int tiempos[] = {15, 8, 12};

    public static void main(String[] args) {

        /*Lista lista_espera = new Lista();
        lista_espera.PUSH("Alfredo", 100, 10, 15);
        lista_espera.PUSH("Chaires", 50, 20, 20);
        lista_espera.PUSH("Oski", 1, 30, 15);
        lista_espera.PUSH("Leal", 3, 30, 10);
        lista_espera.PUSH("Mario", 10, 30, 45);
        lista_espera.PUSH("Tristeza", 1, 30, 15);
        lista_espera.PUSH("La miss", 3, 30, 10);
        lista_espera.PUSH("Mi ruca", 10, 30, 45);
        
        Lista lista_ejecucion = new Lista();
        
        for (int i = 0; i < 3; i++) {
            lista_ejecucion.PUSH(lista_espera.POP_start());
        }
        
        String nombre;
        int numero, tamaño, tiempo;
        String toDelete = "";

        String menuFormat = "Escoja una opción\n"
                + "1.- Capturar nuevo proceso\n"
                + "2.- Ordenar lista por tamaño\n"
                + "3.- Ordenar lista por tiempo\n"
                + "4- Ordenar lista por número\n"
                + "5.- Mostrar datos\n"
                + "6.- Elimnar proceso por número\n"
                + "7.- Salir del menú\n";
        int option;

        do{
            option = Integer.parseInt(JOptionPane.showInputDialog(null, menuFormat));
            switch(option){
                case 1:
                    nombre = JOptionPane.showInputDialog("Insertar nombre: ");
                    numero = Integer.parseInt(JOptionPane.showInputDialog("Insertar número: "));
                    tamaño = Integer.parseInt(JOptionPane.showInputDialog("Insertar tamaño: "));
                    tiempo = Integer.parseInt(JOptionPane.showInputDialog("Insertar tiempo: "));
                    lista_espera.PUSH(nombre, numero, tamaño, tiempo); 
                    break;
                case 2:
                    System.out.println("<----- Procesos ordenados por tamaño ----->");
                    lista_espera.ordenarXtamaño();
                    lista_espera.mostrarDatosX();
                    break;
                case 3:
                    System.out.println("<----- Procesos ordenados por tiempo ----->");
                    lista_espera.ordenarXtiempo();
                    lista_espera.mostrarDatosX();
                    break;
                case 4:
                    System.out.println("<----- Procesos ordenados por número ----->");
                    lista_espera.ordenarXnumero();
                    lista_espera.mostrarDatosX();
                    break;
                case 5:
                    System.out.println("<----- Procesos registrados ----->\n");
                    lista_espera.mostrarDatosX();
                    break;
                case 6:
                    toDelete = JOptionPane.showInputDialog("Nombre del proceso a eliminar: ");
                    //lista_espera.elimnarXnombre(toDelete);
                    break;
                default:
                    System.out.println("\nLa opción seleccionada no es válida");
                    break;
            }
        }while(option != 7);*/
        ordenarTiempos();

    }

    //Métoo burbuja porque tengo entendico que gasta menos recursos que los demás
    public static void ordenarTiempos() {
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

    public static void intercambio(int indexActual, int menorIndex) {
        int aux = tiempos[indexActual];
        tiempos[indexActual] = tiempos[menorIndex];
        tiempos[menorIndex] = aux;
    }
}
