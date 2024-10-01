import java.awt.*;
import javax.swing.*;
public class N22DCCN193_EX12 {
	public static void main(String []args){
        SimpleFrame frame = new SimpleFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class SimpleFrame extends JFrame {
    public SimpleFrame(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
    
        setSize(screenSize.width/3, screenSize.height/3);
        setLocationByPlatform(true);
        setTitle("Xin chao D22CQCN02N");

    }
} 
