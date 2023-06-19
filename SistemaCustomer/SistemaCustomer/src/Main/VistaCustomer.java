package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaCustomer {

	private JFrame frame;
	private JTextField txtId;
	private JTextField txtDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCustomer window = new VistaCustomer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaCustomer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtId = new JTextField();
		txtId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtId.getText().length() >= 10) {
					e.consume();
				}
			}
		});
		txtId.setBounds(202, 22, 86, 20);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);

		JLabel lblId = new JLabel("Id");
		lblId.setBounds(62, 25, 46, 14);
		frame.getContentPane().add(lblId);

		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(62, 50, 46, 14);
		frame.getContentPane().add(lblDate);

		txtDate = new JTextField();
		txtDate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtDate.getText().length() >= 10) {
					e.consume();
				}
			}
		});
		txtDate.setColumns(10);
		txtDate.setBounds(202, 53, 86, 20);
		frame.getContentPane().add(txtDate);

		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					NeocioCustomer nc = new NeocioCustomer();
					nc.setId(txtId.getText());
					nc.setDato(txtDate.getText());
					limpiar();
					if (nc.insertarCustomer()) {
						limpiar();
						JOptionPane.showMessageDialog(null, "Orden Registrada");
					} else {
						JOptionPane.showMessageDialog(null, "Error al insertar");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error al insertar");
				}
			}
		});
		btnInsertar.setBounds(51, 113, 89, 23);
		frame.getContentPane().add(btnInsertar);

		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String Id = JOptionPane.showInputDialog("ID de la orden");
					NeocioCustomer nc = new NeocioCustomer();
					nc.setId(Id);
					if (nc.consultarCustomer()) {
						txtId.setText("" + nc.getId());
						txtDate.setText("" + nc.getDato());
						JOptionPane.showMessageDialog(null, "Orden Encontrada");
					} else {
						JOptionPane.showMessageDialog(null, "Error al encontrar la orden");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error al encontrar la orden");
				}
			}
		});
		btnCargar.setBounds(190, 113, 89, 23);
		frame.getContentPane().add(btnCargar);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					NeocioCustomer no = new NeocioCustomer();
					no.setId(txtId.getText());
					no.setDato(txtDate.getText());
					if (no.actualizarCustomer()) {
						limpiar();
						JOptionPane.showMessageDialog(null, "Datos de la orden actualizada");
					} else {
						JOptionPane.showMessageDialog(null, "Error al actualizar orden");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error al actualizar orden");
				}
			}
		});
		btnActualizar.setBounds(312, 113, 89, 23);
		frame.getContentPane().add(btnActualizar);
	}

	public void limpiar() {
		txtId.setText("");
		txtDate.setText("");
	}

}
