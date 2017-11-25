package primeclient;

public class PrimeClient {
    
    private static String ServerIP;
    private static int ServerPort;
    private static int nPrimes;
    private static UserInterface UI;
    
    public static void main(String[] args) {
        UI = new UserInterface();
        UI.setLocationRelativeTo(null);
        UI.setTitle("Prime Server Client");
        UI.setVisible(true);
        
    }
    
    public static void setValues(String serverIP, int port, int nprimes) {
        ServerIP = serverIP;
        ServerPort = port;
        nPrimes = nprimes;
        System.out.println(ServerIP);
    }
    
}