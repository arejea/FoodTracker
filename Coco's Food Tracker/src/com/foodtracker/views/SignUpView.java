package com.foodtracker.views;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.controllers.SignUpViewController;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpView {

	public JFrame frame;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField emailTextField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JButton btnLogin;
	private JButton btnSignUp;
	private JButton btnSignUpTwo;
	private JLabel emailStar;
	private JLabel lastNameStar;
	private JLabel firstNameStar;
	private JLabel passwordStar;
	private JLabel rePasswordStar;
	SignUpViewController controller;



	/**
	 * Create the application.
	 */
	public SignUpView() {
		controller = new SignUpViewController(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 51, 102));
		frame.getContentPane().setMinimumSize(new Dimension(400, 600));
		frame.setBounds(100, 100, 400, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(controller);
		btnSignUp.setForeground(new Color(255, 69, 0));
		btnSignUp.setBounds(82, 56, 120, 82);
		frame.getContentPane().add(btnSignUp);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(controller);
		btnLogin.setForeground(new Color(0, 100, 0));
		btnLogin.setBounds(227, 56, 120, 82);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("First name");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(11, 266, 130, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last name");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(11, 317, 130, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(11, 362, 130, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(153, 266, 219, 26);
		frame.getContentPane().add(firstNameTextField);
		firstNameTextField.setColumns(10);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(153, 317, 219, 26);
		frame.getContentPane().add(lastNameTextField);
		lastNameTextField.setColumns(10);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(153, 362, 219, 26);
		frame.getContentPane().add(emailTextField);
		emailTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(11, 400, 130, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Re-Type Password");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(6, 438, 135, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(153, 400, 219, 26);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(153, 438, 219, 26);
		frame.getContentPane().add(passwordField_1);
		
		btnSignUpTwo = new JButton("Sign Up");
		btnSignUpTwo.addActionListener(controller);
		btnSignUpTwo.setForeground(new Color(0, 102, 0));
		btnSignUpTwo.setBounds(82, 507, 264, 68);
		frame.getContentPane().add(btnSignUpTwo);
		
		rePasswordStar = new JLabel("*");
		rePasswordStar.setForeground(Color.RED);
		rePasswordStar.setBounds(377, 438, 23, 26);
		rePasswordStar.setVisible(false);
		frame.getContentPane().add(rePasswordStar);
		
		passwordStar = new JLabel("*");
		passwordStar.setForeground(new Color(255, 0, 0));
		passwordStar.setBounds(377, 393, 23, 31);
		passwordStar.setVisible(false);
		frame.getContentPane().add(passwordStar);
		
		emailStar = new JLabel("*");
		emailStar.setForeground(new Color(255, 0, 0));
		emailStar.setBounds(377, 360, 16, 31);
		emailStar.setVisible(false);
		frame.getContentPane().add(emailStar);
		
		lastNameStar = new JLabel("*");
		lastNameStar.setForeground(new Color(255, 0, 0));
		lastNameStar.setBounds(377, 317, 23, 26);
		lastNameStar.setVisible(false);
		frame.getContentPane().add(lastNameStar);
		
		firstNameStar = new JLabel("*");
		firstNameStar.setForeground(new Color(255, 0, 0));
		firstNameStar.setBounds(377, 269, 23, 21);
		firstNameStar.setVisible(false);
		frame.getContentPane().add(firstNameStar);
	}

	public JFrame getFrame() {
		return frame;
	}

	public JTextField getFirstNameTextField() {
		return firstNameTextField;
	}

	public JTextField getLastNameTextField() {
		return lastNameTextField;
	}

	public JTextField getEmailTextField() {
		return emailTextField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JPasswordField getPasswordField_1() {
		return passwordField_1;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public JButton getBtnSignUp() {
		return btnSignUp;
	}

	public JButton getBtnSignUpTwo() {
		return btnSignUpTwo;
	}

	public JLabel getEmailStar() {
		return emailStar;
	}

	public JLabel getLastNameStar() {
		return lastNameStar;
	}

	public JLabel getFirstNameStar() {
		return firstNameStar;
	}

	public JLabel getPasswordStar() {
		return passwordStar;
	}

	public JLabel getRePasswordStar() {
		return rePasswordStar;
	}

	public SignUpViewController getController() {
		return controller;
	}

}