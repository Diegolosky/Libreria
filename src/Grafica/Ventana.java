package Grafica;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import Logica.Biblioteca;
import Logica.Libro;

public class Ventana extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel mantel;
	private JTextField textFieldAutor;
	private JButton btnGuardar;
	private JButton btnBorrar;
	private JTextField textFieldFecha;
	private JTextField textFieldTitulo;
	private JComboBox comboBoxValoracion;
	private JComboBox comboBoxTipo;
	private JTable tabla;
	private DefaultTableModel modelo;
	private Biblioteca miBiblioteca;

	public Ventana() {
		miBiblioteca = new Biblioteca();

		setTitle("Libreria");
		setIconImage(new ImageIcon(getClass().getResource("/Book.png")).getImage());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 450);
		mantel = new JPanel();
		mantel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mantel);
		mantel.setLayout(null);

		crearLabels();
		crearTextFields();
		crearComboBox();
		crearBotones();
		crearTabla();

		cargarTabla();
	}

	private void crearLabels() {
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipo.setBounds(35, 30, 70, 12);
		mantel.add(lblTipo);

		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitulo.setBounds(35, 60, 70, 12);
		mantel.add(lblTitulo);

		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAutor.setBounds(35, 90, 70, 12);
		mantel.add(lblAutor);

		JLabel lblFecha = new JLabel("Fecha (año)");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(35, 120, 80, 12);
		mantel.add(lblFecha);

		JLabel lblValoracion = new JLabel("Valoracion");
		lblValoracion.setHorizontalAlignment(SwingConstants.CENTER);
		lblValoracion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValoracion.setBounds(35, 150, 70, 12);
		mantel.add(lblValoracion);
	}

	private void crearTextFields() {
		textFieldTitulo = new JTextField();
		textFieldTitulo.setColumns(10);
		textFieldTitulo.setBounds(135, 60, 96, 18);
		mantel.add(textFieldTitulo);

		textFieldAutor = new JTextField();
		textFieldAutor.setBounds(135, 90, 96, 18);
		mantel.add(textFieldAutor);
		textFieldAutor.setColumns(10);

		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(135, 119, 96, 18);
		mantel.add(textFieldFecha);
	}

	private void crearComboBox() {
		comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] { "Libro", "Revista", "Comic", "Artículo" }));
		comboBoxTipo.setBounds(135, 28, 96, 20);
		mantel.add(comboBoxTipo);

		comboBoxValoracion = new JComboBox();
		comboBoxValoracion.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
		comboBoxValoracion.setBounds(135, 150, 46, 20);
		mantel.add(comboBoxValoracion);
	}

	private void crearBotones() {
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(35, 197, 96, 25);
		mantel.add(btnGuardar);
		btnGuardar.addActionListener(this);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(140, 197, 96, 25);
		mantel.add(btnBorrar);
		btnBorrar.addActionListener(this);
	}

	private void crearTabla() {
		modelo = new DefaultTableModel();
		modelo.addColumn("Tipo");
		modelo.addColumn("Titulo");
		modelo.addColumn("Autor");
		modelo.addColumn("Año");
		modelo.addColumn("Valoracion");

		tabla = new JTable(modelo);

		JScrollPane scrollPanel = new JScrollPane(tabla);
		scrollPanel.setBounds(260, 30, 580, 320);
		mantel.add(scrollPanel);
	}

	private void cargarTabla() {
		modelo.setRowCount(0);
		ArrayList<Libro> lista = miBiblioteca.getListaLibros();

		for (int i = 0; i < lista.size(); i++) {
			Libro x = lista.get(i);
			Object[] fila = new Object[5];
			fila[0] = x.getTipo();
			fila[1] = x.getTitulo();
			fila[2] = x.getAutor();
			fila[3] = x.getFecha();
			fila[4] = x.getValoracion();
			modelo.addRow(fila);
		}
	}

	private void limpiarCampos() {
		textFieldTitulo.setText("");
		textFieldAutor.setText("");
		textFieldFecha.setText("");
		comboBoxTipo.setSelectedIndex(0);
		comboBoxValoracion.setSelectedIndex(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnGuardar) {
			String tipo = (String) comboBoxTipo.getSelectedItem();
			String titulo = textFieldTitulo.getText();
			String autor = textFieldAutor.getText();
			String fechaTexto = textFieldFecha.getText();
			String valoracion = (String) comboBoxValoracion.getSelectedItem();

			if (titulo.equals("") || autor.equals("") || fechaTexto.equals("")) {
				System.out.println("Por favor, complete todos los campos.");
			} else {
				try {
					int fecha = Integer.parseInt(fechaTexto);

					if (fecha > 2026) {
						System.out.println("El año no puede ser mayor al año actual (2026).");
					} else {
						Libro nuevo = new Libro(tipo, titulo, autor, fecha, valoracion);
						miBiblioteca.agregarLibro(nuevo);
						cargarTabla();
						limpiarCampos();
						System.out.println("Datos guardados correctamente.");
					}
				} catch (NumberFormatException ex) {
					System.out.println("La fecha (año) debe ser un número válido.");
				}
			}
		}

		if (e.getSource() == btnBorrar) {
			int filaSeleccionada = tabla.getSelectedRow();

			if (filaSeleccionada != -1) {
				miBiblioteca.eliminarLibro(filaSeleccionada);
				cargarTabla();
				System.out.println("Libro eliminado correctamente.");
			} else {
				System.out.println("Debe hacer clic en una fila de la tabla para seleccionar el libro a borrar.");
			}
		}
	}
}
