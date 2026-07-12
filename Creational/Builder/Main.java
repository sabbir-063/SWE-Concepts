package Creational.Builder;

// মূল ক্লাস (যেটি আমরা তৈরি করতে চাই)
class House {
    private int floors;
    private boolean hasGarage;
    private boolean hasGarden;
    private boolean hasPool;

    // কনস্ট্রাক্টরকে private করা হলো, যাতে সরাসরি কেউ object বানাতে না পারে। 
    // শুধু Builder এই কনস্ট্রাক্টর কল করতে পারবে।
    private House(HouseBuilder builder) {
        this.floors = builder.floors;
        this.hasGarage = builder.hasGarage;
        this.hasGarden = builder.hasGarden;
        this.hasPool = builder.hasPool;
    }

    public void describe() {
        System.out.println("House with " + floors + " floor(s), " +
                "Garage: " + hasGarage + ", Garden: " + hasGarden + ", Pool: " + hasPool);
    }

    // ---- স্ট্যাটিক ইনার ক্লাস হিসেবে Builder (Java-তে এটি স্ট্যান্ডার্ড প্র্যাকটিস) ----
    public static class HouseBuilder {
        // Builder-এর ভেতরেও সেম প্রপার্টিগুলো থাকবে
        private int floors = 0; // default values
        private boolean hasGarage = false;
        private boolean hasGarden = false;
        private boolean hasPool = false;

        // ধাপে ধাপে ভ্যালু সেট করার মেথডগুলো (এগুলো this রিটার্ন করে যাতে চেইন করা যায়)
        public HouseBuilder setFloors(int floors) {
            this.floors = floors;
            return this;
        }

        public HouseBuilder addGarage() {
            this.hasGarage = true;
            return this;
        }

        public HouseBuilder addGarden() {
            this.hasGarden = true;
            return this;
        }

        public HouseBuilder addPool() {
            this.hasPool = true;
            return this;
        }

        // ফাইনাল অবজেক্ট তৈরি করার মেথড
        public House build() {
            return new House(this); // বর্তমান Builder অবজেক্টটাকে পাস করে দেওয়া হলো
        }
    }
}

// ---- Main Method (Client Code) ----
public class Main {
    public static void main(String[] args) {
        
        // ১. একটি লাক্সারি বাড়ি বানানো (ধাপে ধাপে)
        // লক্ষ্য করুন Method Chaining-এর কারণে কোড পড়া কতো সহজ হয়ে গেছে!
        House luxuryHouse = new House.HouseBuilder()
                .setFloors(3)
                .addGarage()
                .addGarden()
                .addPool()
                .build();
                
        luxuryHouse.describe();
        // আউটপুট: House with 3 floor(s), Garage: true, Garden: true, Pool: true

        // ২. একটি সাধারণ বাড়ি বানানো (শুধু যেগুলো দরকার সেগুলোই কল করলাম)
        House simpleHouse = new House.HouseBuilder()
                .setFloors(1)
                .addGarage()
                // Garden বা Pool কল করলাম না, কারণ সেগুলো দরকার নেই
                .build();
                
        simpleHouse.describe();
        // আউটপুট: House with 1 floor(s), Garage: true, Garden: false, Pool: false
    }
}