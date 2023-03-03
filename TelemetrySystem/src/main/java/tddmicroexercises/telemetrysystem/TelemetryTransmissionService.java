package tddmicroexercises.telemetrysystem;

public interface TelemetryTransmissionService {
    void send(String message);

    String receive();
}
