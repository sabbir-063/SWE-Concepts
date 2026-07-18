package DesignPatterns.Behavioral.ChainOfResponsibility;

// ==========================================
// Component 1: Handler (à¦…à§à¦¯à¦¾à¦¬à¦¸à§à¦Ÿà§à¦°à¦¾à¦•à§à¦Ÿ à¦•à§à¦²à¦¾à¦¸)
// ==========================================
abstract class SupportHandler {
    protected SupportHandler nextHandler; // à¦šà§‡à¦‡à¦¨à§‡à¦° à¦ªà¦°à¦¬à¦°à§à¦¤à§€ à¦œà¦¨ à¦•à§‡ à¦¹à¦¬à§‡, à¦¤à¦¾à¦° à¦°à§‡à¦«à¦¾à¦°à§‡à¦¨à§à¦¸

    // à¦ªà¦°à¦¬à¦°à§à¦¤à§€ à¦¹à§à¦¯à¦¾à¦¨à§à¦¡à¦²à¦¾à¦° à¦¸à§‡à¦Ÿ à¦•à¦°à¦¾à¦° à¦®à§‡à¦¥à¦¡
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // à¦à¦‡ à¦®à§‡à¦¥à¦¡à¦Ÿà¦¿ à¦šà¦¾à¦‡à¦²à§à¦¡ à¦•à§à¦²à¦¾à¦¸à¦—à§à¦²à§‹ à¦‡à¦®à¦ªà§à¦²à¦¿à¦®à§‡à¦¨à§à¦Ÿ à¦•à¦°à¦¬à§‡
    public abstract void handleRequest(String issueSeverity);
}


// ==========================================
// Component 2: Concrete Handlers (à¦†à¦¸à¦² à¦•à¦°à§à¦®à§€ à¦•à§à¦²à¦¾à¦¸à¦—à§à¦²à§‹)
// ==========================================

// à¦²à§‡à¦­à§‡à¦² à§§: à¦¸à¦¾à¦§à¦¾à¦°à¦£ à¦¸à¦®à¦¸à§à¦¯à¦¾à¦° à¦¸à¦®à¦¾à¦§à¦¾à¦¨à¦•à¦¾à¦°à§€
class Level1Support extends SupportHandler {
    @Override
    public void handleRequest(String issueSeverity) {
        if (issueSeverity.equalsIgnoreCase("BASIC")) {
            System.out.println("Level 1 Support: I have solved this basic issue. âœ…");
        } 
        else if (nextHandler != null) {
            System.out.println("Level 1 Support: It's too complex for me. Passing to Level 2... â­ï¸");
            nextHandler.handleRequest(issueSeverity); // à¦ªà¦°à§‡à¦° à¦œà¦¨à§‡à¦° à¦•à¦¾à¦›à§‡ à¦ªà¦¾à¦ à¦¿à§Ÿà§‡ à¦¦à¦¿à¦²à§‹
        }
    }
}

// à¦²à§‡à¦­à§‡à¦² à§¨: à¦®à¦¾à¦à¦¾à¦°à¦¿ à¦¸à¦®à¦¸à§à¦¯à¦¾à¦° à¦¸à¦®à¦¾à¦§à¦¾à¦¨à¦•à¦¾à¦°à§€
class Level2Support extends SupportHandler {
    @Override
    public void handleRequest(String issueSeverity) {
        if (issueSeverity.equalsIgnoreCase("INTERMEDIATE")) {
            System.out.println("Level 2 Support (Manager): I have solved this intermediate issue. âœ…");
        } 
        else if (nextHandler != null) {
            System.out.println("Level 2 Support: It's extremely complex. Passing to Level 3... â­ï¸");
            nextHandler.handleRequest(issueSeverity); // à¦ªà¦°à§‡à¦° à¦œà¦¨à§‡à¦° à¦•à¦¾à¦›à§‡ à¦ªà¦¾à¦ à¦¿à§Ÿà§‡ à¦¦à¦¿à¦²à§‹
        }
    }
}

// à¦²à§‡à¦­à§‡à¦² à§©: à¦šà¦°à¦® à¦œà¦Ÿà¦¿à¦² à¦¸à¦®à¦¸à§à¦¯à¦¾à¦° à¦¸à¦®à¦¾à¦§à¦¾à¦¨à¦•à¦¾à¦°à§€ (Technical Expert)
class Level3Support extends SupportHandler {
    @Override
    public void handleRequest(String issueSeverity) {
        if (issueSeverity.equalsIgnoreCase("CRITICAL")) {
            System.out.println("Level 3 Support (Tech Team): We have fixed the critical issue. ðŸ› ï¸âœ…");
        } 
        else {
            // à¦à¦° à¦ªà¦°à§‡ à¦†à¦° à¦•à§‡à¦‰ à¦¨à§‡à¦‡, à¦¤à¦¾à¦‡ à¦šà§‡à¦‡à¦¨ à¦¶à§‡à¦·
            System.out.println("Level 3 Support: Sorry, this issue cannot be resolved by our team. âŒ");
        }
    }
}


// ==========================================
// Component 3: Client (Main Method)
// ==========================================
public class Main {
    public static void main(String[] args) {
        
        // à§§. à¦šà§‡à¦‡à¦¨à§‡à¦° à¦…à¦¬à¦œà§‡à¦•à§à¦Ÿà¦—à§à¦²à§‹ à¦¤à§ˆà¦°à¦¿ à¦•à¦°à¦¾
        SupportHandler level1 = new Level1Support();
        SupportHandler level2 = new Level2Support();
        SupportHandler level3 = new Level3Support();

        // à§¨. à¦šà§‡à¦‡à¦¨à¦Ÿà¦¿ à¦¸à§‡à¦Ÿà¦†à¦ª à¦•à¦°à¦¾ (à¦•à§‡ à¦•à¦¾à¦° à¦ªà¦°à§‡ à¦•à¦¾à¦œ à¦•à¦°à¦¬à§‡)
        level1.setNextHandler(level2);
        level2.setNextHandler(level3);

        // à§©. à¦°à¦¿à¦•à§‹à§Ÿà§‡à¦¸à§à¦Ÿ à¦ªà¦¾à¦ à¦¾à¦¨à§‹ (à¦•à§à¦²à¦¾à§Ÿà§‡à¦¨à§à¦Ÿ à¦¸à¦¬ à¦¸à¦®à§Ÿ à¦ªà§à¦°à¦¥à¦® à¦œà¦¨à§‡à¦° à¦•à¦¾à¦›à§‡à¦‡ à¦°à¦¿à¦•à§‹à§Ÿà§‡à¦¸à§à¦Ÿ à¦ªà¦¾à¦ à¦¾à¦¬à§‡)
        System.out.println("--- Scenario 1: BASIC Issue ---");
        level1.handleRequest("BASIC");

        System.out.println("\n--- Scenario 2: INTERMEDIATE Issue ---");
        level1.handleRequest("INTERMEDIATE");

        System.out.println("\n--- Scenario 3: CRITICAL Issue ---");
        level1.handleRequest("CRITICAL");

        System.out.println("\n--- Scenario 4: EXTRA CRITICAL Issue ---");
        level1.handleRequest("EXTRA CRITICAL");
    }
}
