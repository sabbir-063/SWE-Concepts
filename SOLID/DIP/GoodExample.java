package SOLID.DIP;

// ✅ Good Example: Dependency Inversion Principle (DIP) ফলো করছে
// আমরা একটি Abstraction (Interface) ব্যবহার করবো, যেন High-level module (UserService) 
// এবং Low-level module (Database classes) একে অপরের সাথে directly কানেক্টেড না থাকে।

// ১. Abstraction (Interface)
interface Database {
    void save(String data);
}

// ২. Low-level module 1: MySQL
class MySQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving [" + data + "] to MySQL Database 🐬");
    }
}

// ৩. Low-level module 2: MongoDB (নতুন ডাটাবেস)
class MongoDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving [" + data + "] to MongoDB 🍃");
    }
}

// ৪. High-level module: UserService
class UserService {
    // এখন UserService সরাসরি কোনো নির্দিষ্ট ডাটাবেস চিনে না, সে শুধু ইন্টারফেসটি চিনে!
    private Database database;

    // একে বলা হয় Dependency Injection (DI) - বাইরে থেকে ডিপেন্ডেন্সি পুশ করে দেওয়া
    public UserService(Database database) {
        this.database = database;
    }

    public void registerUser(String username) {
        database.save("User: " + username);
    }
}

public class GoodExample {
    public static void main(String[] args) {
        // ১. যখন MySQL দরকার...
        Database mySql = new MySQLDatabase();
        UserService serviceWithSql = new UserService(mySql);
        serviceWithSql.registerUser("Rahim");

        // ২. যখন MongoDB দরকার... (UserService এ একটি লাইনও এডিট করতে হয়নি!)
        Database mongo = new MongoDatabase();
        UserService serviceWithMongo = new UserService(mongo);
        serviceWithMongo.registerUser("Karim");
    }
}
