package net.fs.client;

import java.awt.Dialog;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class ChooseLangFrame extends JDialog {

	ClientUI ui;
	private static final long serialVersionUID = 795123843782026018L;
	JDialog self;
	
	ChooseLangFrame(final ClientUI ui, JFrame parent) {
		super(parent,Dialog.ModalityType.APPLICATION_MODAL);
		this.ui=ui;
		self=this;
		setResizable(false);
		setTitle(ui.lang.g(66));
		JPanel mainPanel=(JPanel) this.getContentPane();
		mainPanel.setLayout(new MigLayout("alignx center,insets 5 5 5 5"));
		final JComboBox<String> languageCombo=new JComboBox<>();
		final HashMap<String,String> descMap=new HashMap<>();
		descMap.put("ch.lang", "简体中文");
		descMap.put("tr-ch.lang", "繁體中文");
		descMap.put("en.lang", "English");

		try {
			File d=new File("./");
			for (File f:d.listFiles()) {
				String fileName="";
				if (f.isFile()&&(fileName=f.getName()).endsWith(".lang")){
					String descString=fileName;
					if (descMap.containsKey(fileName)) {
						descString=descMap.get(fileName)+" - "+descString;
					}
					languageCombo.addItem(descString);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, ui.lang.g(67));
			this.dispose();
		}
		mainPanel.add(languageCombo,"width :150:, growx, wrap");
		
		JButton buttonSave=createButton(ui.lang.g(18));
		buttonSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (String k:descMap.keySet()) {
					if (languageCombo.getSelectedItem().toString().equals(descMap.get(k)+" - "+k)) {
						ui.changeLang(k);
						dispose();
					}
				}
			}
		});
		JButton buttonBack=createButton(ui.lang.g(42));
		buttonBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				self.dispose();
			}
		});
		JPanel buttonPanel=new JPanel();
		buttonPanel.setLayout(new MigLayout("alignx center, insets 0 0 0 0"));
		buttonPanel.add(buttonSave,"width 80!");
		buttonPanel.add(buttonBack,"width 80!");
		mainPanel.add(buttonPanel,"alignx center");
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	JButton createButton(String name){
		JButton button=new JButton(name);
		button.setMargin(new Insets(0,0,0,0));
		button.setFocusPainted(false);
		return button;
	}

}
