package controle;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class Calculator extends JFrame {

	// class written by  Luís Coelho -  l.r.c.coelho@gmail.com
	public Calculator(String s) {
		super();
	}

	public static OperationsPanel o;
	static NumberPanel n;
	public static JButton[] numberButton = new JButton[10];
	public static JTextField textfield;

	public static void main(String[] args) {
		Calculator controle = new Calculator("Testes swing ");
		ButtonHandler handler = new ButtonHandler(controle);
		n = new NumberPanel(controle, handler, new GridLayout(6, 4));
		o = new OperationsPanel(controle, handler, new GridLayout(6, 1));

		controle.setLayout(new BorderLayout(1,1));
		textfield = new JTextField();  
		textfield.setVisible(true);
		
		controle.setSize(200, 300);
		controle.setLocation(600, 200);
		controle.add(textfield, BorderLayout.NORTH);
		controle.add(n, BorderLayout.SOUTH);
		controle.add(o, BorderLayout.EAST);
		controle.setVisible(true);
		// p.setBackground(new Color(90,90,200));
		n.setVisible(true);

		controle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controle.add(n);

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
