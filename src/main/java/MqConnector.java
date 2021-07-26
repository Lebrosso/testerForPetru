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
    //MQMT - flaga decydująca jaki message idzie.
    public void sendMessage(String message, Header header, String managerName, String queueName, Hashtable<String,String> props) throws IOException, MQException {
        MQMessage mqMessage = new MQMessage();
        mqMessage.writeString(message);
        MQQueueManager mqQueueManager = new MQQueueManager(managerName, props);
        mqQueueManager.put(queueName, mqMessage);
    }
}
