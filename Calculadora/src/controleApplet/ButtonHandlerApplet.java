package controleApplet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonHandlerApplet implements ActionListener {
	public String operacao = " ";
	public double operando1 = 0d;
	public double operando2 = 0d;
	ControleApplet jframe_aux;

	public enum Situacao {
		INSOPERAN1, INSOPERAN2, INSOPERAC, INSIGUAL
	}

	public Situacao situacao = Situacao.INSOPERAN1;

	ButtonHandlerApplet(ControleApplet applet ) {
		jframe_aux = applet;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton botao = (JButton) e.getSource();
		String tecla = botao.getText();
		double result = 0;
		if (((tecla.compareTo("9") <= 0) && (tecla.compareTo("0") >= 0)) || (tecla.compareTo(".") == 0)) {
			// tecla NUMERICA
			if (situacao.equals(Situacao.INSIGUAL) || situacao.equals(Situacao.INSOPERAC))
				jframe_aux.clearTextfield();
			if (operacao.equals(" ") || operacao.equals("="))
				situacao = Situacao.INSOPERAN1;
			else
				situacao = Situacao.INSOPERAN2;

			// tratamento para ponto repetido
			if (!(tecla.contentEquals(".") && (jframe_aux.getTextfield().contains("."))))
				jframe_aux.setTextfield(tecla);
		} else {
			// tecla NAO NUMERICA
			if (tecla.contentEquals("=")) {
				operando2 = Double.parseDouble(jframe_aux.getTextfield().trim());
				switch (operacao) {
				case "+": {
					result = operando1 + operando2;
					break;
				}
				case "-": {
					result = operando1 - operando2;
					break;
				}
				case "*": {
					result = operando1 * operando2;
					break;
				}
				case "/": {
					result = operando1 / operando2;
					break;
				}
				}
				jframe_aux.clearTextfield();
				jframe_aux.setTextfield(Double.toString(result));
				situacao = Situacao.INSIGUAL;
			} else if (tecla.contentEquals("C")) {
				operando1 = operando2 = 0;
				situacao = Situacao.INSOPERAN1;
				operacao = " ";
				jframe_aux.clearTextfield();
			} else if (tecla.contentEquals("+/-"))  {
				String auxString = jframe_aux.getTextfield(); 
				Double auxDouble = Double.parseDouble(auxString);
				auxDouble = auxDouble * (-1);
				jframe_aux.clearTextfield();
				jframe_aux.setTextfield(Double.toString(auxDouble)); 
				} 
			
			else {
				operando1 = Double.parseDouble(jframe_aux.getTextfield().trim());
				operacao = tecla;
				situacao = Situacao.INSOPERAC;
			}
		
		}
	}
}
