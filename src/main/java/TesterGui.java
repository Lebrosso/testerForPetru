import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TesterGui {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

      public TesterGui(){
          mainFrame = new JFrame("IBMMQ tester");
          mainFrame.setSize(400,400);
          mainFrame.setLayout(new GridLayout(3, 1));

          mainFrame.addWindowListener(new WindowAdapter() {
              public void windowClosing(WindowEvent windowEvent){
                  System.exit(0);
              }
          });

          headerLabel = new JLabel("Choose the message type", JLabel.CENTER);
          statusLabel = new JLabel("Type in the ibmmq location",JLabel.CENTER);
          statusLabel.setSize(350,100);

          JButton sendButton = new JButton("Send message");

          controlPanel = new JPanel();
          controlPanel.setLayout(new FlowLayout());

          mainFrame.add(headerLabel);
          mainFrame.add(controlPanel);
          mainFrame.add(statusLabel);
          mainFrame.add(sendButton);
          mainFrame.setVisible(true);
      }
}
