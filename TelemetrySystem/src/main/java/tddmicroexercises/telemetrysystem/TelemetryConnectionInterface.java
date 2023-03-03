package tddmicroexercises.telemetrysystem;

public interface TelemetryConnectionInterface {
    boolean getOnlineStatus();

    void connect(String telemetryServerConnectionString);

    void disconnect();


}
