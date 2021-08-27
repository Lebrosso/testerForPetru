public class ConnectionProperties {
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

    private String hostname = "localhost";
    private String channel = "DEV.APP.SVRCONN";
    int port = 1414;
    private String userID = "app";
    private String password = "passw0rd";

}
