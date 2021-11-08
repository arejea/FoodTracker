package com.util;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class TableButton extends AbstractCellEditor
implements TableCellRenderer, TableCellEditor, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTable table;
	private Action action;
	
	private JButton renderButton;
	private JButton editButton;
	
	private Object editValue;

	public TableButton(JTable table, Action action, int column) {
		
		this.table = table;
		this.action = action;
		
		
		renderButton = new JButton();
		editButton = new JButton();
		
		editButton.addActionListener(this);
		
		TableColumnModel columnModel = this.table.getColumnModel();
		columnModel.getColumn(column).setCellRenderer(this);
		columnModel.getColumn(column).setCellEditor(this);
		
	}

	@Override
	public Object getCellEditorValue() {
		return editValue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int row =  table.convertRowIndexToModel(table.getEditingRow());
		
		fireEditingStopped();
		
		ActionEvent event = new ActionEvent(table, ActionEvent.ACTION_PERFORMED, String.valueOf(row));
		action.actionPerformed(event);
		
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		if(value== null) {
			editButton.setText("");
		}
		else {
			editButton.setText(value.toString());
		}
		editValue= value;
		return editButton;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		if(isSelected) {
			renderButton.setForeground(table.getSelectionForeground());
			renderButton.setBackground(table.getSelectionBackground());
		}
		else {
			renderButton.setForeground(table.getSelectionForeground());
			renderButton.setBackground(UIManager.getColor("Button.background"));
		}
		
		
		if(value==null) {
			renderButton.setText("");
		}
		else {
			renderButton.setText(value.toString());
		}
			
		
		return renderButton;
	
	}

	
}
