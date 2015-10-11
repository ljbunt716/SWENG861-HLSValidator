import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class URLInput {

	private JFrame frame;
	private JTextField txtInput;
	private JLabel lblErrorMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					URLInput window = new URLInput();
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
	public URLInput() {
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

		JLabel lblPleaseEnterA = new JLabel("Please enter a URL to validate:");
		lblPleaseEnterA.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPleaseEnterA.setBounds(126, 50, 182, 14);
		frame.getContentPane().add(lblPleaseEnterA);

		txtInput = new JTextField();
		txtInput.setBounds(18, 94, 397, 20);
		frame.getContentPane().add(txtInput);
		txtInput.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String input = txtInput.getText().trim();

				if (input.equals("")) {
					lblErrorMessage.setText("URL is empty. Please enter a value.");
				} else {

					// STRICTLY FOR TESTING
					if (input.startsWith("C:"))
						try {
							input = new File(input).toURI().toURL().toString();
						} catch (MalformedURLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					// END TEST BLOCK

					Main.ProcessURL(input);
				}
			}
		});

		btnSubmit.setBounds(172, 139, 89, 23);
		frame.getContentPane().add(btnSubmit);

		lblErrorMessage = new JLabel("");
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblErrorMessage.setBounds(67, 209, 299, 20);
		frame.getContentPane().add(lblErrorMessage);
	}
}
