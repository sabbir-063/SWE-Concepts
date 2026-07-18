package DesignPatterns.Structural.Adapter;

// ১. নতুন ইন্টারফেস (পুরো অ্যাপ্লিকেশন শুধুমাত্র এই ইন্টারফেসটিকে চিনবে)
interface NewPrinterInterface {
    void print(String text);
}

// =======================================================
// নতুন প্রিন্টার ইমপ্লিমেন্টেশন
// =======================================================

// ২. নতুন প্রিন্টার (এটি সরাসরি নতুন ইন্টারফেস ফলো করে, তাই কোনো অ্যাডাপ্টার লাগবে না)
class ModernPrinter implements NewPrinterInterface {
    @Override
    public void print(String text) {
        System.out.println("[Modern Printer 🖨️] " + text);
    }
}


// =======================================================
// পুরনো প্রিন্টার ইমপ্লিমেন্টেশন (অ্যাডাপ্টার দিয়ে)
// =======================================================

// ৩. পুরনো সিস্টেম (যেটা আমাদের কাছে আগে থেকেই আছে, কিন্তু ইন্টারফেস ভিন্ন)
class OldPrinter {
    public void printOldStyle(String text) {
        System.out.println("[Old Printer 📠] " + text);
    }
}

// ৪. Adapter ক্লাস (পুরনো প্রিন্টারকে নতুন ইন্টারফেসের ছাঁচে ফেলার জন্য)
class PrinterAdapter implements NewPrinterInterface {
    private OldPrinter oldPrinter;

    public PrinterAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    @Override
    public void print(String text) {
        oldPrinter.printOldStyle(text); // পুরনো মেথডে কনভার্ট করা হলো
    }
}


// =======================================================
// ক্লায়েন্ট কোড / মেইন মেথড
// =======================================================

public class Main {
    
    // এই মেথডটি শুধু NewPrinterInterface চেনে। 
    // তাকে আপনি নতুন প্রিন্টার দেন বা অ্যাডাপ্টার দেন, তার কিছু যায় আসে না!
    public static void printDocument(NewPrinterInterface printer, String doc) {
        printer.print(doc);
    }

    public static void main(String[] args) {
        
        // --- সিনারিও ১: নতুন প্রিন্টার ব্যবহার ---
        // যেহেতু ModernPrinter সরাসরি নতুন ইন্টারফেস ইমপ্লিমেন্ট করে, তাই সরাসরি পাস করা যায়
        NewPrinterInterface myNewPrinter = new ModernPrinter();
        System.out.println("--- Using New Printer ---");
        printDocument(myNewPrinter, "Hello from the future!");


        // --- সিনারিও ২: পুরনো প্রিন্টার ব্যবহার ---
        // পুরনো প্রিন্টার সরাসরি printDocument() এ পাস করা যাবে না, কারণ ইন্টারফেস মিলে না।
        // তাই একে অ্যাডাপ্টারের ভেতরে মুড়িয়ে তারপর পাস করতে হবে।
        OldPrinter myOldPrinter = new OldPrinter();
        NewPrinterInterface adapter = new PrinterAdapter(myOldPrinter);
        
        System.out.println("\n--- Using Old Printer via Adapter ---");
        printDocument(adapter, "Hello from the past!");
    }
}
