package Persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import Logica.Libro;


public class Persistencia {

	public static void guardarDatos(Libro x) {

		String ruta = System.getProperty("user.dir") + "\\archivo.bin";
		try {
			FileOutputStream flujoSalidaArchivo = new FileOutputStream(ruta);
			ObjectOutputStream flujoSalidaObjeto = new ObjectOutputStream(flujoSalidaArchivo);
			flujoSalidaObjeto.writeObject(x);
			flujoSalidaArchivo.close();
			flujoSalidaObjeto.close();
		} catch (IOException | SecurityException e) {
			e.printStackTrace();
		}
	}

	public static Libro cargarDatos() {

		String ruta = System.getProperty("user.dir") + "\\archivo.bin";
		try {
			FileInputStream flujoEntradaArchivo = new FileInputStream(ruta);
			ObjectInputStream flujoEntradaObjeto = new ObjectInputStream(flujoEntradaArchivo);
			Libro nuevo = (Libro) flujoEntradaObjeto.readObject();
			flujoEntradaArchivo.close();
			flujoEntradaObjeto.close();
			return nuevo;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return new Libro("", "", 0, "");
		}

	}

}
