import java.awt.*;
import javax.swing.*;

public class Main{
   public static void main(String []args){
      ButtonFrame frame = new ButtonFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}


class ButtonFrame extends JFrame{
   
    private JPanel buttonPanel;
    public ButtonFrame(){      
      Toolkit kit = Toolkit.getDefaultToolkit();
      Dimension screenSize = kit.getScreenSize();
    
      setSize(screenSize.width/3, screenSize.height/3);
      setLocationByPlatform(true);
      setTitle("Button Frame");

      JButton yellowButton = new JButton("a"); 
      JButton blueButton = new JButton("b");
      buttonPanel = new JPanel();
      buttonPanel.add(yellowButton); 
      buttonPanel.add(blueButton);  
      add(buttonPanel);  // add panel to frame
      
      // associate actions with buttons
      yellowButton.addActionListener(event -> setTitle("A"));
      blueButton.addActionListener(event -> setTitle("B"));
    }
    
 }
 