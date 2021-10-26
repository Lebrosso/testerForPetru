import com.ibm.mq.MQException;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

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
    private JLabel userIdLabel;
    private JLabel userPasswordLabel;
    private TesterController testerController;
    private JLabel channelNameLabel;
    private JLabel fileChoserLabel;
    private JFileChooser fileChooser;


      public TesterGui() throws MQException, IOException {

          testerController = new TesterController();

          mainFrame = new JFrame("IBMMQ tester");
          int windowWidth;
          int windowHeight;
          mainFrame.setSize(1200,800);

          JPanel innerPanel = new JPanel();
          innerPanel.setLayout(new GridLayout(5,8));

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
          JTextField portNumber = new JTextField(5);
          portNumber.setText("1414");

          messageLabel = new JLabel("Type in the message", JLabel.CENTER);
          messageLabel.setPreferredSize(new Dimension(40,30));
          JTextField messageContent = new JTextField(20);

          JTextField serverLocation = new JTextField(15);
          String[] messageTypes = { MessageType.REQUEST.name(),MessageType.RESPONSE.name(),MessageType.REPLY.name(),MessageType.DATAGRAM.name(),MessageType.REPORT.name()};
          serverLocation.setText("localhost");

          managerNameLabel = new JLabel("Type in the manager name", JLabel.CENTER);
          managerNameLabel.setPreferredSize(new Dimension(40,30));
          JTextField managerName = new JTextField(5);
          managerName.setText("QMtest");

          channelNameLabel = new JLabel("Type in the channel name", JLabel.CENTER);
          channelNameLabel.setPreferredSize(new Dimension(40,30));
          JTextField channelName = new JTextField(5);
          channelName.setText("testChannel");

          queueNameLabel = new JLabel("Type in queue name", JLabel.CENTER);
          queueNameLabel.setPreferredSize(new Dimension(40,30));
          JTextField queueName = new JTextField(5);
          queueName.setText("testQueue");

          userIdLabel = new JLabel("Type in the user id", JLabel.CENTER);
          userIdLabel.setPreferredSize(new Dimension(40,30));
          JTextField userId = new JTextField(5);
          userId.setText("app");

          userPasswordLabel = new JLabel("Type in the user password", JLabel.CENTER);
          userPasswordLabel.setPreferredSize(new Dimension(40,30));
          JTextField userPassField = new JTextField(5);
          userPassField.setText("passw0rd");

          JComboBox messageList = new JComboBox(messageTypes);
          messageList.setPreferredSize(new Dimension(20,69));
          messageList.setSelectedIndex(0);

          fileChoserLabel = new JLabel("File picker for csv and xml files. ", JLabel.CENTER);
          fileChoserLabel.setPreferredSize(new Dimension(40,30));
          fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

         // int returnValue = fileChooser.showOpenDialog(null);
          // int returnValue = jfc.showSaveDialog(null);

       //   if (returnValue == JFileChooser.APPROVE_OPTION) {
         //     File selectedFile = fileChooser.getSelectedFile();
         //    System.out.println(selectedFile.getAbsolutePath());
        //  }

          JButton sendButton = new JButton("Send message");
          JButton fileChooserButton = new JButton("pick a file");

          sendButton.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent e){
                  try {
                      ConnectionProperties props = ConnectionProperties.getInstance();
                      props.setChannel(channelName.getText());
                      props.setHostname(serverLocation.getText());
                      props.setPassword(userPassField.getText());
                      props.setPort(Integer.parseInt(portNumber.getText()));
                      props.setUserID(userId.getText());

                      testerController.sendMessage(messageContent.getText(), managerName.getText(), queueName.getText(), null);
                  } catch (MQException mqException) {
                      mqException.printStackTrace();
                  } catch (IOException ioException) {
                      ioException.printStackTrace();
                  }
              }
          });

          fileChooserButton.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent e){
                  int returnValue = fileChooser.showOpenDialog(null);

                  if (returnValue == JFileChooser.APPROVE_OPTION) {
                      File selectedFile = fileChooser.getSelectedFile();
                      System.out.println(selectedFile.getAbsolutePath());
                  }

              }
          });

          innerPanel.add(queueName);
          innerPanel.add(queueNameLabel);

          innerPanel.add(messageTypeLabel);
          innerPanel.add(messageList);

          innerPanel.add(locationLabel);
          innerPanel.add(serverLocation);

          innerPanel.add(messageLabel);
          innerPanel.add(messageContent);

          innerPanel.add(portLabel);
          innerPanel.add(portNumber);

          innerPanel.add(managerNameLabel);
          innerPanel.add(managerName);

          innerPanel.add(queueNameLabel);
          innerPanel.add(queueName);

          innerPanel.add(userIdLabel);
          innerPanel.add(userId);

          innerPanel.add(userPasswordLabel);
          innerPanel.add(userPassField);

          innerPanel.add(queueNameLabel);
          innerPanel.add(queueName);

          innerPanel.add(channelNameLabel);
          innerPanel.add(channelName);

          innerPanel.add(fileChoserLabel);
          innerPanel.add(fileChooserButton);

          innerPanel.add(sendButton);

          mainFrame.add(innerPanel);
          mainFrame.setVisible(true);
      }
}

