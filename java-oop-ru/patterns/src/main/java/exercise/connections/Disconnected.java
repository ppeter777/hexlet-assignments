package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection {
    private final TcpConnection tcpConnection;

    public Disconnected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public String getCurrentState() {
        return "disconnected";
    }

    @Override
    public void connect() {
//        TcpConnection tcpConnection = this.tcpConnection;
        TcpConnection tcpConnection = this.tcpConnection;
        tcpConnection.setConnection(new Connected(tcpConnection));
        System.out.println("connected successfully");
    }

    @Override
    public void disconnect() {
        System.out.println("Error try to disconnect when connection disconnected");
    }

    @Override
    public void write(String string) {
        System.out.println("Error Try to write to disconnected connection.");
    }
}
// END
