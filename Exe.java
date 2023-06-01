package exe;

import javax.swing.JOptionPane;

public class Exe {

    static int tiempos[] = {15, 8, 12};

    public static void main(String[] args) {

        Lista_Procesos lista_espera = new Lista_Procesos();
        lista_espera.PUSH("1", 100, 1, 5);
        lista_espera.PUSH("2", 50, 2, 10);
        lista_espera.PUSH("3", 1, 3, 4);
        lista_espera.PUSH("4", 3, 4, 7);
        lista_espera.PUSH("5", 10, 5, 3);
        lista_espera.PUSH("6", 1, 6, 5);
        
        
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
                /*case 2:
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
                    break;*/
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
        }while(option != 7);
        ordenarTiempos();
    
    }

    public static void ordenarTiempos2(){
        int menorIndex = 0;
        int vuelta = 0;
        
        while(vuelta < 3){
            for (int i = vuelta; i < vuelta-3; i++) {
                if(tiempos[i] < tiempos[menorIndex] && tiempos[i] != 0){
                    menorIndex = i;
                }
            }
            intercambio(vuelta, menorIndex);
            vuelta++;
        }
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
