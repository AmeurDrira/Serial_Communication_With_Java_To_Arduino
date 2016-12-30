package tn.iit.arduino;

import java.awt.EventQueue;

import javax.swing.JFrame;

import tn.iit.test.SerialClass;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Test {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
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
	public Test() {
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

		JButton btnOn = new JButton("ON");
		btnOn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SerialClass main = new SerialClass();
				main.initialize();

				main.writeData('o');

				System.out.println("Started");

			}
		});
		btnOn.setBounds(40, 86, 117, 29);
		frame.getContentPane().add(btnOn);

		JButton btnOff = new JButton("OFF");
		btnOff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SerialClass main = new SerialClass();
				main.initialize();

				main.writeData('f');

			}

		});
		btnOff.setBounds(217, 86, 117, 29);
		frame.getContentPane().add(btnOff);
	}
}
