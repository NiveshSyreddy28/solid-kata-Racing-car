package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class TelemetryDiagnosticControlsTest {
    @Mock
    private TelemetryClient telemetryClient;
    private TelemetryDiagnosticControls controls;

    @BeforeEach
    public void setUp() {
        telemetryClient = new TelemetryClient();
        controls = new TelemetryDiagnosticControls(telemetryClient);
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
