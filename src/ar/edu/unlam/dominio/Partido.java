package ar.edu.unlam.dominio;

public class Partido {

	private Equipo local;
	private Equipo rival;
	private Integer golesLocal;
	private Integer golesRival;
	
	public Partido(Equipo local, Equipo rival, Integer golesLocal, Integer golesRival) {
		this.local = local;
		this.rival = rival;
		this.golesLocal = golesLocal;
		this.golesRival = golesRival;
	}

	/**
	 * Obtiene el resultado del partido.
	 * 
	 * @resolver	Completar este metodo
	 * 
	 * @return Integer resultado del partido
	 * */
	public String obtenerResultado() {
		String resultado;
		if(golesLocal==golesRival) {
			resultado="Empate: " + this.local.getNombre() +" "+ golesLocal +" - "+ golesRival +" "+ rival.getNombre();
		}
		if(golesLocal>golesRival) {
			resultado="Gano: " + this.local.getNombre() +" "+ golesLocal + " - " + golesRival +" "+ rival.getNombre();
		}else {
			resultado="Gano: " + this.rival.getNombre() +" "+ golesRival + " - " + golesLocal +" "+ local.getNombre();
		}
		// TODO: Resolver: Se debera devolver un texto que indique el resultado del partido.
		// 		 Ejemplo de empate: "Empate: Catar 1 - 1 Ecuador "
		//       Ejemplo con ganador: "Gano Senegal 2 - 1 Paises Bajos" (el ganador primero)
		
		return resultado;
	}

	public Equipo getLocal() {
		return local;
	}

	public void setLocal(Equipo local) {
		this.local = local;
	}

	public Equipo getRival() {
		return rival;
	}

	public void setRival(Equipo rival) {
		this.rival = rival;
	}

	public Integer getGolesLocal() {
		return golesLocal;
	}

	public void setGolesLocal(Integer golesLocal) {
		this.golesLocal = golesLocal;
	}

	public Integer getGolesRival() {
		return golesRival;
	}

	public void setGolesRival(Integer golesRival) {
		this.golesRival = golesRival;
	}
}
