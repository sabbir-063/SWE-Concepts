package DesignPatterns.Creational.Builder;

// à§§. Product (à¦†à¦®à¦°à¦¾ à¦¯à¦¾ à¦¬à¦¾à¦¨à¦¾à¦¬à§‹) â€“ Pizza
class Pizza {
    private String dough;
    private String sauce;
    private String cheese;
    private String topping;
    
    // Constructor private à¦°à¦¾à¦–à¦¬à§‹ à¦¯à¦¾à¦¤à§‡ à¦¶à§à¦§à§ Builder à¦¬à§à¦¯à¦¬à¦¹à¦¾à¦° à¦•à¦°à¦¾ à¦¯à¦¾à§Ÿ
    Pizza() {}

    public void setDough(String dough) { this.dough = dough; }
    public void setSauce(String sauce) { this.sauce = sauce; }
    public void setCheese(String cheese) { this.cheese = cheese; }
    public void setTopping(String topping) { this.topping = topping; }
    
    @Override
    public String toString() {
        return "Pizza [Dough: " + dough + ", Sauce: " + sauce + ", Cheese: " + cheese + ", Topping: " + topping + "]";
    }
}
// à§¨. Builder Interface
interface PizzaBuilder {
    void buildDough();
    void buildSauce();
    void buildCheese();
    void buildTopping();
    Pizza getResult(); // à¦¬à¦¾à¦¨à¦¾à¦¨à§‹ à¦¶à§‡à¦· à¦¹à¦²à§‡ à¦ªà§à¦°à§‹à¦¡à¦¾à¦•à§à¦Ÿ à¦°à¦¿à¦Ÿà¦¾à¦°à§à¦¨ à¦•à¦°à¦¬à§‡
}
// à§©. Concrete Builder â€“ Italian Pizza
class ItalianPizzaBuilder implements PizzaBuilder {
    private Pizza pizza = new Pizza();

    public void buildDough() { pizza.setDough("Thin Crust Dough"); }
    public void buildSauce() { pizza.setSauce("Tomato Sauce"); }
    public void buildCheese() { pizza.setCheese("Parmesan Cheese"); }
    public void buildTopping() { pizza.setTopping("Mushrooms & Pepperoni"); }

    public Pizza getResult() { return pizza; }
}
// à§ª. Concrete Builder â€“ American Pizza
class AmericanPizzaBuilder implements PizzaBuilder {
    private Pizza pizza = new Pizza();

    public void buildDough() { pizza.setDough("Thick Crust Dough"); }
    public void buildSauce() { pizza.setSauce("BBQ Sauce"); }
    public void buildCheese() { pizza.setCheese("Cheddar Cheese"); }
    public void buildTopping() { pizza.setTopping("Chicken & Bacon"); }

    public Pizza getResult() { return pizza; }
}
// à§«. Director (à¦¨à¦¿à¦°à§à¦¦à§‡à¦¶à¦•) â€“ à¦œà¦Ÿà¦¿à¦² step à¦—à§à¦²à§‹ à¦ªà¦°à¦¿à¦šà¦¾à¦²à¦¨à¦¾ à¦•à¦°à§‡
class PizzaDirector {
    public void constructItalianPizza(PizzaBuilder builder) {
        builder.buildDough();
        builder.buildSauce();
        builder.buildCheese();
        builder.buildTopping();
    }
    public void constructAmericanPizza(PizzaBuilder builder) {
        builder.buildDough();
        builder.buildSauce();
        builder.buildCheese();
        builder.buildTopping();
    }
}

// à§¬. Main Class
public class Main2 {
    public static void main(String[] args) {
        
        PizzaDirector director = new PizzaDirector();

        // Italian Pizza à¦¬à¦¾à¦¨à¦¾à¦¨à§‹
        PizzaBuilder italianBuilder = new ItalianPizzaBuilder();
        director.constructItalianPizza(italianBuilder);
        Pizza italianPizza = italianBuilder.getResult();
        System.out.println("Italian Pizza: " + italianPizza);

        System.out.println("----------------------------");

        // American Pizza à¦¬à¦¾à¦¨à¦¾à¦¨à§‹
        PizzaBuilder americanBuilder = new AmericanPizzaBuilder();
        director.constructAmericanPizza(americanBuilder);
        Pizza americanPizza = americanBuilder.getResult();
        System.out.println("American Pizza: " + americanPizza);
    }
}
