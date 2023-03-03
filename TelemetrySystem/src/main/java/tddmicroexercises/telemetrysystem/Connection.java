package tddmicroexercises.telemetrysystem;

public class Connection implements TelemetryConnectionService {
    private final TelemetryClient client;

    public Connection(TelemetryClient client) {
        this.client = client;
    }

    @Override
    public boolean getOnlineStatus() {
        return client.getOnlineStatus();
    }

    @Override
    public void connect(String telemetryServerConnectionString) {
        if (telemetryServerConnectionString == null || "".equals(telemetryServerConnectionString)) {
            throw new IllegalArgumentException();
        }

        // simulate the operation on a real modem
        boolean success = client.getConnectionEventsSimulator().nextInt(10) <= 8;

        client.setOnlineStatus(success);
    }

    @Override
    public void disconnect() {
        client.setOnlineStatus(false);
    }
}
