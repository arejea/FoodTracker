package com.foodtracker.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.controllers.MainFrameController;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class MainFrameView {

	private JFrame frame;
	private JButton trackFoodButton;
	private JButton addFoodButton;
	private JLabel welcomeMssgLabel;
	MainFrameController  mainController;
	


	/**
	 * Create the application.
	 */
	public MainFrameView() {
		mainController = new MainFrameController(this);
		initialize();
	
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(UIManager.getColor("Button.light"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 102));
		panel.setForeground(UIManager.getColor("Button.light"));
		panel.setBounds(6, 0, 438, 272);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		trackFoodButton = new JButton("Track Food");
		trackFoodButton.addActionListener(mainController);
		trackFoodButton.setBounds(24, 127, 169, 66);
		panel.add(trackFoodButton);
		
		addFoodButton = new JButton("Add Food");
		addFoodButton.addActionListener(mainController);
		addFoodButton.setBounds(245, 127, 169, 66);
		panel.add(addFoodButton);
		
		int id = LoginPageView.getLoginController().getUserId();
		
		welcomeMssgLabel = new JLabel("Hello "+mainController.getHandler().getUserName(id)+", ");
		welcomeMssgLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		welcomeMssgLabel.setBounds(73, 42, 225, 40);
		panel.add(welcomeMssgLabel);
	}

	public JFrame getFrame() {
		return frame;
	}


	public JLabel getWelcomeMssgLabel() {
		return welcomeMssgLabel;
	}

	public void setWelcomeMssgLabel(JLabel welcomeMssgLabel) {
		this.welcomeMssgLabel = welcomeMssgLabel;
	}

	public JButton getTrackFoodButton() {
		return trackFoodButton;
	}

	public JButton getAddFoodButton() {
		return addFoodButton;
	}

	public MainFrameController getMainController() {
		return mainController;
	}
}
