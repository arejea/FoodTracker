package com.foodtracker.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.controllers.MainFrameController;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import java.awt.Color;

public class AddFoodItem extends JFrame {

	//private JPanel contentPane;
	private JFrame frame;
	private JPanel panel ;



	/**
	 * Create the frame.
	 */
	public AddFoodItem() {
	//	mainController = new MainFrameController(this);
		initialize();
		
		
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 516, 397);
		//contentPane = new JPanel();
		frame = new JFrame();
		frame.getContentPane().setForeground(UIManager.getColor("Button.light"));
		frame.setBounds(100, 100, 459, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		//contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 459, 464);
		frame.getContentPane().add(panel);
		//contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel caloriesLabel = new JLabel("Calories");
		caloriesLabel.setBounds(6, 47, 66, 27);
		panel.add(caloriesLabel);
		
		JLabel foodNameLabel = new JLabel("Food's Name:");
		foodNameLabel.setBounds(92, 6, 135, 22);
		panel.add(foodNameLabel);
		foodNameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		foodNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblProtein = new JLabel("Protein:");
		lblProtein.setBounds(6, 86, 51, 16);
		panel.add(lblProtein);
		
		JLabel fatsLabel = new JLabel("Fats:");
		fatsLabel.setBounds(6, 114, 98, 22);
		panel.add(fatsLabel);
		
		JLabel lblCarbs = new JLabel("Carbs");
		lblCarbs.setBounds(6, 146, 51, 16);
		panel.add(lblCarbs);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 198, 246, 27);
		panel.add(comboBox);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(43, 248, 83, 16);
		panel.add(lblQuantity);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(109, 281, 105, 35);
		panel.add(btnNewButton);		
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(109, 243, 83, 26);
		panel.add(spinner);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 70, 447, 16);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 174, 459, 12);
		panel.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(-6, 228, 459, 12);
		panel.add(separator_1_1);
	}
}
