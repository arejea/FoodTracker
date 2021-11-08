package com.foodtracker.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.database.DatabaseHandler;
import com.util.TableButton;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.AbstractAction;
import javax.swing.AbstractListModel;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

public class AddFoodView extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private  JFrame frame;
	private  JTable foodTable;
	private  JTextField searctTextField;
	private JPanel panel;
	private JList<String> categoryList;
	private JButton backButton;
	DatabaseHandler handler;
	//JPanel panel;
	
	public AddFoodView() {
		handler = DatabaseHandler.getInstance();
		initialize();
		loadListitems();
		loadAllCategories();
		categoryList.requestFocus();
		categoryList.setSelectedIndex(0);
		foodTable.setRowHeight(32);
		
	}
	
	
	private void loadAllCategories() {
		
		fillFoodTable("","");
	}

	private void loadListitems() {
		String categories[] = {"All", "Drinks", "Cheese", "Meat", "Cereals", "Vegetables",
				"Eggs", "Fats", "Fast-Food", "Sweets", "Dairy", "Spices", "Fruits", "Snacks"};
		
		DefaultListModel<String> model = new DefaultListModel<String> ();
		
		categoryList.setModel(model);
		
		for(String element : categories) {
			model.addElement(element);
		}
	}
	
	private void fillFoodTable(String category, String foodName) {
		
		String columnNames[] = {"Name","Calories", "Protein", "Fats", "Carbs", "Category", ""};
		
		DefaultTableModel tableModel = new DefaultTableModel();
		
		tableModel.setColumnIdentifiers(columnNames);
		
		ResultSet  resultSet = handler.getFoodResultSet(category, foodName);
		
		if(resultSet==null) {
			JOptionPane.showMessageDialog(null,"An error occured: null resultSer", "Error", JOptionPane.ERROR_MESSAGE );
		}
		
		try {
			
			while (resultSet.next()){
				
				String name = resultSet.getString("name");
				Double calories =  resultSet.getDouble("calories");
				Double protein =  resultSet.getDouble("protein");
				Double fats =  resultSet.getDouble("calories");				
				Double carbs =  resultSet.getDouble("carbs");
				String cat = resultSet.getString("category");
				
				Object [] row = new Object[7];
				row[0]= name;
				row[1]= calories;
				row[2]= protein;
				row[3]= fats;
				row[4]= carbs;
				row[5]= cat;
				row[6]= "Add";
				
				tableModel.addRow(row);
				
				
				
			}
			
		}catch(SQLException e) {
			System.out.println("fillFoodTableException() Error "+ e.getMessage());


			
		}	
		
		foodTable.setModel(tableModel);
		
		Action doSomething = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//throw new UnsupportedOperationException("Not supported Yet");
				
				//JTable  table = (JTable) e.getSource();
				
				int row = Integer.valueOf(e.getActionCommand());
				
				
				
			}
			
		};
		
		
		
		TableButton tableButton= new TableButton(foodTable, null, 6);
	
	}

	private  void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(UIManager.getColor("Button.light"));
		frame.getContentPane().setMinimumSize(new Dimension(400, 600));
		frame.setBounds(100, 100, 516, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(UIManager.getColor("Desktop.background"));
		panel.setBounds(0, 0, 515, 375);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel categoriesLabel = new JLabel("Categories");
		categoriesLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		categoriesLabel.setBounds(9, 0, 117, 63);
		panel.add(categoriesLabel);
		
		categoryList = new JList<String>();
		categoryList.setBackground(UIManager.getColor("Desktop.background"));
		categoryList.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		categoryList.setBounds(9, 48, 111, 321);
		panel.add(categoryList);
		
		foodTable = new JTable();
		foodTable.setBounds(146, 48, 365, 321);
		panel.add(foodTable);
		
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(312, 21, 99, 26);
		panel.add(searchButton);
		
		searctTextField = new JTextField();
		searctTextField.setBounds(144, 20, 150, 26);
		panel.add(searctTextField);
		searctTextField.setColumns(10);
		
		backButton = new JButton("New button");
		backButton.setBounds(457, 21, 54, 28);
		panel.add(backButton);
		
		
		
		
	}
	
	


	public JFrame getFrame() {
		return frame;
	}
}
