package net.fs.client;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import net.miginfocom.swing.MigLayout;

public class AddressCellRenderer implements ListCellRenderer<Object>{

	JPanel panel=null;
	
	JLabel addressLabel;
	
	Color color_normal=new Color(255,255,255);

	Color color_selected=new Color(210,233,255);
	
	JButton button_remove;
	
	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		if(panel==null){
			init();
		}
		updateData( list,  value,  index,  isSelected, cellHasFocus);
		return panel;
	}
	
	void init(){
		panel=new JPanel();
		panel.setLayout(new MigLayout("insets 0 5 0 0","[grow,fill]rel[right]", "[]0[]"));
		panel.setOpaque(true);
		panel.setBackground(color_normal);
		addressLabel=new JLabel("");
		panel.add(addressLabel,"");
		addressLabel.setOpaque(false);
	}
	
	void updateData(JList<?> list, Object value, int index, boolean isSelected,boolean cellHasFocus){
		addressLabel.setText(value.toString());
		if(isSelected){
			panel.setBackground(color_selected);
		}else {
			panel.setBackground(color_normal);
		}
	}
	
}
