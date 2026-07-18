package SOLID.SRP;

// ❌ Bad Example: Single Responsibility Principle (SRP) ভায়োলেট করছে
// এই Employee ক্লাসটি ৩টি সম্পূর্ণ আলাদা কাজ করছে:
// ১. Employee-এর ডাটা ম্যানেজ করা (Core business logic)
// ২. Database-এ সেভ করা (Database logic)
// ৩. Report প্রিন্ট করা (Presentation logic)

public class BadExample {
    
    static class Employee {
        private String name;
        private double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        // দায়িত্ব ১: Employee-এর বেসিক কাজ
        public String getName() {
            return name;
        }
        
        public double getSalary() {
            return salary;
        }

        // ❌ দায়িত্ব ২: ডাটাবেসে সেভ করা (Database Logic)
        // যদি ডাটাবেস পরিবর্তন হয় (MySQL থেকে MongoDB), তবে এই ক্লাসটি বদলাতে হবে!
        public void saveToDatabase() {
            System.out.println(name + " has been saved to the database.");
        }

        // ❌ দায়িত্ব ৩: রিপোর্ট জেনারেট করা (Presentation/Formatting Logic)
        // যদি রিপোর্টের ফরম্যাট PDF বা HTML এ পরিবর্তন করতে হয়, তবেও এই ক্লাস বদলাতে হবে!
        public void printReport() {
            System.out.println("Employee Report: Name = " + name + ", Salary = " + salary);
        }
    }

    public static void main(String[] args) {
        Employee emp = new Employee("Rahim", 50000);
        emp.printReport();
        emp.saveToDatabase();
    }
}
