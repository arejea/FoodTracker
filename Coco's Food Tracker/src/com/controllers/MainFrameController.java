package com.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import com.database.DatabaseHandler;
import com.foodtracker.views.AddFoodView;
import com.foodtracker.views.LoginPageView;
import com.foodtracker.views.MainFrameView;
import com.foodtracker.views.ProgressTracker;

public class MainFrameController implements ActionListener {
	MainFrameView view;
	DatabaseHandler handler;
	

	public MainFrameController(MainFrameView window) {
		view = window;
		handler =  DatabaseHandler.getInstance();
		
		//view.getWelcomeMssgLabel().setText("Hello "+handler.getUserName(id)+", ");
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() ==view.getAddFoodButton()) {
			AddFoodView newView = new AddFoodView();
			newView.getFrame().setVisible(true);
			view.getFrame().dispose();
		}
		else if(e.getSource() ==view.getTrackFoodButton()) {
			
			ProgressTracker newView = new ProgressTracker();
			newView.getFrame().setVisible(true);
			view.getFrame().dispose();
		}
		
			
	}


	public DatabaseHandler getHandler() {
		return handler;
	}



}
