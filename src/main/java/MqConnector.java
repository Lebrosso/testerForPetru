import com.ibm.mq.MQException;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQQueueManager;
import java.util.Hashtable;

public class MqConnector {
    //MQMT_   flaga decydująca jaki message idzie
    public MqConnector() throws MQException {
        Hashtable props = new Hashtable();
        props.put("service port", "1414");
        props.put("host name", "127.0.0.1");
        MQQueueManager man = new MQQueueManager("testManager", props);
        MQMessage mes = new MQMessage();
        man.put("testQueue", mes);
    }

  /*  WebClient client = WebClient.create();
    MQQueueManager queueManager;
    {
        try {
            queueManager = new MQQueueManager("testManager");
        } catch (MQException e) {
            e.printStackTrace();
        }
    }  */
}
