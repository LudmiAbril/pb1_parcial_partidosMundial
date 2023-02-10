package ar.edu.unlam.dominio;

public class Equipo {
	
	private String nombre;
	private Grupos grupo;
	private Integer puntos;
	private Integer golesAFavor;
	private Integer golesEnContra;
	
	public Equipo(String nombre, Grupos grupo) {
		this.nombre = nombre;
		this.grupo = grupo;
		this.puntos = 0;
		this.golesAFavor = 0;
		this.golesEnContra = 0;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Grupos getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupos grupo) {
		this.grupo = grupo;
	}

	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}
	
	public Integer getGolesAFavor() {
		return golesAFavor;
	}

	public void setGolesAFavor(Integer golesAFavor) {
		this.golesAFavor = golesAFavor;
	}

	public Integer getGolesEnContra() {
		return golesEnContra;
	}

	public void setGolesEnContra(Integer golesEnContra) {
		this.golesEnContra = golesEnContra;
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", grupo=" + grupo + ", puntos=" + puntos + ", golesAFavor=" + golesAFavor
				+ ", golesEnContra=" + golesEnContra + "]";
	}
	
}
