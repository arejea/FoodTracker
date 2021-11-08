package com.foodtracker.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ProgressTracker extends JFrame {


	private JFrame frame;
	//JPanel panel;
	public ProgressTracker() {
		initiallize();


	}

	private void initiallize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 51, 102));
		frame.getContentPane().setMinimumSize(new Dimension(400, 600));
		frame.setBounds(100, 100, 400, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);		
	}

	public JFrame getFrame() {
		return frame;
	}

}
