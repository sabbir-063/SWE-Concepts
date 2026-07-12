package Creational.Builder;

// ১. Product (আমরা যা বানাবো) – Pizza
class Pizza {
    private String dough;
    private String sauce;
    private String cheese;
    private String topping;
    
    // Constructor private রাখবো যাতে শুধু Builder ব্যবহার করা যায়
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
// ২. Builder Interface
interface PizzaBuilder {
    void buildDough();
    void buildSauce();
    void buildCheese();
    void buildTopping();
    Pizza getResult(); // বানানো শেষ হলে প্রোডাক্ট রিটার্ন করবে
}
// ৩. Concrete Builder – Italian Pizza
class ItalianPizzaBuilder implements PizzaBuilder {
    private Pizza pizza = new Pizza();

    public void buildDough() { pizza.setDough("Thin Crust Dough"); }
    public void buildSauce() { pizza.setSauce("Tomato Sauce"); }
    public void buildCheese() { pizza.setCheese("Parmesan Cheese"); }
    public void buildTopping() { pizza.setTopping("Mushrooms & Pepperoni"); }

    public Pizza getResult() { return pizza; }
}
// ৪. Concrete Builder – American Pizza
class AmericanPizzaBuilder implements PizzaBuilder {
    private Pizza pizza = new Pizza();

    public void buildDough() { pizza.setDough("Thick Crust Dough"); }
    public void buildSauce() { pizza.setSauce("BBQ Sauce"); }
    public void buildCheese() { pizza.setCheese("Cheddar Cheese"); }
    public void buildTopping() { pizza.setTopping("Chicken & Bacon"); }

    public Pizza getResult() { return pizza; }
}
// ৫. Director (নির্দেশক) – জটিল step গুলো পরিচালনা করে
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

// ৬. Main Class
public class Main2 {
    public static void main(String[] args) {
        
        PizzaDirector director = new PizzaDirector();

        // Italian Pizza বানানো
        PizzaBuilder italianBuilder = new ItalianPizzaBuilder();
        director.constructItalianPizza(italianBuilder);
        Pizza italianPizza = italianBuilder.getResult();
        System.out.println("Italian Pizza: " + italianPizza);

        System.out.println("----------------------------");

        // American Pizza বানানো
        PizzaBuilder americanBuilder = new AmericanPizzaBuilder();
        director.constructAmericanPizza(americanBuilder);
        Pizza americanPizza = americanBuilder.getResult();
        System.out.println("American Pizza: " + americanPizza);
    }
}
