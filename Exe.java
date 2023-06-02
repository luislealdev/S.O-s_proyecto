package exe;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Exe {
    static int tiempos[] = { 15, 8, 12 };

    public static void main(String[] args) {
        Lista_Procesos lista_espera = new Lista_Procesos();
        lista_espera.PUSH("1", 7, 1, 5);
        lista_espera.PUSH("2", 8, 2, 9);
        lista_espera.PUSH("3", 1, 3, 4);
        lista_espera.PUSH("4", 3, 4, 7);
        lista_espera.PUSH("5", 8, 5, 3);
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
                + "6.- Eliminar proceso por número\n"
                + "7.- Guardar en un archivo \n"
                + "8.- Salir del menú\n";
        int option;

        do {
            option = Integer.parseInt(JOptionPane.showInputDialog(null, menuFormat));
            switch (option) {
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
                    // lista_espera.elimnarXnombre(toDelete);
                    break;
                case 7:
                    guardarProcesosEnArchivo(lista_espera);
                    break;
                default:
                    System.out.println("\nLa opción seleccionada no es válida");
                    break;
            }
        } while (option != 8);
        ordenarTiempos();
    }

    public static void ordenarTiempos2() {
        int menorIndex = 0;
        int vuelta = 0;

        while (vuelta < 3) {
            for (int i = vuelta; i < vuelta - 3; i++) {
                if (tiempos[i] < tiempos[menorIndex] && tiempos[i] != 0) {
                    menorIndex = i;
                }
            }
            intercambio(vuelta, menorIndex);
            vuelta++;
        }
    }

    // Método burbuja porque tengo entendido que gasta menos recursos que los demás
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

    public static void guardarProcesosEnArchivo(Lista_Procesos lista) {
        Proceso aux = lista.start;
        try {
            FileWriter escritor = new FileWriter("procesos.txt", true);
            escritor.write("-----------INICIO PROCESOS------------\n\n");

            // Guardar orden inicial
            escritor.write("-----------Órden inicial------------\n");
            // Lista_Procesos aux = lista;
            escritor.write(
                    String.format("%-8s %-8s %-8s %-8s %-22s %-22s %-22s%n", "Nombre", "Número", "Tamaño",
                            "Tiempo", "Tiempo de llegada",
                            "Tiempo de salida", "Tiempo en ejecución"));
            while (aux.next != null) {
                escritor.write(String.format("%-8s %-8s %-8s %-8s %-22s %-22s %-22s%n", aux.nombre,
                        aux.numero, aux.tamaño,
                        aux.tiempo, aux.tiempoEnEjecucion, aux.tiempoLlegada,
                        aux.tiempoSalida));
                aux = aux.next;
            }

            // Guardar orden por número
            escritor.write("-----------Órden por número------------\n");
            lista.ordenarXnumero();
            aux = lista.start;
            escritor.write(
                    String.format("%-8s %-8s %-8s %-8s %-22s %-22s %-22s%n", "Nombre", "Número", "Tamaño",
                            "Tiempo", "Tiempo de llegada",
                            "Tiempo de salida", "Tiempo en ejecución"));
            while (aux.next != null) {
                escritor.write(String.format("%-8s %-8s %-8s %-8s %-22s %-22s %-22s%n", aux.nombre,
                        aux.numero, aux.tamaño,
                        aux.tiempo, aux.tiempoEnEjecucion, aux.tiempoLlegada,
                        aux.tiempoSalida));
                aux = aux.next;
            }

            // Guardar en orden por tamaño
            lista.ordenarXtamaño();
            escritor.write("-----------Órden por tamaño------------\n");
            aux = lista.start;
            escritor.write(
                    String.format("%-8s %-8s %-8s %-8s %-22s %-22s %-22s%n", "Nombre", "Número", "Tamaño",
                            "Tiempo", "Tiempo de llegada",
                            "Tiempo de salida", "Tiempo en ejecución"));
            while (aux.next != null) {
                escritor.write(String.format("%-8s %-8s %-8s %-8s %-22s %-22s %-22s%n", aux.nombre,
                        aux.numero, aux.tamaño,
                        aux.tiempo, aux.tiempoEnEjecucion, aux.tiempoLlegada,
                        aux.tiempoSalida));
                aux = aux.next;
            }

            // Guardar en orden por tiempo
            lista.ordenarXtiempo();
            escritor.write("-----------Órden por tiempo------------\n");
            aux = lista.start;
            escritor.write(
                    String.format("%-8s %-8s %-8s %-8s %-22s %-22s %-22s%n", "Nombre", "Número", "Tamaño",
                            "Tiempo", "Tiempo de llegada",
                            "Tiempo de salida", "Tiempo en ejecución"));
            while (aux.next != null) {
                escritor.write(String.format("%-8s %-8s %-8s %-8s %-22s %-22s %-22s%n", aux.nombre,
                        aux.numero, aux.tamaño,
                        aux.tiempo, aux.tiempoEnEjecucion, aux.tiempoLlegada,
                        aux.tiempoSalida));
                aux = aux.next;
            }

            // Guardar texto para dividir
            escritor.write("\n-----------FIN PROCESOS------------\n\n");
            escritor.close();
            System.out.println("Se ha escrito en el archivo correctamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        }
    }

}
