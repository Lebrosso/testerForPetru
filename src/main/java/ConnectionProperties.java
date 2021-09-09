public class ConnectionProperties {

    private ConnectionProperties(){};

    private String hostname;
    private String channel;
    int port;
    private String userID;
    private String password;
    public static ConnectionProperties instance;

    public static ConnectionProperties getInstance(){
      if(instance == null) {
          instance = new ConnectionProperties();
      } else {
          return instance;
      }
          return instance;
    }

    public static void setInstance(ConnectionProperties instance) {
        ConnectionProperties.instance = instance;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
