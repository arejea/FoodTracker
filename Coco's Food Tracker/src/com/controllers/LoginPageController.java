package com.controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;

import com.database.DatabaseHandler;
import com.foodtracker.views.LoginPageView;
import com.foodtracker.views.MainFrameView;
import com.foodtracker.views.SignUpView;



public class LoginPageController implements ActionListener, FocusListener {
	LoginPageView view;
	DatabaseHandler handler;
	private static int userId = -1;
	

	public static int getUserId() {
		return userId;
	}

	public LoginPageController(LoginPageView window) {
		view = window;
		handler =  DatabaseHandler.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == view.getBtnSignUp()) {
			SignUpView signUp = new SignUpView();
			signUp.frame.setVisible(true);
			view.getFrame().dispose();
		}
		
		else if(e.getSource() == view.getBtnLoginOne() || e.getSource() == view.getBtnLoginTwo() 
				|| e.getSource() == view.getUsernameTextField() || e.getSource() == view.getPasswordField()) {
			String email = view.getUsernameTextField().getText();
			String pwd = String.valueOf(view.getPasswordField().getPassword());
			
			if(makeEmptyField()) {
				JOptionPane.showMessageDialog(null, "Please enter all feilds! ", "", JOptionPane.ERROR_MESSAGE);
			}
			else {
				if((handler.validateUser(email, pwd))>0) {
					userId = handler.validateUser(email, pwd);
					MainFrameView n = new MainFrameView();
					
					n.getFrame().setVisible(true);
					view.getFrame().dispose();
				}
				
				else {
					
					JOptionPane.showMessageDialog(null, "Invalid Credentials! ", "", JOptionPane.ERROR_MESSAGE);
					System.out.println("login not success");
				}
			}
			
			
		}
		
				
	}
	
	
	
	public void setStarsVisible(boolean flag) {
		view.getUsernameStar().setVisible(flag);
		view.getPasswordStar().setVisible(flag);
	}
	

	public boolean makeEmptyField() {
		
		boolean isEmpty = false;
		
		if(view.getUsernameTextField().getForeground() == Color.gray) {
			isEmpty = true;
			view.getUsernameStar().setVisible(true);
		}
		
		if(view.getPasswordField().getForeground()==Color.gray) {
		
			isEmpty = true;
			view.getUsernameStar().setVisible(true);
		}
		
		return isEmpty;
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource()==view.getUsernameTextField()) {
			if(view.getUsernameTextField().getForeground() == Color.gray) {
				view.getUsernameTextField().setText("");
				view.getUsernameTextField().setForeground(null);
			}
		}
		
		if(e.getSource()==view.getPasswordField()) {
			
			if(view.getPasswordField().getForeground()==Color.gray){
				view.getPasswordField().setEchoChar('*');
				view.getPasswordField().setText("");
				view.getPasswordField().setForeground(null);
			}
			
		}
		
		
	}
	
	public void setUserFeild() {
		if(view.getUsernameTextField().getText().isEmpty()) {
			view.getUsernameTextField().setText("Username");
			view.getUsernameTextField().setForeground(Color.gray);
		}
	}

	public void setPasswordFeild(){
		
		if(String.valueOf(view.getPasswordField().getPassword()).isEmpty()){
			view.getPasswordField().setEchoChar((char)0);
			view.getPasswordField().setText("Password");
			view.getPasswordField().setForeground(Color.gray);
		}
		
	}
	
	@Override
	public void focusLost(FocusEvent e) {
		
		if(e.getSource()==view.getUsernameTextField()) {
			
			setUserFeild();
		}
		
		if(e.getSource()==view.getPasswordField()) {
			
			setPasswordFeild();
			
		}
		
	}
}
