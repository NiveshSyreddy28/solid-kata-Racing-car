package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnosticControls implements TelemetryDiagnosticControlService {
    private final String DiagnosticChannelConnectionString = "*111#";

    private final TelemetryConnectionService connection;
    private final TelemetryTransmissionService transmission;
    private String diagnosticInfo = "";

    public TelemetryDiagnosticControls(TelemetryConnectionService connection, TelemetryTransmissionService transmission) {
        this.connection = connection;
        this.transmission = transmission;
    }

    public String getDiagnosticInfo() {
        return diagnosticInfo;
    }

    public void setDiagnosticInfo(String diagnosticInfo) {
        this.diagnosticInfo = diagnosticInfo;
    }

    public void checkTransmission() throws Exception {
        diagnosticInfo = "";


        if (establishConnection(connection)) {
            transmission.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
            diagnosticInfo = transmission.receive();
        } else {
            throw new Exception("Unable to connect.");
        }


    }

    public boolean establishConnection(TelemetryConnectionService connection) {
        connection.disconnect();

        int retryLeft = 3;
        while (connection.getOnlineStatus() == false && retryLeft > 0) {
            connection.connect(DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }

        return connection.getOnlineStatus();
    }
}
