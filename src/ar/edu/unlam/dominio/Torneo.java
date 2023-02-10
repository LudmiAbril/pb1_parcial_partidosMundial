package ar.edu.unlam.dominio;

import java.util.Random;

public class Torneo {

	private static final Integer CANTIDAD_PARTIDOS = 48, CANTIDAD_EQUIPOS_OCTAVOS = 16;

	private String nombre;
	private Equipo[] equipos;
	private Partido[] partidos;

	public Torneo(String nombre, Equipo[] equipos) {
		this.nombre = nombre;
		this.equipos = equipos;
		this.partidos = new Partido[CANTIDAD_PARTIDOS];
	}

	/**
	 * Simula un partido y lo guarda en el array de partidos
	 * 
	 * @param local Equipo local
	 * @param rival Equipo rival
	 * 
	 * @resolver	Completar este metodo
	 * 
	 * @return partido El partido que se agrego
	 */
	public Partido jugarPartido(Equipo local, Equipo rival) {
		int golesLocal=obtenerCantidadGoles();
		int golesRival=obtenerCantidadGoles();
		Partido partido=new Partido(local,rival,golesLocal,golesRival);
		// Se construira un partido que no se jugo antes
		
		for(int i=0;i<partidos.length;i++) {
			if(partidos[i]!=null) {
				partidos[i]=partido;
			}
		}
		
		// TODO: Resolver: generar los goles de cada equipo de manera aleatoria mediante el metodo "obtenerCantidadGoles()" 
		// 		 e instanciar un partido el cual debera ser agregado al array de partidos.

		return partido;
	}

	/**
	 * Obtiene un numero aleatorio entre 1 y 10 que representa la cantidad de goles convertidos por un equipo
	 * 
	 *  @resolver	Completar este metodo
	 *  
	 * */
	private int obtenerCantidadGoles() {
		int goles=(int)(Math.random()*(10-1+1)+1);
		return goles;
	}

	/**
	 * Agrega los goles a favor y los goles en contra a cada equipo segun el partido jugado
	 * 
	 * @param partido Partido jugado
	 */
	public void actualizarGolesAEquipos(Partido partido) {
		Equipo local = partido.getLocal();
		Equipo rival = partido.getRival();

		this.actualizarEquipo(local, partido.getGolesLocal(), partido.getGolesRival());
		this.actualizarEquipo(rival, partido.getGolesRival(), partido.getGolesLocal());
	}

	/**
	 * Actualiza los goles a favor y en contra de un equipo luego de un partido
	 * 
	 * @param equipo		Equipo
	 * @param golesAFavor	Goles convertidos
	 * @param golesEnContra	Goles recibidos
	 * 
	 * @resolver	Completar este metodo
	 * 
	 * @return true		en caso de actualizar correctamente
	 * */
	public boolean actualizarEquipo(Equipo equipo, Integer golesAFavor, Integer golesEnContra) {
		// TODO: Resolver: se deberan agregar los goles convertidos y los goles recibidos a los existentes, buscando el equipo por su nombre.
		for(int i=0;i<equipos.length;i++) {
			if(equipos[i]!=null && equipos[i].getNombre().equals(equipo.getNombre())) {
				equipo.setGolesAFavor(golesAFavor);
				equipo.setGolesEnContra(golesEnContra);
				return true;
			}
		}
		return false;
	}

	/**
	 * Verifica si los equipos ya jugaron un partido entre si.
	 * 
	 * @param local       Equipo local
	 * @param rival		  Equipo contra el que juega el equipo local
	 * 
	 * @resolver	Completar este metodo
	 * 
	 * @return true En caso de existir el partido
	 * 
	 */
	public boolean yaJugaron(Equipo local, Equipo rival) {
		// TODO: Resolver Es necesario validar si jugaron considerando que un partido pudo jugarse como alguno de los siguientes casos: 
		// 		 Caso 1: Catar vs Ecuador | Caso 2: Ecuador vs Catar.
		// 		 Si existe un partido que cumpla con alguno de esos casos, se considera que ya jugaron.
		
		for(int i=0;i<partidos.length;i++) {
			if((partidos[i]!=null && partidos[i].getLocal().equals(rival) && partidos[i].getRival().equals(local)) ||
			(partidos[i]!=null && partidos[i].getLocal().equals(local) && partidos[i].getRival().equals(rival))) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Obtiene los equipos de un grupo
	 * 
	 * @param grupo Grupo de equipos
	 * 
	 * @resolver	Completar este metodo
	 * 
	 * @return Equipo[]
	 */
	public Equipo[] obtenerEquiposDelGrupo(Grupos grupo) {
		Equipo[] equiposgrupo=new Equipo[4];
		int j=0;
		
		for(int i=0;i<equipos.length;i++) {
			if(equipos[i]!=null && equipos[i].getGrupo().equals(grupo)) {
				equiposgrupo[j]=equipos[i];
				j++;
			}
		}
		// TODO: Resolver: Devolver un array con los 4 equipos pertenecientes al grupo que llega como parametro  
		return equiposgrupo;
	}

	/**
	 * Obtiene el equipo que mas goles convirtio
	 * 
	 * @resolver	Completar este metodo
	 * 
	 * @return Equipo goleador
	 */
	public Equipo obtenerEquipoQueMasGoleadorDeLaFaseDeGrupos() {
		int goles=0;
		Equipo goleador=null;
		for(int i=0;i<equipos.length;i++) {
			if(equipos[i]!=null && equipos[i].getGolesAFavor()>goles) {
				goles=equipos[i].getGolesAFavor();
				goleador=equipos[i];
			}
		}
		// TODO: Resolver: Devolver el equipo que, sin importar su grupo, convirtio mas goles en la fase de grupos.
		
		return goleador;
	}

	/**
	 * Obtiene un array de equipos que contiene los dos equipos con mas puntos de cada grupo.
	 * 
	 * @resolver	Completar este metodo
	 * 
	 * @return array con equipos que pasan a octavos
	 * 
	 */
	public Equipo[] obtenerEquiposQuePasanAOctavos() {
		 Grupos[] grupos = Grupos.values();
		 Equipo grupo[];
		 Equipo octavos[]=new Equipo[16];
		 int o=0;
		 
	for(int i=0;i<grupos.length;i++) {
		grupo=obtenerEquiposDelGrupo(grupos[i]);
		for(int j=0;j<2;j++) {
			octavos[o]=grupo[j];
			o++;
		}
		
	}
		// TODO: Resolver: se debera devoler un array con los 16 equipos que pasaron a octavos de final.
		//		 Solo los 2 primeros de cada grupo deben estar el nuevo array.
		//		 Prestar atencion a los metodos!
		
		return octavos;
	}

	private Equipo[] ordenarPorPuntosDescendente(Equipo[] equipos) {
		Equipo aux = null;

		for (int i = 1; i < equipos.length; i++) {
			for (int j = 0; j < equipos.length - 1; j++) {

				if (equipos[j] != null && equipos[j + 1] != null
						&& equipos[j + 1].getPuntos() > equipos[j].getPuntos()) {
					aux = equipos[j + 1];
					equipos[j + 1] = equipos[j];
					equipos[j] = aux;
				}
			}
		}

		return equipos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Equipo[] getEquipos() {
		return equipos;
	}

	public void setEquipos(Equipo[] equipos) {
		this.equipos = equipos;
	}

	public Partido[] getPartidos() {
		return partidos;
	}

	public void setPartidos(Partido[] partidos) {
		this.partidos = partidos;
	}

}
