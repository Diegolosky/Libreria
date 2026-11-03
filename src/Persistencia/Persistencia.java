package Persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import Logica.Libro;

public class Persistencia {

	public static void guardarDatos(ArrayList<Libro> lista) {
		String ruta = System.getProperty("user.dir") + "\\archivo.bin";
		try {
			FileOutputStream flujoSalidaArchivo = new FileOutputStream(ruta);
			ObjectOutputStream flujoSalidaObjeto = new ObjectOutputStream(flujoSalidaArchivo);

			flujoSalidaObjeto.writeObject(lista);

			flujoSalidaObjeto.close();
			flujoSalidaArchivo.close();
		} catch (Exception e) {
			System.out.println("Error al guardar los datos: " + e.getMessage());
		}
	}

	public static ArrayList<Libro> cargarDatos() {
		String ruta = System.getProperty("user.dir") + "\\archivo.bin";
		File archivo = new File(ruta);

		if (!archivo.exists()) {
			return new ArrayList<Libro>();
		}

		try {
			FileInputStream flujoEntradaArchivo = new FileInputStream(ruta);
			ObjectInputStream flujoEntradaObjeto = new ObjectInputStream(flujoEntradaArchivo);

			ArrayList<Libro> listaCargada = (ArrayList<Libro>) flujoEntradaObjeto.readObject();

			flujoEntradaObjeto.close();
			flujoEntradaArchivo.close();

			return listaCargada;
		} catch (Exception e) {
			System.out.println("Error al cargar los datos: " + e.getMessage());
			return new ArrayList<Libro>();
		}
	}
}