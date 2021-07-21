import com.ibm.mq.MQException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

  /**
  /  @author jsapieja
  /  GUI for mq tester
 */
public class TesterGui {

    private MqConnector client;
    private JFrame mainFrame;
    private JLabel messageTypeLabel;
    private JLabel locationLabel;

      public TesterGui(){
          mainFrame = new JFrame("IBMMQ tester");
          mainFrame.setSize(400,800);
          mainFrame.setLayout(new GridLayout(3, 1));

          mainFrame.addWindowListener(new WindowAdapter() {
              public void windowClosing(WindowEvent windowEvent){
                  System.exit(0);
              }
          });

          messageTypeLabel = new JLabel("Choose the message type", JLabel.CENTER);

          locationLabel = new JLabel("Type in the ibmmq server location", JLabel.CENTER);
          locationLabel.setSize(350,100);

          JTextField serverLocation = new JTextField(20);
          String[] messageTypes = { MessageType.DATAGRAM.name(), MessageType.REPORT.name(), MessageType.REQUEST.name(), MessageType.REPLY.name(), MessageType.RESPONSE.name() };

          JComboBox messageList = new JComboBox(messageTypes);
          messageList.setSelectedIndex(4);

          JButton sendButton = new JButton("Send message");
          sendButton.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent e){
                  try {
                      new MqConnector();
                  } catch (MQException mqException) {
                      mqException.printStackTrace();
                  } catch (IOException ioException) {
                      ioException.printStackTrace();
                  }
              }
          });

          mainFrame.add(messageTypeLabel);
          mainFrame.add(messageList);

          mainFrame.add(locationLabel);
          mainFrame.add(serverLocation);

          mainFrame.add(sendButton);
          mainFrame.setVisible(true);
      }
}

/*


 */
