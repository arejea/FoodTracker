package com.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.database.DatabaseHandler;
import com.foodtracker.views.LoginPageView;
import com.foodtracker.views.SignUpView;

public class SignUpViewController implements ActionListener {
	
	SignUpView view;
	DatabaseHandler handler;
	
	public SignUpViewController (SignUpView theView) {
		view = theView;
		handler = DatabaseHandler.getInstance();
		//makeStarsInivisible();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==view.getBtnLogin()) {
			view.getFrame().dispose();
			LoginPageView newView = new LoginPageView();
			newView.getFrame().setVisible(true);
		}
		
		if(e.getSource()==view.getBtnSignUp() || e.getSource()==view.getBtnSignUpTwo() ) {
			makeStarsInivisible();
			if(makeEmptyField()) {
				JOptionPane.showMessageDialog(null, "Please enter all feilds", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(!matchPassword()) {
				JOptionPane.showMessageDialog(null, "Password should match", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			
			}
			
			if(handler.insertUser(view.getFirstNameTextField().getText(), view.getLastNameTextField().getText(), view.getEmailTextField().getText(),
					String.valueOf(view.getPasswordField().getPassword()))){
				
				JOptionPane.showMessageDialog(null, "Your Sign Up was Successfull", "Success", JOptionPane.INFORMATION_MESSAGE);

				
			}
			else {
				JOptionPane.showMessageDialog(null, "Email Already Registered", "Error", JOptionPane.ERROR_MESSAGE);

			}
			
		}
		
	}
	
	
	
	public void makeStarsInivisible() {
		
		view.getFirstNameStar().setVisible(false);
		view.getLastNameStar().setVisible(false);
		view.getEmailStar().setVisible(false);
		view.getPasswordStar().setVisible(false);
		view.getRePasswordStar().setVisible(false);
	}
	
	public boolean makeEmptyField() {
		
		boolean isEmpty = false;
		
		if(view.getFirstNameTextField().getText().isEmpty()) {
			isEmpty = true;
			view.getFirstNameStar().setVisible(true);
		}
		if(view.getLastNameTextField().getText().isEmpty()) {
			isEmpty = true;
			view.getLastNameStar().setVisible(true);
		}
		if(view.getEmailTextField().getText().isEmpty()) {
			isEmpty = true;
			view.getEmailStar().setVisible(true);
		}
		if(String.valueOf(view.getPasswordField().getPassword()).isEmpty()) {
			isEmpty = true;
			view.getPasswordStar().setVisible(true);
		}
		if(String.valueOf(view.getPasswordField_1().getPassword()).isEmpty()) {
			isEmpty = true;
			view.getRePasswordStar().setVisible(true);
		}
		
		
		return isEmpty;
	}
	
	
	private boolean matchPassword() {
		
		return (String.valueOf(view.getPasswordField_1().getPassword())).equals(String.valueOf(view.getPasswordField().getPassword()));
	}

}
