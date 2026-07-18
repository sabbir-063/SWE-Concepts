package DesignPatterns.Creational.Builder;

// à¦®à§‚à¦² à¦•à§à¦²à¦¾à¦¸ (à¦¯à§‡à¦Ÿà¦¿ à¦†à¦®à¦°à¦¾ à¦¤à§ˆà¦°à¦¿ à¦•à¦°à¦¤à§‡ à¦šà¦¾à¦‡)
class House {
    private int floors;
    private boolean hasGarage;
    private boolean hasGarden;
    private boolean hasPool;

    // à¦•à¦¨à¦¸à§à¦Ÿà§à¦°à¦¾à¦•à§à¦Ÿà¦°à¦•à§‡ private à¦•à¦°à¦¾ à¦¹à¦²à§‹, à¦¯à¦¾à¦¤à§‡ à¦¸à¦°à¦¾à¦¸à¦°à¦¿ à¦•à§‡à¦‰ object à¦¬à¦¾à¦¨à¦¾à¦¤à§‡ à¦¨à¦¾ à¦ªà¦¾à¦°à§‡à¥¤ 
    // à¦¶à§à¦§à§ Builder à¦à¦‡ à¦•à¦¨à¦¸à§à¦Ÿà§à¦°à¦¾à¦•à§à¦Ÿà¦° à¦•à¦² à¦•à¦°à¦¤à§‡ à¦ªà¦¾à¦°à¦¬à§‡à¥¤
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

    // ---- à¦¸à§à¦Ÿà§à¦¯à¦¾à¦Ÿà¦¿à¦• à¦‡à¦¨à¦¾à¦° à¦•à§à¦²à¦¾à¦¸ à¦¹à¦¿à¦¸à§‡à¦¬à§‡ Builder (Java-à¦¤à§‡ à¦à¦Ÿà¦¿ à¦¸à§à¦Ÿà§à¦¯à¦¾à¦¨à§à¦¡à¦¾à¦°à§à¦¡ à¦ªà§à¦°à§à¦¯à¦¾à¦•à¦Ÿà¦¿à¦¸) ----
    public static class HouseBuilder {
        // Builder-à¦à¦° à¦­à§‡à¦¤à¦°à§‡à¦“ à¦¸à§‡à¦® à¦ªà§à¦°à¦ªà¦¾à¦°à§à¦Ÿà¦¿à¦—à§à¦²à§‹ à¦¥à¦¾à¦•à¦¬à§‡
        private int floors = 0; // default values
        private boolean hasGarage = false;
        private boolean hasGarden = false;
        private boolean hasPool = false;

        // à¦§à¦¾à¦ªà§‡ à¦§à¦¾à¦ªà§‡ à¦­à§à¦¯à¦¾à¦²à§ à¦¸à§‡à¦Ÿ à¦•à¦°à¦¾à¦° à¦®à§‡à¦¥à¦¡à¦—à§à¦²à§‹ (à¦à¦—à§à¦²à§‹ this à¦°à¦¿à¦Ÿà¦¾à¦°à§à¦¨ à¦•à¦°à§‡ à¦¯à¦¾à¦¤à§‡ à¦šà§‡à¦‡à¦¨ à¦•à¦°à¦¾ à¦¯à¦¾à§Ÿ)
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

        // à¦«à¦¾à¦‡à¦¨à¦¾à¦² à¦…à¦¬à¦œà§‡à¦•à§à¦Ÿ à¦¤à§ˆà¦°à¦¿ à¦•à¦°à¦¾à¦° à¦®à§‡à¦¥à¦¡
        public House build() {
            return new House(this); // à¦¬à¦°à§à¦¤à¦®à¦¾à¦¨ Builder à¦…à¦¬à¦œà§‡à¦•à§à¦Ÿà¦Ÿà¦¾à¦•à§‡ à¦ªà¦¾à¦¸ à¦•à¦°à§‡ à¦¦à§‡à¦“à§Ÿà¦¾ à¦¹à¦²à§‹
        }
    }
}

// ---- Main Method (Client Code) ----
public class Main {
    public static void main(String[] args) {
        
        // à§§. à¦à¦•à¦Ÿà¦¿ à¦²à¦¾à¦•à§à¦¸à¦¾à¦°à¦¿ à¦¬à¦¾à§œà¦¿ à¦¬à¦¾à¦¨à¦¾à¦¨à§‹ (à¦§à¦¾à¦ªà§‡ à¦§à¦¾à¦ªà§‡)
        // à¦²à¦•à§à¦·à§à¦¯ à¦•à¦°à§à¦¨ Method Chaining-à¦à¦° à¦•à¦¾à¦°à¦£à§‡ à¦•à§‹à¦¡ à¦ªà§œà¦¾ à¦•à¦¤à§‹ à¦¸à¦¹à¦œ à¦¹à§Ÿà§‡ à¦—à§‡à¦›à§‡!
        House luxuryHouse = new House.HouseBuilder()
                .setFloors(3)
                .addGarage()
                .addGarden()
                .addPool()
                .build();
                
        luxuryHouse.describe();
        // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: House with 3 floor(s), Garage: true, Garden: true, Pool: true

        // à§¨. à¦à¦•à¦Ÿà¦¿ à¦¸à¦¾à¦§à¦¾à¦°à¦£ à¦¬à¦¾à§œà¦¿ à¦¬à¦¾à¦¨à¦¾à¦¨à§‹ (à¦¶à§à¦§à§ à¦¯à§‡à¦—à§à¦²à§‹ à¦¦à¦°à¦•à¦¾à¦° à¦¸à§‡à¦—à§à¦²à§‹à¦‡ à¦•à¦² à¦•à¦°à¦²à¦¾à¦®)
        House simpleHouse = new House.HouseBuilder()
                .setFloors(1)
                .addGarage()
                // Garden à¦¬à¦¾ Pool à¦•à¦² à¦•à¦°à¦²à¦¾à¦® à¦¨à¦¾, à¦•à¦¾à¦°à¦£ à¦¸à§‡à¦—à§à¦²à§‹ à¦¦à¦°à¦•à¦¾à¦° à¦¨à§‡à¦‡
                .build();
                
        simpleHouse.describe();
        // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: House with 1 floor(s), Garage: true, Garden: false, Pool: false
    }
}
