package classes;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Titulo extends JPanel{

	// Construtor
	
	Titulo() {
		this.setPreferredSize(new Dimension(400, 80));

		JLabel titleText = new JLabel("To do List");
		titleText.setPreferredSize(new Dimension(200, 80));
		titleText.setFont(new Font("Sans-serif", Font.BOLD, 20));
		titleText.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(titleText);
	}
}
