package tddmicroexercises.telemetrysystem;

public interface TelemetryDiagnosticControlService {
    String getDiagnosticInfo();

    void checkTransmission() throws Exception;

    boolean establishConnection(TelemetryConnectionInterface telemetryClient);
}
