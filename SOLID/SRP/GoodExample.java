package SOLID.SRP;

// ✅ Good Example: Single Responsibility Principle (SRP) ফলো করছে
// এখন প্রতিটি ক্লাসের মাত্র একটিই দায়িত্ব (Single Responsibility) আছে।

// ১. Employee ক্লাস: এর কাজ শুধুমাত্র Employee-এর ডাটা ধরে রাখা।
class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }
}

// ২. EmployeeRepository ক্লাস: এর কাজ শুধুমাত্র ডাটাবেসে সেভ করা বা রিড করা।
// এখন ডাটাবেস পরিবর্তন হলে (যেমন MySQL থেকে MongoDB) শুধু এই ক্লাসটি বদলাতে হবে।
class EmployeeRepository {
    public void save(Employee employee) {
        // Database connection and save logic goes here
        System.out.println(employee.getName() + " has been successfully saved to the database.");
    }
}

// ৩. EmployeeReportFormatter ক্লাস: এর কাজ শুধুমাত্র রিপোর্ট জেনারেট করা।
// এখন যদি PDF বা HTML রিপোর্ট বানাতে হয়, শুধু এই ক্লাসে নতুন মেথড যোগ করতে হবে।
class EmployeeReportFormatter {
    public void printTextReport(Employee employee) {
        System.out.println("Employee Report: Name = " + employee.getName() + ", Salary = " + employee.getSalary());
    }
    
    // Future extension example:
    public void printHtmlReport(Employee employee) {
        System.out.println("<div><h1>" + employee.getName() + "</h1><p>Salary: " + employee.getSalary() + "</p></div>");
    }
}

public class GoodExample {
    public static void main(String[] args) {
        // ১. ডাটা তৈরি করা
        Employee emp = new Employee("Karim", 60000);
        
        // ২. রিপোর্ট প্রিন্ট করা (অন্য ক্লাসের মাধ্যমে)
        EmployeeReportFormatter formatter = new EmployeeReportFormatter();
        formatter.printTextReport(emp);
        formatter.printHtmlReport(emp);
        
        // ৩. ডাটাবেসে সেভ করা (আরেকটি ডেডিকেটেড ক্লাসের মাধ্যমে)
        EmployeeRepository repository = new EmployeeRepository();
        repository.save(emp);
    }
}
