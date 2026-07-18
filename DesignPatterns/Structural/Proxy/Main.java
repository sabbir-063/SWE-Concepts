package DesignPatterns.Structural.Proxy;

import java.util.ArrayList;
import java.util.List;
// à§§. Subject Interface (à¦†à¦¸à¦² à¦…à¦¬à¦œà§‡à¦•à§à¦Ÿ à¦à¦¬à¦‚ à¦ªà§à¦°à¦•à§à¦¸à¦¿â€” à¦¦à§à¦œà¦¨à¦•à§‡à¦‡ à¦à¦Ÿà¦¿ à¦®à¦¾à¦¨à¦¤à§‡ à¦¹à¦¬à§‡)
interface Internet {
    void connectTo(String serverHost);
}

// à§¨. Real Subject (à¦†à¦¸à¦² à¦‡à¦¨à§à¦Ÿà¦¾à¦°à¦¨à§‡à¦Ÿ à¦•à¦¾à¦¨à§‡à¦•à¦¶à¦¨, à¦¯à¦¾ à¦¸à¦°à¦¾à¦¸à¦°à¦¿ à¦¸à¦¾à¦‡à¦Ÿà§‡ à¦•à¦¾à¦¨à§‡à¦•à§à¦Ÿ à¦•à¦°à§‡)
class RealInternet implements Internet {
    @Override
    public void connectTo(String serverHost) {
        System.out.println("Connecting to " + serverHost + " ðŸŒ");
    }
}

// à§©. Proxy Subject (à¦ªà¦¾à¦¹à¦¾à¦°à¦¾à¦¦à¦¾à¦°, à¦¯à§‡ à¦†à¦¸à¦² à¦‡à¦¨à§à¦Ÿà¦¾à¦°à¦¨à§‡à¦Ÿà§‡à¦° à¦†à¦—à§‡ à¦šà§‡à¦• à¦•à¦°à¦¬à§‡)
class ProxyInternet implements Internet {
    private RealInternet realInternet;
    // à¦¬à§à¦²à¦• à¦•à¦°à¦¾ à¦¸à¦¾à¦‡à¦Ÿà§‡à¦° à¦²à¦¿à¦¸à§à¦Ÿ
    private static List<String> bannedSites = new ArrayList<>();

    static {
        bannedSites.add("facebook.com");
        bannedSites.add("youtube.com");
        bannedSites.add("tiktok.com");
    }

    @Override
    public void connectTo(String serverHost) {
        // à¦ªà§à¦°à¦•à§à¦¸à¦¿à¦° à¦¨à¦¿à¦œà¦¸à§à¦¬ à¦²à¦œà¦¿à¦• (Access Control)
        if (bannedSites.contains(serverHost.toLowerCase())) {
            System.out.println("Access Denied âŒ: Cannot connect to " + serverHost);
            return; // à¦°à¦¿à¦•à§‹à§Ÿà§‡à¦¸à§à¦Ÿ à¦à¦–à¦¾à¦¨à§‡à¦‡ à¦¬à§à¦²à¦• à¦•à¦°à§‡ à¦¦à¦¿à¦²à§‹!
        }

        // à¦¯à¦¦à¦¿ à¦¸à¦¬ à¦ à¦¿à¦• à¦¥à¦¾à¦•à§‡, à¦¤à¦¬à§‡ à¦†à¦¸à¦² à¦‡à¦¨à§à¦Ÿà¦¾à¦°à¦¨à§‡à¦Ÿà§‡à¦° à¦…à¦¬à¦œà§‡à¦•à§à¦Ÿ à¦¤à§ˆà¦°à¦¿ à¦•à¦°à§‡ à¦¤à¦¾à¦•à§‡ à¦•à¦² à¦•à¦°à¦¾
        if (realInternet == null) {
            realInternet = new RealInternet(); 
        }
        
        // à¦†à¦¸à¦² à¦…à¦¬à¦œà§‡à¦•à§à¦Ÿà¦•à§‡ à¦•à¦¾à¦œà¦Ÿà¦¾ à¦¬à§à¦à¦¿à§Ÿà§‡ à¦¦à§‡à¦“à§Ÿà¦¾ (Delegation)
        realInternet.connectTo(serverHost);
    }
}

// ---- Main Method (Client Code) ----
public class Main {
    public static void main(String[] args) {
        
        // à¦•à§à¦²à¦¾à§Ÿà§‡à¦¨à§à¦Ÿ à¦®à¦¨à§‡ à¦•à¦°à¦›à§‡ à¦¸à§‡ à¦†à¦¸à¦² à¦‡à¦¨à§à¦Ÿà¦¾à¦°à¦¨à§‡à¦Ÿ à¦¬à§à¦¯à¦¬à¦¹à¦¾à¦° à¦•à¦°à¦›à§‡
        // à¦•à¦¿à¦¨à§à¦¤à§ à¦†à¦®à¦°à¦¾ à¦¤à¦¾à¦•à§‡ à¦ªà§à¦°à¦•à§à¦¸à¦¿ à¦‡à¦¨à§à¦Ÿà¦¾à¦°à¦¨à§‡à¦Ÿ à¦§à¦°à¦¿à§Ÿà§‡ à¦¦à¦¿à§Ÿà§‡à¦›à¦¿!
        Internet internet = new ProxyInternet();

        try {
            internet.connectTo("google.com");      // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: Connecting to google.com ðŸŒ
            internet.connectTo("wikipedia.org");   // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: Connecting to wikipedia.org ðŸŒ
            
            // à¦à¦¬à¦¾à¦° à¦¬à§à¦²à¦•à¦¡ à¦¸à¦¾à¦‡à¦Ÿà§‡ à¦¯à¦¾à¦“à§Ÿà¦¾à¦° à¦šà§‡à¦·à§à¦Ÿà¦¾
            internet.connectTo("facebook.com");    // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: Access Denied âŒ: Cannot connect to facebook.com
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
