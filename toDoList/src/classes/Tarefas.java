package classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tarefas extends JPanel{
	
	private JLabel index;
	private JTextField nomeDaTarefa;
	private JButton concluido;
	
	private boolean verificado;
	// Construtor
	
	Tarefas() 
	{
		this.setPreferredSize(new Dimension(40, 20));
		this.setBackground(Color.red);
		
		this.setLayout(new BorderLayout());
		
		verificado = false;
		
		index = new JLabel("");
		index.setPreferredSize(new Dimension(20, 20));
		index.setHorizontalAlignment(JLabel.CENTER);
		this.add(index, BorderLayout.WEST);
		
		nomeDaTarefa = new JTextField("Sua tarefa");
		nomeDaTarefa.setBorder(BorderFactory.createEmptyBorder());
		nomeDaTarefa.setBackground(Color.red);
		
		this.add(nomeDaTarefa, BorderLayout.CENTER);
		
		concluido = new JButton("Feito");
		concluido.setPreferredSize(new Dimension(40, 20));
		concluido.setBorder(BorderFactory.createEmptyBorder());
		
		this.add(concluido, BorderLayout.EAST);
	}
	
	public JButton getConcluido()
	{
		return concluido;
	}
	
	public void changeIndex(int num)
	{
		this.index.setText(num + "");
		this.revalidate();
	}
	
	public void mudaStatus()
	{
		this.setBackground(Color.green);
		nomeDaTarefa.setBackground(Color.green);
		verificado = true;
	}
	
	public boolean isVerificado() {
		return verificado;
	}
	
}
