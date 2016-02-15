package src;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Save extends JDialog {

	private final static JPanel contentPanel = new JPanel();
	private static JTextField textField;
	private static Save dialog;
	private static JLabel lblTitleForThe;
	private static JTextPane textPane;
	private static JScrollPane scrollPane;
	public static int type=1;
	
	/**
	 * Launch the application.
	 */
	public static void run() {
		try {
			dialog = new Save();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			if(type==2){
				dialog.setTitle("Annotation ..");
				lblTitleForThe.setText("Enter annotation: ");
				textPane = new JTextPane();
				textPane.setBounds(190, 11, 244, 102);
				scrollPane = new JScrollPane(textPane);
				scrollPane.setBounds(190, 11, 244, 102);
				contentPanel.add(scrollPane);
			}
			else{
				{
					textField = new JTextField();
					textField.setBounds(165, 58, 269, 27);
					contentPanel.add(textField);
					textField.setColumns(10);
				}
			}
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Save() {
		setTitle("SAVE AS ..");
		setResizable(false);
		setBounds(100, 100, 450, 186);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblTitleForThe = new JLabel("Title for the Image File:");
			lblTitleForThe.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitleForThe.setBounds(10, 50, 170, 38);
			contentPanel.add(lblTitleForThe);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(type==2){
							Window.temp.annotation=textPane.getText();
							textPane.setText("");
							contentPanel.removeAll();
							contentPanel.updateUI();
							DigitalAlbum temp1=new DigitalAlbum(Window.temp);
							Window.album.add(temp1);
							dialog.dispose();
							Window.setAlbum();
						}
						else{
							Window.temp.title=textField.getText();
							textField.setText("");
							dialog.dispose();
							type=2;
							contentPanel.removeAll();
							contentPanel.updateUI();
							run();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
