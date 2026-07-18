package DesignPatterns.Structural.Composite;

import java.util.ArrayList;
import java.util.List;

// ১. Component (কমন ইন্টারফেস)
interface FileSystemItem {
    int getSize();
    void display(String indent);
}

// ২. Leaf (সিঙ্গেল আইটেম, এর ভেতরে আর কোনো চাইল্ড নেই)
class File implements FileSystemItem {
    private String name;
    private int size; // KB তে

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "📄 " + name + " (" + size + "KB)");
    }
}

// ৩. Composite (এটি অন্যান্য FileSystemItem কে নিজের ভেতর ধারণ করতে পারে)
class Folder implements FileSystemItem {
    private String name;
    // ফোল্ডারের ভেতর ফাইলও থাকতে পারে, আবার ফোল্ডারও থাকতে পারে
    private List<FileSystemItem> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystemItem item) {
        children.add(item);
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        // রিকার্সন (Recursion): ফোল্ডারের ভেতরের সব চাইল্ডের সাইজ যোগ করা হচ্ছে
        for (FileSystemItem child : children) {
            totalSize += child.getSize(); 
        }
        return totalSize;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "📁 " + name + " (" + getSize() + "KB total)");
        // ভেতরের জিনিসগুলো প্রিন্ট করা হচ্ছে
        for (FileSystemItem child : children) {
            child.display(indent + "  "); 
        }
    }
}

// ---- Main Method (Client Code) ----
public class Main {
    public static void main(String[] args) {
        
        // ১. কিছু সিঙ্গেল ফাইল তৈরি করি
        FileSystemItem resume = new File("resume.pdf", 200);
        FileSystemItem photo = new File("photo.png", 500);
        FileSystemItem appCode = new File("app.java", 50);

        // ২. একটি প্রজেক্ট ফোল্ডার বানিয়ে তাতে কোড ফাইল রাখি
        Folder projectsFolder = new Folder("Projects");
        projectsFolder.add(appCode);

        // ৩. একটি রুট (Root) ফোল্ডার বানিয়ে তাতে সব রাখি
        Folder rootFolder = new Folder("MyDocuments");
        rootFolder.add(resume);
        rootFolder.add(photo);
        rootFolder.add(projectsFolder); // ফোল্ডারের ভেতর ফোল্ডার ঢুকালাম

        // ৪. ক্লায়েন্ট শুধু জানে display() বা getSize() কল করতে হবে
        // সে সিঙ্গেল ফাইল নাকি ফোল্ডার, তা ক্লায়েন্টের ভাবার দরকার নেই!
        rootFolder.display("");
        
        System.out.println("\nTotal size of root folder: " + rootFolder.getSize() + "KB");
    }
}
