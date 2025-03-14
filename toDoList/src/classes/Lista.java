package classes;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class Lista extends JPanel{

	Lista() 
	{
		GridLayout layout = new GridLayout(10, 1);
		layout.setVgap(5);
		
		this.setLayout(layout);

	}
	
	public void updateNumber()
	{
		Component[] listItems = this.getComponents();
		
		for(int i = 0; i < listItems.length; i++)
		{
			if(listItems[i] instanceof Tarefas)
			{
				((Tarefas)listItems[i]).changeIndex(i+1);
			}
		}
	}
}
 