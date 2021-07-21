import com.ibm.mq.MQException;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQQueueManager;
import java.io.IOException;
import java.util.Hashtable;

/**
 * @author jsapieja
 * Connector class using java classes for IBMMQ
 */
public class MqConnector {
    //MQMT_   flaga decydująca jaki message idzie
    public MqConnector() throws MQException, IOException {

        Hashtable<String,String> props = new Hashtable<>();

        props.put("service port", "1414");
        props.put("host name", "127.0.0.1");

        MQMessage mqMessage = new MQMessage();
        mqMessage.writeString("trst");

        MQQueueManager mqQueueManager = new MQQueueManager("testManager", props);
        mqQueueManager.put("testQueue", mqMessage);
    }
}
