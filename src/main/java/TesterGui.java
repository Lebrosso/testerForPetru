import com.ibm.mq.MQException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Hashtable;

/**
  /  @author jsapieja
  /  GUI for mq tester
 */
public class TesterGui {

    private JFrame mainFrame;
    private JLabel messageTypeLabel;
    private JLabel locationLabel;
    private JLabel messageLabel;
    private JLabel portLabel;
    private JLabel managerNameLabel;
    private JLabel queueNameLabel;
    private MqConnector mqConnector;

      public TesterGui() throws MQException, IOException {

          mainFrame = new JFrame("IBMMQ tester");
          mqConnector = new MqConnector();
          mainFrame.setSize(600,400);

          JPanel innerPanel = new JPanel();
          innerPanel.setLayout(new GridLayout(6,8));

          mainFrame.addWindowListener(new WindowAdapter() {
              public void windowClosing(WindowEvent windowEvent){
                  System.exit(0);
              }
          });

          messageTypeLabel = new JLabel("Choose the message type", JLabel.CENTER);
          messageTypeLabel.setBackground(new Color(3,56,7,8));

          managerNameLabel = new JLabel("Type in the ibm manager name", JLabel.CENTER);
          managerNameLabel.setBackground(new Color(3,56,7,8));

          queueNameLabel = new JLabel("Type in a queue name", JLabel.CENTER);
          queueNameLabel.setBackground(new Color(3,56,7,8));

          locationLabel = new JLabel("Type in the ibmmq server location", JLabel.CENTER);
          locationLabel.setPreferredSize(new Dimension(40,30));

          portLabel = new JLabel("Insert port number", JLabel.CENTER);
          portLabel.setBackground(new Color(3,56,7,8));

          messageLabel = new JLabel("Type in the message", JLabel.CENTER);
          messageLabel.setPreferredSize(new Dimension(40,30));

          JTextField serverLocation = new JTextField(15);
          String[] messageTypes = { MessageType.REQUEST.name(),MessageType.RESPONSE.name(),MessageType.REPLY.name(),MessageType.DATAGRAM.name(),MessageType.REPORT.name()};

          JTextField messageContent = new JTextField(20);

          JTextField portNumber = new JTextField(5);

          JComboBox messageList = new JComboBox(messageTypes);
          messageList.setPreferredSize(new Dimension(20,69));
          messageList.setSelectedIndex(0);

          JButton sendButton = new JButton("Send message");
          sendButton.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent e){
                  try {
                      Hashtable<String,String> props = new Hashtable<>();
                      props.put("service port", portNumber.getText());
                      props.put("host name", serverLocation.getText());
                      mqConnector.sendMessage(messageContent.getText(),null,"testManager","testQueue", props);
                  } catch (MQException mqException) {
                      mqException.printStackTrace();
                  } catch (IOException ioException) {
                      ioException.printStackTrace();
                  }
              }
          });

          innerPanel.add(messageTypeLabel);
          innerPanel.add(messageList);
          innerPanel.add(locationLabel);
          innerPanel.add(serverLocation);
          innerPanel.add(messageLabel);
          innerPanel.add(messageContent);
          innerPanel.add(portLabel);
          innerPanel.add(portNumber);
          innerPanel.add(sendButton);

          mainFrame.add(innerPanel);
          mainFrame.setVisible(true);
      }
}

