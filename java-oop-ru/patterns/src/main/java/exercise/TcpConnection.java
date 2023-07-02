package exercise;
import exercise.connections.Connected;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

// BEGIN
public class TcpConnection implements Connection{

    private Connection connection;
    String ip;
    int port;

    public TcpConnection(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.connection = new Disconnected(this);
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String getCurrentState() {
        return connection.getCurrentState();
    }

    @Override
    public void connect() {
        connection.connect();
    }

    @Override
    public void disconnect() {
        connection.disconnect();
    }

    @Override
    public void write(String string) {
        connection.write(string);
    }
}
// END
