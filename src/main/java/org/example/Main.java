package org.example;

public class Main {
    public static void main(String[] args) {

        // Check if a port number was provided
        if (args.length < 1) {
            System.out.println("Usage: java -jar MyServer.jar <port>");
            System.exit(1);
        }

        // Read the port number from the command line arguments
        int port = 0;
        try {
            port = Integer.parseInt(args[0]);  // Parse the first argument as an integer
        } catch (NumberFormatException e) {
            System.out.println("Error: Port must be a number.");
            System.exit(1);
        }

        GrpcServer server1 = GrpcServer.create(port, builder -> {
            builder.addService(new KNNService());
        });

        System.out.println("Starting server on port: " + port);
//
//
//        GrpcServer server2 = GrpcServer.create(7575, builder -> {
//            builder.addService(new KNNService());
//        });

        server1.start();
//        server2.start();

        server1.await();
//        server2.await();
    }

    private static class KNNServerInstanceOne {
        public static void main(String[] args) {
            GrpcServer.create(6565, builder -> {
                        builder.addService(new KNNService());
                    })
                    .start()
                    .await();
        }
    }

    private static class KNNServerInstanceTwo {
        public static void main(String[] args) {
            GrpcServer.create(7575, builder -> {
                        builder.addService(new KNNService());
                    })
                    .start()
                    .await();
        }
    }
}
