package src;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ImageView extends JFrame {

	private JPanel contentPane;
	public static JTextPane annotation;
	private static JLabel image;
	private JScrollPane scrollPane;
	private JScrollPane sPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageView frame = new ImageView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ImageView(String title,ImageIcon url)
	{
		setTitle(title);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1200, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		image = new JLabel(url);
		image.setBounds(0, 49, 1194, 572);
		scrollPane = new JScrollPane(image);
		scrollPane.setBounds(0, 49, 1194, 572);
		contentPane.add(scrollPane);
		
		annotation = new JTextPane();
		annotation.setBounds(0, 0, 1194, 48);
		annotation.setEditable(false);
		sPane=new JScrollPane(annotation);
		sPane.setBounds(0,0,1194,48);
		contentPane.add(sPane);
		
	}

	/**
	 * Create the frame.
	 */
	public ImageView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1200, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		image = new JLabel("");
		image.setBounds(0, 29, 894, 562);
		scrollPane = new JScrollPane(image);
		scrollPane.setBounds(0, 29, 1194, 662);
		contentPane.add(scrollPane);
		
		JTextPane annotation = new JTextPane();
		annotation.setBounds(0, 0, 1194, 28);
		annotation.setEditable(false);
		contentPane.add(annotation);
		
	}
}
