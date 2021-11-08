package com.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import com.foodtracker.views.AddFoodView;

public class AddFoodController  implements ActionListener, FocusListener {
	
	AddFoodView view;
	//AddFoodItem viewItem;
	
	public AddFoodController(AddFoodView view) {
		this.view= view;
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
