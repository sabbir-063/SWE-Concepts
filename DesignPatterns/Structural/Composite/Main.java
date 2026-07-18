package DesignPatterns.Structural.Composite;

import java.util.ArrayList;
import java.util.List;

// à§§. Component (à¦•à¦®à¦¨ à¦‡à¦¨à§à¦Ÿà¦¾à¦°à¦«à§‡à¦¸)
interface FileSystemItem {
    int getSize();
    void display(String indent);
}

// à§¨. Leaf (à¦¸à¦¿à¦™à§à¦—à§‡à¦² à¦†à¦‡à¦Ÿà§‡à¦®, à¦à¦° à¦­à§‡à¦¤à¦°à§‡ à¦†à¦° à¦•à§‹à¦¨à§‹ à¦šà¦¾à¦‡à¦²à§à¦¡ à¦¨à§‡à¦‡)
class File implements FileSystemItem {
    private String name;
    private int size; // KB à¦¤à§‡

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
        System.out.println(indent + "ðŸ“„ " + name + " (" + size + "KB)");
    }
}

// à§©. Composite (à¦à¦Ÿà¦¿ à¦…à¦¨à§à¦¯à¦¾à¦¨à§à¦¯ FileSystemItem à¦•à§‡ à¦¨à¦¿à¦œà§‡à¦° à¦­à§‡à¦¤à¦° à¦§à¦¾à¦°à¦£ à¦•à¦°à¦¤à§‡ à¦ªà¦¾à¦°à§‡)
class Folder implements FileSystemItem {
    private String name;
    // à¦«à§‹à¦²à§à¦¡à¦¾à¦°à§‡à¦° à¦­à§‡à¦¤à¦° à¦«à¦¾à¦‡à¦²à¦“ à¦¥à¦¾à¦•à¦¤à§‡ à¦ªà¦¾à¦°à§‡, à¦†à¦¬à¦¾à¦° à¦«à§‹à¦²à§à¦¡à¦¾à¦°à¦“ à¦¥à¦¾à¦•à¦¤à§‡ à¦ªà¦¾à¦°à§‡
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
        // à¦°à¦¿à¦•à¦¾à¦°à§à¦¸à¦¨ (Recursion): à¦«à§‹à¦²à§à¦¡à¦¾à¦°à§‡à¦° à¦­à§‡à¦¤à¦°à§‡à¦° à¦¸à¦¬ à¦šà¦¾à¦‡à¦²à§à¦¡à§‡à¦° à¦¸à¦¾à¦‡à¦œ à¦¯à§‹à¦— à¦•à¦°à¦¾ à¦¹à¦šà§à¦›à§‡
        for (FileSystemItem child : children) {
            totalSize += child.getSize(); 
        }
        return totalSize;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "ðŸ“ " + name + " (" + getSize() + "KB total)");
        // à¦­à§‡à¦¤à¦°à§‡à¦° à¦œà¦¿à¦¨à¦¿à¦¸à¦—à§à¦²à§‹ à¦ªà§à¦°à¦¿à¦¨à§à¦Ÿ à¦•à¦°à¦¾ à¦¹à¦šà§à¦›à§‡
        for (FileSystemItem child : children) {
            child.display(indent + "  "); 
        }
    }
}

// ---- Main Method (Client Code) ----
public class Main {
    public static void main(String[] args) {
        
        // à§§. à¦•à¦¿à¦›à§ à¦¸à¦¿à¦™à§à¦—à§‡à¦² à¦«à¦¾à¦‡à¦² à¦¤à§ˆà¦°à¦¿ à¦•à¦°à¦¿
        FileSystemItem resume = new File("resume.pdf", 200);
        FileSystemItem photo = new File("photo.png", 500);
        FileSystemItem appCode = new File("app.java", 50);

        // à§¨. à¦à¦•à¦Ÿà¦¿ à¦ªà§à¦°à¦œà§‡à¦•à§à¦Ÿ à¦«à§‹à¦²à§à¦¡à¦¾à¦° à¦¬à¦¾à¦¨à¦¿à§Ÿà§‡ à¦¤à¦¾à¦¤à§‡ à¦•à§‹à¦¡ à¦«à¦¾à¦‡à¦² à¦°à¦¾à¦–à¦¿
        Folder projectsFolder = new Folder("Projects");
        projectsFolder.add(appCode);

        // à§©. à¦à¦•à¦Ÿà¦¿ à¦°à§à¦Ÿ (Root) à¦«à§‹à¦²à§à¦¡à¦¾à¦° à¦¬à¦¾à¦¨à¦¿à§Ÿà§‡ à¦¤à¦¾à¦¤à§‡ à¦¸à¦¬ à¦°à¦¾à¦–à¦¿
        Folder rootFolder = new Folder("MyDocuments");
        rootFolder.add(resume);
        rootFolder.add(photo);
        rootFolder.add(projectsFolder); // à¦«à§‹à¦²à§à¦¡à¦¾à¦°à§‡à¦° à¦­à§‡à¦¤à¦° à¦«à§‹à¦²à§à¦¡à¦¾à¦° à¦¢à§à¦•à¦¾à¦²à¦¾à¦®

        // à§ª. à¦•à§à¦²à¦¾à§Ÿà§‡à¦¨à§à¦Ÿ à¦¶à§à¦§à§ à¦œà¦¾à¦¨à§‡ display() à¦¬à¦¾ getSize() à¦•à¦² à¦•à¦°à¦¤à§‡ à¦¹à¦¬à§‡
        // à¦¸à§‡ à¦¸à¦¿à¦™à§à¦—à§‡à¦² à¦«à¦¾à¦‡à¦² à¦¨à¦¾à¦•à¦¿ à¦«à§‹à¦²à§à¦¡à¦¾à¦°, à¦¤à¦¾ à¦•à§à¦²à¦¾à§Ÿà§‡à¦¨à§à¦Ÿà§‡à¦° à¦­à¦¾à¦¬à¦¾à¦° à¦¦à¦°à¦•à¦¾à¦° à¦¨à§‡à¦‡!
        rootFolder.display("");
        
        System.out.println("\nTotal size of root folder: " + rootFolder.getSize() + "KB");
    }
}
