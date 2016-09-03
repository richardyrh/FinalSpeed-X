// Copyright (c) 2015 D1SM.net

package net.fs.client;

import java.awt.Dialog;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class AddMapFrame extends JDialog{

	private static final long serialVersionUID = -3248779355079724594L;
		
	ClientUI ui;
	
	JTextField portTextField, text_port,nameTextField;
	
	int downloadSpeed,uploadSpeed;
	
	MapRule maprule_origin;
	
	boolean edit=false;
		
	AddMapFrame(final ClientUI ui,JFrame parent,final MapRule maprule_origin,final boolean edit){
		super(parent,Dialog.ModalityType.APPLICATION_MODAL);
		this.ui=ui;
		this.edit=edit;
		this.maprule_origin=maprule_origin;
		setTitle(ui.lang.g(35));
		if(edit){
			setTitle(ui.lang.g(36));
		}
		
		JPanel panel=(JPanel) getContentPane();
		panel.setLayout(new MigLayout("alignx center,insets 5 5 5 5"));
		
		JPanel p3=new JPanel();
		panel.add(p3,"wrap");
		p3.setBorder(BorderFactory.createEtchedBorder());
		p3.setLayout(new MigLayout("inset 5 5 5 5"));
		
		p3.add(new JLabel(ui.lang.g(39)));
		nameTextField=new JTextField();
		p3.add(nameTextField,"width 120! ,wrap");
		
		p3.add(new JLabel(ui.lang.g(40)));
		portTextField=new JTextField("");
		p3.add(portTextField,"width 120!,wrap");
		portTextField.setToolTipText(ui.lang.g(37));
		
		p3.add(new JLabel(ui.lang.g(41)));
		text_port=new JTextField();
		p3.add(text_port,"width 120! ,wrap");

		JPanel p6=new JPanel();
		panel.add(p6);
		p6.setLayout(new MigLayout("width 190!"));
		
		JButton button_ok=createButton(ui.lang.g(38));
		p6.add(button_ok, "width 80!, left");
		button_ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					checkName(nameTextField.getText());
					checkPort(text_port.getText());
					checkPort(portTextField.getText());
					String name=nameTextField.getText();
					int listen_port=Integer.parseInt(text_port.getText());
					int dst_port=Integer.parseInt(portTextField.getText());
					MapRule mapRule_new=new MapRule();
					mapRule_new.setName(name);
					mapRule_new.listen_port=listen_port;
					mapRule_new.setDst_port(dst_port);
					if(!edit){
						ui.mapClient.portMapManager.addMapRule(mapRule_new);
					}else {
						ui.mapClient.portMapManager.updateMapRule(maprule_origin,mapRule_new);
					}
					ui.loadMapRule();
					ui.select(mapRule_new.name);
					setVisible(false);
				} catch (Exception e1) {
					//e2.printStackTrace();
					JOptionPane.showMessageDialog(ui.mainFrame, e1.getMessage(),ui.lang.g(9),JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		JButton button_cancel=createButton(ui.lang.g(42));
		p6.add(button_cancel, "width 80!");
		button_cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		
		if(edit){
			nameTextField.setText(maprule_origin.name);
			text_port.setText(maprule_origin.listen_port+"");
			portTextField.setText(maprule_origin.dst_port+"");
		}
		
		pack();
		setLocationRelativeTo(parent);
		setVisible(true);
	}
	
	void checkName(String s) throws Exception{
		if(s.trim().equals("")){
			throw new Exception(ui.lang.g(43));
		}
	}
	
	void checkDstAddress(String s) throws Exception{
		if(s.trim().equals("")){
			throw new Exception(ui.lang.g(44));
		}
	}
	
	void checkPort(String s) throws Exception{
		int port=0;
		try {
			port=Integer.parseInt(s);
		} catch (Exception e1) {
			throw new Exception(ui.lang.g(45));
		}
		if(port<1|port>256*256){
			throw new Exception(ui.lang.g(45));
		}
	}
	
	JButton createButton(String name){
		JButton button=new JButton(name);
		button.setMargin(new Insets(0,0,0,0));
		button.setFocusPainted(false);
		return button;
	}

	

}
