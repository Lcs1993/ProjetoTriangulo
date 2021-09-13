package br.com.curso;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ProjetoTriangulo {

	private JFrame frame;
	private JPanel panResultado ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjetoTriangulo window = new ProjetoTriangulo();
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
	public ProjetoTriangulo() {
		initialize();
		
		panResultado.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Segmento A");
		lblNewLabel.setBounds(0, 33, 81, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Segmento B");
		lblNewLabel_1.setBounds(0, 70, 81, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Segmento C");
		lblNewLabel_2.setBounds(0, 108, 81, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JSlider sliC = new JSlider();
		
		sliC.setValue(0);
		sliC.setMaximum(20);
		sliC.setBounds(101, 108, 200, 26);
		frame.getContentPane().add(sliC);
		
		JSlider sliB = new JSlider();
		
		sliB.setMaximum(20);
		sliB.setValue(0);
		sliB.setBounds(101, 71, 200, 26);
		frame.getContentPane().add(sliB);
		
		JSlider sliA = new JSlider();
		
		sliA.setValue(0);
		sliA.setMaximum(20);
		sliA.setBounds(101, 33, 200, 26);
		frame.getContentPane().add(sliA);
		
		JLabel lblA = new JLabel("0");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblA.setForeground(Color.LIGHT_GRAY);
		lblA.setBounds(321, 33, 46, 14);
		frame.getContentPane().add(lblA);
		
		JLabel lblB = new JLabel("0");
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblB.setForeground(Color.LIGHT_GRAY);
		lblB.setBounds(321, 70, 46, 14);
		frame.getContentPane().add(lblB);
		
		JLabel lblC = new JLabel("0");
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblC.setForeground(Color.LIGHT_GRAY);
		lblC.setBounds(321, 108, 46, 14);
		frame.getContentPane().add(lblC);
		
		JButton btnVerificar = new JButton("Verificar");
		
		btnVerificar.setBounds(155, 161, 89, 23);
		frame.getContentPane().add(btnVerificar);
		
		panResultado= new JPanel();
		panResultado.setBounds(10, 195, 357, 55);
		frame.getContentPane().add(panResultado);
		panResultado.setLayout(null);
		
		JLabel lblStatus = new JLabel("Forma ou n\u00E3o?");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStatus.setForeground(Color.BLUE);
		lblStatus.setBounds(10, 5, 337, 14);
		lblStatus.setBackground(new Color(240, 240, 240));
		panResultado.add(lblStatus);
		
		JLabel lblTriangulo = new JLabel("Tipo de triangulo");
		lblTriangulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTriangulo.setForeground(Color.RED);
		lblTriangulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTriangulo.setBounds(0, 30, 347, 25);
		panResultado.add(lblTriangulo);
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a=sliA.getValue();
				int b=sliB.getValue();
				int c=sliC.getValue();
				if(a<b+c && b<a+c && c<a+b) {
					lblStatus.setText("forma um triângulo");
					if (a==b && b==c) {
						lblTriangulo.setText("equilátero");
					} else if(a!=b && b!=c && a!=c) {
						lblTriangulo.setText("escaleno");
					}else {
						lblTriangulo.setText("isóseles");
					}
				} else {
					lblStatus.setText("não forma um triângulo");
					lblTriangulo.setText("---");
				}
				panResultado.setVisible(true);
			}
		});
		sliA.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblA.setText(Integer.toString(sliA.getValue()));
			}
		});
		sliB.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblB.setText(Integer.toString(sliB.getValue()));
			}
		});
		sliC.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblC.setText(Integer.toString(sliC.getValue()));;
			}
		});
	}
}
