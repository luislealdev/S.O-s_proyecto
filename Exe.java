
package exe;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Exe {

    public static void main(String[] args) {
       
        Lista newList = new Lista();
        newList.PUSH("Alfredo", 100, 10, 15);
        newList.PUSH("Chaires", 50, 20, 20);
        newList.PUSH("Oski", 1, 30, 15);
        newList.PUSH("Leal", 3, 30, 10);
        newList.PUSH("Mario", 10, 30, 45);
        
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
                    newList.mostrarDatosX();
                    break;
                case 3:
                    System.out.println("<----- Procesos ordenados por tiempo ----->");
                    newList.ordenarXtiempo();
                    newList.mostrarDatosX();
                    break;
                case 4:
                    System.out.println("<----- Procesos ordenados por número ----->");
                    newList.ordenarXnumero();
                    newList.mostrarDatosX();
                    break;
                case 5:
                    System.out.println("<----- Procesos registrados ----->\n");
                    newList.mostrarDatosX();
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
