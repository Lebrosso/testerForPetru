import com.ibm.mq.MQException;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.headers.internal.Header;

import java.io.IOException;
import java.util.Hashtable;

/**
 * @author jsapieja
 * Connector class using java classes for IBMMQ
 */
public class MqConnector {
    public void sendMessage(String message, Header header, String managerName, String queueName, Hashtable<String,String> props) throws IOException, MQException {
        MQQueueManager mqQueueManager = new MQQueueManager(managerName, props);
        MQMessage mqMessage = new MQMessage();
        mqMessage.writeString(message);
        mqQueueManager.put(queueName, mqMessage);
    }
}
