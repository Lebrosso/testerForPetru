import com.ibm.mq.MQException;
import com.ibm.mq.headers.internal.Header;

import java.io.IOException;
import java.util.Hashtable;

public class TesterController {
    private MqConnector mqConnector;
    public TesterController(){
        mqConnector = new MqConnector();
    }

    public void sendMessage(String message, Header header, String managerName, String queueName, Hashtable<String,String> props) throws IOException, MQException {
        mqConnector.sendMessage(message, header, managerName, queueName, props);
    }


}
