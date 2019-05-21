package model;

public class Novela {
	private String titulo;
	private int horario, capitulos;
	
	public Novela(String titulo, int horario, int capitulos) {
		this.titulo = titulo;
		this.horario = horario;
		this.capitulos = capitulos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getHorario() {
		return horario;
	}

	public void setHorario(int horario) {
		this.horario = horario;
	}

	public int getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(int capitulos) {
		this.capitulos = capitulos;
	}
	
	
}
