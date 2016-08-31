package net.fs.client;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;

import net.fs.utils.LogListener;
import net.fs.utils.LogOutputStream;
import net.miginfocom.swing.MigLayout;

public class LogFrame extends JFrame implements LogListener{
	
	private static final long serialVersionUID = 8642892909397273483L;

	ClientUI ui;
	
	JTextArea logArea;
	
	JScrollPane scroll;
	
	boolean autoScroll=true;
	
	final int SCROLL_BUFFER_SIZE = 1000;
	
	LogFrame(ClientUI ui){
		super("Log");
		this.ui=ui;
		JPanel panel=(JPanel) getContentPane();
		panel.setLayout(new MigLayout("insets 5 5 5 5"));
		
		this.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
				setMaximumSize(new Dimension(getWidth(),2160));
			}
			public void windowClosing(WindowEvent e) {}
			public void windowClosed(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowActivated(WindowEvent e) {}
			public void windowDeactivated(WindowEvent e) {}
		});

		logArea=new JTextArea();
		
		scroll = new JScrollPane(logArea); 
		
		panel.add(scroll,"growx, width 240::, wrap");
		
		JPanel p3=new JPanel();
		panel.add(p3,"align center,wrap");
		p3.setLayout(new MigLayout("inset 5 5 5 5"));

		final JCheckBox cb_lock=new JCheckBox("Auto Scroll",autoScroll);
		p3.add(cb_lock,"align center");
		cb_lock.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				autoScroll=cb_lock.isSelected();
			}

		});
		
		JButton button_clear=createButton("Clear");
		p3.add(button_clear);
		button_clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logArea.setText("");
			}
		});
		
	}
	
	public void trunkTextArea(JTextArea txtWin){
	    int numLinesToTrunk = txtWin.getLineCount() - SCROLL_BUFFER_SIZE;
	    if(numLinesToTrunk > 0)
	    {
	        try
	        {
	            int posOfLastLineToTrunk = txtWin.getLineEndOffset(numLinesToTrunk - 1);
	            txtWin.replaceRange("",0,posOfLastLineToTrunk);
	        }
	        catch (BadLocationException ex) {
	            ex.printStackTrace();
	        }
	    }
	}
	
	void showText(String text){
		logArea.append(text);
		trunkTextArea(logArea);
		if(autoScroll){
			JScrollBar vertical = scroll.getVerticalScrollBar();
			vertical.setValue(vertical.getMaximum() );
		}
	}

	@Override
	public void onAppendContent(LogOutputStream los,final String text) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				logArea.append(text);
				trunkTextArea(logArea);
				if(autoScroll){
					logArea.setCaretPosition(logArea.getDocument().getLength());
				}
			}
		});
		
	}
	
	JButton createButton(String name){
		JButton button=new JButton(name);
		button.setMargin(new Insets(0,5,0,5));
		button.setFocusPainted(false);
		return button;
	}
	
	
}
