package src;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Window {

	private JFrame frmPhotoAlbum;
	public static ArrayList<DigitalAlbum> album=new ArrayList<DigitalAlbum>();
	public static DigitalAlbum temp=new DigitalAlbum();
	private static JPanel photoPane;
	private static JScrollPane sPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmPhotoAlbum.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void setAlbum(){
		photoPane.removeAll();
		photoPane.updateUI();
		for(int i=0;i<album.size();i++)
		{
			MyIcon icon =new MyIcon(album.get(i).url);
			icon.titleB.setText(album.get(i).title);
			icon.titleB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton button=(JButton)e.getSource();
					int id=(int)button.getClientProperty("id");
					ImageView photo=new ImageView(album.get(id).title,new ImageIcon(album.get(id).url));
					ImageView.annotation.setText(album.get(id).annotation);
					photo.setVisible(true);
				}
			});
			icon.titleB.putClientProperty("id", i);
			photoPane.add(icon);
		}
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frmPhotoAlbum = new JFrame();
		frmPhotoAlbum.setTitle("PHOTO ALBUM");
		frmPhotoAlbum.setResizable(false);
		frmPhotoAlbum.setBounds(100, 100, 574, 336);
		frmPhotoAlbum.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPhotoAlbum.getContentPane().setLayout(null);
		
		JLabel lblPhotos = new JLabel("PHOTOS");
		lblPhotos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhotos.setBounds(10, 11, 548, 31);
		frmPhotoAlbum.getContentPane().add(lblPhotos);
		
		photoPane = new JPanel();
		photoPane.setBounds(10, 53, 548, 209);
		
		sPane = new JScrollPane(photoPane);
		photoPane.setLayout(new BoxLayout(photoPane, BoxLayout.X_AXIS));
		sPane.setBounds(10, 53, 548, 209);
		frmPhotoAlbum.getContentPane().add(sPane);
		
		JButton btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				JFileChooser chFile=new JFileChooser(".");
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "JPG, PNG & GIF Images", "jpg","jpeg","png", "gif");
				chFile.setFileFilter(filter);
				chFile.setVisible(true);
				int status=chFile.showOpenDialog(frmPhotoAlbum);
				if(status==JFileChooser.APPROVE_OPTION)
				{
					try
					{
						Save.type=1;
						temp.url=chFile.getSelectedFile().toURL();
						Save.run();
					}
					catch(Exception exception)
					{
						System.out.println(exception);
					}
				}
			}
		});
		btnUpload.setBounds(415, 273, 143, 23);
		frmPhotoAlbum.getContentPane().add(btnUpload);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPhotoAlbum.dispose();
			}
		});
		btnClose.setBounds(10, 273, 151, 23);
		frmPhotoAlbum.getContentPane().add(btnClose);
	}
}
