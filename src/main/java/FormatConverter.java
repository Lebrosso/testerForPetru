import org.milyn.Smooks;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;

public class FormatConverter {

     Smooks smooks;
     public void convertFormat(){
         try {
             smooks = new Smooks("/smooks/echo-example.xml");
             smooks.filterSource(new StreamSource());
         } catch (IOException e) {
             e.printStackTrace();
         } catch (SAXException e) {
             e.printStackTrace();
         }
     }
}
