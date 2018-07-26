package pl.edu.agh.wiet.sr.banking.client;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 10000;
        try {
            if(args.length >=2) {
                host = args[0];
                port = Integer.parseInt(args[1]);
            } else {
                throw new IllegalArgumentException("No host/port provided");
            }
        } catch(IllegalArgumentException e) {
            System.err.println("Cannot parse host/port: " + e.getMessage());
            System.out.println("Using default values...");
        }
        CommandLineInteractiveClient client = new CommandLineInteractiveClient(args, host, port);
        client.run();
    }
}
