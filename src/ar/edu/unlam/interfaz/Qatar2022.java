package ar.edu.unlam.interfaz;

import java.util.Scanner;

import ar.edu.unlam.dominio.Equipo;
import ar.edu.unlam.dominio.Grupos;
import ar.edu.unlam.dominio.Partido;
import ar.edu.unlam.dominio.Torneo;

public class Qatar2022 {

	private static final int VER_EQUIPOS_EN_GRUPO = 1, JUGAR_PARTIDO = 2, MOSTRAR_GOLEADOR = 3,
			MOSTRAR_EQUIPOS_A_OCTAVOS = 4, SALIR = 9;

	/**
	 * Este producto software representa la gestion de los partidos, de la fase de grupos, del mundial Qatar 2022.
	 * Los equipos estan pre cargados basados en las selecciones del array "selecciones". Dicho array esta ordenado por los eqiupos que integran cada grupo. 
	 * El objetivo es resolver las funcionalidades incluidas en en menu principal.
	 * 
	 * IMPORTANTE: Donde se encuentre un "TODO: Resolver:" o "@resolver", debera completar con codigo para que el proyecto funcione segun lo requerido. 
	 * Hay algunos comentarios que sirven de guia.
	 * Prestar atencion a los metodos existentes. 
	 * 
	 */
	private static String[] selecciones = { "Catar", "Ecuador", "Senegal", "Paises Bajos", "Inglaterra", "Iran",
			"Estados Unidos", "Gales", "Argentina", "Arabia Saudita", "Mexico", "Polonia", "Francia", "Australia",
			"Dinamarca", "Tunez", "Espania", "Costa Rica", "Alemania", "Japon", "Belgica", "Canada", "Marruecos",
			"Croacia", "Brasil", "Serbia", "Suiza", "Camerun", "Portugal", "Ghana", "Uruguay", "Corea del Sur" };

	public static void main(String[] args) {
		mostrarMensaje("Bienvenido a la fase de grupos del mundial Qatar 2022");

		Scanner teclado = new Scanner(System.in);
		Equipo[] equipos = cargarEquipos();
		Torneo qatar = new Torneo("Qatar2022", equipos);

		int opcion = 0;
		Grupos grupo = null;
		Equipo[] equiposEnGrupo = null;

		do {
			mostrarMenu();
			opcion = teclado.nextInt();

			switch (opcion) {
			case VER_EQUIPOS_EN_GRUPO:
				grupo = ingresarGrupo(teclado);
				System.out.println("** EQUIPOS DEL GRUPO " + grupo + " **");
				mostrarEquipos(qatar.obtenerEquiposDelGrupo(grupo));
				
				// TODO: Resolver: Mostrar los equipos de un grupo ingresado por teclado. Prestar atencion a los metodos existentes.

				break;
			case JUGAR_PARTIDO:

				grupo = ingresarGrupo(teclado);

				// Seleccionar equipo local
				Equipo local = ingresarEquipo(qatar.obtenerEquiposDelGrupo(grupo), teclado);

				Equipo rival = null;
				do {
					rival=ingresarEquipo(qatar.obtenerEquiposDelGrupo(grupo), teclado);
				}while(rival==local);
				
				// TODO: Resolver: el equipo rival no puede ser el mismo equipo que el equipo local

				// Seleccionar equipo rival

				Partido partido = null;

				boolean jugaron = qatar.yaJugaron(local, rival);

				// Solo si no jugaron antes, pueden jugar
				if (!jugaron) {
					partido=qatar.jugarPartido(local, rival);
					qatar.actualizarGolesAEquipos(partido);
					System.out.println(partido.obtenerResultado()); 
					// TODO: Resolver: Jugar el partido, actualizar los goles a cada equipo y mostrar el resultado del partido
					
				} else {
					mostrarMensaje("Ooops, estos equipos ya jugaron!");
				}

				break;
			case MOSTRAR_GOLEADOR:
				Equipo goleador=qatar.obtenerEquipoQueMasGoleadorDeLaFaseDeGrupos();
				if(goleador!=null) {
					System.out.println("el equipo mas goleador de la fase de grupos es: " + goleador.toString());
				}else {
					System.out.println("aun no se ah jugado ningun partido");
				}
				// TODO: Resolver: Obtener el equipo goleador de la fase de grupos y mostrarlo.
				
				break;
			case MOSTRAR_EQUIPOS_A_OCTAVOS:
				Equipo[]octavos=qatar.obtenerEquiposQuePasanAOctavos();
				
				if(octavos!=null) {
					System.out.println("** EQUIPOS QUE PASAN A OCTAVOS **");
					mostrarEquipos(octavos);
				}else {
					System.out.println("aun no termino la fase de grupos");
				}
				// TODO: Resolver: Obtener los equipos que pasan a octavos y mostrarlos.

				break;
			case SALIR:
				mostrarMensaje("Hasta luego!");
				break;
			}

		} while (opcion != SALIR);

	}

	/**
	 * muestra los equipos pertenecientes a un grupo para ser elegido.
	 * @param equiposDelGrupo	Equipos que conforman el grupo
	 * @param teclado	Scanner para interactuar
	 * 
	 * @resolver	Completar este metodo
	 * 
	 * @return Equipo	
	 * */
	private static Equipo ingresarEquipo(Equipo[] equiposDelGrupo, Scanner teclado) {
		int op;
		do {
			mostrarEquipos(equiposDelGrupo);
			op=teclado.nextInt();
		}while(op<1 || op>4);
		
		Equipo equipo=equiposDelGrupo[op-1];
		
		// TODO: Resolver: solo permitir que se ingrese un equipo del grupo (solo hay 4 equipos en un grupo).
		
		return equipo;
	}

	/**
	 * Ingresa el grupo por teclado
	 * @param teclado	Scanner para interactuar
	 * 
	 * @resolver	Completar este metodo
	 * 
	 * @return Grupos	Elemento del enum Grupos
	 * 
	 * */
	private static Grupos ingresarGrupo(Scanner teclado) {
		int op;
		do {
		System.out.println("ingrese el grupo"
				+ "\n 1 -A "
				+ "\n 2 -B"
				+ "\n 3 -C"
				+ "\n 4 -D"
				+ "\n 5 -E"
				+ "\n 6 -F"
				+ "\n 7 -G"
				+ "\n 8 -H");
		op=teclado.nextInt();
		}while(op<1 || op>8);
		
		// Cada grupo esta representado por una letra
		return Grupos.values()[op-1];
	}

	private static void mostrarEquipos(Equipo[] equiposEnGrupo) {
		int num=1;
		for (int i = 0; i < equiposEnGrupo.length; i++) {
			if (equiposEnGrupo[i] != null) {
				mostrarMensaje(num+" - "+equiposEnGrupo[i].toString());
				num++;
			}
		}
	}

	private static void mostrarMenu() {
		mostrarMensaje("\n\nMenu principal");
		mostrarMensaje("\n1 - Ver los equipos de un grupo");
		mostrarMensaje("\n2 - Para jugar un partido de un grupo");
		mostrarMensaje("\n3 - Mostrar equipo mas goleador");
		mostrarMensaje("\n4 - Mostrar equipos que pasan a octavos");
		mostrarMensaje("\n\n9 - Salir");
	}

	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}

	private static Equipo crearEquipo(String nombre, Grupos grupo) {
		return new Equipo(nombre, grupo);
	}

	private static Equipo[] cargarEquipos() {
		Equipo[] equipos = new Equipo[32];

		// Variable que se usa para obtener el grupo por indice en enum
		int grupo = 0;

		for (int i = 0; i < equipos.length; i++) {

			equipos[i] = crearEquipo(selecciones[i], Grupos.values()[grupo]);

			// Cada 4 posiciones, cambio de grupo
			if (i != 0 && ((i + 1) % 4 == 0)) {
				grupo++;
			}
		}

		return equipos;
	}

}
