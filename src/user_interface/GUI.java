package user_interface;
//import data_structures.Database;
//import data_structures.Table;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GUI extends JFrame{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//public JFrame frame; //Extends JFrame already so 'this' IS a frame
	public JPasswordField passwordField;
	public JTextField textField;
	public JButton login;
	public JRadioButton doctor;
	public JRadioButton nurse;
	public ButtonGroup bg1;
	   /**
	    * Launch the application.
	    */
	public static void main(String[] args) {
       EventQueue.invokeLater(new Runnable() {
           public void run() {
               try {
                   GUI window = new GUI();
                   window.setVisible(true);
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       });
   }
   /**
    * Create the application.
    */
   public GUI() {
       initialize();
       groupButton();
   }
   /**
    * Initialize the contents of the frame.
    */
   public void initialize() {
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //DO NOT forget this, the instance will continue to run if not.
     setLayout(null);
     setTitle("Doctor Login");
     setSize(400,300); // only added so I didn't have to expand window as often
     passwordField = new JPasswordField();
     passwordField.setBounds(90, 114, 105, 22);
     add(passwordField);
     textField = new JTextField();
     textField.setBounds(90, 79, 105, 22);
     add(textField);
     textField.setColumns(10);
   
     doctor= new JRadioButton("Doctor");
     doctor.setSelected(true);
     nurse= new JRadioButton("Nurse");
     nurse.setSelected(true);
    
     JLabel Username = new JLabel("Username");
     Username.setBounds(220, 82, 76, 16);
     add(Username);
     JLabel Password = new JLabel("Password");
     Password.setBounds(220, 117, 66, 16);
     add(Password);
     JButton login = new JButton("Log In");
     login.setBounds(144, 158, 97, 25);
     login.addActionListener(new ActionListener() { //moved from actionGUI()
         public void actionPerformed(ActionEvent ae){
         }
     });        
     add(login);
     add(passwordField);
     add(textField);
    
   }
   private void groupButton() {
    ButtonGroup bg1 = new ButtonGroup( );
    bg1.add(doctor);
    bg1.add(nurse);
    }
}