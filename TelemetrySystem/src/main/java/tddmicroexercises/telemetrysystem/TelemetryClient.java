package tddmicroexercises.telemetrysystem;

import java.util.Random;

public class TelemetryClient {
    public static final String DIAGNOSTIC_MESSAGE = "AT#UD";

    private boolean onlineStatus;
    private String diagnosticMessageResult = "";

    private final Random connectionEventsSimulator = new Random(42);

    public void setOnlineStatus(boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public String getDiagnosticMessageResult() {
        return diagnosticMessageResult;
    }

    public void setDiagnosticMessageResult(String diagnosticMessageResult) {
        this.diagnosticMessageResult = diagnosticMessageResult;
    }

    public Random getConnectionEventsSimulator() {
        return connectionEventsSimulator;
    }

    public boolean getOnlineStatus() {
        return this.onlineStatus;
    }
}

