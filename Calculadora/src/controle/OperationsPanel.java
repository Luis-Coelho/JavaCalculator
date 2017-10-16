package controle;

import java.awt.GridLayout;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OperationsPanel extends JPanel {

	public static HashSet<String> teclasOpValidas = new HashSet<String>();

	public OperationsPanel(Calculator jframe, ButtonHandler handler, GridLayout g) {
		this.setLayout(g);
		JButton bMais = new JButton("+");
		teclasOpValidas.add("+");
		JButton bMenos = new JButton("-");
		teclasOpValidas.add("-");
		JButton bMult = new JButton("*");
		teclasOpValidas.add("*");
		JButton bDiv = new JButton("/");
		teclasOpValidas.add("/");
		JButton bEquals = new JButton("=");
		teclasOpValidas.add("=");
		JButton bClear = new JButton("C");
		teclasOpValidas.add("C");
		
		
		this.add(bMais);
		this.add(bMenos);
		this.add(bMult);
		this.add(bDiv);
		this.add(bEquals);
		this.add(bClear);
		
		bMais.setVisible(true);
		bMenos.setVisible(true);
		bMult.setVisible(true);
		bDiv.setVisible(true);
		bEquals.setVisible(true);
		bClear.setVisible(true);

		bMais.addActionListener(handler);
		bMenos.addActionListener(handler);
		bMult.addActionListener(handler);
		bDiv.addActionListener(handler);
		bEquals.addActionListener(handler);
		bClear.addActionListener(handler);

	}

	public static boolean OperacaoValida(String op) {
		return teclasOpValidas.contains(op);
	}

}
