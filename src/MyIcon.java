package src;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MyIcon extends JPanel {

	public JButton titleB;
	public JLabel icon;
	
	/**
	 * Create the panel.
	 */
	public MyIcon(URL url) {
		setLayout(null);
		
		titleB = new JButton("title");
		titleB.setBounds(0, 125, 199, 23);
		add(titleB);

		ImageIcon imageIcon =new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(199, 126, Image.SCALE_DEFAULT));
		
		icon = new JLabel(imageIcon);
		icon.setBounds(0, 0, 199, 126);
		add(icon);
		
		setPreferredSize(new Dimension(210,135));
		
	}
}
