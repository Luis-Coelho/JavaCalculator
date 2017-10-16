package controleApplet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class NumberPanelApplet extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JButton[] numberButton = new JButton[10];
	public static JButton bPonto = new JButton(".");
	public static JButton bMaisMenos=new JButton("+/-");
	
	public NumberPanelApplet(ControleApplet jframe, ButtonHandlerApplet handler, GridLayout b) {
		//super(b);
		this.setLayout(b);
		for (int i = 0; i < 10; i++)
		  { numberButton[i] = new JButton(String.valueOf(i));
		    this.add(numberButton[i] );
		    numberButton[i].setVisible(true);
		    numberButton[i].addActionListener(handler);   
			}
		this.add(bPonto);
		bPonto.setVisible(true);
		bPonto.addActionListener(handler);
		this.add(bMaisMenos);
		bMaisMenos.setVisible(true);
		bMaisMenos.addActionListener(handler);
 		
	}

}
