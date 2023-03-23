
package exe;

import javax.swing.JOptionPane;

public class Exe {

    public static void main(String[] args) {
        Lista2 newList = new Lista2();
        newList.PUSH("Alfredo", 0, 10, 15);
        newList.PUSH("Chaires", 0, 20, 20);
        newList.PUSH("Leal", 0, 30, 45);
        
        //Lista newList = new Lista();
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
                    newList.PUSH(nombre, numero, tamaño, tiempo); 
                    break;
                case 2:
                    System.out.println("<----- Procesos ordenados por tamaño ----->");
                    newList.ordenarXtamaño();
                    //newList.mostrarDatos();
                    break;
                case 3:
                    System.out.println("<----- Procesos ordenados por tiempo ----->");
                    newList.ordenarXtiempo();
                    //newList.mostrarDatos();
                    break;
                case 4:
                    System.out.println("<----- Procesos ordenados por número ----->");
                    newList.ordenarXnumero();
                    //newList.mostrarDatos();
                    break;
                case 5:
                    System.out.println("<----- Procesos registrados ----->\n");
                    newList.mostrarDatos();
                    break;
                case 6:
                    toDelete = JOptionPane.showInputDialog("Nombre del proceso a eliminar: ");
                    //newList.elimnarXnombre(toDelete);
                    break;
                default:
                    System.out.println("\nLa opción seleccionada no es válida");
                    break;
            }
        }while(option != 7);
        
    }
    
}
