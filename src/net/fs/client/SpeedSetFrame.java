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
		setTitle("Set Bandwidth");
		
		JPanel panel=(JPanel) getContentPane();
		panel.setLayout(new MigLayout("alignx center,aligny center,insets 10 10 10 10"));
		
		
		panel.add(new JLabel("In Mbps (1 Mbit=128 KBytes,10 Mbits=1.25 Mbytes)"),"height ::,wrap");
		panel.add(new JLabel("Precise input gives better boost effect."),"height ::,wrap");

		JPanel p5=new JPanel();
		panel.add(p5,"wrap");
		p5.setLayout(new MigLayout("insets 0 0 0 0"));
		p5.add(new JLabel("Download:"));
		text_ds=new JTextField("");
		p5.add(text_ds,"width 70::");
		p5.add(new JLabel("Mbps"));
		p5.add(new JLabel("  "));
		p5.add(new JLabel("Upload:"));
		text_us=new JTextField("");
		p5.add(text_us,"width 70::");
		//text_us.setEditable(false);
		p5.add(new JLabel("Mbps"));
		
		JPanel p6=new JPanel();
		panel.add(p6,"align center,wrap");
		p6.setLayout(new MigLayout("align center, insets 0 0 0 0"));
		
		JButton button_ok=createButton("Done");
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
					JOptionPane.showMessageDialog(ui.mainFrame, "Incorrect Input!");
				}
				
			}
		});
		
		p6.add(new JLabel(" "));
		
		JButton button_cancel=createButton("Cancel");
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
			MLog.println("You have to manually set bandwidth information in client_config.json, "
					+ "or start up the application in non-CLI mode first.");
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
