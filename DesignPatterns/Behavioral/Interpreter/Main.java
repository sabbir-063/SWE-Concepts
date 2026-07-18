package DesignPatterns.Behavioral.Interpreter;

// ==========================================
// Component 1: Abstract Expression (à¦‡à¦¨à§à¦Ÿà¦¾à¦°à¦ªà§à¦°à§‡à¦Ÿà¦¾à¦°à§‡à¦° à¦°à§à¦²à¦¸)
// ==========================================
interface Expression {
    // context à¦¹à¦²à§‹ à¦¸à§‡à¦‡ à¦¬à¦¾à¦•à§à¦¯ à¦¬à¦¾ à¦¡à§‡à¦Ÿà¦¾, à¦¯à¦¾à¦•à§‡ à¦†à¦®à¦°à¦¾ à¦‡à¦¨à§à¦Ÿà¦¾à¦°à¦ªà§à¦°à§‡à¦Ÿ à¦¬à¦¾ à¦šà§‡à¦• à¦•à¦°à¦¬à§‹
    boolean interpret(String context);
}

// ==========================================
// Component 2: Terminal Expression (à¦¸à¦¬à¦šà§‡à¦¯à¦¼à§‡ à¦›à§‹à¦Ÿ à¦à¦¬à¦‚ à¦¶à§‡à¦·à§‡à¦° à¦‡à¦‰à¦¨à¦¿à¦Ÿ)
// ==========================================
// à¦à¦Ÿà¦¿ à¦šà§‡à¦• à¦•à¦°à§‡ à¦¯à§‡, à¦¨à¦¿à¦°à§à¦¦à¦¿à¦·à§à¦Ÿ à¦•à§‹à¦¨à§‹ à¦¶à¦¬à§à¦¦ à¦¬à¦¾à¦•à§à¦¯à§‡à¦° à¦­à§‡à¦¤à¦° à¦†à¦›à§‡ à¦•à¦¿ à¦¨à¦¾
class WordExpression implements Expression {
    private String data;

    public WordExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        // à¦¯à¦¦à¦¿ à¦¬à¦¾à¦•à§à¦¯à§‡à¦° à¦­à§‡à¦¤à¦° à¦†à¦®à¦¾à¦¦à§‡à¦° à¦•à¦¾à¦™à§à¦•à§à¦·à¦¿à¦¤ à¦¶à¦¬à§à¦¦à¦Ÿà¦¿ à¦¥à¦¾à¦•à§‡, à¦¤à¦¬à§‡ true à¦°à¦¿à¦Ÿà¦¾à¦°à§à¦¨ à¦•à¦°à¦¬à§‡
        return context.contains(data);
    }
}

// ==========================================
// Component 3: Non-Terminal Expression (à¦¯à¦¾à¦¦à§‡à¦° à¦­à§‡à¦¤à¦° à¦…à¦¨à§à¦¯ à¦à¦•à§à¦¸à¦ªà§à¦°à§‡à¦¶à¦¨ à¦¥à¦¾à¦•à§‡)
// ==========================================

// OR à¦à¦•à§à¦¸à¦ªà§à¦°à§‡à¦¶à¦¨ (à¦¦à§à¦Ÿà¦¿à¦° à¦¯à§‡à¦•à§‹à¦¨à§‹ à¦à¦•à¦Ÿà¦¿ true à¦¹à¦²à§‡à¦‡ true)
class OrExpression implements Expression {
    private Expression expr1;
    private Expression expr2;

    public OrExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}

// AND à¦à¦•à§à¦¸à¦ªà§à¦°à§‡à¦¶à¦¨ (à¦¦à§à¦Ÿà¦¿à¦•à§‡à¦‡ true à¦¹à¦¤à§‡ à¦¹à¦¬à§‡)
class AndExpression implements Expression {
    private Expression expr1;
    private Expression expr2;

    public AndExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) && expr2.interpret(context);
    }
}


// ==========================================
// Client Code (Main Method)
// ==========================================
public class Main {
    
    // à¦à¦•à¦Ÿà¦¿ à¦°à§à¦² à¦¤à§ˆà¦°à¦¿ à¦•à¦°à¦¾ à¦¹à¦šà§à¦›à§‡: "Java" à¦…à¦¥à¦¬à¦¾ "Spring" à¦œà¦¾à¦¨à¦²à§‡ à¦¸à§‡ à¦¬à§à¦¯à¦¾à¦•à¦à¦¨à§à¦¡ à¦¡à§‡à¦­à§‡à¦²à¦ªà¦¾à¦°
    public static Expression getBackendDeveloperRule() {
        Expression java = new WordExpression("Java");
        Expression spring = new WordExpression("Spring");
        return new OrExpression(java, spring);
    }

    // à¦†à¦°à§‡à¦•à¦Ÿà¦¿ à¦°à§à¦² à¦¤à§ˆà¦°à¦¿ à¦•à¦°à¦¾ à¦¹à¦šà§à¦›à§‡: "Java" à¦à¦¬à¦‚ "Spring" à¦¦à§à¦Ÿà§‹à¦‡ à¦œà¦¾à¦¨à¦²à§‡ à¦¸à§‡ à¦ªà§à¦°à§‹-à¦¡à§‡à¦­à§‡à¦²à¦ªà¦¾à¦°
    public static Expression getProDeveloperRule() {
        Expression java = new WordExpression("Java");
        Expression spring = new WordExpression("Spring");
        return new AndExpression(java, spring);
    }

    public static void main(String[] args) {
        
        Expression isBackend = getBackendDeveloperRule();
        Expression isPro = getProDeveloperRule();

        // à¦‡à¦‰à¦œà¦¾à¦° à§§: à¦¸à§‡ à¦¶à§à¦§à§ Java à¦œà¦¾à¦¨à§‡
        String user1Context = "I know Java and HTML";
        System.out.println("User 1 Context: " + user1Context);
        System.out.println("Is Backend Developer? " + isBackend.interpret(user1Context)); // true
        System.out.println("Is Pro Developer? " + isPro.interpret(user1Context));         // false

        System.out.println("\n-----------------------------------\n");

        // à¦‡à¦‰à¦œà¦¾à¦° à§¨: à¦¸à§‡ Java à¦à¦¬à¦‚ Spring à¦¦à§à¦Ÿà§‹à¦‡ à¦œà¦¾à¦¨à§‡
        String user2Context = "I love coding in Java and Spring framework";
        System.out.println("User 2 Context: " + user2Context);
        System.out.println("Is Backend Developer? " + isBackend.interpret(user2Context)); // true
        System.out.println("Is Pro Developer? " + isPro.interpret(user2Context));         // true
    }
}
