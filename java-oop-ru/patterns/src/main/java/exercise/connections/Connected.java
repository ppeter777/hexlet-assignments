package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection {

    private final TcpConnection tcpConnection;

    public Connected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public String getCurrentState() {
        return "connected";
    }

    @Override
    public void connect() {
        System.out.println("Error try to connect when connection connected");
    }

    @Override
    public void disconnect() {
        TcpConnection tcpConnection = this.tcpConnection;
        tcpConnection.setConnection(new Disconnected(tcpConnection));
        System.out.println("disconnected successfully");
    }

    @Override
    public void write(String string) {
        System.out.println("write: " + string);
    }
}
// END
