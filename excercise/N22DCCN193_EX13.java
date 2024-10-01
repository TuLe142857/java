import java.awt.*;
import javax.swing.*;

public class N22DCCN193_EX13{
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

      JButton btnA = new JButton("btnA"); 
      JButton btnB = new JButton("btnB");
      buttonPanel = new JPanel();
      buttonPanel.add(btnA); 
      buttonPanel.add(btnB);  
      add(buttonPanel);

      
      btnA.addActionListener(event -> setTitle("btnA Frame"));
      btnB.addActionListener(event -> setTitle("btnB Frame"));
    }
    
 }
 