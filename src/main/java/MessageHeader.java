import com.ibm.mq.headers.MQDataException;
import com.ibm.mq.headers.MQHeader;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;

public class MessageHeader implements MQHeader{
    @Override
    public Object getValue(String s) {
        return null;
    }

    @Override
    public void setValue(String s, Object o) {

    }

    @Override
    public String type() {
        return null;
    }

    @Override
    public List<?> fields() {
        return null;
    }

    @Override
    public int read(DataInput dataInput) throws MQDataException, IOException {
        return 0;
    }

    @Override
    public int read(DataInput dataInput, int i, int i1) throws Exception, MQDataException, IOException {
        return 0;
    }

    @Override
    public int write(DataOutput dataOutput) throws IOException {
        return 0;
    }

    @Override
    public int write(DataOutput dataOutput, int i, int i1) throws IOException {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }
}
