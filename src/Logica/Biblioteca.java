package Logica;

import java.util.ArrayList;
import Persistencia.Persistencia;

public class Biblioteca {

	private ArrayList<Libro> listaLibros;

	public Biblioteca() {
		listaLibros = Persistencia.cargarDatos();
	}

	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}

	public void agregarLibro(Libro l) {
		listaLibros.add(l);
		Persistencia.guardarDatos(listaLibros);
	}

	public void eliminarLibro(int posicion) {
		if (posicion >= 0 && posicion < listaLibros.size()) {
			listaLibros.remove(posicion);
			Persistencia.guardarDatos(listaLibros);
		}
	}
}