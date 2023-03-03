package tddmicroexercises.telemetrysystem;

public interface TelemetryDiagnosticControlService {

    void checkTransmission() throws Exception;

    boolean establishConnection(TelemetryConnectionService connection);
}
