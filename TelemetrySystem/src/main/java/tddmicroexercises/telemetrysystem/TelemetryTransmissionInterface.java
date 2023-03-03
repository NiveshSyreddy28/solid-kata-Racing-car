package tddmicroexercises.telemetrysystem;

public interface TelemetryTransmissionInterface {
    void send(String message);

    String receive();
}
