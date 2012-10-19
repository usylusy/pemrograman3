import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RadioButtonDemo extends JPanel implements ActionListener {
	static String birdString = "Bird";
	static String catString = "Cat";
	static String dogString = "Dog";
	static String rabbitString = "Rabbit";
	static String pigString = "Pig";
	
	JLabel picture;
	
	public RadioButtonDemo() {
		super (new BorderLayout());
		
		JRadioButton birdButton = new JRadioButton(birdString);
		birdButton.setMnemonic(KeyEvent.VK_B);
		birdButton.setActionCommand(birdString);
		birdButton.setSelected(true);
		
		JRadioButton catButton = new JRadioButton(catString);
		catButton.setMnemonic(KeyEvent.VK_C);
		catButton.setActionCommand(catString);
		
		JRadioButton dogButton = new JRadioButton(dogString);
		dogButton.setMnemonic(KeyEvent.VK_D);
		dogButton.setActionCommand(dogString);
		
		JRadioButton rabbitButton = new JRadioButton(rabbitString);
		rabbitButton.setMnemonic(KeyEvent.VK_R);
		rabbitButton.setActionCommand(rabbitString);
		
		JRadioButton pigButton = new JRadioButton(pigString);
		pigButton.setMnemonic(KeyEvent.VK_P);
		pigButton.setActionCommand(pigString);
		
		ButtonGroup group = new ButtonGroup();
		group.add(birdButton);
		group.add(catButton);
		group.add(dogButton);
		group.add(rabbitButton);
		group.add(pigButton);
		
		birdButton.addActionListener(this);
		catButton.addActionListener(this);
		dogButton.addActionListener(this);
		rabbitButton.addActionListener(this);
		pigButton.addActionListener(this);
		
		picture = new JLabel(createImageIcon("images/" + birdString + ".gif"));
		picture.setPreferredSize(new Dimension(177, 122));
		
		JPanel radioPanel = new JPanel(new GridLayout(0, 1));
		radioPanel.add(birdButton);
		radioPanel.add(catButton);
		radioPanel.add(dogButton);
		radioPanel.add(rabbitButton);
		radioPanel.add(pigButton);
		
		add(radioPanel, BorderLayout.LINE_START);
		add(picture, BorderLayout.CENTER);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}
	
	public void actionPerformed(ActionEvent e){
		picture.setIcon(createImageIcon("images/" + e.getActionCommand() + ".gif"));
	}
	
	protected static ImageIcon createImageIcon(String path){
		java.net.URL imgURL = RadioButtonDemo.class.getResource(path);
		if (imgURL !=null){
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn'n find file: " + path);
				return null;
		}
	}
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("RadioButtonDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JComponent newContentPane = new RadioButtonDemo();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				createAndShowGUI();
			}
		});
	}
}