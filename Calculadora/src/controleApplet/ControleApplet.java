package controleApplet;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.TextField;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class ControleApplet extends Applet   {

	public ControleApplet(String s) {
		super();
	}

//	public ControleApplet() {
//			}
	public static OperationsPanelApplet o;
	static NumberPanelApplet n;
	public static JButton[] numberButton = new JButton[10];
	public static JTextField textfield;

	public ControleApplet() {
		ControleApplet controleApplet = new ControleApplet("Testes swing ");
		ButtonHandlerApplet handler = new ButtonHandlerApplet(controleApplet);
		n = new NumberPanelApplet(controleApplet, handler, new GridLayout(6, 4));
		o = new OperationsPanelApplet(controleApplet, handler, new GridLayout(6, 1));

		controleApplet.setLayout(new BorderLayout(1,1));
		textfield = new JTextField();  
		textfield.setVisible(true);
		
		controleApplet.setSize(200, 300);
		controleApplet.setLocation(600, 200);
		controleApplet.add(textfield, BorderLayout.NORTH);
		controleApplet.add(n, BorderLayout.SOUTH);
		controleApplet.add(o, BorderLayout.EAST);
		controleApplet.setVisible(true);
		// p.setBackground(new Color(90,90,200));
		n.setVisible(true);

		controleApplet.add(n);

	}

	public void setTextfield(String s) {
		this.textfield.setText(this.textfield.getText().concat(s));
	}

	public String getTextfield() {
		return this.textfield.getText();
	}

	public void clearTextfield() {
		this.textfield.setText(" ");

	}

}
