package tddmicroexercises.telemetrysystem;

public class Transmission implements TelemetryTransmissionService {

    private final TelemetryClient client;

    public Transmission(TelemetryClient client) {
        this.client = client;
    }

    @Override
    public void send(String message) {
        if (message == null || "".equals(message)) {
            throw new IllegalArgumentException();
        }

        if (message == client.DIAGNOSTIC_MESSAGE) {
            // simulate a status report
            client.setDiagnosticMessageResult(
                    "LAST TX rate................ 100 MBPS\r\n"
                            + "HIGHEST TX rate............. 100 MBPS\r\n"
                            + "LAST RX rate................ 100 MBPS\r\n"
                            + "HIGHEST RX rate............. 100 MBPS\r\n"
                            + "BIT RATE.................... 100000000\r\n"
                            + "WORD LEN.................... 16\r\n"
                            + "WORD/FRAME.................. 511\r\n"
                            + "BITS/FRAME.................. 8192\r\n"
                            + "MODULATION TYPE............. PCM/FM\r\n"
                            + "TX Digital Los.............. 0.75\r\n"
                            + "RX Digital Los.............. 0.10\r\n"
                            + "BEP Test.................... -5\r\n"
                            + "Local Rtrn Count............ 00\r\n"
                            + "Remote Rtrn Count........... 00"
            );
        }
    }

    @Override
    public String receive() {
        String message;

        if (client.getDiagnosticMessageResult() == null || "".equals(client.getDiagnosticMessageResult())) {
            // simulate a received message (just for illustration - not needed for this exercise)
            message = "";
            int messageLength = client.getConnectionEventsSimulator().nextInt(50) + 60;
            for (int i = messageLength; i >= 0; --i) {
                message += (char) client.getConnectionEventsSimulator().nextInt(40) + 86;
            }

        } else {
            message = client.getDiagnosticMessageResult();
            client.setDiagnosticMessageResult("");
        }

        return message;
    }
}
