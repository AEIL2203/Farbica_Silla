package Inicio;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import static java.lang.System.exit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Inicio {
	public static void main(String[] args) {
		int Op;

		Scanner Entrada = new Scanner(System.in);
		// Menu principal
		System.out.println("Bienvenido que eres???");
		System.out.println("1) Usuario");
		System.out.println("2) Administrador ");
		System.out.println("3) Salir");

		Op = Entrada.nextInt();

		switch (Op) {

		case 1:
			// Mostrar opciones de usuario
			Usuario();
			break;
		case 2:
			// Mostrar opciones de Administrador
			Admin();
			break;
		case 3:
			// Salir del programa
			exit(0);
			break;

		}
	}

	private static void Usuario() {
		String archivoEntrada = "Materiales.txt";
		Random rand = new Random();
		Scanner Entrada = new Scanner(System.in);
		String Nom;
		int Mad, Cla, Gom, Sil, i = 0, Mad2, Cla2, Gom2, Rand, Rand2, Rand3, Rand4, Total;
		// Datos de uso de materiales
		Mad = 15;
		Cla = 18;
		Gom = 5;
		// Menu de usuario
		System.out.println("Ingrese su Nombre");
		Nom = Entrada.nextLine();
		System.out.println("Bienvenido " + Nom + " a la fábrica de sillas");
		System.out.println("Cuantas sillas va a comprar??");
		Sil = Entrada.nextInt();
		// Ciclo de repeticion para que ensamble las sillas
		while (i < Sil) {
			//
			int maderaActual = 0, clavosActual = 0, gomaActual = 0;

			// Uso de archivo txt para sacar los datos
			try {
				FileReader archivoReader = new FileReader(archivoEntrada);
				BufferedReader bufferedReader = new BufferedReader(archivoReader);

				String linea;
				while ((linea = bufferedReader.readLine()) != null) {
					String[] partes = linea.split(", ");
					if (partes.length == 2) {
						String tipo = partes[0].trim();
						int cantidad = Integer.parseInt(partes[1].trim());
						if (tipo.equals("Madera")) {
							maderaActual = cantidad;
						} else if (tipo.equals("Clavos")) {
							clavosActual = cantidad;
						} else if (tipo.equals("Goma")) {
							gomaActual = cantidad;
						}
					}
				}
				bufferedReader.close();
			} catch (IOException e) {
				System.err.println("Error al leer el archivo: " + e.getMessage());
			}
			// Verificador de si tiene suficientes materiales para ensamblar la silla
			if (Mad <= maderaActual && Cla <= clavosActual && Gom <= gomaActual) {
				// resta de materiales del archivo de txt
				maderaActual -= Mad;
				clavosActual -= Cla;
				gomaActual -= Gom;
				// Ingreso de los resultados en el archivo txt
				try {
					FileWriter archivoWriter = new FileWriter(archivoEntrada, false);
					archivoWriter.write("Madera, " + maderaActual + "\n");
					archivoWriter.write("Clavos, " + clavosActual + "\n");
					archivoWriter.write("Goma, " + gomaActual + "\n");
					archivoWriter.close();
					System.out.println("Compra realizada correctamente");
				} catch (IOException e) {
					System.out.println("Ha ocurrido un error al guardar los datos en 'Materiales.txt'");
					e.printStackTrace();
				}
			} else {
				System.out.println("No hay suficientes materiales para hacer la silla.");
			}

			i++;
		}
		// Contadores de materiales
		Mad2 = Sil * Mad;
		Cla2 = Sil * Cla;
		Gom2 = Sil * Gom;
		Total = Sil * 100;
		Rand = rand.nextInt(10);
		Rand2 = rand.nextInt(10);
		Rand3 = rand.nextInt(10);
		Rand4 = rand.nextInt(10);

		System.out.println("------FACTURA No." + 0 + Rand + Rand2 + Rand3 + Rand4 + "------");
		System.out.println(" ");
		System.out.println("------" + Nom + "------");
		System.out.println("------Materiales usados------");
		System.out.println("Tipo------Cantidad------Precio  ");
		System.out.println("Madera:      " + Mad2 + "         Q50.00");
		System.out.println("Clavos:      " + Cla2 + "         Q25.00");
		System.out.println("Goma:        " + Gom2 + "         Q25.00");
		System.out.println("Total-------------------Q" + Total+".00");

		File archivo = new File("Factura.txt");
		 if (!archivo.exists()) {
	            try {
	                archivo.createNewFile();
	                FileWriter archivoWriter = new FileWriter(archivo, true);
	                archivoWriter.write("------FACTURA No." + (Rand + Rand2 + Rand3 + Rand4) + "------\n");
	                archivoWriter.write("Cliente: " + Nom + "\n");
	                archivoWriter.write("------Materiales usados------\n");
	                archivoWriter.write("Tipo      Cantidad  Precio\n");
	                archivoWriter.write("Madera:   " + Mad2 + "        Q50.00\n");
	                archivoWriter.write("Clavos:   " + Cla2 + "        Q25.00\n");
	                archivoWriter.write("Goma:     " + Gom2 + "        Q25.00\n");
	                archivoWriter.write("Total                    Q" + Total + ".00\n");

	                archivoWriter.close(); 

	                System.out.println("Se ha creado el archivo 'Factura.txt'");
	            } catch (IOException e) {
	                System.out.println("Ha ocurrido un error al crear el archivo 'Factura.txt'");
	                e.printStackTrace();
	                return;
	            }
	        } else {
	            System.out.println("El archivo 'Factura.txt' ya existe.");
	        }
		}

	

	private static void Admin() {
		String Usua;
		int Contra, i = 0;
		Scanner Entrada2 = new Scanner(System.in);

		System.out.println("Bienvenido Admin");

		while (i == 0) {

			System.out.println("Ingrese el Usuario");
			Usua = Entrada2.next();
			System.out.println("Ingrese el Contrasena");
			Contra = Entrada2.nextInt();

			if (Usua.equals("Admin234") && Contra == 102003) {
				System.out.println("Bienvenido Admin");
				i = i + 1;
				Admin234();

			} else if (Usua.equals("Admin234") && Contra != 102003) {
				System.out.println("Contrasena Incorrecta");
				limpiarConsola();

			} else if (!Usua.equals("Admin234") && Contra == 102003) {
				System.out.println("Usuario Incorecto");
				limpiarConsola();

			}
		}
	}

	public static void limpiarConsola() {
		for (int i = 0; i < 20; i++) {
			System.out.println();
		}
	}

	public static void Admin234() {
		File archivo = new File("Materiales.txt");
		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
				System.out.println("Se ha creado el archivo 'Materiales.txt'");
			} catch (IOException e) {
				System.out.println("Ha ocurrido un error al crear el archivo 'Materiales.txt'");
				e.printStackTrace();
				return;
			}
		}

		int Op2, Mad, Cla, Gom;
		String TxT;
		Scanner Entrada = new Scanner(System.in);

		System.out.println("Que desea hacer?");
		System.out.println("1) Ver cantidad de materiales");
		System.out.println("2) Comprar materiales");
		System.out.println("3) Salir");

		Op2 = Entrada.nextInt();

		switch (Op2) {
		case 1:
			TxT = "Materiales.txt";
			Ver_Material.Ver_Mat(TxT);
			break;

		case 2:
			System.out.println("Cuantas tablas de madera desea comprar?");
			Mad = Entrada.nextInt();

			System.out.println("Cuantos clavos desea comprar?");
			Cla = Entrada.nextInt();

			System.out.println("Cuantos litros de goma desea comprar?");
			Gom = Entrada.nextInt();

			try {
				FileWriter archivoWriter = new FileWriter(archivo, true);
				archivoWriter.write("Madera, " + Mad);
				archivoWriter.write("Clavos, " + Cla);
				archivoWriter.write("Goma, " + Gom);
				archivoWriter.close();
				System.out.println("Se han guardado los datos correctamente en 'Materiales.txt'");
			} catch (IOException e) {
				System.out.println("Ha ocurrido un error al guardar los datos en 'Materiales.txt'");
				e.printStackTrace();
			}
			break;
		case 3:
			System.out.println("Saliendo del programa.");
			System.exit(0);
			break;
		default:
			System.out.println("Opción no válida.");
		}

	}
}
