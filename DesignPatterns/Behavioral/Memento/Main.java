package DesignPatterns.Behavioral.Memento;

import java.util.Stack;

// ==========================================
// Component 2: Memento (à¦…à¦¬à¦œà§‡à¦•à§à¦Ÿà§‡à¦° à¦¸à§‡à¦­ à¦•à¦°à¦¾ à¦¸à§à¦Ÿà§‡à¦Ÿ à¦¬à¦¾ à¦¸à§à¦¨à§à¦¯à¦¾à¦ªà¦¶à¦Ÿ)
// ==========================================
// à¦à¦‡ à¦•à§à¦²à¦¾à¦¸à§‡à¦° à¦­à§à¦¯à¦¾à¦²à§ à¦à¦•à¦¬à¦¾à¦° à¦¸à§‡à¦Ÿ à¦¹à¦²à§‡ à¦†à¦° à¦ªà¦°à¦¿à¦¬à¦°à§à¦¤à¦¨ à¦•à¦°à¦¾ à¦¯à¦¾à§Ÿ à¦¨à¦¾ (Immutable)
class EditorState {
    private final String content;

    public EditorState(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

// ==========================================
// Component 1: Originator (à¦†à¦¸à¦² à¦…à¦¬à¦œà§‡à¦•à§à¦Ÿ à¦¯à¦¾à¦° à¦¸à§à¦Ÿà§‡à¦Ÿ à¦†à¦®à¦°à¦¾ à¦¸à§‡à¦­ à¦•à¦°à¦¤à§‡ à¦šà¦¾à¦‡)
// ==========================================
class TextEditor {
    private String content;

    public void type(String words) {
        this.content = words;
    }

    public String getContent() {
        return content;
    }

    // à¦¬à¦°à§à¦¤à¦®à¦¾à¦¨ à¦…à¦¬à¦¸à§à¦¥à¦¾à¦° à¦à¦•à¦Ÿà¦¿ à¦¸à§à¦¨à§à¦¯à¦¾à¦ªà¦¶à¦Ÿ (Memento) à¦¤à§ˆà¦°à¦¿ à¦•à¦°à§‡ à¦¦à¦¿à¦šà§à¦›à§‡
    public EditorState saveState() {
        return new EditorState(this.content);
    }

    // à¦à¦•à¦Ÿà¦¿ à¦ªà§à¦°à¦¨à§‹ à¦¸à§à¦¨à§à¦¯à¦¾à¦ªà¦¶à¦Ÿ (Memento) à¦¥à§‡à¦•à§‡ à¦†à¦—à§‡à¦° à¦…à¦¬à¦¸à§à¦¥à¦¾à§Ÿ à¦«à¦¿à¦°à§‡ à¦¯à¦¾à¦“à§Ÿà¦¾
    public void restoreState(EditorState state) {
        this.content = state.getContent();
    }
}

// ==========================================
// Component 3: Caretaker (à¦¯à§‡ à¦¸à§‡à¦­ à¦•à¦°à¦¾ à¦¸à§à¦Ÿà§‡à¦Ÿà¦—à§à¦²à§‹ à¦œà¦®à¦¾ à¦•à¦°à§‡ à¦°à¦¾à¦–à§‡)
// ==========================================
class History {
    // à¦¸à§à¦Ÿà§à¦¯à¦¾à¦• (Stack) à¦¬à§à¦¯à¦¬à¦¹à¦¾à¦° à¦•à¦°à¦¾ à¦¹à¦šà§à¦›à§‡ à¦¯à¦¾à¦¤à§‡ à¦¸à¦¬à¦¾à¦° à¦¶à§‡à¦·à§‡à¦° à¦¸à§‡à¦­ à¦•à¦°à¦¾ à¦¸à§à¦Ÿà§‡à¦Ÿ à¦¸à¦¬à¦¾à¦° à¦†à¦—à§‡ à¦ªà¦¾à¦“à§Ÿà¦¾ à¦¯à¦¾à§Ÿ (LIFO)
    private Stack<EditorState> historyStates = new Stack<>();

    public void push(EditorState state) {
        historyStates.push(state);
    }

    public EditorState pop() {
        if (!historyStates.isEmpty()) {
            return historyStates.pop();
        }
        return null;
    }
}

// ==========================================
// Client Code (Main Method)
// ==========================================
public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        // à§§. à¦à¦¡à¦¿à¦Ÿà¦°à§‡ à¦•à¦¿à¦›à§ à¦²à¦¿à¦–à¦²à¦¾à¦®
        editor.type("Hello");
        System.out.println("Current Content: " + editor.getContent()); // Hello

        // à§¨. à¦¬à¦°à§à¦¤à¦®à¦¾à¦¨ à¦…à¦¬à¦¸à§à¦¥à¦¾ à¦¸à§‡à¦­ à¦•à¦°à§‡ à¦°à¦¾à¦–à¦²à¦¾à¦®
        history.push(editor.saveState());

        // à§©. à¦†à¦°à¦“ à¦•à¦¿à¦›à§ à¦²à¦¿à¦–à¦²à¦¾à¦®
        editor.type("Hello World!");
        System.out.println("Current Content: " + editor.getContent()); // Hello World!

        // à§ª. à¦à¦‡ à¦…à¦¬à¦¸à§à¦¥à¦¾à¦“ à¦¸à§‡à¦­ à¦•à¦°à§‡ à¦°à¦¾à¦–à¦²à¦¾à¦®
        history.push(editor.saveState());

        // à§«. à¦à¦¬à¦¾à¦° à¦­à§à¦² à¦•à¦°à§‡ à¦¸à¦¬ à¦®à§à¦›à§‡ à¦…à¦¨à§à¦¯ à¦•à¦¿à¦›à§ à¦²à¦¿à¦–à§‡ à¦«à§‡à¦²à¦²à¦¾à¦®
        editor.type("Oops! Wrong text.");
        System.out.println("Current Content: " + editor.getContent()); // Oops! Wrong text.

        // à§¬. à¦à¦¬à¦¾à¦° Undo à¦•à¦°à¦¬à§‹ (Caretaker à¦¥à§‡à¦•à§‡ à¦†à¦—à§‡à¦° à¦¸à§à¦Ÿà§‡à¦Ÿ à¦¨à¦¿à§Ÿà§‡ à¦†à¦¸à¦¬à§‹)
        System.out.println("\n--- Performing Undo ---");
        editor.restoreState(history.pop());
        System.out.println("After 1st Undo: " + editor.getContent()); // Hello World!

        editor.restoreState(history.pop());
        System.out.println("After 2nd Undo: " + editor.getContent()); // Hello
    }
}
