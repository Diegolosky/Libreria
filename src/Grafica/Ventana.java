package Grafica;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Logica.Libro;

public class Ventana extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel mantel;
	private JTextField textFieldAutor;
	private JButton btnGuardar;
	private JTextField textFieldFecha;
	private JTextField textFieldTitulo;
	private JLabel lblValoracion;
	private JComboBox comboBoxValoracion;
	private JLabel lblTipo;
	private JComboBox comboBoxTipo;

	public Ventana() {
		setTitle("Libreria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 230);
		mantel = new JPanel();
		mantel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mantel);
		mantel.setLayout(null);
		crearLabels();
		crearTextFields();
		crearBotones();
		crearComboBox();

		Libro datosInicio = Persistencia.Persistencia.cargarDatos();
		comboBoxTipo.setSelectedItem(datosInicio.getTipo());
		textFieldTitulo.setText(datosInicio.getTitulo());
		textFieldAutor.setText(datosInicio.getAutor());
		textFieldFecha.setText(String.valueOf(datosInicio.getFecha()));
		comboBoxValoracion.setSelectedItem(datosInicio.getValoracion());

	}

	private void crearLabels() {

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipo.setBounds(54, 21, 70, 12);
		mantel.add(lblTipo);

		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitulo.setBounds(54, 44, 70, 12);
		mantel.add(lblTitulo);

		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAutor.setBounds(54, 71, 70, 12);
		mantel.add(lblAutor);

		JLabel lblFecha = new JLabel("Fecha (año)");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(28, 84, 96, 12);
		mantel.add(lblFecha);

		JLabel lblValoracion = new JLabel("Valoracion");
		lblValoracion.setHorizontalAlignment(SwingConstants.CENTER);
		lblValoracion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValoracion.setBounds(54, 130, 70, 12);
		mantel.add(lblValoracion);
	}

	private void crearTextFields() {

		textFieldTitulo = new JTextField();
		textFieldTitulo.setText((String) null);
		textFieldTitulo.setColumns(10);
		textFieldTitulo.setBounds(134, 43, 96, 18);
		mantel.add(textFieldTitulo);

		textFieldAutor = new JTextField();
		textFieldAutor.setBounds(134, 70, 96, 18);
		mantel.add(textFieldAutor);
		textFieldAutor.setColumns(10);

		textFieldFecha = new JTextField();
		textFieldFecha.setText("");
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(134, 97, 96, 18);
		mantel.add(textFieldFecha);
	}

	private void crearBotones() {
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(134, 151, 96, 18);
		mantel.add(btnGuardar);
		btnGuardar.addActionListener(this);

	}

	private void crearComboBox() {

		comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] { "Libro", "Revista", "Comic" }));
		comboBoxTipo.setBounds(134, 18, 96, 20);
		mantel.add(comboBoxTipo);

		comboBoxValoracion = new JComboBox();
		comboBoxValoracion.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
		comboBoxValoracion.setBounds(144, 125, 46, 20);
		mantel.add(comboBoxValoracion);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			System.out.println("Botón Guardar clikeado");

			String tipo = (String) comboBoxTipo.getSelectedItem();
			String titulo = textFieldTitulo.getText();
			String autor = textFieldAutor.getText();
			String fechaTexto = textFieldFecha.getText();
			String valoracion = (String) comboBoxValoracion.getSelectedItem();

			if (tipo == null || titulo.trim().isEmpty() || autor.trim().isEmpty() || fechaTexto.trim().isEmpty()
					|| valoracion == null) {
				System.out.println("Por favor, complete todos los campos.");
			} else {
				try {
					int fecha = Integer.parseInt(fechaTexto.trim());
					Libro x = new Libro(tipo, titulo, autor, fecha, valoracion);
					Persistencia.Persistencia.guardarDatos(x);
					System.out.println("Datos guardados correctamente.");
				} catch (NumberFormatException ex) {
					System.out.println("El año debe ser un número entero válido.");
				}
			}
		}
	}
}
