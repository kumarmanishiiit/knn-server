package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        // Read the port number from the command line arguments
        int port = 0;

        try {
            // Check if a port number was provided
            if (args.length < 1) {
                log.info("No port number provided. Defaulting to 6565.");
                port = 6565;
            } else {
                port = Integer.parseInt(args[0]);
            }
        } catch (NumberFormatException e) {
            log.error("Error: Port must be a number.");
            System.exit(1);
        }

        GrpcServer server1 = GrpcServer.create(port, builder -> {
            builder.addService(new KNNService());
        });

        log.info("server started. listening on port {}.", port);

        server1.start();
        server1.await();
    }
}
