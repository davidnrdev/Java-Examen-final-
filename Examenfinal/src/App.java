/*
EXAMEN FINAL JAVA CURSO DE PROGRAMACION
Autor: David Narvaez
Fecha: 08/07/2026
Una academia de videojuegos necesita un programa para registrar personajes. Todos comparten un
identificador, un nombre y un nivel, pero cada tipo realiza una acción diferente. El sistema debe guardar los
objetos en una sola colección, mostrarlos y buscar uno por su identificador.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Personaje> personajes = new ArrayList<>();
        int opcion = 0;

        do {
            try {
                System.out.println("\n=== MENÚ DE GESTIÓN DE PERSONAJES ===");
                System.out.println("1. Registrar personaje");
                System.out.println("2. Mostrar personajes");
                System.out.println("3. Buscar personaje por id");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        registrarPersonaje(sc, personajes);
                        break;
                    case 2:
                        mostrarPersonajes(personajes);
                        break;
                    case 3:
                        buscarPersonaje(sc, personajes);
                        break;
                    case 4:
                        System.out.println("Saliendo del sistema");
                        break;
                    default:
                        System.out.println("[!] Opción inválida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("[!] Error: Debe ingresar un valor numérico válido.");
                sc.nextLine(); // Limpiar buffer de entrada
                opcion = 0;
            }
        } while (opcion != 4);

        sc.close();
    }

    public static void registrarPersonaje(Scanner sc, ArrayList<Personaje> personajes) {
        System.out.println("\n--- REGISTRO DE PERSONAJE ---");
        System.out.print("Seleccione el tipo (1 = Guerrero, 2 = Mago): ");
        int tipo = sc.nextInt();

        if (tipo != 1 && tipo != 2) {
            System.out.println("[!] Tipo de personaje inválido. Registro cancelado.");
            return;
        }

        System.out.print("Ingrese ID (debe ser mayor a 0): ");
        int id = sc.nextInt();
        if (id <= 0) {
            System.out.println("[!] Error: El ID debe ser mayor a 0.");
            return;
        }

        System.out.print("Ingrese Nombre (sin espacios): ");
        String nombre = sc.next();
        if (nombre.trim().isEmpty()) {
            System.out.println("[!] Error: El nombre no puede estar vacío.");
            return;
        }

        System.out.print("Ingrese Nivel (1 a 100): ");
        int nivel = sc.nextInt();
        if (nivel < 1 || nivel > 100) {
            System.out.println("[!] Error: El nivel debe estar entre 1 y 100.");
            return;
        }

        if (tipo == 1) {
            personajes.add(new Guerrero(id, nombre, nivel));
            System.out.println("-> Guerrero registrado exitosamente.");
        } else {
            personajes.add(new Mago(id, nombre, nivel));
            System.out.println("-> Mago registrado exitosamente.");
        }
    }

    public static void mostrarPersonajes(ArrayList<Personaje> personajes) {
        if (personajes.isEmpty()) {
            System.out.println("\n[!] No hay personajes registrados en la lista.");
            return;
        }

        System.out.println("\n--- LISTA DE PERSONAJES ---");
        for (Personaje p : personajes) {
            p.mostrarInfo();
            System.out.println("   Acción: " + p.realizarAccion());
        }
    }

    public static void buscarPersonaje(Scanner sc, ArrayList<Personaje> personajes) {
        if (personajes.isEmpty()) {
            System.out.println("\n[!] No hay personajes registrados para buscar.");
            return;
        }

        System.out.print("\nIngrese el ID a buscar: ");
        int idBusqueda = sc.nextInt();
        boolean encontrado = false;

        for (Personaje p : personajes) {
            if (p.getId() == idBusqueda) {
                System.out.println("\n[+] Personaje Encontrado:");
                p.mostrarInfo();
                System.out.println("   Acción: " + p.realizarAccion());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Personaje no encontrado");
        }
    }
}