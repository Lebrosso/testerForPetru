import javax.swing.*;
import java.awt.*;

public class TesterGui {
      public TesterGui(){
          Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
          JButton sendButton=new JButton("SEND MESSAGE");
          sendButton.setBounds(50,100,95,30);

          JFrame f = new JFrame();
          f.setSize(dim.width,600);
          f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
          f.setUndecorated(true);
          f.add(sendButton);
          f.setVisible(true);
      }
}
