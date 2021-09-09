import com.ibm.mq.MQException;
import java.io.IOException;
import java.util.Hashtable;

public class TesterController {
    private MqConnector mqConnector;
    public TesterController(){
        mqConnector = new MqConnector();
    }

    public void sendMessage(String message, String managerName, String queueName, Hashtable<String, String> props) throws IOException, MQException {
        mqConnector.sendMessage(message, managerName, queueName);
    }
}
