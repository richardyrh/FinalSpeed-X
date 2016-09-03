// Copyright (c) 2015 D1SM.net

package net.fs.client;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


import net.miginfocom.swing.MigLayout;
//import sun.swing.DefaultLookup;

public class MapRuleRender extends JLabel implements TableCellRenderer {

	private static final long serialVersionUID = -3260748459008436510L;

	JPanel pleft,pright,p1;

	JLabel label_wan_address;
	JLabel label_DstPort;
	JLabel label2;

	MapRule rule;

	ClientUI ui;
	
	public MapRuleRender(ClientUI ui) {
		this.ui=ui;
		setOpaque(true);
		setLayout(new MigLayout("insets 8 10 0 0"));
		label_wan_address=new JLabel();
		add(label_wan_address,"width :500:,wrap");
		label_wan_address.setBackground(new Color(0f,0f,0f,0f));
		label_wan_address.setOpaque(true);
		label_DstPort=new JLabel();
		add(label_DstPort,"width :500:");
		label_DstPort.setBackground(new Color(0f,0f,0f,0f));
		label_DstPort.setOpaque(true);
		label2=new JLabel();
		add(label2,"width :500:,wrap");
		label2.setBackground(new Color(0f,0f,0f,0f));
		label2.setOpaque(true);
	}


	void update(MapRule rule,JTable table,int row){
		this.rule=rule;
		int rowHeight=50;
		int h=table.getRowHeight(row);
		if(h!=rowHeight){
			table.setRowHeight(row, rowHeight);
		}
		String name=rule.getName();
		if(name==null){
			name=ui.lang.g(49);
		}else if(name.trim().equals("")){
			name=ui.lang.g(49);
		}
		label_wan_address.setText(ui.lang.g(39)+" "+rule.name);
		label_DstPort.setText(ui.lang.g(40)+" "+rule.dst_port);
		label2.setText(ui.lang.g(41)+" "+rule.getListen_port());

	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		JTable.DropLocation dropLocation = table.getDropLocation();
		if (dropLocation != null
				&& !dropLocation.isInsertRow()
				&& !dropLocation.isInsertColumn()
				&& dropLocation.getRow() == row
				&& dropLocation.getColumn() == column) {
			isSelected = true;
		}
		if (isSelected) {
			setBackground(Color.lightGray);
		} else {
			setBackground(new Color(1f,1f,1f,1f));
		}
		MapRule rule=(MapRule)value;
		update(rule,table,row);
		return this;
	}

}
