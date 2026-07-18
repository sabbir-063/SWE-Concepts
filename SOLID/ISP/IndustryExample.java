package SOLID.ISP;

// 🏢 Industry Level Example: Cloud Storage Provider

// আমরা যখন AWS, Google Drive বা Dropbox এর মত ক্লাউড স্টোরেজ নিয়ে কাজ করি,
// তখন সব ক্লাউড প্রোভাইডার একই ফিচার দেয় না।
// যেমন: AWS S3 তে ফাইল আপলোড/ডাউনলোড করা যায়, কিন্তু সব ফাইল শেয়ার করার পাবলিক লিংক জেনারেট করা যায় না।

// ১. বেসিক ক্লাউড স্টোরেজ (সবার এটা থাকতে হবে)
interface CloudStorage {
    void uploadFile(String fileName);
    void downloadFile(String fileName);
}

// ২. লিংক শেয়ারিং ফিচার (শুধু যাদের এই ফিচার আছে, তারা এটা ইমপ্লিমেন্ট করবে)
interface SharableStorage {
    String generatePublicLink(String fileName);
}

// ৩. এডভান্সড ক্লাউড স্টোরেজ (যেমন Google Drive - এরা সব পারে)
class GoogleDrive implements CloudStorage, SharableStorage {
    @Override
    public void uploadFile(String fileName) {
        System.out.println("Uploading " + fileName + " to Google Drive ☁️");
    }

    @Override
    public void downloadFile(String fileName) {
        System.out.println("Downloading " + fileName + " from Google Drive ⬇️");
    }

    @Override
    public String generatePublicLink(String fileName) {
        return "https://drive.google.com/open?id=" + fileName;
    }
}

// ৪. বেসিক/প্রাইভেট ক্লাউড স্টোরেজ (যেমন লোকাল স্টোরেজ বা সিকিউরড সার্ভার - এরা লিংক শেয়ার দেয় না)
// এরা শুধুমাত্র CloudStorage ইন্টারফেসটি নিলো।
class SecureCompanyServer implements CloudStorage {
    @Override
    public void uploadFile(String fileName) {
        System.out.println("Uploading " + fileName + " securely to Company Server 🔒");
    }

    @Override
    public void downloadFile(String fileName) {
        System.out.println("Downloading " + fileName + " securely from Company Server ⬇️");
    }
}

public class IndustryExample {
    public static void main(String[] args) {
        GoogleDrive gDrive = new GoogleDrive();
        gDrive.uploadFile("photo.png");
        System.out.println("Link: " + gDrive.generatePublicLink("photo.png"));

        System.out.println("-----------------");

        SecureCompanyServer server = new SecureCompanyServer();
        server.uploadFile("secret-document.pdf");
        
        // এখানে server.generatePublicLink() কল করার কোনো অপশনই নেই!
        // ফলে কোনো প্রাইভেট ফাইল ভুলে পাবলিক হয়ে যাওয়ার সুযোগ থাকলো না!
    }
}
