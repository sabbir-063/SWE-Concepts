package DesignPatterns.Behavioral.Interpreter;

// ==========================================
// Component 1: Abstract Expression (ইন্টারপ্রেটারের রুলস)
// ==========================================
interface Expression {
    // context হলো সেই বাক্য বা ডেটা, যাকে আমরা ইন্টারপ্রেট বা চেক করবো
    boolean interpret(String context);
}

// ==========================================
// Component 2: Terminal Expression (সবচেয়ে ছোট এবং শেষের ইউনিট)
// ==========================================
// এটি চেক করে যে, নির্দিষ্ট কোনো শব্দ বাক্যের ভেতর আছে কি না
class WordExpression implements Expression {
    private String data;

    public WordExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        // যদি বাক্যের ভেতর আমাদের কাঙ্ক্ষিত শব্দটি থাকে, তবে true রিটার্ন করবে
        return context.contains(data);
    }
}

// ==========================================
// Component 3: Non-Terminal Expression (যাদের ভেতর অন্য এক্সপ্রেশন থাকে)
// ==========================================

// OR এক্সপ্রেশন (দুটির যেকোনো একটি true হলেই true)
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

// AND এক্সপ্রেশন (দুটিকেই true হতে হবে)
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
    
    // একটি রুল তৈরি করা হচ্ছে: "Java" অথবা "Spring" জানলে সে ব্যাকএন্ড ডেভেলপার
    public static Expression getBackendDeveloperRule() {
        Expression java = new WordExpression("Java");
        Expression spring = new WordExpression("Spring");
        return new OrExpression(java, spring);
    }

    // আরেকটি রুল তৈরি করা হচ্ছে: "Java" এবং "Spring" দুটোই জানলে সে প্রো-ডেভেলপার
    public static Expression getProDeveloperRule() {
        Expression java = new WordExpression("Java");
        Expression spring = new WordExpression("Spring");
        return new AndExpression(java, spring);
    }

    public static void main(String[] args) {
        
        Expression isBackend = getBackendDeveloperRule();
        Expression isPro = getProDeveloperRule();

        // ইউজার ১: সে শুধু Java জানে
        String user1Context = "I know Java and HTML";
        System.out.println("User 1 Context: " + user1Context);
        System.out.println("Is Backend Developer? " + isBackend.interpret(user1Context)); // true
        System.out.println("Is Pro Developer? " + isPro.interpret(user1Context));         // false

        System.out.println("\n-----------------------------------\n");

        // ইউজার ২: সে Java এবং Spring দুটোই জানে
        String user2Context = "I love coding in Java and Spring framework";
        System.out.println("User 2 Context: " + user2Context);
        System.out.println("Is Backend Developer? " + isBackend.interpret(user2Context)); // true
        System.out.println("Is Pro Developer? " + isPro.interpret(user2Context));         // true
    }
}
