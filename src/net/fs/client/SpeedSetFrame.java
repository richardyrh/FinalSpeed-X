// Copyright (c) 2015 D1SM.net

package net.fs.client;

import java.awt.Dialog;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.fs.utils.MLog;
import net.miginfocom.swing.MigLayout;

public class SpeedSetFrame extends JDialog{

	private static final long serialVersionUID = -3248779355079724594L;
		
	ClientUI ui;
	
	JTextField text_ds,text_us;
	
	SpeedSetFrame(final ClientUI ui,JFrame parent){
		super(parent,Dialog.ModalityType.APPLICATION_MODAL);
		this.ui=ui;
		setResizable(false);
		setTitle(ui.lang.g(55));
		
		JPanel panel=(JPanel) getContentPane();
		panel.setLayout(new MigLayout("alignx center,aligny center,insets 10 10 10 10"));
		
		
		panel.add(new JLabel(ui.lang.g(56)),"height ::,wrap");
		panel.add(new JLabel(ui.lang.g(57)),"height ::,wrap");

		JPanel p5=new JPanel();
		panel.add(p5,"wrap");
		p5.setLayout(new MigLayout("insets 0 0 0 0"));
		p5.add(new JLabel(ui.lang.g(12)));
		text_ds=new JTextField("");
		p5.add(text_ds,"width 70::");
		p5.add(new JLabel("Mbps"));
		p5.add(new JLabel("  "));
		p5.add(new JLabel(ui.lang.g(13)));
		text_us=new JTextField("");
		p5.add(text_us,"width 70::");
		//text_us.setEditable(false);
		p5.add(new JLabel("Mbps"));
		
		JPanel p6=new JPanel();
		panel.add(p6,"align center,wrap");
		p6.setLayout(new MigLayout("align center, insets 0 0 0 0"));
		
		JButton button_ok=createButton(ui.lang.g(58));
		p6.add(button_ok);
		button_ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String us=text_ds.getText().trim();
				String ds=text_us.getText().trim();
				try {
					int d=(int) (Float.parseFloat(us)*1024*1024/8/1.1);
					int u=(int) (Float.parseFloat(ds)*1024*1024/8/1.1);
					ui.setSpeed(d, u);
					setVisible(false);
				} catch (Exception e2) {
					//e2.printStackTrace();
					JOptionPane.showMessageDialog(ui.mainFrame, ui.lang.g(59));
				}
				
			}
		});
		
		p6.add(new JLabel(" "));
		
		JButton button_cancel=createButton(ui.lang.g(42));
		p6.add(button_cancel);
		button_cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		pack();
		setLocationRelativeTo(parent);
		if(ui.isVisible){
			setVisible(true);
		} else {
			MLog.println(ui.lang.g(60));
			System.exit(0);
		}
	}
	
	JButton createButton(String name){
		JButton button=new JButton(name);
		button.setMargin(new Insets(0,0,0,0));
		button.setFocusPainted(false);
		return button;
	}

	

}
