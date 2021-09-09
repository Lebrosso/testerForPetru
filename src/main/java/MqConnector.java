import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.headers.internal.Header;
import java.io.IOException;

/**
 * @author jsapieja
 * Connector class using java classes for IBMMQ
 * When MQ client and mq server reside in the same
 * location a connection must run in a client mode.
 * Using mqEnvironment.hostname turns on a client mode.
 * There is also a bindings mode.
 */


public class MqConnector {

    ConnectionProperties props;

    public MqConnector(){
        props = ConnectionProperties.getInstance();
        MQEnvironment mqEnvironment = new MQEnvironment();
        mqEnvironment.hostname = props.getHostname();
        mqEnvironment.channel = props.getChannel();
        mqEnvironment.port = props.getPort();
        mqEnvironment.userID = props.getUserID();
        mqEnvironment.password = props.getPassword();

    }

    public void sendMessage(String message, String managerName, String queueName) throws IOException, MQException {
        MQQueueManager mqQueueManager = new MQQueueManager(managerName);
        MQMessage mqMessage = new MQMessage();
        mqMessage.writeString(message);
        mqQueueManager.put(queueName, mqMessage);
    }
}
