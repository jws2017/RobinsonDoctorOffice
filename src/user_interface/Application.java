package user_interface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

public class Application {
	public static void main(String[] args) {
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JFrame mainWindow = new JFrame("Doctor Login");
		mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    mainWindow.getContentPane().setLayout(new GridBagLayout());
	    mainWindow.setMinimumSize(new java.awt.Dimension(800, 600));
	    mainWindow.setSize(mainWindow.getMinimumSize());

	    GridBagConstraints constraints = new GridBagConstraints();

	    constraints.fill = GridBagConstraints.BOTH;
	    constraints.gridx = 0;
	    constraints.gridy = 0;
	    constraints.ipadx = 50;
	    constraints.ipady = 20;
	    mainWindow.add(new JLabel("Username:"), constraints);

	    constraints.gridx = 1;
	    mainWindow.add(new JTextField(25), constraints);

	    constraints.gridx = 0;
	    constraints.gridy = 1;
	    mainWindow.add(new JLabel("Password:"), constraints);

	    constraints.gridx = 1;
	    mainWindow.add(new JPasswordField(25), constraints);

	    constraints.gridx = 0;
	    constraints.gridy = 2;
	    constraints.gridwidth = 2;
	    mainWindow.add(new JButton("Log In"), constraints);

	     mainWindow.setVisible(true);
	}
}