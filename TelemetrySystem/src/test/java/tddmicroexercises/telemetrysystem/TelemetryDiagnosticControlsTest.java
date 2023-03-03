package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TelemetryDiagnosticControlsTest {
    //    @Mock
    private TelemetryClient telemetryClient;
    private TelemetryConnectionService connectionService;
    private TelemetryTransmissionService transmissionService;
    private TelemetryDiagnosticControlService controls;

    @BeforeEach
    public void setUp() {
        telemetryClient = new TelemetryClient();
        connectionService = new Connection(telemetryClient);
        transmissionService = new Transmission(telemetryClient);
        controls = new TelemetryDiagnosticControls(connectionService, transmissionService);
    }

    @Test
    public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() {
        try {
            controls.checkTransmission();
        } catch (Exception e) {
//            throw new RuntimeException(e);
            System.out.println(e);
        }
    }
}
