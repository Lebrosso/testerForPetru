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
          statusLabel = new JLabel("Type in the ibmmq server location", JLabel.CENTER);

          String[] messageTypes = { MessageType.DATAGRAM.name(), MessageType.REPORT.name(), MessageType.REQUEST.name(), MessageType.REPLY.name(), MessageType.RESPONSE.name() };

          JComboBox petList = new JComboBox(messageTypes);
          petList.setSelectedIndex(4);

        /*  “host name” - the name of the IBM MQ server
        “service port” - the connection port
        “channel name” - the element used to transfer messages between queues
        “queue manager name” - the name of the element (it’s a logical entity) that handles the connection with the tested queue
        “queue name” - the specific queue we are testing, our target of message exchanging
        “userid” and “password” needed to open the connection  */

          statusLabel.setSize(350,100);

          JButton sendButton = new JButton("Send message");

          controlPanel = new JPanel();
          controlPanel.setLayout(new FlowLayout());

          mainFrame.add(headerLabel);
          mainFrame.add(controlPanel);
          mainFrame.add(petList);
          mainFrame.add(statusLabel);
          mainFrame.add(sendButton);
          mainFrame.setVisible(true);
      }
}

/*


 */
