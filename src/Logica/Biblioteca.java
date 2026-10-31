package Logica;

import java.util.ArrayList;

public class Biblioteca extends Libro {

	private ArrayList<Libro> libros;

	public Biblioteca(String tipo, String titulo, String autor, int fecha, String valoracion) {
		super(tipo, titulo, autor, fecha, valoracion);
		this.libros = new ArrayList<Libro>();

	}
}
