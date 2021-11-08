package com.foodtracker.views;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;

import com.controllers.LoginPageController;

import javax.swing.JPasswordField;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LoginPageView {

	private JFrame frame;
	private JTextField usernameTextField;
	private JPasswordField passwordField;
	private static LoginPageController loginController;
	private JButton btnLoginOne;
	private JButton btnSignUp;
	private JButton btnLoginTwo;
	private JLabel usernameStar;
	private JLabel passwordStar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPageView window = new LoginPageView();
					
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
	public LoginPageView() {
		loginController = new LoginPageController(this);
		initialize();
		loginController.setUserFeild();
		loginController.setPasswordFeild();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(0, 51, 102));
		frame.setMinimumSize(new Dimension(300, 300));
		frame.getContentPane().setBackground(new Color(0, 0, 102));
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 102));
		panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		frame.getContentPane().add(panel);
			panel.setLayout(null);
		
			btnSignUp = new JButton("Sign Up");
			btnSignUp.setBounds(94, 45, 106, 73);
			panel.add(btnSignUp);
			btnSignUp.addActionListener(loginController);
			btnSignUp.setFont(new Font("Lucida Grande", Font.BOLD, 13));
			btnSignUp.setBackground(new Color(255, 153, 0));
			btnSignUp.setForeground(new Color(0, 153, 51));
			
			btnLoginOne = new JButton("Login");
			btnLoginOne.setBounds(280, 45, 106, 73);
			panel.add(btnLoginOne);
			btnLoginOne.addActionListener(loginController);
			btnLoginOne.setForeground(new Color(204, 51, 0));
			btnLoginOne.setBackground(new Color(255, 153, 0));
			
			passwordField = new JPasswordField();
			passwordField.addActionListener(loginController);
			passwordField.addFocusListener(loginController);
			passwordField.setBounds(180, 164, 130, 26);
			panel.add(passwordField);
			passwordField.setEchoChar('*');
			
			btnLoginTwo = new JButton("Login");
			btnLoginTwo.setBounds(146, 202, 79, 29);
			panel.add(btnLoginTwo);
			btnLoginTwo.addActionListener(loginController);
			btnLoginTwo.setForeground(new Color(255, 69, 0));
			btnLoginTwo.setBackground(new Color(60, 179, 113));
			
			usernameTextField = new JTextField();
			usernameTextField.addActionListener(loginController);
			usernameTextField.addFocusListener(loginController);
			usernameTextField.setBounds(180, 130, 130, 26);
			panel.add(usernameTextField);
			usernameTextField.setColumns(10);
			
			usernameStar = new JLabel("*");
			usernameStar.setForeground(Color.RED);
			usernameStar.setVisible(false);
			usernameStar.setBounds(322, 135, 13, 16);
			panel.add(usernameStar);
			
			passwordStar = new JLabel("*");
			passwordStar.setForeground(Color.RED);
			passwordStar.setVisible(false);
			passwordStar.setBounds(322, 169, 13, 21);
			panel.add(passwordStar);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JFrame getFrame() {
		return frame;
	}

	public JTextField getUsernameTextField() {
		return usernameTextField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JButton getBtnLoginOne() {
		return btnLoginOne;
	}

	public void setBtnLoginOne(JButton btnLoginOne) {
		this.btnLoginOne = btnLoginOne;
	}

	public JButton getBtnSignUp() {
		return btnSignUp;
	}

	public JButton getBtnLoginTwo() {
		return btnLoginTwo;
	}

	public JLabel getUsernameStar() {
		return usernameStar;
	}

	public JLabel getPasswordStar() {
		return passwordStar;
	}

	public static LoginPageController getLoginController() {
		return loginController;
	}
}
