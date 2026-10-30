package Logica;

import java.io.Serializable;

public class Libro implements Serializable {

	private static final long serialVersionUID = 1L;

	private String titulo;
	private String autor;
	private int fecha;
	private String valoracion;

	public Libro(String titulo, String autor, int fecha, String valoracion) {
		this.titulo = titulo;
		this.autor = autor;
		this.fecha = fecha;
		this.valoracion = valoracion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getFecha() {
		return fecha;
	}

	public void setFecha(int fecha) {
		this.fecha = fecha;
	}
	public String getValoracion() {		return valoracion;	}	public void setValoracion(String valoracion) {		this.valoracion = valoracion;	}}