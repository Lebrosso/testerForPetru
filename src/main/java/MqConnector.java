import com.ibm.mq.MQEnvironment;
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
        MQEnvironment mqEnvironment = new MQEnvironment();
        mqEnvironment.hostname = "127.0.0.1";
        mqEnvironment.channel = "testChannel";
        mqEnvironment.port = 1414;
        // CMQC.TRANSPORT_MQSERIES_CLIENT
        // CMQC.TRANSPORT_PROPERTY
        MQQueueManager mqQueueManager = new MQQueueManager(managerName, props);
        System.out.println(mqQueueManager.getDescription());
        MQMessage mqMessage = new MQMessage();
        mqMessage.writeString(message);
        mqQueueManager.put(queueName, mqMessage);
    }
}
