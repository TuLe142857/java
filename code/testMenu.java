

import java.awt.*;
import javax.swing.*;
public class testMenu {
	public static void main(String []args){
		JFrame frame = new JFrame();
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(new JMenuItem("New"));
		JMenuItem open = new JMenuItem("Open");
		open.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		fileMenu.add(open);
		fileMenu.addSeparator();
		// fileMenu.add(new JMenuItem("Open"));

		JMenuItem save= new JMenuItem("Save");
		save.setEnabled(false);
		save.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
		fileMenu.add(save);
		// fileMenu.add(new JMenuItem("Save"));
		fileMenu.add(new JMenuItem("Save as"));
		fileMenu.addSeparator();


		fileMenu.add(new JMenuItem("Exit"));

		


		bar.add(fileMenu);
		bar.add(new JMenu("Edit"));
		bar.add(new JMenu("Help"));
		JPanel panel = new JPanel();
		panel.add(bar);
		frame.add(panel, BorderLayout.NORTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}
