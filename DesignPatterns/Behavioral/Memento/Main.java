package DesignPatterns.Behavioral.Memento;

import java.util.Stack;

// ==========================================
// Component 2: Memento (অবজেক্টের সেভ করা স্টেট বা স্ন্যাপশট)
// ==========================================
// এই ক্লাসের ভ্যালু একবার সেট হলে আর পরিবর্তন করা যায় না (Immutable)
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
// Component 1: Originator (আসল অবজেক্ট যার স্টেট আমরা সেভ করতে চাই)
// ==========================================
class TextEditor {
    private String content;

    public void type(String words) {
        this.content = words;
    }

    public String getContent() {
        return content;
    }

    // বর্তমান অবস্থার একটি স্ন্যাপশট (Memento) তৈরি করে দিচ্ছে
    public EditorState saveState() {
        return new EditorState(this.content);
    }

    // একটি পুরনো স্ন্যাপশট (Memento) থেকে আগের অবস্থায় ফিরে যাওয়া
    public void restoreState(EditorState state) {
        this.content = state.getContent();
    }
}

// ==========================================
// Component 3: Caretaker (যে সেভ করা স্টেটগুলো জমা করে রাখে)
// ==========================================
class History {
    // স্ট্যাক (Stack) ব্যবহার করা হচ্ছে যাতে সবার শেষের সেভ করা স্টেট সবার আগে পাওয়া যায় (LIFO)
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

        // ১. এডিটরে কিছু লিখলাম
        editor.type("Hello");
        System.out.println("Current Content: " + editor.getContent()); // Hello

        // ২. বর্তমান অবস্থা সেভ করে রাখলাম
        history.push(editor.saveState());

        // ৩. আরও কিছু লিখলাম
        editor.type("Hello World!");
        System.out.println("Current Content: " + editor.getContent()); // Hello World!

        // ৪. এই অবস্থাও সেভ করে রাখলাম
        history.push(editor.saveState());

        // ৫. এবার ভুল করে সব মুছে অন্য কিছু লিখে ফেললাম
        editor.type("Oops! Wrong text.");
        System.out.println("Current Content: " + editor.getContent()); // Oops! Wrong text.

        // ৬. এবার Undo করবো (Caretaker থেকে আগের স্টেট নিয়ে আসবো)
        System.out.println("\n--- Performing Undo ---");
        editor.restoreState(history.pop());
        System.out.println("After 1st Undo: " + editor.getContent()); // Hello World!

        editor.restoreState(history.pop());
        System.out.println("After 2nd Undo: " + editor.getContent()); // Hello
    }
}
