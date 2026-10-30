package Logica;

import Grafica.Ventana;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ventana ventana = new Ventana();
		ventana.setVisible(true);

	}

}

/*
 * Se requerirá hacer un programa que permita agregar, visualizar, actualizar y
 * borrar información relacionada. Usando la interfaz gráfica de java swing. La
 * información a guardar será sobre libros y/o documentos de texto de otros
 * tipos, por ejemplo, artículos científicos, publicaciones, etc. (no se deberá
 * guardar el contenido en sí, sino información del mismo, por ej: nombre, fecha
 * de lanzamiento, autor, valoración, etc). Se requerirá la implementación de
 * algún tipo de persistencia para la información para cuando se cierre el
 * programa (en clase trabajaremos con archivos serializados, en caso de usar
 * una base de datos SQL, deberán saber el funcionamiento de las consultas y
 * encargarse de mandar también el código para crear la base de datos y tablas)
 * 
 * Se valorará la existencia de filtrados entre los diferentes tipos, o
 * búsquedas en base a los nombres (u otro criterio) de los contenidos, cómo
 * también prolijidad en la interfaz gráfica. También se valorará que el
 * programa funcione en situaciones excepcionales. Un requerimiento importante
 * para el programa será que sea una versión de prueba, es decir, que solo se
 * pueda usar por 30 minutos en total, luego que no funcione más, solamente
 * quedando habilitada la función para visualizar la información guardada
 * previamente. La legibilidad y orden del código será importante para una buena
 * defensa, si bien podrá tener comentarios, de haberlos, se asumirá que es de
 * algo que no dominan. Es decir, el exceso de comentarios podrá influir en la
 * calificación.
 */