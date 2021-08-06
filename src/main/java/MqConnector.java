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

    /*
    /  When MQ client and mq server reside in the same
    /  location a connection must run in a client mode.
    /  Using mqEnvironment.hostname turns on a client mode.
    /  There is also a bindings mode.
    */

public class MqConnector {

    public MqConnector(){
        MQEnvironment mqEnvironment = new MQEnvironment();
        mqEnvironment.hostname = "localhost";
        mqEnvironment.channel = "DEV.APP.SVRCONN";
        mqEnvironment.port = 1414;
        mqEnvironment.userID = "app";
        mqEnvironment.password = "passw0rd";
    }

    public void sendMessage(String message, Header header, String managerName, String queueName, Hashtable<String,String> props) throws IOException, MQException {
        MQQueueManager mqQueueManager = new MQQueueManager(managerName);
        MQMessage mqMessage = new MQMessage();
        mqMessage.writeString(message);
        mqQueueManager.put(queueName, mqMessage);
    }
}
