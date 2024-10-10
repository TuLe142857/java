import java.awt.*;
import javax.swing.*;
import javax.swing.event.MenuEvent;
public class N22DCCN193_EX14 {
	public static void main(String []args){
		JFrame frame = new JFrame();

		JMenuBar bar = new JMenuBar();
		bar.add(initFileMenu());
		bar.add(new JMenu("Edit"));
		bar.add(new JMenu("Help"));

		frame.add(bar, BorderLayout.NORTH);

		//chinh kich thuoc
		Toolkit kit = Toolkit.getDefaultToolkit();
    	Dimension screenSize = kit.getScreenSize();
		frame.setSize((int)screenSize.getWidth()/3, (int)screenSize.getHeight()/3);
		frame.setLocationByPlatform(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static JMenu initFileMenu(){
		JMenu fileMenu = new JMenu("File");

		fileMenu.add(new JMenuItem("New"));
		JMenuItem open = new JMenuItem("Open");
		open.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		fileMenu.add(open);
		fileMenu.addSeparator();

		JMenuItem save = new JMenuItem("Save");
		save.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
		fileMenu.add(save);
		fileMenu.add(new JMenuItem("Save as"));
		fileMenu.addSeparator();


		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(event -> System.exit(0));
		fileMenu.add(exit);
		
		return fileMenu;
	}
}

