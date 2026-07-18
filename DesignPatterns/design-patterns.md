# 23 Design Patterns — Complete Interview Guide
## (Gang of Four / GoF Design Patterns) — English + বাংলা মিশ্রিত ব্যাখ্যা

> **এই ডকুমেন্ট কেন বানানো হয়েছে:** Interview এ English এ confidently বলতে পারবেন, আর নিজে পড়ার সময় বাংলায় বুঝতে পারবেন। প্রতিটা pattern এ আছে — definition (English + বাংলা), JavaScript class example (copy-paste করে চালানো যায়), deep explanation, 2টা simple example + 2টা industry-level example, pros, cons, when to use, when NOT to use, এবং extra interview tips।

---

## 📚 Table of Contents

### 1️⃣ Creational Patterns (কিভাবে object বানানো হবে তার pattern)
1. [Singleton](#1-singleton-pattern)
2. [Factory Method](#2-factory-method-pattern)
3. [Abstract Factory](#3-abstract-factory-pattern)
4. [Builder](#4-builder-pattern)
5. [Prototype](#5-prototype-pattern)

### 2️⃣ Structural Patterns (Object/Class কে কিভাবে compose করবেন তার pattern)
6. [Adapter](#6-adapter-pattern)
7. [Bridge](#7-bridge-pattern)
8. [Composite](#8-composite-pattern)
9. [Decorator](#9-decorator-pattern)
10. [Facade](#10-facade-pattern)
11. [Flyweight](#11-flyweight-pattern)
12. [Proxy](#12-proxy-pattern)

### 3️⃣ Behavioral Patterns (Object গুলোর মধ্যে communication/responsibility এর pattern)
13. [Chain of Responsibility](#13-chain-of-responsibility-pattern)
14. [Command](#14-command-pattern)
15. [Iterator](#15-iterator-pattern)
16. [Mediator](#16-mediator-pattern)
17. [Memento](#17-memento-pattern)
18. [Observer](#18-observer-pattern)
19. [State](#19-state-pattern)
20. [Strategy](#20-strategy-pattern)
21. [Template Method](#21-template-method-pattern)
22. [Visitor](#22-visitor-pattern)
23. [Interpreter](#23-interpreter-pattern)

---

## 🎯 Quick Summary Table (Interview এর আগে এক নজরে দেখার জন্য)

| # | Pattern | Category | এক লাইনে মূল কথা |
|---|---------|----------|-------------------|
| 1 | Singleton | Creational | একটাই instance, পুরো app জুড়ে শেয়ার হবে |
| 2 | Factory Method | Creational | Object বানানোর কাজ subclass এর হাতে ছেড়ে দেওয়া |
| 3 | Abstract Factory | Creational | Family of related objects বানানোর factory |
| 4 | Builder | Creational | জটিল object কে step-by-step বানানো |
| 5 | Prototype | Creational | নতুন বানানোর বদলে existing object clone করা |
| 6 | Adapter | Structural | দুই incompatible interface কে compatible বানানো |
| 7 | Bridge | Structural | Abstraction আর Implementation কে আলাদা করা |
| 8 | Composite | Structural | Tree structure এ individual ও group একইভাবে treat করা |
| 9 | Decorator | Structural | Object এ dynamically নতুন behavior যোগ করা |
| 10 | Facade | Structural | জটিল system এর জন্য সহজ interface |
| 11 | Flyweight | Structural | Memory বাঁচাতে shared object reuse করা |
| 12 | Proxy | Structural | একটা object এর substitute/placeholder রাখা |
| 13 | Chain of Responsibility | Behavioral | Request কে handler chain এর মধ্য দিয়ে পাস করা |
| 14 | Command | Behavioral | Request কে object বানিয়ে ফেলা |
| 15 | Iterator | Behavioral | Collection এর ভেতরের structure না জেনেও loop চালানো |
| 16 | Mediator | Behavioral | Objects এর মধ্যে communication কে centralize করা |
| 17 | Memento | Behavioral | Object এর আগের state এ ফিরে যাওয়ার ক্ষমতা |
| 18 | Observer | Behavioral | একজন বদলালে সবাইকে notify করা (pub-sub) |
| 19 | State | Behavioral | Object এর behavior তার internal state অনুযায়ী বদলানো |
| 20 | Strategy | Behavioral | Algorithm কে runtime এ swap করার ক্ষমতা |
| 21 | Template Method | Behavioral | Algorithm এর skeleton fix, কিছু step subclass এ override |
| 22 | Visitor | Behavioral | Object structure না বদলে নতুন operation যোগ করা |
| 23 | Interpreter | Behavioral | একটা language এর grammar রুল কে interpret করা |

---

# 🏗️ CATEGORY 1: CREATIONAL PATTERNS
> **Creational patterns** deal with object creation mechanisms. লক্ষ্য হলো — object তৈরির process টাকে flexible করা, যাতে code কম coupled থাকে আর situation অনুযায়ী সঠিক object বানানো যায়।

---

## 1. Singleton Pattern

### 📖 Definition
**English:** Singleton pattern ensures that a class has **only one instance** throughout the application's lifecycle, and provides a **global access point** to that instance.

**বাংলা:** Singleton pattern গ্যারান্টি দেয় যে একটা class এর **মাত্র একটাই instance (object)** পুরো application এ থাকবে, এবং সেই instance এ যেকোনো জায়গা থেকে access করা যাবে। যেমন — আপনার বাসায় একটাই WiFi router আছে, সবাই সেই একটা router ব্যবহার করছে, নতুন router বানানো হচ্ছে না।

### 💻 JavaScript Implementation

```javascript
class Singleton {
  static #instance = null; // private static field — instance store করার জন্য

  constructor(data) {
    if (Singleton.#instance) {
      // যদি আগেই instance বানানো থাকে, পুরনোটাই return করো
      throw new Error("Use Singleton.getInstance() instead of new Singleton()");
    }
    this.data = data;
    this.createdAt = new Date();
  }

  static getInstance(data) {
    if (!Singleton.#instance) {
      Singleton.#instance = new Singleton(data);
      console.log("New instance created!");
    } else {
      console.log("Returning existing instance.");
    }
    return Singleton.#instance;
  }

  getData() {
    return this.data;
  }
}

// ---- USAGE / TEST ----
const obj1 = Singleton.getInstance("First Data");
const obj2 = Singleton.getInstance("Second Data"); // এটা ignore হবে, পুরনো instance ই ফেরত আসবে

console.log(obj1.getData()); // "First Data"
console.log(obj2.getData()); // "First Data" (same instance!)
console.log(obj1 === obj2);  // true — দুটোই same object
```

### 🔍 Deep Explanation
**বাংলা ব্যাখ্যা:** এখানে `#instance` নামে একটা private static field রাখা হয়েছে যেটা class এর সব instance এর মধ্যে শেয়ার্ড (class level এ একবারই থাকে, object level এ না)। `getInstance()` static method চেক করে — instance আগে থেকে আছে কিনা। থাকলে পুরনোটা ফেরত দেয়, না থাকলে নতুন বানিয়ে save করে রাখে। এর ফলে `new Singleton()` দিয়ে সরাসরি object বানানো block করা হয়েছে (constructor এ guard দিয়ে), যাতে সবাই বাধ্য হয়ে `getInstance()` ব্যবহার করে।

**English:** The class keeps a private static reference to its only instance. Every time someone calls `getInstance()`, it checks whether the instance already exists — if yes, return it; if no, create it once and store it. This pattern controls instantiation centrally instead of letting `new` be called freely.

### 🧪 Simple Examples (2)
1. **Counter App:** একটা app-wide counter যেটা সব component থেকে increment করা যাবে কিন্তু সবাই একই counter দেখবে।
2. **App Configuration Object:** App এর settings (theme, language) যেটা সব জায়গা থেকে একই object access করবে।

### 🏢 Industry Use Case Examples (2)
1. **Database Connection Pool:** একটা app এ বার বার নতুন DB connection বানানো খুবই costly। Singleton দিয়ে একটাই connection pool manager বানিয়ে রাখা হয়, যেকোনো module সেটা থেকেই connection নেয়।
   ```javascript
   class DBConnectionManager {
     static #instance = null;
     #pool = [];

     static getInstance() {
       if (!DBConnectionManager.#instance) {
         DBConnectionManager.#instance = new DBConnectionManager();
       }
       return DBConnectionManager.#instance;
     }

     getConnection() {
       console.log("Reusing single DB connection pool");
       return this.#pool;
     }
   }
   // Express app এর প্রতিটা route এই same instance ব্যবহার করবে
   ```
2. **Logger Service:** Production app এ সব module থেকে একটাই Logger instance ব্যবহার করা হয়, যাতে সব log একই জায়গায় (file/console) একই format এ লেখা হয় — Winston/Pino এর মতো logging library গুলো ভেতরে এই pattern ব্যবহার করে।

### ✅ Pros
- শুধু একটা instance থাকায় **memory সাশ্রয়** হয় (heavy object যেমন DB connection, cache এর জন্য দরকারি)।
- পুরো app এ **consistent state** বজায় থাকে — সবাই একই data দেখে।
- Global access point থাকায় কোথাও থেকেই সহজে access করা যায়।

### ❌ Cons
- **Global state** তৈরি হয়, যা testing কঠিন করে দেয় (unit test এ mock করা tricky)।
- Hidden dependency তৈরি হয় — কোড পড়ে বোঝা যায় না কোন module Singleton এর উপর depend করছে।
- Multi-threaded environment এ (Node.js এ কম প্রবলেম, কিন্তু Java/C++ এ বড় issue) race condition হতে পারে।
- SOLID এর **Single Responsibility Principle** ভাঙে — class নিজেই instance control করে + নিজের actual কাজও করে।

### 🤔 When to Use
- App-wide shared resource লাগলে: DB connection, configuration manager, logger, cache manager।
- যখন নিশ্চিত যে পুরো app lifecycle এ এই object এর exactly একটা instance ই লাগবে।

### 🚫 When NOT to Use
- যখন unit testing এ object কে easily mock/replace করার প্রয়োজন আছে (Singleton এটা কঠিন করে)।
- যখন ভবিষ্যতে multiple instance লাগতে পারে এমন সম্ভাবনা থাকে।
- Dependency Injection ব্যবহার করা ভালো বিকল্প — অনেক modern framework (Angular, NestJS) DI container দিয়ে singleton-like behavior দেয় কিন্তু testable থাকে।

### 💡 Extra Interview Tips
- Interviewer প্রায়ই জিজ্ঞেস করে: *"Singleton vs Static class?"* — Static class এ state lazily initialize করা যায় না, inheritance/polymorphism সাপোর্ট করে না, কিন্তু Singleton object হওয়ায় interface implement করতে পারে, lazy-load করা যায়।
- "Singleton is an anti-pattern" — এই বিতর্ক জানা থাকা ভালো, কারণ অনেক senior engineer এটাকে overused/misused pattern মনে করেন।
- JavaScript এ আসলে module system (`export default`) দিয়েও Singleton-এর মতো behavior পাওয়া যায়, কারণ ES module একবারই evaluate হয়।

---

## 2. Factory Method Pattern

### 📖 Definition
**English:** Factory Method defines an interface for creating an object, but lets **subclasses decide which class to instantiate**. It delegates the instantiation logic to child classes.

**বাংলা:** Factory Method pattern এমন একটা interface/method define করে যা object বানায়, কিন্তু **কোন exact class এর object বানানো হবে সেটা subclass ঠিক করে**। মানে object তৈরির দায়িত্ব parent class থেকে subclass এ pass হয়ে যায়। যেমন — একটা "Restaurant" এর `makeFood()` method আছে, কিন্তু "PizzaRestaurant" বানাবে Pizza আর "BurgerRestaurant" বানাবে Burger — দুটোই একই method কল করছে কিন্তু আলাদা product পাচ্ছে।

### 💻 JavaScript Implementation

```javascript
// Product interface (conceptually) — সব vehicle এর common behavior
class Vehicle {
  drive() {
    throw new Error("drive() must be implemented");
  }
}

class Car extends Vehicle {
  drive() {
    return "Driving a car on the road 🚗";
  }
}

class Bike extends Vehicle {
  drive() {
    return "Riding a bike on the road 🏍️";
  }
}

// Creator (Factory) — abstract base
class VehicleFactory {
  // Factory Method — subclass override করবে
  createVehicle() {
    throw new Error("createVehicle() must be implemented by subclass");
  }

  deliverVehicle() {
    const vehicle = this.createVehicle(); // কোন class বানাচ্ছে জানে না, subclass জানে
    console.log("Vehicle ready for delivery!");
    return vehicle.drive();
  }
}

class CarFactory extends VehicleFactory {
  createVehicle() {
    return new Car();
  }
}

class BikeFactory extends VehicleFactory {
  createVehicle() {
    return new Bike();
  }
}

// ---- USAGE / TEST ----
const carFactory = new CarFactory();
console.log(carFactory.deliverVehicle()); // "Driving a car on the road 🚗"

const bikeFactory = new BikeFactory();
console.log(bikeFactory.deliverVehicle()); // "Riding a bike on the road 🏍️"
```

### 🔍 Deep Explanation
**বাংলা ব্যাখ্যা:** `VehicleFactory` parent class এ `createVehicle()` একটা placeholder method, যেটা override করার জন্য subclass এ ছেড়ে দেওয়া হয়েছে। `deliverVehicle()` method টা জানে না exactly কোন vehicle তৈরি হচ্ছে — সে শুধু জানে যে `createVehicle()` call করলে একটা `Vehicle`-type object পাবে, এবং সেটার উপর `drive()` call করতে পারবে। এই ভাবে **object creation logic** কে actual business logic (`deliverVehicle`) থেকে আলাদা করা হলো — এটাই Factory Method এর core idea।

**English:** The base class defines the skeleton (`deliverVehicle`) but delegates the actual object creation (`createVehicle`) to subclasses. This decouples the "what to do with the object" logic from "how to create the object" logic — following the Open/Closed Principle, since adding a new vehicle type means adding a new factory subclass, not modifying existing code.

### 🧪 Simple Examples (2)
1. **Shape Factory:** `ShapeFactory` এর `createShape()` method override করে `CircleFactory`, `SquareFactory` আলাদা আলাদা shape বানায়।
2. **Notification Factory:** `NotificationFactory` এর subclass `EmailNotificationFactory`, `SMSNotificationFactory` আলাদা notification object বানায়।

### 🏢 Industry Use Case Examples (2)
1. **Payment Gateway Integration:** E-commerce app এ multiple payment provider (Stripe, PayPal, bKash) সাপোর্ট করতে হলে—
   ```javascript
   class PaymentProcessor {
     createPaymentGateway() {
       throw new Error("Must implement createPaymentGateway()");
     }
     processPayment(amount) {
       const gateway = this.createPaymentGateway();
       return gateway.pay(amount);
     }
   }

   class BkashProcessor extends PaymentProcessor {
     createPaymentGateway() {
       return { pay: (amt) => `Paid ${amt} BDT via bKash` };
     }
   }

   class StripeProcessor extends PaymentProcessor {
     createPaymentGateway() {
       return { pay: (amt) => `Paid $${amt} via Stripe` };
     }
   }

   const bkash = new BkashProcessor();
   console.log(bkash.processPayment(500)); // "Paid 500 BDT via bKash"
   ```
   এতে নতুন payment method (যেমন Nagad) যুক্ত করতে existing code touch করতে হয় না, শুধু নতুন subclass বানালেই হয়।

2. **UI Component Library (React-style):** Cross-platform app এ Button factory যেখানে web এর জন্য `<button>`, mobile এর জন্য native button component তৈরি হয় — কিন্তু caller এর কাছে interface একই থাকে।

### ✅ Pros
- **Open/Closed Principle** মেনে চলে — নতুন product type add করতে existing code change করতে হয় না, নতুন factory class add করলেই হয়।
- Object creation logic আর business logic আলাদা থাকে — code cleaner হয়।
- Loose coupling — client code শুধু abstract interface এর সাথে কাজ করে, concrete class জানা লাগে না।

### ❌ Cons
- প্রতিটা নতুন product এর জন্য নতুন subclass বানাতে হয় — class এর সংখ্যা বেড়ে যেতে পারে।
- ছোট প্রজেক্টে এটা **overengineering** মনে হতে পারে, simple `if-else` দিয়েও একই কাজ করা যায়।

### 🤔 When to Use
- যখন কোন exact class এর object বানানো হবে সেটা runtime এ বা subclass অনুযায়ী ঠিক হবে।
- যখন একই family এর object বানানোর জন্য common interface/logic দরকার কিন্তু implementation আলাদা আলাদা হবে।
- Library/framework design করার সময় যেখানে user নিজের custom object type plug-in করতে পারবে।

### 🚫 When NOT to Use
- যদি object creation logic খুবই simple হয় (একটা constructor call), তখন factory বানানো অপ্রয়োজনীয় complexity যোগ করবে।
- যখন object types ভবিষ্যতে বাড়ার সম্ভাবনা নেই।

### 💡 Extra Interview Tips
- Factory Method আর Simple Factory (এক স্ট্যাটিক method এ if-else দিয়ে object বানানো) — দুটোর পার্থক্য বলতে পারা জরুরি। Simple Factory টা GoF pattern না, এটা একটা idiom।
- Factory Method এ **inheritance** ব্যবহার হয় (subclassing দিয়ে), কিন্তু Abstract Factory এ **composition** ব্যবহার হয় (object pass করে)। এই পার্থক্যটা interviewer অনেক সময় জিজ্ঞেস করে।

---

## 3. Abstract Factory Pattern

### 📖 Definition
**English:** Abstract Factory provides an interface for creating **families of related or dependent objects** without specifying their concrete classes. It's a "factory of factories."

**বাংলা:** Abstract Factory pattern এমন একটা interface দেয় যেটা দিয়ে **একসাথে related object গুলোর পুরো family** বানানো যায়, exact class না জেনেই। এটাকে বলা হয় "factory এর factory"। যেমন — একটা furniture company যদি Victorian style আর Modern style — দুই ধরনের furniture (chair + sofa + table একসাথে, matching set) বানায়, তাহলে আপনি যেই style factory বেছে নিবেন, সেই পুরো matching family পাবেন।

### 💻 JavaScript Implementation

```javascript
// ---- Products ----
class Button { render() { throw new Error("Implement render()"); } }
class Checkbox { render() { throw new Error("Implement render()"); } }

class WindowsButton extends Button {
  render() { return "Rendering a Windows-style button 🟦"; }
}
class WindowsCheckbox extends Checkbox {
  render() { return "Rendering a Windows-style checkbox ☑️"; }
}

class MacButton extends Button {
  render() { return "Rendering a Mac-style button 🍎"; }
}
class MacCheckbox extends Checkbox {
  render() { return "Rendering a Mac-style checkbox ✅"; }
}

// ---- Abstract Factory ----
class UIFactory {
  createButton() { throw new Error("Implement createButton()"); }
  createCheckbox() { throw new Error("Implement createCheckbox()"); }
}

// ---- Concrete Factories ----
class WindowsFactory extends UIFactory {
  createButton() { return new WindowsButton(); }
  createCheckbox() { return new WindowsCheckbox(); }
}

class MacFactory extends UIFactory {
  createButton() { return new MacButton(); }
  createCheckbox() { return new MacCheckbox(); }
}

// ---- Client code ----
function renderUI(factory) {
  const button = factory.createButton();
  const checkbox = factory.createCheckbox();
  console.log(button.render());
  console.log(checkbox.render());
}

// ---- USAGE / TEST ----
console.log("--- Windows UI ---");
renderUI(new WindowsFactory());

console.log("--- Mac UI ---");
renderUI(new MacFactory());
```

### 🔍 Deep Explanation
**বাংলা ব্যাখ্যা:** এখানে `UIFactory` একটা abstract factory, যেখানে `createButton()` আর `createCheckbox()` — দুটো related product বানানোর method আছে। `WindowsFactory` আর `MacFactory` — দুটো concrete factory, প্রতিটাই তার নিজের style এর পুরো family (button + checkbox) বানায়। Client code (`renderUI`) শুধু `UIFactory` interface এর সাথে কাজ করে, exactly কোন platform এর object বানানো হচ্ছে সেটা জানার দরকার নেই। ফলে পুরো app এ consistency বজায় থাকে — যদি Windows factory ব্যবহার হয়, তাহলে ভুলে কখনো Mac checkbox তৈরি হবে না।

**English:** The abstract factory groups together creation methods for a **family** of related products. Each concrete factory ensures all products it creates belong to the same "theme" or "family" — preventing mismatched combinations (e.g., a Windows button with a Mac checkbox). The client only interacts with the abstract interface.

### 🧪 Simple Examples (2)
1. **Furniture Factory:** `ModernFurnitureFactory` বানায় Modern Chair + Modern Sofa; `VictorianFurnitureFactory` বানায় Victorian Chair + Victorian Sofa।
2. **Theme Factory:** `DarkThemeFactory` বানায় matching dark-colored button, background, text; `LightThemeFactory` matching light versions বানায়।

### 🏢 Industry Use Case Examples (2)
1. **Cross-Database Query Builder:** একটা ORM/data-layer যেটা MySQL আর MongoDB দুটোই সাপোর্ট করে —
   ```javascript
   class DBFactory {
     createConnection() { throw new Error("Implement"); }
     createQueryBuilder() { throw new Error("Implement"); }
   }

   class MySQLFactory extends DBFactory {
     createConnection() { return { type: "MySQL Connection" }; }
     createQueryBuilder() { return { build: (q) => `SQL: ${q}` }; }
   }

   class MongoFactory extends DBFactory {
     createConnection() { return { type: "Mongo Connection" }; }
     createQueryBuilder() { return { build: (q) => `Mongo Query: ${q}` }; }
   }

   function runQuery(factory, query) {
     const conn = factory.createConnection();
     const builder = factory.createQueryBuilder();
     console.log(conn.type, "->", builder.build(query));
   }
   runQuery(new MySQLFactory(), "SELECT * FROM users");
   ```
2. **Cross-Platform Mobile App (React Native style):** iOS আর Android এর জন্য matching component family (NavigationBar, TabBar, Modal) — যেখানে একই code logic, কিন্তু platform-specific look তৈরি হয়।

### ✅ Pros
- Related object গুলোর মধ্যে **consistency guarantee** করে (একই family এর বাইরে mix হবে না)।
- Concrete product class গুলো client code থেকে সম্পূর্ণ আলাদা থাকে (high decoupling)।
- নতুন family (যেমন নতুন Linux theme) যুক্ত করা সহজ — শুধু একটা নতুন concrete factory বানালেই হয়।

### ❌ Cons
- Code complexity অনেক বেড়ে যায় — অনেক class/interface লাগে।
- নতুন **product type** (যেমন নতুন `createScrollbar()`) যুক্ত করতে হলে সব existing concrete factory edit করতে হয় — এটা একটা trade-off।

### 🤔 When to Use
- যখন আপনার system এ multiple related product family আছে এবং সেগুলো একসাথে consistent থাকা জরুরি।
- Cross-platform বা multi-vendor support দরকার হলে (multiple DB, multiple OS, multiple theme)।

### 🚫 When NOT to Use
- যদি শুধু একটাই product type থাকে (তখন simple Factory Method যথেষ্ট)।
- ছোট/মাঝারি প্রজেক্টে যেখানে family-based grouping দরকার নেই।

### 💡 Extra Interview Tips
- সবচেয়ে কমন interview question: **"Factory Method vs Abstract Factory পার্থক্য কি?"** — Factory Method একটা single product বানায় (inheritance ব্যবহার করে), Abstract Factory related products এর পুরো family বানায় (composition ব্যবহার করে, factory object pass করা হয়)।
- Real-world এ React এর কোনো UI library, বা Java এর `javax.xml.parsers.DocumentBuilderFactory` — এগুলো Abstract Factory এর classic example।

---

## 4. Builder Pattern

### 📖 Definition
**English:** Builder pattern separates the construction of a **complex object** from its representation, allowing the same construction process to create different representations, **step by step**.

**বাংলা:** Builder pattern একটা জটিল object কে **step-by-step** ভাবে বানানোর প্রক্রিয়া দেয়, যেখানে construction logic আর final object representation আলাদা থাকে। যেমন — একটা বার্গার বানানো: bun দিন, তারপর patty, তারপর sauce, তারপর veggies — প্রতিটা step আলাদা, এবং চাইলে যেকোনো combination বানানো যায়, সব একসাথে একটা huge constructor এ না দিয়ে।

### 💻 JavaScript Implementation

```javascript
class House {
  constructor() {
    this.floors = 0;
    this.hasGarage = false;
    this.hasGarden = false;
    this.hasPool = false;
  }

  describe() {
    return `House with ${this.floors} floor(s), ` +
      `Garage: ${this.hasGarage}, Garden: ${this.hasGarden}, Pool: ${this.hasPool}`;
  }
}

class HouseBuilder {
  constructor() {
    this.house = new House();
  }

  setFloors(count) {
    this.house.floors = count;
    return this; // method chaining এর জন্য 'this' return করা হয়
  }

  addGarage() {
    this.house.hasGarage = true;
    return this;
  }

  addGarden() {
    this.house.hasGarden = true;
    return this;
  }

  addPool() {
    this.house.hasPool = true;
    return this;
  }

  build() {
    return this.house; // final object return করো
  }
}

// ---- USAGE / TEST ----
const luxuryHouse = new HouseBuilder()
  .setFloors(3)
  .addGarage()
  .addGarden()
  .addPool()
  .build();

console.log(luxuryHouse.describe());
// "House with 3 floor(s), Garage: true, Garden: true, Pool: true"

const simpleHouse = new HouseBuilder()
  .setFloors(1)
  .build();

console.log(simpleHouse.describe());
// "House with 1 floor(s), Garage: false, Garden: false, Pool: false"
```

### 🔍 Deep Explanation
**বাংলা ব্যাখ্যা:** `HouseBuilder` class একটা `House` object কে ধাপে ধাপে তৈরি করে। প্রতিটা method (`setFloors`, `addGarage` ইত্যাদি) `this` রিটার্ন করে, যাতে **method chaining** (একটার পর একটা `.method()` কল) করা যায় — এটাকে বলে **fluent interface**। সবশেষে `build()` কল করলে final, পুরোপুরি configured object ফেরত আসে। এর সুবিধা হলো — আপনি optional field গুলো শুধু প্রয়োজন হলেই set করতে পারবেন, একটা huge constructor এ ৮-১০টা parameter পাস করার দরকার নেই (যেটাকে বলা হয় "telescoping constructor problem")।

**English:** Instead of a constructor with many optional parameters (`new House(3, true, false, true, ...)` — hard to read), the Builder exposes named methods for each property, chainable via `return this`. The `build()` method finalizes and returns the constructed object. This avoids the "telescoping constructor" anti-pattern and makes object creation self-documenting.

### 🧪 Simple Examples (2)
1. **Pizza Builder:** `.addCheese().addMushroom().addOlives().build()` — চাহিদা অনুযায়ী topping যুক্ত করে pizza বানানো।
2. **Form/Survey Builder:** `.addTextField().addCheckbox().addSubmitButton().build()` দিয়ে dynamic form বানানো।

### 🏢 Industry Use Case Examples (2)
1. **HTTP Request Builder (API client library):** Axios/fetch wrapper বানানোর সময় common pattern —
   ```javascript
   class RequestBuilder {
     constructor() {
       this.config = { headers: {}, method: "GET" };
     }
     setUrl(url) { this.config.url = url; return this; }
     setMethod(method) { this.config.method = method; return this; }
     addHeader(key, value) { this.config.headers[key] = value; return this; }
     setBody(body) { this.config.body = JSON.stringify(body); return this; }
     build() { return this.config; }
   }

   const request = new RequestBuilder()
     .setUrl("/api/users")
     .setMethod("POST")
     .addHeader("Authorization", "Bearer token123")
     .setBody({ name: "Musfique" })
     .build();

   console.log(request);
   ```
2. **SQL Query Builder (like Knex.js):** `.select("name").from("users").where("age", ">", 18).build()` — এই ভাবে dynamic, readable SQL query বানানো হয় বড় backend system গুলোতে।

### ✅ Pros
- জটিল object কে readable, step-by-step ভাবে বানানো যায় — code এর readability অনেক বাড়ে।
- Optional parameters হ্যান্ডেল করার জন্য সবচেয়ে clean সমাধান — "telescoping constructor" সমস্যা দূর হয়।
- একই building process দিয়ে আলাদা আলাদা representation (object configuration) বানানো যায়।
- Immutable object বানানোর জন্যও ব্যবহার করা যায় (build() এর আগ পর্যন্ত mutable, পরে freeze)।

### ❌ Cons
- ছোট, simple object এর জন্য Builder বানালে অপ্রয়োজনীয় boilerplate code বেড়ে যায়।
- প্রতিটা product এর জন্য আলাদা Builder class লাগতে পারে, যা class count বাড়ায়।

### 🤔 When to Use
- Object এর অনেক optional field/parameter আছে।
- Object construction এ multiple steps আছে এবং প্রতিটা step এ validation/logic দরকার।
- Immutable object বানাতে চান কিন্তু construction process complex।

### 🚫 When NOT to Use
- Object simple হলে (২-৩টা field, সব mandatory) — তখন সরাসরি constructor/object literal যথেষ্ট।
- Performance-critical hot path এ, যেখানে extra object creation (builder instance) overhead তৈরি করতে পারে।

### 💡 Extra Interview Tips
- **Builder vs Factory** পার্থক্য: Factory একবারে পুরো object বানায় (one shot), Builder step-by-step বানায় এবং intermediate state থাকে।
- JavaScript এ অনেক সময় Builder এর বদলে object destructuring + default parameters দিয়েও similar readability পাওয়া যায় — এই trade-off বলতে জানা ভালো ("In JS, sometimes a config object achieves similar readability without a full Builder class").
- Lombok (Java) এর `@Builder` annotation, বা React এর component composition — এসব আসলে Builder pattern এর spirit follow করে।

---

## 5. Prototype Pattern

### 📖 Definition
**English:** Prototype pattern creates new objects by **copying (cloning) an existing object**, known as the prototype, instead of creating from scratch.

**বাংলা:** Prototype pattern নতুন object বানানোর সময় শুরু থেকে না বানিয়ে একটা **existing object কে clone (copy)** করে নতুন object বানায়। যেমন — একটা document এর template থাকলে, নতুন document বানাতে আপনি পুরো formatting নতুন করে না করে, template কপি করে শুধু content বদলে দেন।

### 💻 JavaScript Implementation

```javascript
class Sheep {
  constructor(name, color) {
    this.name = name;
    this.color = color;
  }

  clone() {
    // shallow clone — নতুন object বানানো হচ্ছে existing data থেকে
    return new Sheep(this.name, this.color);
  }

  describe() {
    return `${this.name} is a ${this.color} sheep 🐑`;
  }
}

// ---- USAGE / TEST ----
const original = new Sheep("Dolly", "white");
console.log(original.describe()); // "Dolly is a white sheep 🐑"

const clone1 = original.clone();
clone1.name = "Dolly Clone 1";
console.log(clone1.describe()); // "Dolly Clone 1 is a white sheep 🐑"

console.log(original === clone1); // false — আলাদা object, কিন্তু same starting data
```

```javascript
// Native JS এ Object.create() / structuredClone() দিয়েও Prototype pattern করা যায়
class Robot {
  constructor(model, capabilities = []) {
    this.model = model;
    this.capabilities = capabilities;
  }

  clone() {
    // deep clone — যাতে nested array/object আলাদা reference পায়
    return structuredClone(this);
  }
}

const baseRobot = new Robot("R2-Unit", ["walk", "talk"]);
const customRobot = baseRobot.clone();
customRobot.capabilities.push("fly");

console.log(baseRobot.capabilities);   // ["walk", "talk"] — original untouched
console.log(customRobot.capabilities); // ["walk", "talk", "fly"]
```

### 🔍 Deep Explanation
**বাংলা ব্যাখ্যা:** এখানে প্রতিটা class এ একটা `clone()` method আছে, যা নিজের current data দিয়ে নতুন object তৈরি করে রিটার্ন করে। প্রথম example এ **shallow clone** দেখানো হয়েছে (নতুন constructor call করে), দ্বিতীয় example এ `structuredClone()` দিয়ে **deep clone** দেখানো হয়েছে — যেখানে nested object/array গুলোও সম্পূর্ণ আলাদা reference পায় (তাই `customRobot.capabilities.push()` করলে `baseRobot` এর array তে effect পড়ে না)। Shallow vs deep clone এর পার্থক্য বোঝা এই pattern এর সবচেয়ে গুরুত্বপূর্ণ অংশ।

**English:** Each class implements a `clone()` method that returns a new object copied from itself. Shallow cloning copies only top-level properties (nested objects still share references), while deep cloning (`structuredClone`, or manual recursive copy) ensures fully independent copies — critical when the cloned object contains arrays/objects that shouldn't be shared.

### 🧪 Simple Examples (2)
1. **Game Character Cloning:** একটা base "Enemy" template বানিয়ে, game এ ১০০টা enemy spawn করার সময় প্রতিটা clone করে আলাদা position/health সেট করা।
2. **Document Template:** একটা resume template object clone করে বিভিন্ন user এর জন্য আলাদা resume বানানো, base formatting same রেখে।

### 🏢 Industry Use Case Examples (2)
1. **Redux/State Management Snapshot:** State immutability বজায় রাখার জন্য পুরনো state কে clone করে নতুন state বানানো (spread operator `{...state}` আসলে shallow Prototype-style cloning)।
   ```javascript
   class AppState {
     constructor(user, cart) {
       this.user = user;
       this.cart = cart;
     }
     clone() {
       return new AppState({ ...this.user }, [...this.cart]);
     }
   }

   const state1 = new AppState({ name: "Musfique" }, ["item1"]);
   const state2 = state1.clone();
   state2.cart.push("item2");
   console.log(state1.cart); // ["item1"] — original unaffected
   console.log(state2.cart); // ["item1", "item2"]
   ```
2. **Object Pool for Performance (game engines, particle systems):** Heavy initialization logic আছে এমন object (যেমন complex 3D model configuration) বার বার নতুন বানানোর বদলে একটা prototype থেকে clone করে performance বাড়ানো হয়, কারণ clone করা constructor চালানোর চেয়ে দ্রুত হতে পারে।

### ✅ Pros
- Object creation **costly/expensive initialization logic** থাকলে, সেই কাজ বার বার না করে clone করে সময় বাঁচানো যায়।
- Complex object structure সহজে duplicate করা যায়, ক্লাস না জেনেও (`clone()` interface থাকলেই হয়)।
- Runtime এ dynamically নতুন object configuration বানানো সহজ হয়।

### ❌ Cons
- **Deep vs shallow clone** এর পার্থক্য না বুঝলে subtle bug হতে পারে (nested object accidentally shared হয়ে যাওয়া)।
- Circular reference থাকলে cloning জটিল হয়ে যায় (`structuredClone` কিছু কেস handle করে, কিন্তু সব না — যেমন function clone করা যায় না)।

### 🤔 When to Use
- Object বানানো resource-intensive (database call, complex calculation, large initialization)।
- Existing object এর variation বানাতে চান যেখানে বেশিরভাগ property same থাকবে, কিছু আলাদা হবে।

### 🚫 When NOT to Use
- Object simple এবং lightweight হলে — তখন সরাসরি `new` করাই সহজ এবং clear।
- যখন object এ function/closure আছে যা clone করা প্রায় অসম্ভব বা অর্থহীন।

### 💡 Extra Interview Tips
- JavaScript এ আসলে **prototypal inheritance** (যা `Object.create()`, `__proto__` দিয়ে কাজ করে) — নাম একই হলেও এটা GoF Prototype pattern থেকে আলাদা concept, কিন্তু interviewer অনেক সময় গুলিয়ে ফেলে জিজ্ঞেস করতে পারে — পার্থক্য স্পষ্ট রাখা জরুরি।
- `JSON.parse(JSON.stringify(obj))` একটা পুরনো deep-clone trick ছিল, কিন্তু এখন `structuredClone()` ব্যবহার করা ভালো (এটা function, undefined, Date ঠিকভাবে handle করে যা JSON trick করতে পারে না)।

---

# 🧱 CATEGORY 2: STRUCTURAL PATTERNS
> **Structural patterns** deal with how classes and objects are **composed** to form larger structures, while keeping these structures flexible and efficient.

---

## 6. Adapter Pattern

### 📖 Definition
**English:** Adapter pattern allows objects with **incompatible interfaces** to work together by wrapping one interface with another that the client expects.

**বাংলা:** Adapter pattern দুটো **incompatible interface** কে একসাথে কাজ করতে সাহায্য করে — একটা wrapper বানিয়ে দেওয়া হয় যা একটা interface কে অন্যটাতে convert করে দেয়। যেমন — বাংলাদেশের plug ইউরোপের socket এ লাগানো যায় না, তাই একটা **adapter/converter** লাগানো হয় — এটাই এই pattern এর নাম দেওয়ার মূল inspiration।

### 💻 JavaScript Implementation

```javascript
// পুরনো/existing system — যেটা আমরা বদলাতে পারবো না
class OldPrinter {
  printOld(text) {
    return `[Old Printer]: ${text}`;
  }
}

// নতুন system যা আমাদের code expect করে
class NewPrinterInterface {
  print(text) {
    throw new Error("print() must be implemented");
  }
}

// Adapter — পুরনো interface কে নতুন interface এর মতো দেখায়
class PrinterAdapter extends NewPrinterInterface {
  constructor(oldPrinter) {
    super();
    this.oldPrinter = oldPrinter;
  }

  print(text) {
    // নতুন interface এর call কে পুরনো interface এর method এ translate করছে
    return this.oldPrinter.printOld(text);
  }
}

// ---- USAGE / TEST ----
const oldPrinter = new OldPrinter();
const adapter = new PrinterAdapter(oldPrinter);

// Client code শুধু নতুন interface (print) জানে, কিন্তু কাজ হচ্ছে পুরনো system দিয়ে
console.log(adapter.print("Hello World")); // "[Old Printer]: Hello World"
```

### 🔍 Deep Explanation
**বাংলা ব্যাখ্যা:** `OldPrinter` এর method নাম `printOld()`, কিন্তু আমাদের নতুন code `print()` method expect করে। `PrinterAdapter` ক্লাসটা `OldPrinter` কে wrap করে রাখে (composition ব্যবহার করে — `this.oldPrinter`), এবং নতুন interface এর `print()` method এর ভেতরে গিয়ে পুরনো `printOld()` কে call করে। এর ফলে client code কে পুরনো system এর internal detail জানতে হয় না — শুধু `print()` কল করলেই হয়। এই pattern টা legacy code এর সাথে নতুন code কে integrate করার সময় খুব কাজে লাগে।

**English:** The adapter wraps the incompatible (`OldPrinter`) object and exposes the interface the client expects (`print()`). Internally it translates the call to the old method (`printOld()`). This lets you integrate legacy code or third-party libraries without modifying their source — you just wrap them.

### 🧪 Simple Examples (2)
1. **Temperature Converter Adapter:** Celsius দেওয়া API কে Fahrenheit expect করা client code এর সাথে adapt করা।
2. **Array-like to Array Adapter:** একটা custom object (যার `getItem(i)`, `length` আছে) কে standard array methods (`map`, `filter`) দিয়ে কাজ করানোর জন্য adapt করা।

### 🏢 Industry Use Case Examples (2)
1. **Third-Party API Response Adapter:** ধরুন আপনার app পুরনো payment API (`amount_in_cents`, `currency_code`) ব্যবহার করত, কিন্তু নতুন payment provider আলাদা format (`amountCents`, `currency`) দেয় —
   ```javascript
   class LegacyPaymentAPI {
     getPaymentData() {
       return { amount_in_cents: 50000, currency_code: "BDT" };
     }
   }

   class ModernPaymentInterface {
     getPayment() { throw new Error("Implement getPayment()"); }
   }

   class PaymentAdapter extends ModernPaymentInterface {
     constructor(legacyApi) {
       super();
       this.legacyApi = legacyApi;
     }
     getPayment() {
       const raw = this.legacyApi.getPaymentData();
       return { amountCents: raw.amount_in_cents, currency: raw.currency_code };
     }
   }

   const adapter2 = new PaymentAdapter(new LegacyPaymentAPI());
   console.log(adapter2.getPayment()); // { amountCents: 50000, currency: "BDT" }
   ```
2. **Different Logging Libraries Adapter:** একটা app যেখানে `console.log` থেকে `Winston`/`Pino` logger এ migrate করা হচ্ছে — দুটোর API আলাদা হলে, একটা common `Logger` interface বানিয়ে দুটোকেই adapt করা হয়, যাতে বাকি code এ কোনো change লাগে না।

### ✅ Pros
- Legacy বা third-party code কে modify না করেই নতুন system এর সাথে integrate করা যায়।
- Single Responsibility বজায় থাকে — interface conversion logic একটা আলাদা class এ থাকে।
- Existing code reusability বাড়ে — পুরনো working code ফেলে দিতে হয় না।

### ❌ Cons
- Extra layer of abstraction যুক্ত হয়, যা code কে কিছুটা জটিল করে এবং debugging এ একটা extra hop যুক্ত হয়।
- অনেক Adapter জমা হলে code maintain করা কঠিন হয়ে যেতে পারে।

### 🤔 When to Use
- যখন existing class এর interface আপনার প্রয়োজনীয় interface এর সাথে মেলে না।
- Third-party library/legacy system integrate করার সময়, যার source code modify করতে পারবেন না।

### 🚫 When NOT to Use
- যদি direct access/modification সম্ভব হয় তাহলে Adapter বানানোর বদলে সরাসরি interface ঠিক করে দেওয়া ভালো।
- যদি দুটো interface এর পার্থক্য খুবই সামান্য হয়, তাহলে inline conversion যথেষ্ট, পুরো class বানানোর দরকার নেই।

### 💡 Extra Interview Tips
- Real life এ Node.js এর অনেক wrapper library (যেমন পুরনো callback-based API কে Promise-based বানানো — `util.promisify`) Adapter pattern এর উদাহরণ।
- **Adapter vs Facade পার্থক্য:** Adapter একটা existing interface কে অন্য একটা interface এ convert করে (one-to-one mapping জাতীয়), Facade একাধিক জটিল interface এর সামনে একটা সহজ, নতুন interface বানায় (simplification, নতুন কিছু hide করা)।

---

## 7. Bridge Pattern

### 📖 Definition
**English:** Bridge pattern decouples an **abstraction from its implementation**, so the two can vary and evolve independently of each other.

**বাংলা:** Bridge pattern **abstraction (কি করা হবে)** আর **implementation (কিভাবে করা হবে)** কে আলাদা করে দেয়, যাতে দুটো একে অপরের উপর নির্ভর না করে আলাদাভাবে change/extend করা যায়। যেমন — একটা TV Remote (abstraction) আর TV (implementation) — যেকোনো remote যেকোনো TV ব্র্যান্ডের সাথে কাজ করতে পারে যদি দুটোর মধ্যে একটা common "bridge"/interface থাকে।

### 💻 JavaScript Implementation

```javascript
// Implementation hierarchy — "কিভাবে" করা হবে
class Device {
  turnOn() { throw new Error("Implement turnOn()"); }
  turnOff() { throw new Error("Implement turnOff()"); }
  setVolume(level) { throw new Error("Implement setVolume()"); }
}

class TV extends Device {
  turnOn() { return "TV is now ON 📺"; }
  turnOff() { return "TV is now OFF"; }
  setVolume(level) { return `TV volume set to ${level}`; }
}

class Radio extends Device {
  turnOn() { return "Radio is now ON 📻"; }
  turnOff() { return "Radio is now OFF"; }
  setVolume(level) { return `Radio volume set to ${level}`; }
}

// Abstraction hierarchy — "কি" করা হবে, কিন্তু actual কাজ device কে delegate করে
class RemoteControl {
  constructor(device) {
    this.device = device; // bridge — composition দিয়ে implementation কে hold করছে
  }
  togglePower() {
    return this.device.turnOn();
  }
  volumeUp() {
    return this.device.setVolume(10);
  }
}

// Extended abstraction — নতুন feature যোগ হচ্ছে, কিন্তু device hierarchy touch হচ্ছে না
class AdvancedRemoteControl extends RemoteControl {
  mute() {
    return this.device.setVolume(0);
  }
}

// ---- USAGE / TEST ----
const tvRemote = new AdvancedRemoteControl(new TV());
console.log(tvRemote.togglePower()); // "TV is now ON 📺"
console.log(tvRemote.mute());        // "TV volume set to 0"

const radioRemote = new RemoteControl(new Radio());
console.log(radioRemote.togglePower()); // "Radio is now ON 📻"
```

### 🔍 Deep Explanation
**বাংলা ব্যাখ্যা:** এখানে দুটো আলাদা hierarchy আছে — একটা `Device` (TV, Radio — implementation side) আর একটা `RemoteControl` (abstraction side)। `RemoteControl` সরাসরি TV বা Radio এর code জানে না, সে শুধু `Device` interface এর সাথে কাজ করে এবং constructor এ device টা **inject (composition)** করা হয়। এর ফলে নতুন remote feature (`AdvancedRemoteControl`) বা নতুন device type (যেমন `SmartSpeaker`) — যেকোনো একদিকে change করলে অন্যদিকে কোনো প্রভাব পড়ে না — দুটো hierarchy **independently grow** করতে পারে। এটাই Bridge এর মূল power — যদি inheritance দিয়ে করতাম (`TVRemote extends TV`), তাহলে combination বাড়ার সাথে সাথে class explosion হতো (TVRemote, RadioRemote, AdvancedTVRemote, AdvancedRadioRemote...)।

**English:** Bridge separates two hierarchies — abstraction (`RemoteControl`) and implementation (`Device`) — connected via composition rather than inheritance. This avoids the "class explosion" problem you'd get if you tried to create a subclass for every combination of remote-type × device-type. Each hierarchy can be extended independently.

### 🧪 Simple Examples (2)
1. **Shape + Color Bridge:** `Shape` (Circle, Square) আর `Color` (Red, Blue) — `new Circle(new RedColor())` করে যেকোনো combination বানানো, `RedCircle`, `BlueSquare` class না বানিয়েই।
2. **Message Sender Bridge:** `Message` abstraction (UrgentMessage, NormalMessage) আর `Sender` implementation (EmailSender, SMSSender) — independently combine করা যায়।

### 🏢 Industry Use Case Examples (2)
1. **Cross-Platform Rendering Engine:** একটা UI framework যেখানে `Shape` (abstraction: Circle, Rectangle) কে আলাদা `Renderer` (implementation: SVGRenderer, CanvasRenderer) দিয়ে আলাদা platform এ আঁকা যায় —
   ```javascript
   class Renderer {
     renderCircle(radius) { throw new Error("Implement"); }
   }
   class SVGRenderer extends Renderer {
     renderCircle(radius) { return `<svg><circle r="${radius}" /></svg>`; }
   }
   class CanvasRenderer extends Renderer {
     renderCircle(radius) { return `canvas.arc(0,0,${radius},0,2*Math.PI)`; }
   }
   class Shape {
     constructor(renderer) { this.renderer = renderer; }
   }
   class Circle extends Shape {
     constructor(renderer, radius) { super(renderer); this.radius = radius; }
     draw() { return this.renderer.renderCircle(this.radius); }
   }
   const svgCircle = new Circle(new SVGRenderer(), 10);
   console.log(svgCircle.draw()); // "<svg><circle r="10" /></svg>"
   ```
2. **Notification System with Multiple Channels:** `NotificationType` (Alert, Reminder — abstraction) যেকোনো `NotificationChannel` (Email, SMS, Push — implementation) এর সাথে independently combine হতে পারে, প্রতিটা combination এর জন্য আলাদা class না বানিয়েই।

### ✅ Pros
- দুটো hierarchy আলাদা আলাদাভাবে extend করা যায়, একে অপরকে প্রভাবিত না করে।
- Inheritance এর বদলে composition ব্যবহার হওয়ায় **runtime এ implementation swap** করা সম্ভব (যেমন remote এ runtime এ device বদলানো)।
- Class explosion problem এড়ানো যায়।

### ❌ Cons
- Design এর শুরুতে complexity বাড়ে — দুটো আলাদা hierarchy design করা সহজ কাজ না, ভুল হলে over-engineering হয়ে যায়।
- ছোট প্রজেক্টে এটা প্রায়ই অপ্রয়োজনীয় মনে হতে পারে।

### 🤔 When to Use
- যখন একাধিক dimension এ variation আছে (যেমন shape × color, device × remote) এবং সব combination এর জন্য আলাদা class বানানো অবাস্তব।
- যখন runtime এ implementation পরিবর্তনের সুযোগ রাখতে চান।

### 🚫 When NOT to Use
- যখন শুধুমাত্র একটা hierarchy আছে এবং variation এর প্রয়োজন নেই।
- ছোট, stable codebase যেখানে ভবিষ্যতে multiple implementation আসার সম্ভাবনা নেই।

### 💡 Extra Interview Tips
- **Bridge vs Adapter পার্থক্য (খুব কমন প্রশ্ন):** Adapter পরে এসে দুটো **already-existing, incompatible** interface কে মেলায় (after-the-fact fix), কিন্তু Bridge **design করার সময় থেকেই** ইচ্ছাকৃতভাবে abstraction আর implementation কে আলাদা রাখে (upfront design decision)।
- JDBC (Java) একটা classic Bridge pattern example — `Connection` interface (abstraction) বিভিন্ন database driver (implementation: MySQL driver, PostgreSQL driver) এর সাথে কাজ করে।

---

## 8. Composite Pattern

### 📖 Definition
**English:** Composite pattern lets you compose objects into **tree structures** and then work with these structures as if they were individual objects — treating a single object and a group of objects **uniformly**.

**বাংলা:** Composite pattern object গুলোকে একটা **tree structure** এ সাজায়, এবং single object আর group of objects (composite) — দুটোকেই **একই interface দিয়ে treat** করা যায়। যেমন — একটা ফোল্ডার সিস্টেম: একটা ফাইল একটা single item, কিন্তু একটা ফোল্ডারের ভেতরেও ফাইল/ফোল্ডার থাকতে পারে — দুটোকেই আপনি "open করো", "size দেখাও" — একই কমান্ড দিয়ে handle করতে পারেন।

### 💻 JavaScript Implementation

```javascript
// Common interface — leaf এবং composite দুটোই এটা implement করবে
class FileSystemItem {
  getSize() { throw new Error("Implement getSize()"); }
  display(indent = "") { throw new Error("Implement display()"); }
}

// Leaf — কোনো children নেই, এটাই simplest unit
class File extends FileSystemItem {
  constructor(name, size) {
    super();
    this.name = name;
    this.size = size; // KB তে
  }
  getSize() {
    return this.size;
  }
  display(indent = "") {
    console.log(`${indent}📄 ${this.name} (${this.size}KB)`);
  }
}

// Composite — children রাখতে পারে (File বা আরেকটা Folder)
class Folder extends FileSystemItem {
  constructor(name) {
    super();
    this.name = name;
    this.children = [];
  }
  add(item) {
    this.children.push(item);
    return this;
  }
  getSize() {
    // Recursive — নিজের সব children এর size যোগ করে
    return this.children.reduce((total, child) => total + child.getSize(), 0);
  }
  display(indent = "") {
    console.log(`${indent}📁 ${this.name} (${this.getSize()}KB total)`);
    this.children.forEach(child => child.display(indent + "  "));
  }
}

// ---- USAGE / TEST ----
const resume = new File("resume.pdf", 200);
const photo = new File("photo.png", 500);

const projectsFolder = new Folder("Projects");
projectsFolder.add(new File("app.js", 50)).add(new File("style.css", 20));

const rootFolder = new Folder("MyDocuments");
rootFolder.add(resume).add(photo).add(projectsFolder);

rootFolder.display();
// 📁 MyDocuments (770KB total)
//   📄 resume.pdf (200KB)
//   📄 photo.png (500KB)
//   📁 Projects (70KB total)
//     📄 app.js (50KB)
//     📄 style.css (20KB)

console.log("Total size:", rootFolder.getSize()); // Total size: 770
```

### 🔍 Deep Explanation
**বাংলা ব্যাখ্যা:** `File` (leaf node) আর `Folder` (composite node) — দুটোই `FileSystemItem` এর common interface implement করে (`getSize()`, `display()`)। `Folder` এর ভেতরে আবার `File` বা আরেকটা `Folder` থাকতে পারে — এটাই **recursive tree structure**। যখন `rootFolder.getSize()` কল করা হয়, এটা নিজের সব child এর `getSize()` কল করে, child যদি folder হয় তাহলে সেও আবার তার children এর size যোগ করে — এটা recursion দিয়ে পুরো tree traverse করে। Client code (যেমন আমাদের `console.log`) জানেই না কোনটা single file আর কোনটা পুরো folder — সবাইকে একইভাবে `.getSize()` কল করেই treat করছে।

**English:** Both `File` (leaf) and `Folder` (composite) implement the same interface. A `Folder` can contain other `Folder`s or `File`s, forming a tree. Calling `getSize()` on the root recursively sums up sizes through the entire tree — the client code doesn't need to know whether it's dealing with a single file or an entire nested folder structure; both are treated uniformly.

### 🧪 Simple Examples (2)
1. **Organization Hierarchy:** একটা `Employee` (leaf) আর `Manager` (composite, যার team members আছে) — দুটোর `getSalaryTotal()` একইভাবে কল করা যায়।
2. **Menu System:** একটা `MenuItem` (leaf) আর `Menu` (composite, যার ভেতরে sub-menu items থাকে) — UI তে render করার সময় একইভাবে handle করা।

### 🏢 Industry Use Case Examples (2)
1. **DOM Tree / React Component Tree:** Browser এর DOM নিজেই Composite pattern এর বাস্তব উদাহরণ — একটা `<div>` এর ভেতরে আরো `<div>`, `<span>`, বা plain text থাকতে পারে, এবং `element.textContent` বা `element.addEventListener` মতো operation সব node এর উপর uniformly কাজ করে। React component tree তেও একই concept — একটা Component আরেকটা Component কে render করে।
   ```javascript
   class UIComponent {
     render() { throw new Error("Implement render()"); }
   }
   class TextComponent extends UIComponent {
     constructor(text) { super(); this.text = text; }
     render() { return this.text; }
   }
   class ContainerComponent extends UIComponent {
     constructor() { super(); this.children = []; }
     add(child) { this.children.push(child); return this; }
     render() {
       return `<div>${this.children.map(c => c.render()).join("")}</div>`;
     }
   }
   const page = new ContainerComponent()
     .add(new TextComponent("Hello"))
     .add(new ContainerComponent().add(new TextComponent("Nested")));
   console.log(page.render()); // "<div>Hello<div>Nested</div></div>"
   ```
2. **Permission/Access Control Tree:** একটা organization এ Department (composite) এর ভেতরে Team (composite) এর ভেতরে Employee (leaf) — `checkAccess()` method পুরো tree তে uniformly propagate হয়, কোনো একটা node এর access বদলালে তার সব descendant এ effect পড়ে।

### ✅ Pros
- Tree-like (hierarchical) data structure কে খুব naturally represent করা যায়।
- Client code single object আর group — দুটোকেই একইভাবে handle করতে পারে, code simplify হয়।
- নতুন component type যুক্ত করা সহজ — Open/Closed Principle মেনে চলে।

### ❌ Cons
- Design টা overly general হয়ে যেতে পারে — কখনো কখনো নির্দিষ্ট leaf/composite এর জন্য type-checking লাগে, যা interface এর uniformity ভেঙে দেয়।
- প্রতিটা operation (`getSize`, `display`) leaf এবং composite — দুই জায়গায় implement করতে হয়, যা মাঝে মাঝে অর্থহীন/empty implementation এ পরিণত হয়।

### 🤔 When to Use
- যখন data hierarchical/tree-like structure এ আছে (file system, organization chart, UI component tree, menu)।
- যখন client code কে individual object এবং composition — দুটোর পার্থক্য না করে কাজ করানো দরকার।

### 🚫 When NOT to Use
- যখন data structure flat/linear (tree না), তখন Composite এর কোনো লাভ নেই।
- যখন leaf আর composite এর behavior এতটাই আলাদা যে common interface বানানো অস্বাভাবিক/জোরাজুরি মনে হয়।

### 💡 Extra Interview Tips
- DOM, React/Vue component tree, JSON-এর nested object — এই সবকিছুই Composite pattern এর real-life উদাহরণ, এই connection বলতে পারলে interviewer impressed হয়।
- Composite pattern প্রায়ই **Visitor pattern** এর সাথে combine করা হয় — tree traverse করে নতুন operation চালানোর জন্য (নিচে #22 দেখুন)।

---

## 9. Decorator Pattern

### 📖 Definition
**English:** Decorator pattern lets you attach **new behaviors to an object dynamically** by wrapping it inside decorator objects, without altering the original object's structure or affecting other instances of the same class.

**বাংলা:** Decorator pattern একটা object এ **dynamically নতুন behavior/feature যুক্ত করতে** দেয়, object টাকে একটা wrapper/decorator object এর ভেতরে রেখে — original class এর code change না করেই, এবং অন্য instance গুলোতে কোনো effect না ফেলেই। যেমন — একটা plain কফিতে আপনি চাইলে দুধ, চিনি, ক্যারামেল যুক্ত করতে পারেন — প্রতিটা addition একটা "layer/decoration", কফি কাপটা একই থাকে কিন্তু feature বাড়ছে।

### 💻 JavaScript Implementation

```javascript
// Base component
class Coffee {
  cost() { return 50; } // basic coffee price (BDT তে)
  description() { return "Coffee"; }
}

// Base Decorator — একই interface মেইনটেইন করে, but wraps another component
class CoffeeDecorator {
  constructor(coffee) {
    this.coffee = coffee;
  }
  cost() {
    return this.coffee.cost();
  }
  description() {
    return this.coffee.description();
  }
}

// Concrete Decorators — প্রতিটা নতুন একটা feature/cost যুক্ত করছে
class MilkDecorator extends CoffeeDecorator {
  cost() {
    return this.coffee.cost() + 15;
  }
  description() {
    return this.coffee.description() + " + Milk";
  }
}

class SugarDecorator extends CoffeeDecorator {
  cost() {
    return this.coffee.cost() + 5;
  }
  description() {
    return this.coffee.description() + " + Sugar";
  }
}

class CaramelDecorator extends CoffeeDecorator {
  cost() {
    return this.coffee.cost() + 25;
  }
  description() {
    return this.coffee.description() + " + Caramel";
  }
}

// ---- USAGE / TEST ----
let myCoffee = new Coffee();
console.log(myCoffee.description(), "=", myCoffee.cost(), "BDT");
// "Coffee = 50 BDT"

myCoffee = new MilkDecorator(myCoffee);
myCoffee = new SugarDecorator(myCoffee);
myCoffee = new CaramelDecorator(myCoffee);

console.log(myCoffee.description(), "=", myCoffee.cost(), "BDT");
// "Coffee + Milk + Sugar + Caramel = 95 BDT"
```

### 🔍 Deep Explanation
**বাংলা ব্যাখ্যা:** `CoffeeDecorator` একটা base wrapper class যা `Coffee` এর মতো একই interface (`cost()`, `description()`) রাখে, কিন্তু ভেতরে একটা `Coffee` instance ধরে রাখে (`this.coffee`)। প্রতিটা concrete decorator (`MilkDecorator`, `SugarDecorator`) তার own logic চালায় এবং তারপর wrapped object এর method কে call করে result এর সাথে যুক্ত করে (`this.coffee.cost() + 15`)। আমরা যখন `new CaramelDecorator(new SugarDecorator(new MilkDecorator(coffee)))` এর মতো **nested wrapping** করি, তখন প্রতিটা layer একটার পর একটা যুক্ত হয় — এটাই "decoration"। মূল `Coffee` class কখনো change হচ্ছে না, এবং অন্য কোনো coffee instance এতে প্রভাবিত হচ্ছে না — কারণ প্রতিটা wrapping নতুন object তৈরি করছে।

**English:** Each decorator wraps the previous object and adds its own logic before/after delegating to the wrapped object's method. Chaining decorators (`new SugarDecorator(new MilkDecorator(coffee))`) stacks behaviors dynamically at runtime, without touching the original `Coffee` class or affecting other coffee instances. This follows the Open/Closed Principle perfectly.

### 🧪 Simple Examples (2)
1. **Text Formatter Decorator:** Plain text কে `BoldDecorator`, `ItalicDecorator`, `UnderlineDecorator` দিয়ে wrap করে formatting যুক্ত করা।
2. **Pizza Topping Decorator:** Base pizza এর উপর `CheeseDecorator`, `OliveDecorator` চাপিয়ে price/description বাড়ানো।

### 🏢 Industry Use Case Examples (2)
1. **Express.js Middleware (conceptually similar):** যদিও Express middleware টেকনিক্যালি Chain of Responsibility, কিন্তু **HOC (Higher-Order Component) in React** একটা সরাসরি Decorator pattern এর উদাহরণ —
   ```javascript
   // React HOC pattern — Decorator এর JS/React version
   function withLogging(WrappedComponent) {
     return function EnhancedComponent(props) {
       console.log("Rendering with props:", props);
       return WrappedComponent(props);
     };
   }
   function UserCard(props) {
     return `<div>${props.name}</div>`;
   }
   const LoggedUserCard = withLogging(UserCard);
   console.log(LoggedUserCard({ name: "Musfique" }));
   // logs: "Rendering with props: { name: 'Musfique' }"
   // returns: "<div>Musfique</div>"
   ```
2. **API Response Caching/Compression Layer:** একটা base `ApiService.fetchData()` কে `CachingDecorator` এবং `CompressionDecorator` দিয়ে wrap করা হয়, যাতে original service টা না বদলিয়েই caching আর compression feature যুক্ত করা যায়।
   ```javascript
   class ApiService {
     fetchData(id) { return `Data for ${id}`; }
   }
   class CachingDecorator {
     constructor(service) { this.service = service; this.cache = {}; }
     fetchData(id) {
       if (this.cache[id]) return `[CACHED] ${this.cache[id]}`;
       const result = this.service.fetchData(id);
       this.cache[id] = result;
       return result;
     }
   }
   const cachedApi = new CachingDecorator(new ApiService());
   console.log(cachedApi.fetchData(1)); // "Data for 1"
   console.log(cachedApi.fetchData(1)); // "[CACHED] Data for 1"
   ```

### ✅ Pros
- Runtime এ dynamically behavior add/remove করা যায়, inheritance এর মতো compile-time এ fix না হয়ে।
- একাধিক decorator combine করে অসংখ্য combination বানানো যায়, প্রতিটার জন্য আলাদা subclass বানাতে হয় না (class explosion এড়ানো)।
- Single Responsibility বজায় থাকে — প্রতিটা decorator একটা specific feature এর জন্য responsible।

### ❌ Cons
- অনেক decorator stack করলে code বোঝা/debug করা কঠিন হয়ে যায় (deep nesting)।
- Decorator এর order মাঝে মাঝে matter করে — ভুল order এ wrap করলে unexpected result আসতে পারে।

### 🤔 When to Use
- যখন একটা object এ runtime এ optional feature/behavior যুক্ত করতে চান, inheritance দিয়ে static ভাবে না করে।
- যখন subclassing করলে class এর সংখ্যা exponentially বেড়ে যাবে (যেমন প্রতিটা topping combination এর জন্য আলাদা Pizza subclass)।

### 🚫 When NOT to Use
- যখন behavior simple এবং fixed, পরিবর্তনের সম্ভাবনা নেই — তখন সরাসরি class এ method রাখাই ভালো।
- যখন decorator এর stack অনেক বড় হয়ে যাবে এবং debugging কঠিন করে তুলবে।

### 💡 Extra Interview Tips
- **Decorator vs Inheritance পার্থক্য:** Inheritance compile-time এ behavior fix করে দেয় (static), Decorator runtime এ dynamically combine করা যায় (flexible)।
- JavaScript এর actual `@decorator` syntax (TypeScript/Babel এ ব্যবহৃত, যেমন `@Component`, `@Injectable` in Angular/NestJS) এই pattern থেকেই inspired, যদিও implementation ভিন্ন (এটা মেটাডেটা/annotation যুক্ত করে, ক্লাসিক wrapping না)। এই পার্থক্যটা জানা থাকলে interview এ ভালো impression হয়।

---

## 10. Facade Pattern

### 📖 Definition
**English:** Facade pattern provides a **simplified, unified interface** to a complex subsystem of classes, hiding its internal complexity from the client.

**বাংলা:** Facade pattern একটা জটিল system এর সামনে একটা **সহজ, single interface** তৈরি করে দেয়, যাতে ভেতরের complexity client থেকে hide থাকে। যেমন — একটা গাড়ির ignition বাটন একটাই, কিন্তু পেছনে fuel injection, battery check, starter motor activation — অনেক জটিল কাজ একসাথে হয়। আপনি শুধু একটা বাটন চাপেন, পুরো জটিল process আপনার থেকে hidden।

### 💻 JavaScript Implementation

```javascript
// জটিল subsystem — আলাদা আলাদা ক্লাস, প্রতিটার নিজের নিজের কাজ
class CPU {
  start() { return "CPU: Booting up..."; }
}
class Memory {
  load() { return "Memory: Loading data into RAM..."; }
}
class HardDrive {
  read() { return "HardDrive: Reading OS files..."; }
}
class Display {
  turnOn() { return "Display: Showing boot screen..."; }
}

// Facade — সহজ interface যা ভেতরের complexity hide করে
class ComputerFacade {
  constructor() {
    this.cpu = new CPU();
    this.memory = new Memory();
    this.hardDrive = new HardDrive();
    this.display = new Display();
  }

  // একটা simple method — client কে অনেক step জানতে হচ্ছে না
  startComputer() {
    const steps = [
      this.cpu.start(),
      this.hardDrive.read(),
      this.memory.load(),
      this.display.turnOn(),
    ];
    return steps.join("\n");
  }
}

// ---- USAGE / TEST ----
const computer = new ComputerFacade();
console.log(computer.startComputer());
// CPU: Booting up...
// HardDrive: Reading OS files...
// Memory: Loading data into RAM...
// Display: Showing boot screen...
```

### 🔍 Deep Explanation
**বাংলা ব্যাখ্যা:** Client (আমাদের usage code) কে `CPU`, `Memory`, `HardDrive`, `Display` — এই ৪টা আলাদা ক্লাস এবং তাদের method এর order জানতে হচ্ছে না। `ComputerFacade` একটা single method `startComputer()` এর ভেতরে সবকিছু coordinate করে দিচ্ছে — কোন order এ কোন subsystem call হবে, সেই knowledge Facade এর ভেতরে encapsulated। এর ফলে client code অনেক simple এবং clean থাকে, এবং subsystem এর internal change হলেও (যতক্ষণ Facade এর public method একই থাকে) client code touch করতে হয় না।

**English:** The client doesn't need to know about `CPU`, `Memory`, `HardDrive`, or `Display` individually, or the correct order to call them. `ComputerFacade.startComputer()` encapsulates that orchestration logic. This decouples client code from subsystem internals — if the subsystem changes internally, the client remains unaffected as long as the facade's public API stays the same.

### 🧪 Simple Examples (2)
1. **Home Theater Facade:** `watchMovie()` একটা method — যা ভেতরে projector on, lights dim, sound system setup — সবকিছু করে দেয়।
2. **Order Placement Facade:** `placeOrder()` method — ভেতরে inventory check, payment process, shipping schedule — সব subsystem coordinate করে।

### 🏢 Industry Use Case Examples (2)
1. **E-commerce Checkout Facade:** একটা checkout process এ inventory, payment, shipping, notification — সব আলাদা service থাকে, কিন্তু client একটাই method কল করে —
   ```javascript
   class InventoryService {
     checkStock(item) { return `${item} is in stock`; }
   }
   class PaymentService {
     charge(amount) { return `Charged ${amount} BDT`; }
   }
   class ShippingService {
     schedule(address) { return `Shipping scheduled to ${address}`; }
   }
   class NotificationService {
     sendEmail() { return "Confirmation email sent"; }
   }

   class CheckoutFacade {
     constructor() {
       this.inventory = new InventoryService();
       this.payment = new PaymentService();
       this.shipping = new ShippingService();
       this.notification = new NotificationService();
     }
     placeOrder(item, amount, address) {
       return [
         this.inventory.checkStock(item),
         this.payment.charge(amount),
         this.shipping.schedule(address),
         this.notification.sendEmail(),
       ].join("\n");
     }
   }

   const checkout = new CheckoutFacade();
   console.log(checkout.placeOrder("Laptop", 85000, "Dhaka"));
   ```
2. **jQuery (historically):** jQuery নিজেই DOM manipulation, AJAX, animation — অনেক জটিল browser API এর উপর একটা সহজ Facade ছিল। `$.ajax()` এর পেছনে `XMLHttpRequest` এর অনেক জটিল configuration hide করা থাকত।

### ✅ Pros
- জটিল subsystem কে simple, easy-to-use interface এর পেছনে hide করে client code কে readable/maintainable বানায়।
- Subsystem এর internal change client code কে প্রভাবিত করে না (loose coupling)।
- নতুন developer দ্রুত system ব্যবহার করতে পারে, পুরো internal architecture না শিখেই।

### ❌ Cons
- Facade নিজেই একটা **"god object"** এ পরিণত হতে পারে যদি অতিরিক্ত responsibility চাপানো হয়।
- Subsystem এর সব feature/flexibility সরাসরি expose না হওয়ায়, advanced use case এ Facade bypass করে সরাসরি subsystem access করার দরকার হতে পারে।

### 🤔 When to Use
- যখন একটা জটিল subsystem আছে এবং client কে সহজ entry point দিতে চান।
- Layered architecture এ একটা layer কে অন্য layer থেকে আলাদা রাখতে (যেমন API layer service layer এর জটিলতা hide করে)।

### 🚫 When NOT to Use
- যখন subsystem এর প্রতিটা detail/flexibility client এর সরাসরি লাগবে — তখন Facade সেই access সীমিত করে ফেলতে পারে।
- অতিরিক্ত ছোট subsystem এর জন্য Facade বানানো অপ্রয়োজনীয় layer যুক্ত করে।

### 💡 Extra Interview Tips
- **Facade vs Adapter পার্থক্য:** Adapter একটা existing interface কে অন্য একটা interface এ রূপান্তর করে (same level of complexity, ভিন্ন shape), Facade একাধিক জটিল interface কে simplify করে একটা নতুন, সহজ interface বানায়।
- Real-world এ Node.js এর `fs.promises` module — পুরনো callback-based `fs` module এর উপর একটা simplified Promise-based facade।

---

## 11. Flyweight Pattern

### 📖 Definition
**English:** Flyweight pattern minimizes memory usage by **sharing common parts of objects' state** between multiple objects, instead of storing the same data redundantly in each instance.

**বাংলা:** Flyweight pattern memory বাঁচানোর জন্য object এর **common/shared data** কে একটা জায়গায় রেখে multiple object এর মধ্যে reuse করে — প্রতিটা object এ একই data বার বার store না করে। যেমন — একটা text editor এ লক্ষ লক্ষ character আছে, কিন্তু প্রতিটা character এর জন্য আলাদা "font object" না বানিয়ে, একই font (Arial, 12pt) ব্যবহার করা সব character একটাই shared font object reference করে।

### 💻 JavaScript Implementation

```javascript
// Flyweight — shared, immutable data (intrinsic state)
class TreeType {
  constructor(name, color, texture) {
    this.name = name;
    this.color = color;
    this.texture = texture; // ধরা যাক এটা একটা heavy image data
  }
  draw(x, y) {
    return `Drawing ${this.name} tree (${this.color}) at (${x}, ${y})`;
  }
}

// Flyweight Factory — একই type বার বার বানানোর বদলে reuse করে
class TreeTypeFactory {
  static #treeTypes = new Map();

  static getTreeType(name, color, texture) {
    const key = `${name}_${color}_${texture}`;
    if (!TreeTypeFactory.#treeTypes.has(key)) {
      console.log(`Creating NEW TreeType: ${key}`);
      TreeTypeFactory.#treeTypes.set(key, new TreeType(name, color, texture));
    } else {
      console.log(`Reusing EXISTING TreeType: ${key}`);
    }
    return TreeTypeFactory.#treeTypes.get(key);
  }
}

// Context — unique/extrinsic state (position) আলাদাভাবে রাখে
class Tree {
  constructor(x, y, treeType) {
    this.x = x;
    this.y = y;
    this.treeType = treeType; // shared flyweight reference
  }
  draw() {
    return this.treeType.draw(this.x, this.y);
  }
}

// ---- USAGE / TEST ----
const forest = [];
function plantTree(x, y, name, color, texture) {
  const type = TreeTypeFactory.getTreeType(name, color, texture);
  forest.push(new Tree(x, y, type));
}

plantTree(10, 20, "Oak", "Green", "rough.png");
plantTree(15, 25, "Oak", "Green", "rough.png"); // same type — reuse হবে
plantTree(30, 40, "Pine", "DarkGreen", "smooth.png");

forest.forEach(tree => console.log(tree.draw()));
// Creating NEW TreeType: Oak_Green_rough.png
// Reusing EXISTING TreeType: Oak_Green_rough.png
// Creating NEW TreeType: Pine_DarkGreen_smooth.png
// "Drawing Oak tree (Green) at (10, 20)"
// "Drawing Oak tree (Green) at (15, 25)"
// "Drawing Pine tree (DarkGreen) at (30, 40)"
```

### 🔍 Deep Explanation
**বাংলা ব্যাখ্যা:** এখানে দুই ধরনের state আলাদা করা হয়েছে — **intrinsic state** (`TreeType` এর name, color, texture — যা অনেক tree তে একই থাকে, শেয়ার করা যায়) এবং **extrinsic state** (`Tree` এর x, y position — যা প্রতিটা tree এর জন্য unique, শেয়ার করা যায় না)। `TreeTypeFactory` একটা Map এ already-created TreeType গুলো cache করে রাখে — একই ধরনের tree (Oak, Green, rough texture) বার বার চাইলে নতুন object না বানিয়ে পুরনোটাই reuse করে। লক্ষ লক্ষ গাছ থাকলেও, যদি মাত্র ১০-২০ ধরনের tree type থাকে, তাহলে memory তে মাত্র ১০-২০টা `TreeType` object থাকবে, আর প্রতিটা `Tree` object শুধু position + একটা reference রাখবে — অনেক memory বাঁচবে।

**English:** State is split into **intrinsic** (shared, immutable — like tree type/texture) and **extrinsic** (unique per object — like position). The factory caches and reuses flyweight objects by a key, so even with millions of `Tree` instances, only a handful of unique `TreeType` objects exist in memory. Each `Tree` just stores a lightweight reference plus its unique data.

### 🧪 Simple Examples (2)
1. **Text Character Formatting:** একটা document এ হাজার হাজার character, কিন্তু font style (bold, italic, font-family) মাত্র কয়েকটা — সব character একই style object share করে।
2. **Particle System (game):** হাজার হাজার bullet/particle, কিন্তু sprite/texture মাত্র কয়েক ধরনের — সব particle একই texture object reference করে, position আলাদা রাখে।

### 🏢 Industry Use Case Examples (2)
1. **Icon/Image Caching in UI Libraries:** একটা dashboard এ হাজার হাজার row আছে, প্রতিটাতে একটা status icon (✅/❌) — যদি প্রতিটা row নতুন icon object বানায় তাহলে memory waste হয়। Flyweight দিয়ে status icon গুলো cache করে reuse করা হয়।
   ```javascript
   class IconCache {
     static #icons = new Map();
     static getIcon(type) {
       if (!IconCache.#icons.has(type)) {
         IconCache.#icons.set(type, { type, svgData: `<svg-${type}-data>` });
       }
       return IconCache.#icons.get(type);
     }
   }
   const row1Icon = IconCache.getIcon("success");
   const row2Icon = IconCache.getIcon("success");
   console.log(row1Icon === row2Icon); // true — same shared object
   ```
2. **String Interning (JS engines internally do this):** JavaScript engine গুলো ভেতরে ভেতরে identical string literal গুলোকে share করে রাখে (memory optimization), যা Flyweight pattern এর spirit follow করে — যদিও এটা language-level optimization, ডেভেলপার সরাসরি দেখতে পায় না।

### ✅ Pros
- লক্ষ লক্ষ similar object থাকলে **drastically memory বাঁচায়**।
- Performance বাড়ে কারণ object creation এর সংখ্যা কমে যায়।

### ❌ Cons
- Code complexity বাড়ে — intrinsic vs extrinsic state আলাদা করে design করা সহজ কাজ না।
- যদি extrinsic state বেশি হয়ে যায় (object এর বেশিরভাগ data unique), তাহলে Flyweight এর সুবিধা কমে যায়।
- Thread-safety/mutation নিয়ে সতর্ক থাকতে হয় — shared object accidentally mutate হলে সব reference এ effect পড়বে।

### 🤔 When to Use
- যখন অ্যাপে অনেক (হাজার/লক্ষ) object আছে যাদের মধ্যে অনেক common/shared data আছে।
- Memory একটা bottleneck হয়ে দাঁড়িয়েছে এমন পরিস্থিতিতে (game engine, large dataset rendering)।

### 🚫 When NOT to Use
- যখন object সংখ্যা কম, বা object গুলোর মধ্যে shared data নেই (সব unique)।
- যখন memory কোনো issue না, কিন্তু complexity বাড়িয়ে fellow developer দের জন্য code কঠিন করে তোলা অর্থহীন হবে।

### 💡 Extra Interview Tips
- Intrinsic vs Extrinsic state এর পার্থক্য স্পষ্ট করে বলতে পারা — এই pattern এর সবচেয়ে গুরুত্বপূর্ণ part, interviewer প্রায়ই এটাই জিজ্ঞেস করে।
- বাস্তব জীবনে এটা কম ব্যবহৃত হয় modern web dev এ (কারণ memory আগের মতো বড় constraint না), কিন্তু game development, large-scale data visualization (millions of map markers), বা text editor এর মতো জায়গায় এখনো খুব relevant।

---

## 12. Proxy Pattern

### 📖 Definition
**English:** Proxy pattern provides a **substitute or placeholder object** that controls access to another object, allowing you to perform something (validation, caching, logging, lazy loading) before or after the request reaches the original object.

**বাংলা:** Proxy pattern একটা **substitute/placeholder object** তৈরি করে যা আসল object এর access কে নিয়ন্ত্রণ করে — request টা আসল object এ পৌঁছানোর আগে বা পরে কিছু extra কাজ (validation, caching, logging, lazy loading) করার সুযোগ দেয়। যেমন — একটা credit card একটা bank account এর "proxy" — সরাসরি account এ হাত না দিয়ে, card দিয়ে controlled ভাবে access করা হয়, এবং card এ extra security check ও থাকে।

### 💻 JavaScript Implementation

```javascript
// Real Subject — আসল, heavy object
class RealImage {
  constructor(filename) {
    this.filename = filename;
    this.loadFromDisk(); // heavy/costly operation
  }
  loadFromDisk() {
    console.log(`Loading ${this.filename} from disk... (expensive!)`);
  }
  display() {
    console.log(`Displaying ${this.filename}`);
  }
}

// Proxy — RealImage এর মতো same interface রাখে, কিন্তু lazy loading করে
class ImageProxy {
  constructor(filename) {
    this.filename = filename;
    this.realImage = null; // আসল object এখনো তৈরি হয়নি
  }
  display() {
    if (!this.realImage) {
      // প্রথমবার display() কল হলেই RealImage তৈরি হবে — Lazy Loading
      this.realImage = new RealImage(this.filename);
    }
    this.realImage.display(); // already loaded থাকলে সরাসরি display
  }
}

// ---- USAGE / TEST ----
console.log("Creating proxy (no loading yet)...");
const image = new ImageProxy("photo.jpg");

console.log("First display call:");
image.display(); // এখন loadFromDisk() call হবে
// Loading photo.jpg from disk... (expensive!)
// Displaying photo.jpg

console.log("Second display call:");
image.display(); // আবার loadFromDisk() হবে না, আগের instance reuse হবে
// Displaying photo.jpg
```

### 🔍 Deep Explanation
**বাংলা ব্যাখ্যা:** `ImageProxy` ক্লাসটা `RealImage` এর মতো same interface (`display()`) রাখে, কিন্তু আসল heavy object (`RealImage`, যেটা constructor এ `loadFromDisk()` এর মতো costly কাজ করে) সাথে সাথে তৈরি করে না। যখনই প্রথমবার `display()` কল হয়, তখন actual `RealImage` তৈরি হয় (lazy initialization)। এর পরের বার `display()` কল হলে, আগের তৈরি করা instance reuse হয়, আবার disk থেকে load করতে হয় না। এই ভাবে Proxy আসল object এর জীবনযাত্রা (creation, access) সম্পূর্ণভাবে নিয়ন্ত্রণ করে, client (`image.display()` কল করা code) জানেও না ভেতরে lazy loading হচ্ছে।

**English:** `ImageProxy` exposes the same interface as `RealImage` but defers the expensive object creation (`loadFromDisk`) until it's actually needed (lazy initialization). On the first `display()` call, the real object is created; subsequent calls reuse it. The client interacts with the proxy exactly as it would with the real object — completely unaware that lazy loading or any other control logic is happening behind the scenes.

### 🧪 Simple Examples (2)
1. **Access Control Proxy:** একটা `DocumentProxy` যা `RealDocument` এর আগে user এর permission check করে, তারপর access দেয় বা deny করে।
2. **Logging Proxy:** একটা method call হওয়ার আগে/পরে automatically log করার জন্য proxy ব্যবহার করা।

### 🏢 Industry Use Case Examples (2)
1. **JavaScript এর Native `Proxy` Object (ES6):** JavaScript এ built-in `Proxy` class আছে যা সরাসরি এই pattern implement করে —
   ```javascript
   const realUser = { name: "Musfique", role: "engineer" };

   const userProxy = new Proxy(realUser, {
     get(target, property) {
       console.log(`Accessing property: ${property}`);
       return target[property];
     },
     set(target, property, value) {
       console.log(`Setting ${property} to ${value}`);
       target[property] = value;
       return true;
     }
   });

   console.log(userProxy.name); // logs "Accessing property: name", then "Musfique"
   userProxy.role = "senior engineer"; // logs "Setting role to senior engineer"
   ```
   এই native `Proxy` ব্যবহার হয় Vue 3 এর reactivity system এ (data change track করার জন্য), validation layer তৈরিতে, এবং API call interception এ।
2. **API Rate Limiting / Caching Proxy:** একটা backend service এর সামনে proxy layer রাখা হয় যা rate limiting, authentication check, বা response caching করে, আসল service এ পৌঁছানোর আগেই।
   ```javascript
   class RealApiService {
     fetchUser(id) { return `User data for ${id} from server`; }
   }
   class CachingProxy {
     constructor(service) { this.service = service; this.cache = new Map(); }
     fetchUser(id) {
       if (this.cache.has(id)) return `[CACHE] ${this.cache.get(id)}`;
       const data = this.service.fetchUser(id);
       this.cache.set(id, data);
       return data;
     }
   }
   const api = new CachingProxy(new RealApiService());
   console.log(api.fetchUser(1)); // "User data for 1 from server"
   console.log(api.fetchUser(1)); // "[CACHE] User data for 1 from server"
   ```

### ✅ Pros
- Real object এর access কে control করা যায় (security, validation, logging) — মূল object এর code touch না করেই।
- **Lazy loading** এর মাধ্যমে performance optimize করা যায় — heavy object দরকার না হওয়া পর্যন্ত তৈরি না করা।
- Caching, rate-limiting এর মতো cross-cutting concern গুলো cleanly আলাদা রাখা যায়।

### ❌ Cons
- Extra layer of indirection — response time এ ছোট একটা overhead যুক্ত হতে পারে।
- Code এর জটিলতা বাড়ে, debugging এ একটা extra hop যুক্ত হয় (request কোথায় গেল বোঝা কঠিন হতে পারে)।

### 🤔 When to Use
- যখন কোনো heavy object এর creation/access কে lazy বা controlled রাখতে চান।
- Access control, logging, caching, বা rate-limiting এর মতো cross-cutting concern যুক্ত করতে চান original object না বদলিয়ে।

### 🚫 When NOT to Use
- যখন object lightweight এবং access control এর কোনো প্রয়োজন নেই — তখন সরাসরি object ব্যবহার করাই ভালো।
- Performance-critical hot path এ যেখানে extra indirection layer অগ্রহণযোগ্য overhead তৈরি করে।

### 💡 Extra Interview Tips
- **Proxy vs Decorator পার্থক্য (কমন প্রশ্ন):** Decorator object এ নতুন **behavior/feature যুক্ত করে** (enhancement), Proxy object এর **access কে নিয়ন্ত্রণ করে** (control) — কাঠামো (structure) প্রায় একই রকম দেখতে, কিন্তু **intent** আলাদা।
- JavaScript এর built-in `Proxy` + `Reflect` API নিয়ে interview এ প্রশ্ন আসতে পারে — এটা practical, real example হিসেবে খুব strong পয়েন্ট।

---

# 🔄 CATEGORY 3: BEHAVIORAL PATTERNS
> **Behavioral patterns** focus on how objects **communicate and interact** with each other, and how responsibilities are distributed between them.

---

## 13. Chain of Responsibility Pattern

### 📖 Definition
**English:** Chain of Responsibility lets you pass a request along a **chain of handlers**, where each handler decides either to process the request or pass it to the next handler in the chain.

**বাংলা:** Chain of Responsibility pattern একটা request কে একটা **handler-এর chain** এর মধ্য দিয়ে পাস করে দেয়, যেখানে প্রতিটা handler ঠিক করে — সে নিজে এই request handle করবে, না পরের handler এর কাছে পাস করে দেবে। যেমন — অফিসে একটা leave application প্রথমে Team Lead এর কাছে যায়, সে approve করতে না পারলে Manager এর কাছে যায়, সেও না পারলে HR এর কাছে যায় — প্রতিটা স্তর নিজের ক্ষমতা অনুযায়ী handle করে বা পাস করে দেয়।

### 💻 JavaScript Implementation

```javascript
// Abstract Handler
class Handler {
  constructor() {
    this.nextHandler = null;
  }
  setNext(handler) {
    this.nextHandler = handler;
    return handler; // chaining এর জন্য
  }
  handle(request) {
    if (this.nextHandler) {
      return this.nextHandler.handle(request);
    }
    return `No handler could process request: ${request.amount}`;
  }
}

// Concrete Handlers
class TeamLeadHandler extends Handler {
  handle(request) {
    if (request.amount <= 5000) {
      return `Team Lead approved leave/expense of ${request.amount} BDT`;
    }
    return super.handle(request); // পরের handler এ পাস করো
  }
}

class ManagerHandler extends Handler {
  handle(request) {
    if (request.amount <= 20000) {
      return `Manager approved expense of ${request.amount} BDT`;
    }
    return super.handle(request);
  }
}

class HRHandler extends Handler {
  handle(request) {
    if (request.amount <= 100000) {
      return `HR approved expense of ${request.amount} BDT`;
    }
    return super.handle(request);
  }
}

// ---- USAGE / TEST ----
const teamLead = new TeamLeadHandler();
const manager = new ManagerHandler();
const hr = new HRHandler();

teamLead.setNext(manager).setNext(hr); // chain তৈরি করা হলো

console.log(teamLead.handle({ amount: 3000 }));   // Team Lead handles it
console.log(teamLead.handle({ amount: 15000 }));  // passes to Manager
console.log(teamLead.handle({ amount: 80000 }));  // passes to HR
console.log(teamLead.handle({ amount: 500000 })); // No one can handle
```

### 🔍 Deep Explanation
**বাংলা ব্যাখ্যা:** প্রতিটা handler (`TeamLeadHandler`, `ManagerHandler`, `HRHandler`) চেক করে request টা তার নিজের **threshold/ক্ষমতার মধ্যে আছে কিনা**। যদি থাকে, সে নিজেই handle করে এবং chain থেমে যায়। যদি না থাকে, সে `super.handle(request)` কল করে পরের handler এ request পাস করে দেয় (`this.nextHandler.handle()`)। `setNext()` method দিয়ে chain link করা হয় — প্রতিটা handler জানে তার পরে কে আছে, কিন্তু পুরো chain এর knowledge কারো একা নেই। Caller (`teamLead.handle()`) শুধু chain এর শুরুর handler কে কল করে, পুরো chain automatically traverse হয়।

**English:** Each handler checks if it can process the request (within its authority/threshold). If yes, it handles it and the chain stops. If no, it delegates to the next handler via `super.handle()`. The caller only invokes the first handler in the chain — the request automatically propagates until someone handles it or the chain ends.

### 🧪 Simple Examples (2)
1. **ATM Cash Dispenser:** ₹2000, ₹500, ₹100 নোটের handler chain — request amount অনুযায়ী কোন নোট কতটা দেওয়া হবে ঠিক করে।
2. **Customer Support Ticket Escalation:** Level 1 Support → Level 2 → Level 3 Engineer — যেই level সমস্যা সমাধান করতে পারে সেখানেই থেমে যায়।

### 🏢 Industry Use Case Examples (2)
1. **Express.js/Node.js Middleware Chain:** এটা Chain of Responsibility এর সবচেয়ে practical, real-world example —
   ```javascript
   class Middleware {
     constructor() { this.next = null; }
     setNext(mw) { this.next = mw; return mw; }
     handle(req) {
       if (this.next) return this.next.handle(req);
       return "Request processed successfully";
     }
   }
   class AuthMiddleware extends Middleware {
     handle(req) {
       if (!req.token) return "401: Unauthorized — no token";
       console.log("Auth passed");
       return super.handle(req);
     }
   }
   class ValidationMiddleware extends Middleware {
     handle(req) {
       if (!req.body) return "400: Bad Request — no body";
       console.log("Validation passed");
       return super.handle(req);
     }
   }
   const auth = new AuthMiddleware();
   const validation = new ValidationMiddleware();
   auth.setNext(validation);
   console.log(auth.handle({ token: "abc", body: { name: "test" } }));
   // "Auth passed" -> "Validation passed" -> "Request processed successfully"
   ```
2. **Form Validation Pipeline:** একটা input field validate করার সময় — `RequiredFieldValidator` → `LengthValidator` → `FormatValidator` — প্রতিটা validator চেক করে, fail হলে error দেয়, pass হলে পরের validator এ যায়।

### ✅ Pros
- Sender আর receiver এর মধ্যে **loose coupling** তৈরি হয় — sender জানে না exactly কে request handle করবে।
- নতুন handler যুক্ত করা বা chain এর order বদলানো সহজ — Open/Closed Principle মেনে চলে।
- Single Responsibility বজায় থাকে — প্রতিটা handler একটা specific concern এর জন্য responsible।

### ❌ Cons
- যদি chain ভুলভাবে configure করা হয় (যেমন কোনো handler set না করা), request unhandled থেকে যেতে পারে।
- Debug করা কঠিন হতে পারে — request আসলে কোন handler পর্যন্ত গিয়ে কোথায় থামল, ট্রেস করা সময়সাপেক্ষ হতে পারে লম্বা chain এ।

### 🤔 When to Use
- যখন একাধিক object request handle করতে পারে এবং exactly কে handle করবে runtime এ ঠিক হবে।
- Middleware/pipeline ধরনের architecture বানাতে চাইলে (validation, authentication, logging steps)।

### 🚫 When NOT to Use
- যখন handler এর সংখ্যা/order fixed এবং পরিবর্তনের সম্ভাবনা নেই — তখন simple if-else/switch যথেষ্ট।
- যখন request অবশ্যই কেউ না কেউ handle করবে এই guarantee দরকার এবং chain miss হওয়ার ঝুঁকি acceptable না (তখন explicit error handling বেশি safe)।

### 💡 Extra Interview Tips
- Express.js/Koa এর middleware (`app.use()`) — এটা practically Chain of Responsibility, interview এ এই example দিলে খুব strong impression হয়।
- **Chain of Responsibility vs Decorator পার্থক্য:** দুটোই object কে chain/wrap করে, কিন্তু Chain of Responsibility এ যেকোনো handler chain থামিয়ে দিতে পারে (request আর এগোয় না), Decorator এ সবসময় পুরো chain পার হয়ে যায় (সব decorator তাদের কাজ করে)।

---

## 14. Command Pattern

### 📖 Definition
**English:** Command pattern turns a **request into a standalone object** that contains all information about the request, allowing you to parameterize methods, queue requests, and support undo operations.

**বাংলা:** Command pattern একটা request/action কে একটা **standalone object** এ পরিণত করে, যার ভেতরে action সম্পর্কিত সব তথ্য থাকে। এর ফলে আপনি action গুলোকে parameter এর মতো pass করতে পারেন, queue করে রাখতে পারেন, বা undo করতে পারেন। যেমন — একটা restaurant এ অর্ডার স্লিপ একটা "command object" — waiter অর্ডার লিখে রাখে, chef সেটা পরে execute করে, এবং চাইলে অর্ডার বাতিল (undo) করা যায়।

### 💻 JavaScript Implementation

```javascript
// Command interface
class Command {
  execute() { throw new Error("Implement execute()"); }
  undo() { throw new Error("Implement undo()"); }
}

// Receiver — যার উপর actual কাজ হয়
class TextEditor {
  constructor() {
    this.text = "";
  }
  addText(text) {
    this.text += text;
  }
  removeText(length) {
    this.text = this.text.slice(0, -length);
  }
}

// Concrete Command
class AddTextCommand extends Command {
  constructor(editor, textToAdd) {
    super();
    this.editor = editor;
    this.textToAdd = textToAdd;
  }
  execute() {
    this.editor.addText(this.textToAdd);
  }
  undo() {
    this.editor.removeText(this.textToAdd.length);
  }
}

// Invoker — command গুলো store/manage করে, history রাখে
class CommandManager {
  constructor() {
    this.history = [];
  }
  executeCommand(command) {
    command.execute();
    this.history.push(command);
  }
  undoLast() {
    const command = this.history.pop();
    if (command) command.undo();
  }
}

// ---- USAGE / TEST ----
const editor = new TextEditor();
const manager = new CommandManager();

manager.executeCommand(new AddTextCommand(editor, "Hello "));
manager.executeCommand(new AddTextCommand(editor, "World"));
console.log(editor.text); // "Hello World"

manager.undoLast();
console.log(editor.text); // "Hello " — last command undone

manager.undoLast();
console.log(editor.text); // "" — everything undone
```

### 🔍 Deep Explanation
**বাংলা ব্যাখ্যা:** এখানে `AddTextCommand` একটা action (text যুক্ত করা) কে object এ রূপান্তরিত করেছে — এটার ভেতরে আছে কোন editor এর উপর কাজ করতে হবে (`this.editor`), কি data যুক্ত হবে (`this.textToAdd`), এবং কিভাবে কাজটা করতে হবে (`execute()`) ও কিভাবে undo করতে হবে (`undo()`)। `CommandManager` (Invoker) প্রতিটা execute হওয়া command কে `history` array তে রাখে। যখন undo করতে চাই, সবচেয়ে সাম্প্রতিক command টা history থেকে নিয়ে তার `undo()` method কল করি। এই decoupling এর কারণে — যে action ট্রিগার করছে (button click) তাকে জানতে হয় না action টা ঠিক কিভাবে কাজ করে, সে শুধু command object টা execute করে।

**English:** `AddTextCommand` encapsulates an action as an object — it knows the target (`editor`), the data (`textToAdd`), and both how to perform (`execute()`) and reverse (`undo()`) the action. The `CommandManager` (invoker) keeps a history stack of executed commands, enabling undo by popping and reversing the most recent one. This decouples the thing that triggers an action from the logic of how that action is performed.

### 🧪 Simple Examples (2)
1. **Remote Control Buttons:** প্রতিটা button একটা `Command` object ধরে রাখে (LightOnCommand, LightOffCommand) — button কে জানতে হয় না light কিভাবে কাজ করে।
2. **Calculator Operations:** `AddCommand`, `SubtractCommand` — প্রতিটা operation কে object করে রাখলে undo/redo সহজ হয়।

### 🏢 Industry Use Case Examples (2)
1. **Redux Actions (React state management):** Redux এর `action` object (`{ type: "ADD_TODO", payload: {...} }`) সরাসরি Command pattern এর একটা রূপ — প্রতিটা action একটা command যা describe করে কি কাজ করতে হবে, এবং reducer সেটা execute করে।
   ```javascript
   // Redux-style command/action pattern
   class TodoCommand {
     constructor(type, payload) {
       this.type = type;
       this.payload = payload;
     }
   }
   class TodoStore {
     constructor() { this.todos = []; this.history = []; }
     dispatch(command) {
       if (command.type === "ADD_TODO") {
         this.todos.push(command.payload);
         this.history.push(command);
       }
     }
     undo() {
       const last = this.history.pop();
       if (last && last.type === "ADD_TODO") {
         this.todos = this.todos.filter(t => t !== last.payload);
       }
     }
   }
   const store = new TodoStore();
   store.dispatch(new TodoCommand("ADD_TODO", "Learn Design Patterns"));
   console.log(store.todos); // ["Learn Design Patterns"]
   store.undo();
   console.log(store.todos); // []
   ```
2. **Task Queue System (Job Processing):** একটা background job processor (যেমন Bull/BullMQ এর মতো queue system) এ প্রতিটা job/task একটা command object — যেটা queue তে রাখা হয় এবং worker পরে এসে execute করে। এর সুবিধা হলো — task গুলো immediately execute না হয়ে later/asynchronously process করা যায়, retry করা যায়।

### ✅ Pros
- Action গুলোকে object বানিয়ে **queue, log, undo/redo** করার সুযোগ পাওয়া যায়।
- Sender (invoker) আর receiver এর মধ্যে decoupling হয় — invoker জানে না action exactly কিভাবে কাজ করে।
- নতুন command যুক্ত করা সহজ, existing code পরিবর্তন না করেই (Open/Closed Principle)।

### ❌ Cons
- প্রতিটা action এর জন্য একটা আলাদা command class বানাতে হয়, যা ছোট কাজের জন্য boilerplate বাড়িয়ে দিতে পারে।
- Simple, one-off action এর জন্য এটা অতিরিক্ত abstraction মনে হতে পারে।

### 🤔 When to Use
- যখন undo/redo functionality লাগবে।
- যখন action গুলো queue/schedule/log করতে চান (background jobs, task scheduling)।
- GUI button/menu item এর behavior কে parameterize করতে চাইলে।

### 🚫 When NOT to Use
- যখন simple, direct method call যথেষ্ট এবং undo/queueing এর কোনো প্রয়োজন নেই।
- ছোট scripts/applications এ যেখানে এই অতিরিক্ত abstraction এর কোনো practical benefit নেই।

### 💡 Extra Interview Tips
- Redux/Vuex এর action-reducer pattern, Git এর commit history (প্রতিটা commit একটা "command" যা revert করা যায়) — এই real-world analogy গুলো বলতে পারলে interviewer কে strong impression দেওয়া যায়।
- **Command vs Strategy পার্থক্য:** Command একটা action/request কে encapsulate করে (what to do, focus action এর উপর), Strategy একটা algorithm/behavior কে encapsulate করে (how to do something, focus পদ্ধতির উপর) — দুটো গঠনে কাছাকাছি কিন্তু intent আলাদা।

---

## 15. Iterator Pattern

### 📖 Definition
**English:** Iterator pattern provides a way to **access elements of a collection sequentially** without exposing its underlying structure (array, linked list, tree, etc.).

**বাংলা:** Iterator pattern একটা collection এর elements গুলোকে **একে একে access করার** একটা standard উপায় দেয়, কিন্তু collection টা ভেতরে কিভাবে structured (array, linked list, tree) সেটা জানার প্রয়োজন হয় না। যেমন — একটা TV remote এর "next channel" বাটন — আপনি জানেন না channel গুলো ভেতরে কিভাবে store করা আছে, শুধু "next" চাপলে পরের channel আসে।

### 💻 JavaScript Implementation

```javascript
// Custom Collection with its own internal structure
class BookCollection {
  constructor() {
    this.books = [];
  }
  addBook(book) {
    this.books.push(book);
  }
  // Symbol.iterator implement করলে এটা JS এর native for...of এর সাথে কাজ করবে
  [Symbol.iterator]() {
    let index = 0;
    const books = this.books;
    return {
      next() {
        if (index < books.length) {
          return { value: books[index++], done: false };
        }
        return { value: undefined, done: true };
      }
    };
  }
}

// ---- USAGE / TEST ----
const myBooks = new BookCollection();
myBooks.addBook("Clean Code");
myBooks.addBook("Design Patterns");
myBooks.addBook("The Pragmatic Programmer");

// for...of কাজ করছে, কারণ Symbol.iterator implement করা আছে
for (const book of myBooks) {
  console.log(book);
}
// Clean Code
// Design Patterns
// The Pragmatic Programmer

// Manual iterator usage
const iterator = myBooks[Symbol.iterator]();
console.log(iterator.next()); // { value: "Clean Code", done: false }
console.log(iterator.next()); // { value: "Design Patterns", done: false }
```

### 🔍 Deep Explanation
**বাংলা ব্যাখ্যা:** `BookCollection` এর ভেতরে data একটা plain array তে store করা আছে, কিন্তু সেই internal detail বাইরে থেকে জানার প্রয়োজন নেই। `[Symbol.iterator]()` method implement করলে JavaScript এর built-in `for...of` loop, spread operator (`...`), `Array.from()` — সবই স্বয়ংক্রিয়ভাবে এই custom object এর সাথে কাজ করতে পারে। `next()` method প্রতিবার কল হলে একটা `{ value, done }` object রিটার্ন করে — `done: true` হলে iteration শেষ। এই standard protocol টা মানলে আপনার custom collection টা JS এর সব built-in iteration feature এর সাথে seamlessly কাজ করবে, ভেতরে array থাকুক বা linked list — caller এর কোনো ফারাক বুঝতে হবে না।

**English:** The internal storage (array) is hidden — what matters is implementing the `[Symbol.iterator]()` protocol, which returns an object with a `next()` method yielding `{ value, done }`. This lets JavaScript's native `for...of`, spread operator, and destructuring work seamlessly with any custom collection, regardless of its internal data structure (array, linked list, tree, graph).

### 🧪 Simple Examples (2)
1. **Custom Range Iterator:** `new Range(1, 5)` যা `for...of` দিয়ে 1,2,3,4,5 generate করে, ভেতরে কোনো array store না করেই (lazy generation)।
2. **Playlist Iterator:** একটা music playlist এর songs একে একে access করা, `next()`, `hasNext()` method দিয়ে।

### 🏢 Industry Use Case Examples (2)
1. **Pagination Iterator for API Data:** Large dataset কে page-by-page fetch করে একটা unified iterator দেওয়া, যেখানে caller জানে না পেছনে multiple API call হচ্ছে —
   ```javascript
   class PaginatedAPIIterator {
     constructor(totalPages) {
       this.currentPage = 1;
       this.totalPages = totalPages;
     }
     [Symbol.iterator]() {
       let page = 1;
       const total = this.totalPages;
       return {
         next() {
           if (page <= total) {
             const data = `Data from page ${page}`; // আসলে এখানে real API call হতো
             page++;
             return { value: data, done: false };
           }
           return { value: undefined, done: true };
         }
       };
     }
   }
   const pages = new PaginatedAPIIterator(3);
   for (const pageData of pages) {
     console.log(pageData);
   }
   // "Data from page 1", "Data from page 2", "Data from page 3"
   ```
2. **Tree/Graph Traversal in File Explorers:** একটা nested folder structure এর সব file কে depth-first বা breadth-first ভাবে iterate করার জন্য custom iterator বানানো, যাতে caller folder structure এর জটিলতা না জেনেই সব file পেতে পারে।

### ✅ Pros
- Collection এর internal structure hide থাকে — encapsulation বজায় থাকে।
- Multiple iterator একসাথে একই collection এর উপর independently কাজ করতে পারে।
- JavaScript এর built-in iteration protocol (`for...of`, spread) এর সাথে seamlessly ইন্টিগ্রেট করা যায়।

### ❌ Cons
- ছোট, simple collection এর জন্য custom iterator বানানো অপ্রয়োজনীয় হতে পারে (array এর built-in method যথেষ্ট)।
- Iterator state management (যেমন multiple simultaneous iteration) এ ভুল হলে bug হতে পারে।

### 🤔 When to Use
- যখন একটা custom data structure (tree, graph, linked list) এর elements সহজভাবে traverse করার দরকার।
- যখন built-in JS iteration syntax (`for...of`) এর সাথে compatible হতে চান নিজের data structure কে।

### 🚫 When NOT to Use
- যখন simple array/object যথেষ্ট, এবং built-in array methods (`map`, `filter`, `forEach`) এ কাজ চলে যায়।
- যখন collection এর internal structure hide করার কোনো প্রয়োজন নেই।

### 💡 Extra Interview Tips
- JavaScript এ Iterator pattern প্রায় **language-level feature** — `Map`, `Set`, `Array`, `String` সবই built-in iterator implement করে। এটা জানা থাকলে interview এ ভালো পয়েন্ট পাওয়া যায়।
- **Generator function** (`function*`) ব্যবহার করলে `[Symbol.iterator]` manually লেখার দরকার পড়ে না — generator automatically iterator protocol satisfy করে, কোড অনেক ছোট হয়ে যায়:
  ```javascript
  class SimpleRange {
    constructor(start, end) { this.start = start; this.end = end; }
    *[Symbol.iterator]() {
      for (let i = this.start; i <= this.end; i++) yield i;
    }
  }
  console.log([...new SimpleRange(1, 5)]); // [1, 2, 3, 4, 5]
  ```

---

## 16. Mediator Pattern

### 📖 Definition
**English:** Mediator pattern centralizes complex communications between multiple objects into a single **mediator object**, so objects don't communicate directly with each other and don't need to know about each other.

**বাংলা:** Mediator pattern একাধিক object এর মধ্যে জটিল communication কে একটা **single mediator object** এর মধ্যে centralize করে দেয়, ফলে object গুলো একে অপরের সাথে সরাসরি communicate করে না, এবং একে অপরের অস্তিত্ব সম্পর্কে জানার দরকারও হয় না। যেমন — এয়ারপোর্টে control tower (mediator) — সব plane সরাসরি একে অপরের সাথে communicate করে না, সবাই control tower এর সাথে communicate করে, control tower বাকি সব coordinate করে।

### 💻 JavaScript Implementation

```javascript
// Mediator
class ChatRoomMediator {
  constructor() {
    this.users = [];
  }
  register(user) {
    this.users.push(user);
    user.mediator = this;
  }
  // একটা user মেসেজ পাঠালে, mediator সেটা বাকি সবাইকে distribute করে
  sendMessage(message, fromUser) {
    this.users
      .filter(user => user !== fromUser)
      .forEach(user => user.receive(message, fromUser.name));
  }
}

// Participant — শুধু mediator এর সাথে communicate করে, অন্য user দের সরাসরি জানে না
class User {
  constructor(name) {
    this.name = name;
    this.mediator = null;
  }
  send(message) {
    console.log(`${this.name} sends: ${message}`);
    this.mediator.sendMessage(message, this);
  }
  receive(message, fromName) {
    console.log(`${this.name} received from ${fromName}: ${message}`);
  }
}

// ---- USAGE / TEST ----
const chatRoom = new ChatRoomMediator();

const alice = new User("Alice");
const bob = new User("Bob");
const charlie = new User("Charlie");

chatRoom.register(alice);
chatRoom.register(bob);
chatRoom.register(charlie);

alice.send("Hi everyone!");
// Alice sends: Hi everyone!
// Bob received from Alice: Hi everyone!
// Charlie received from Alice: Hi everyone!
```

### 🔍 Deep Explanation
**বাংলা ব্যাখ্যা:** এখানে `User` class গুলো একে অপরের reference রাখে না — `alice.send()` কল করলে এটা সরাসরি `bob` বা `charlie` কে জানায় না, বরং `this.mediator.sendMessage()` কল করে। `ChatRoomMediator` জানে কোন কোন user registered আছে, এবং সে responsibility নিয়ে message টা বাকি সবার কাছে পাঠিয়ে দেয় (`receive()` কল করে)। যদি Mediator না থাকত, প্রতিটা `User` কে প্রতিটা অন্য `User` এর reference রাখতে হতো — N users থাকলে N² সম্পর্ক তৈরি হতো (everyone-knows-everyone)। Mediator দিয়ে এটা N সম্পর্কে নেমে আসে (everyone-knows-mediator-only)।

**English:** `User` objects never reference each other directly — `alice.send()` only talks to `this.mediator`. The `ChatRoomMediator` knows all registered users and takes responsibility for distributing the message. Without a mediator, you'd need N² relationships (everyone knows everyone); with it, you only need N relationships (everyone knows the mediator), drastically reducing coupling.

### 🧪 Simple Examples (2)
1. **Air Traffic Control:** একাধিক plane সরাসরি একে অপরের সাথে communicate করে না, সবাই control tower এর মাধ্যমে coordinate হয়।
2. **Form Field Validation Mediator:** একটা form এ multiple field (password, confirm password) — সরাসরি একে অপরের সাথে check না করে, একটা FormMediator centrally validation logic চালায়।

### 🏢 Industry Use Case Examples (2)
1. **UI Component Coordination (Dashboard widgets):** একটা dashboard এ multiple widget (filter dropdown, chart, table) — filter বদলালে chart আর table দুটোই update হওয়া দরকার। সরাসরি widget-to-widget coupling এর বদলে একটা mediator ব্যবহার করা হয়।
   ```javascript
   class DashboardMediator {
     constructor() { this.widgets = {}; }
     register(name, widget) {
       this.widgets[name] = widget;
       widget.mediator = this;
     }
     notify(senderName, event, data) {
       Object.entries(this.widgets).forEach(([name, widget]) => {
         if (name !== senderName) widget.onEvent(event, data);
       });
     }
   }
   class FilterWidget {
     constructor() { this.mediator = null; }
     changeFilter(value) {
       console.log(`Filter changed to: ${value}`);
       this.mediator.notify("filter", "FILTER_CHANGED", value);
     }
     onEvent() {}
   }
   class ChartWidget {
     constructor() { this.mediator = null; }
     onEvent(event, data) {
       if (event === "FILTER_CHANGED") console.log(`Chart updating for filter: ${data}`);
     }
   }
   const dashboard = new DashboardMediator();
   const filter = new FilterWidget();
   const chart = new ChartWidget();
   dashboard.register("filter", filter);
   dashboard.register("chart", chart);
   filter.changeFilter("Last 7 days");
   // "Filter changed to: Last 7 days"
   // "Chart updating for filter: Last 7 days"
   ```
2. **Event Bus / Pub-Sub System in Frontend Apps:** Large React/Vue app এ component গুলোর মধ্যে direct prop-passing এর বদলে একটা central event bus (mediator) ব্যবহার করা হয়, deeply nested component এর মধ্যে communication সহজ করতে।

### ✅ Pros
- Object গুলোর মধ্যে **coupling drastically কমে যায়** (many-to-many থেকে many-to-one হয়)।
- Communication logic একটা জায়গায় centralized থাকে — maintain করা সহজ হয়।
- নতুন participant যুক্ত করা সহজ, existing participant গুলোর code পরিবর্তন না করেই।

### ❌ Cons
- Mediator নিজেই একটা **"god object"** এ পরিণত হতে পারে, যদি অতিরিক্ত responsibility জমা হয়।
- জটিল business logic centralize হয়ে গেলে mediator class টা maintain করা কঠিন হয়ে যেতে পারে।

### 🤔 When to Use
- যখন একাধিক object এর মধ্যে জটিল, many-to-many communication আছে।
- UI component গুলোর মধ্যে interaction simplify করতে চাইলে।

### 🚫 When NOT to Use
- যখন object গুলোর মধ্যে সম্পর্ক simple এবং সরাসরি communication এ কোনো সমস্যা নেই।
- ছোট প্রজেক্টে যেখানে শুধু ২-৩টা object communicate করে, Mediator বানালে over-engineering হবে।

### 💡 Extra Interview Tips
- **Mediator vs Observer পার্থক্য (কমন প্রশ্ন):** Observer এ একটা object (subject) এর state বদলালে সব listener directly notify হয় (one-to-many, broadcast), Mediator এ object গুলো একে অপরের সাথে communicate করার জন্য একটা central hub ব্যবহার করে (many-to-many coordination, logic mediator এর ভেতরে)।
- Node.js এর `EventEmitter` কিছুটা Mediator+Observer দুটোর মিশ্রণ হিসেবে কাজ করে — practical উদাহরণ হিসেবে বলা যায়।

---

## 17. Memento Pattern

### 📖 Definition
**English:** Memento pattern lets you **capture and externalize an object's internal state** (without violating encapsulation) so that the object can be **restored to that state later** — the foundation of undo/redo mechanisms.

**বাংলা:** Memento pattern একটা object এর **internal state কে capture করে বাইরে save** রাখে (encapsulation না ভেঙেই), যাতে পরে প্রয়োজনে সেই object কে **আগের state এ ফিরিয়ে আনা** যায়। যেমন — video game এ "save point" — আপনি একটা checkpoint এ game save করেন, পরে মারা গেলে সেই save point থেকে আবার শুরু করতে পারেন, game এর internal complex state নিজে হাতে না বুঝেও।

### 💻 JavaScript Implementation

```javascript
// Memento — state এর snapshot ধরে রাখে, immutable
class EditorMemento {
  constructor(content) {
    this._content = content; // private-ish, বাইরে থেকে modify করা উচিত না
  }
  getContent() {
    return this._content;
  }
}

// Originator — যার state save/restore হবে
class TextEditor {
  constructor() {
    this.content = "";
  }
  type(text) {
    this.content += text;
  }
  save() {
    // বর্তমান state এর একটা snapshot/memento বানিয়ে রিটার্ন করে
    return new EditorMemento(this.content);
  }
  restore(memento) {
    this.content = memento.getContent();
  }
}

// Caretaker — memento গুলোর history রাখে, কিন্তু ভেতরে কি আছে জানে না/দেখে না
class History {
  constructor() {
    this.mementos = [];
  }
  push(memento) {
    this.mementos.push(memento);
  }
  pop() {
    return this.mementos.pop();
  }
}

// ---- USAGE / TEST ----
const editor = new TextEditor();
const history = new History();

editor.type("Hello ");
history.push(editor.save()); // checkpoint 1

editor.type("World");
history.push(editor.save()); // checkpoint 2

editor.type("!!! (mistake)");
console.log(editor.content); // "Hello World!!! (mistake)"

editor.restore(history.pop()); // checkpoint 2 এ ফিরে গেলাম
console.log(editor.content); // "Hello World"

editor.restore(history.pop()); // checkpoint 1 এ ফিরে গেলাম
console.log(editor.content); // "Hello "
```

### 🔍 Deep Explanation
**বাংলা ব্যাখ্যা:** `TextEditor` (Originator) তার নিজের `content` state রাখে। যখন `save()` কল করা হয়, এটা একটা `EditorMemento` object বানায় যার ভেতরে current state এর copy থাকে — এই memento object টা immutable, এবং বাইরের কেউ এর ভেতরের data সরাসরি modify করতে পারে না, শুধু `getContent()` দিয়ে পড়তে পারে। `History` (Caretaker) এই memento গুলো একটা stack এ জমা রাখে, কিন্তু memento এর ভেতরে কি আছে সেটা নিয়ে কিছু জানে না বা মাথা ঘামায় না — সে শুধু সেগুলো store/retrieve করে। `restore()` কল করলে editor তার state কে memento এর data দিয়ে replace করে দেয়। এই তিনটা role (Originator, Memento, Caretaker) আলাদা থাকায় encapsulation বজায় থাকে — Caretaker editor এর internal structure জানে না।

**English:** The `TextEditor` (Originator) creates immutable `EditorMemento` snapshots of its state via `save()`. The `History` (Caretaker) stores these mementos without knowing or caring about their internal structure — it just manages the stack. Calling `restore()` resets the originator's state from a memento. This three-role separation keeps encapsulation intact: the caretaker never directly accesses or modifies the originator's internal state.

### 🧪 Simple Examples (2)
1. **Undo Button in a Drawing App:** প্রতিটা draw action এর পরে canvas state save করা, undo বাটনে আগের state এ ফিরে যাওয়া।
2. **Game Save/Checkpoint System:** Player এর position, health, inventory — একটা checkpoint এ save করে, মৃত্যুর পরে সেখান থেকে restore করা।

### 🏢 Industry Use Case Examples (2)
1. **Form State Undo (Rich Text Editors like Google Docs):** একটা document editor এ প্রতিটা significant change এর পরে state snapshot রাখা হয়, যাতে Ctrl+Z দিয়ে আগের version এ ফিরে যাওয়া যায়।
   ```javascript
   class DocumentState {
     constructor(text, cursorPosition) {
       this.text = text;
       this.cursorPosition = cursorPosition;
     }
   }
   class DocumentEditor {
     constructor() { this.text = ""; this.cursorPosition = 0; }
     type(text) {
       this.text += text;
       this.cursorPosition = this.text.length;
     }
     save() { return new DocumentState(this.text, this.cursorPosition); }
     restore(state) {
       this.text = state.text;
       this.cursorPosition = state.cursorPosition;
     }
   }
   ```
2. **Redux State Time-Travel Debugging:** Redux DevTools যেভাবে প্রতিটা action এর আগের/পরের state snapshot রাখে এবং developer কে কোনো একটা পুরনো state এ "time travel" করতে দেয় — এটা Memento pattern এর একটা বড় scale practical implementation।

### ✅ Pros
- Object এর internal state বাইরে expose না করেই save/restore করা যায় — encapsulation বজায় থাকে।
- Undo/redo এবং checkpoint/rollback এর মতো feature সহজে implement করা যায়।
- Originator এর code clean থাকে — state management logic Caretaker এ আলাদা থাকে।

### ❌ Cons
- যদি state অনেক বড়/জটিল হয় এবং প্রতিটা snapshot এ পুরো state copy হয়, তাহলে **memory consumption** বেশি হতে পারে।
- Memento গুলো manage করার (কতগুলো রাখা হবে, কখন delete হবে) জন্য আলাদা logic দরকার হতে পারে।

### 🤔 When to Use
- যখন undo/redo বা checkpoint/rollback ফাংশনালিটি দরকার।
- যখন object এর state এ direct access না দিয়েও তার history রাখতে চান।

### 🚫 When NOT to Use
- যখন object এর state খুবই বড়/heavy এবং বার বার snapshot নেওয়া performance/memory এর জন্য costly হয়ে যায় (তখন diff-based বা partial state saving বিবেচনা করা উচিত)।
- যখন undo/history feature এর কোনো প্রয়োজনই নেই।

### 💡 Extra Interview Tips
- Memento প্রায়ই **Command pattern** এর সাথে combine হয় — Command এর `undo()` ভেতরে Memento ব্যবহার করে আগের state restore করতে পারে।
- Deep copy vs shallow copy এর প্রসঙ্গ এখানেও আসে (Prototype pattern এর মতো) — state save করার সময় nested object থাকলে deep clone করা জরুরি, না হলে memento "mutate" হয়ে যেতে পারে original state এর সাথে।

---

## 18. Observer Pattern

### 📖 Definition
**English:** Observer pattern defines a **one-to-many dependency** between objects, so that when one object (the subject) changes state, all its dependents (observers) are automatically notified and updated.

**বাংলা:** Observer pattern একটা **one-to-many dependency** তৈরি করে — একটা object (subject) এর state বদলালে, তার উপর নির্ভরশীল সব object (observers) কে automatically notify করা হয়। যেমন — YouTube চ্যানেলে subscribe করা — চ্যানেল owner (subject) নতুন video আপলোড করলে, সব subscriber (observers) automatically notification পায়, channel owner কে আলাদা আলাদা করে প্রতিটা subscriber কে চিনতে/মনে রাখতে হয় না individually কোডে handle করতে।

### 💻 JavaScript Implementation

```javascript
// Subject (Observable)
class YouTubeChannel {
  constructor(name) {
    this.name = name;
    this.subscribers = [];
  }
  subscribe(observer) {
    this.subscribers.push(observer);
  }
  unsubscribe(observer) {
    this.subscribers = this.subscribers.filter(sub => sub !== observer);
  }
  uploadVideo(title) {
    console.log(`${this.name} uploaded: "${title}"`);
    this.notifyAll(title);
  }
  notifyAll(title) {
    this.subscribers.forEach(sub => sub.update(this.name, title));
  }
}

// Observer interface
class Subscriber {
  constructor(name) {
    this.name = name;
  }
  update(channelName, videoTitle) {
    console.log(`${this.name} got notified: ${channelName} uploaded "${videoTitle}"`);
  }
}

// ---- USAGE / TEST ----
const techChannel = new YouTubeChannel("Tech With Musfique");

const sub1 = new Subscriber("Rahim");
const sub2 = new Subscriber("Karim");

techChannel.subscribe(sub1);
techChannel.subscribe(sub2);

techChannel.uploadVideo("23 Design Patterns Explained");
// Tech With Musfique uploaded: "23 Design Patterns Explained"
// Rahim got notified: Tech With Musfique uploaded "23 Design Patterns Explained"
// Karim got notified: Tech With Musfique uploaded "23 Design Patterns Explained"

techChannel.unsubscribe(sub1);
techChannel.uploadVideo("Next Video");
// Only Karim gets notified now
```

### 🔍 Deep Explanation
**বাংলা ব্যাখ্যা:** `YouTubeChannel` (Subject) তার `subscribers` array তে সব observer রাখে। `subscribe()`/`unsubscribe()` দিয়ে observer যুক্ত/বাদ দেওয়া হয়। যখন `uploadVideo()` কল হয়, এটা `notifyAll()` কল করে যা প্রতিটা subscriber এর `update()` method কল করে। লক্ষ্য করুন — `YouTubeChannel` কে জানতে হয় না exactly কয়জন subscriber আছে বা তারা কে কে, সে শুধু generic `update()` interface এর সাথে কাজ করে। নতুন subscriber যুক্ত হলে existing code এর কোনো পরিবর্তন লাগে না — এটাই loose coupling।

**English:** The `YouTubeChannel` (subject) maintains a list of subscribers and calls `update()` on each whenever state changes (`uploadVideo`). The subject doesn't need to know concrete details about each subscriber — it only relies on the common `update()` interface. Adding/removing subscribers doesn't require changing the subject's code, achieving loose coupling between the publisher and its listeners.

### 🧪 Simple Examples (2)
1. **Weather Station:** Temperature sensor (subject) বদলালে সব display device (observers — phone app, smart watch) update হয়।
2. **Stock Price Ticker:** একটা stock এর price বদলালে সব investor (subscribers) যারা সেই stock track করছে, তারা notification পায়।

### 🏢 Industry Use Case Examples (2)
1. **JavaScript DOM Event Listeners:** এটাই সবচেয়ে practical, দৈনন্দিন উদাহরণ — `element.addEventListener("click", callback)` ভেতরে ভেতরে Observer pattern ব্যবহার করে।
   ```javascript
   // Native browser API নিজেই Observer pattern এর implementation
   const button = { listeners: [], addEventListener(fn) { this.listeners.push(fn); }, click() { this.listeners.forEach(fn => fn("clicked!")); } };
   button.addEventListener((event) => console.log("Handler 1:", event));
   button.addEventListener((event) => console.log("Handler 2:", event));
   button.click();
   // Handler 1: clicked!
   // Handler 2: clicked!
   ```
2. **React State Management (Redux store.subscribe / RxJS Observables):** Redux এর `store.subscribe(listener)` — store (subject) এর state বদলালে সব registered listener (UI components) automatically re-render এর জন্য notify হয়। RxJS এর পুরো library ই Observer pattern এর উপর ভিত্তি করে বানানো।
   ```javascript
   class Store {
     constructor(state) { this.state = state; this.listeners = []; }
     subscribe(listener) { this.listeners.push(listener); }
     setState(newState) {
       this.state = { ...this.state, ...newState };
       this.listeners.forEach(listener => listener(this.state));
     }
   }
   const store = new Store({ count: 0 });
   store.subscribe(state => console.log("Component A re-rendering:", state));
   store.setState({ count: 1 });
   // "Component A re-rendering: { count: 1 }"
   ```

### ✅ Pros
- Subject আর Observer এর মধ্যে **loose coupling** — subject জানে না observer গুলো exactly কি করছে।
- Runtime এ dynamically observer যুক্ত/বাদ দেওয়া যায়।
- **Open/Closed Principle** মেনে চলে — নতুন observer type যুক্ত করতে subject এর code change লাগে না।

### ❌ Cons
- যদি observer এর সংখ্যা অনেক বেশি হয় বা notification chain জটিল হয়, তাহলে **performance issue** এবং debug করা কঠিন হয়ে যেতে পারে।
- **Memory leak** এর ঝুঁকি থাকে — যদি observer ঠিকমতো unsubscribe না করা হয় (JS এ event listener memory leak এর কমন কারণ)।
- Notification এর order guarantee করা কঠিন হতে পারে, যদি observer গুলো একে অপরের উপর নির্ভর করে।

### 🤔 When to Use
- যখন একটা object এর state change এ একাধিক object কে react করতে হবে।
- Event-driven architecture, pub-sub system, real-time UI update দরকার হলে।

### 🚫 When NOT to Use
- যখন শুধু একটা observer আছে এবং সম্পর্ক সহজ — সরাসরি method call যথেষ্ট।
- যখন observer chain এর complexity ও memory leak risk handle করার মতো রিসোর্স/সতর্কতা নেই।

### 💡 Extra Interview Tips
- **Observer vs Pub-Sub পার্থক্য (গুরুত্বপূর্ণ প্রশ্ন):** Classic Observer pattern এ subject সরাসরি observer দের রেফারেন্স রাখে এবং সরাসরি কল করে (tight-ish coupling, কিন্তু interface দিয়ে), Pub-Sub এ একটা middle layer (message broker/event bus) থাকে — publisher আর subscriber একে অপরের অস্তিত্ব সম্পর্কেই জানে না।
- DOM events, Node.js `EventEmitter`, RxJS, Redux/Vuex, React's `useEffect` dependency tracking — সবকিছুর মূলে Observer pattern এর concept আছে, এই connection গুলো বলতে পারা interview এ অনেক ভ্যালু যুক্ত করে।

---

## 19. State Pattern

### 📖 Definition
**English:** State pattern allows an object to **change its behavior dynamically based on its internal state**, by delegating state-specific behavior to separate state objects, making it look like the object changed its class.

**বাংলা:** State pattern একটা object কে তার **internal state অনুযায়ী dynamically behavior পরিবর্তন** করতে দেয় — প্রতিটা state এর behavior একটা আলাদা state object এ রাখা হয়। যেমন — একটা traffic light: Red state এ থাকলে গাড়ি থামে, Green state এ থাকলে চলে — একই traffic light object, কিন্তু state বদলালে behavior সম্পূর্ণ আলাদা হয়ে যায়।

### 💻 JavaScript Implementation

```javascript
// State interface
class OrderState {
  next(order) { throw new Error("Implement next()"); }
  getStatus() { throw new Error("Implement getStatus()"); }
}

// Concrete States
class PendingState extends OrderState {
  next(order) {
    console.log("Order confirmed, moving to Shipped");
    order.setState(new ShippedState());
  }
  getStatus() { return "Pending"; }
}

class ShippedState extends OrderState {
  next(order) {
    console.log("Order delivered!");
    order.setState(new DeliveredState());
  }
  getStatus() { return "Shipped"; }
}

class DeliveredState extends OrderState {
  next(order) {
    console.log("Order already delivered, no further state.");
  }
  getStatus() { return "Delivered"; }
}

// Context — যার behavior state অনুযায়ী বদলায়
class Order {
  constructor() {
    this.state = new PendingState(); // initial state
  }
  setState(state) {
    this.state = state;
  }
  next() {
    this.state.next(this); // delegate করা হচ্ছে current state কে
  }
  getStatus() {
    return this.state.getStatus();
  }
}

// ---- USAGE / TEST ----
const order = new Order();
console.log(order.getStatus()); // "Pending"

order.next(); // "Order confirmed, moving to Shipped"
console.log(order.getStatus()); // "Shipped"

order.next(); // "Order delivered!"
console.log(order.getStatus()); // "Delivered"

order.next(); // "Order already delivered, no further state."
```

### 🔍 Deep Explanation
**বাংলা ব্যাখ্যা:** `Order` (Context) class টা নিজে কোনো if-else দিয়ে state check করে না — সে শুধু `this.state` এ current state object রাখে এবং সব কাজ সেই object এর কাছে **delegate** করে দেয় (`this.state.next(this)`)। প্রতিটা state class (`PendingState`, `ShippedState`, `DeliveredState`) জানে তার পরে কোন state আসবে এবং সেই অনুযায়ী `order.setState()` কল করে state বদলে দেয়। এই pattern এ মূল trick হলো — `next()` কল করলে exact behavior depend করে current state object টা কি, `Order` class এর কোড একই থাকলেও output আলাদা হয় কারণ delegate হওয়া object আলাদা।

**English:** The `Order` (context) doesn't use if-else chains to check its status — it simply delegates behavior to the current state object (`this.state.next(this)`). Each state class knows what the next state should be and transitions the context via `setState()`. This eliminates large conditional blocks and makes adding new states (e.g., `CancelledState`) just a matter of adding a new class.

### 🧪 Simple Examples (2)
1. **Traffic Light:** Red → Green → Yellow → Red — প্রতিটা state এর আলাদা behavior এবং next state।
2. **Media Player:** Playing, Paused, Stopped state — `play()`, `pause()` button এর behavior state অনুযায়ী আলাদা হয়।

### 🏢 Industry Use Case Examples (2)
1. **Document/Workflow Approval System:** একটা document এর state (Draft → Review → Approved → Published) — প্রতিটা state এ আলাদা action allowed/disallowed হয় —
   ```javascript
   class DocumentState {
     edit(doc) { console.log("Cannot edit in this state"); }
     submit(doc) { console.log("Cannot submit in this state"); }
   }
   class DraftState extends DocumentState {
     edit(doc) { console.log("Editing draft..."); }
     submit(doc) { console.log("Submitted for review"); doc.setState(new ReviewState()); }
   }
   class ReviewState extends DocumentState {
     submit(doc) { console.log("Approved!"); doc.setState(new ApprovedState()); }
   }
   class ApprovedState extends DocumentState {
     edit(doc) { console.log("Cannot edit an approved document"); }
   }
   class Document {
     constructor() { this.state = new DraftState(); }
     setState(s) { this.state = s; }
     edit() { this.state.edit(this); }
     submit() { this.state.submit(this); }
   }
   const doc = new Document();
   doc.edit();    // "Editing draft..."
   doc.submit();  // "Submitted for review"
   doc.edit();    // "Cannot edit in this state" (default base behavior)
   ```
2. **UI Component States (Loading/Success/Error):** একটা data-fetching component এর behavior (`render()`) তার state (Loading, Success, Error) অনুযায়ী সম্পূর্ণ আলাদা — many frontend state-machine library (XState) এই pattern কে formalize করে।

### ✅ Pros
- জটিল `if-else`/`switch` চেইন এর বদলে state-specific behavior আলাদা class এ organize করা যায় — code অনেক readable হয়।
- নতুন state যুক্ত করা সহজ (Open/Closed Principle) — existing state class গুলো touch করতে হয় না।
- State transition logic explicit এবং centralized থাকে প্রতিটা state class এর ভেতরে।

### ❌ Cons
- ছোট সংখ্যক state (২-৩টা) থাকলে আলাদা class বানানো overkill হতে পারে, simple if-else যথেষ্ট হতে পারে।
- State এর সংখ্যা বাড়ার সাথে সাথে class এর সংখ্যাও বাড়ে, যা প্রজেক্ট navigate করা কঠিন করে দিতে পারে।

### 🤔 When to Use
- যখন object এর behavior তার state অনুযায়ী dramatically পরিবর্তিত হয়, এবং state transition গুলো well-defined।
- যখন কোডে অনেক বড় `if-else`/`switch` block দেখা যায় যা state check করছে।

### 🚫 When NOT to Use
- যখন state সংখ্যা খুব কম এবং transition logic খুবই simple।
- যখন behavior state অনুযায়ী খুব একটা পরিবর্তিত হয় না।

### 💡 Extra Interview Tips
- **State vs Strategy পার্থক্য (অত্যন্ত কমন প্রশ্ন):** গঠনে দুটো প্রায় identical (composition দিয়ে behavior delegate করা), কিন্তু **intent আলাদা** — State pattern এ state object গুলো একে অপরের মধ্যে **transition** করে (state object নিজেই next state ঠিক করে), Strategy pattern এ client নিজে ইচ্ছামত algorithm/strategy বেছে নেয় এবং strategy গুলো একে অপরের কথা জানেও না বা transition করে না।
- Frontend এ XState এর মতো library সরাসরি State pattern কে একটা formal "state machine" এ পরিণত করে — এটা practical example হিসেবে interview এ উল্লেখ করা যায়।

---

## 20. Strategy Pattern

### 📖 Definition
**English:** Strategy pattern defines a family of **interchangeable algorithms**, encapsulates each one separately, and lets the client choose/swap which algorithm to use at runtime.

**বাংলা:** Strategy pattern একগুচ্ছ **পরিবর্তনযোগ্য algorithm** define করে, প্রতিটাকে আলাদা class এ encapsulate করে, এবং client কে runtime এ যেকোনো একটা algorithm বেছে নেওয়ার/পরিবর্তন করার সুযোগ দেয়। যেমন — Google Maps এ আপনি "Driving", "Walking", "Cycling" — যেকোনো route strategy বেছে নিতে পারেন, destination same থাকলেও algorithm আলাদা।

### 💻 JavaScript Implementation

```javascript
// Strategy interface
class SortStrategy {
  sort(data) { throw new Error("Implement sort()"); }
}

// Concrete Strategies
class BubbleSortStrategy extends SortStrategy {
  sort(data) {
    console.log("Sorting using Bubble Sort");
    return [...data].sort((a, b) => a - b); // simplified for demo
  }
}

class QuickSortStrategy extends SortStrategy {
  sort(data) {
    console.log("Sorting using Quick Sort");
    if (data.length <= 1) return data;
    const [pivot, ...rest] = data;
    const left = rest.filter(n => n < pivot);
    const right = rest.filter(n => n >= pivot);
    return [...this.sort(left), pivot, ...this.sort(right)];
  }
}

// Context — strategy কে holds করে এবং delegate করে
class Sorter {
  constructor(strategy) {
    this.strategy = strategy;
  }
  setStrategy(strategy) {
    this.strategy = strategy; // runtime এ strategy বদলানো যায়
  }
  sortData(data) {
    return this.strategy.sort(data);
  }
}

// ---- USAGE / TEST ----
const numbers = [5, 2, 8, 1, 9];

const sorter = new Sorter(new BubbleSortStrategy());
console.log(sorter.sortData(numbers)); // Sorting using Bubble Sort -> [1, 2, 5, 8, 9]

sorter.setStrategy(new QuickSortStrategy());
console.log(sorter.sortData(numbers)); // Sorting using Quick Sort -> [1, 2, 5, 8, 9]
```

### 🔍 Deep Explanation
**বাংলা ব্যাখ্যা:** `Sorter` (Context) class টা actual sorting algorithm জানে না — সে শুধু একটা `strategy` object hold করে এবং `sortData()` কল হলে সেটা delegate করে দেয় (`this.strategy.sort(data)`)। `setStrategy()` দিয়ে runtime এ algorithm বদলানো যায় — `BubbleSortStrategy` থেকে `QuickSortStrategy` এ switch করতে `Sorter` class এর কোনো কোড change লাগে না। এই pattern এর core idea হলো — **algorithm কে object এ encapsulate করে**, সেগুলোকে interchangeable বানানো, যাতে client নিজের প্রয়োজন অনুযায়ী যেকোনো একটা বেছে নিতে পারে।

**English:** The `Sorter` (context) doesn't know the actual sorting logic — it just holds a `strategy` object and delegates the work (`this.strategy.sort(data)`). `setStrategy()` allows swapping algorithms at runtime without touching the `Sorter` class itself. The core idea is encapsulating each algorithm as an interchangeable object that the client can select based on context (e.g., dataset size, performance needs).

### 🧪 Simple Examples (2)
1. **Payment Strategy:** Checkout এ `CreditCardStrategy`, `PayPalStrategy`, `CashStrategy` — যেকোনো একটা বেছে নিয়ে payment process করা।
2. **Discount Calculation Strategy:** `RegularCustomerDiscount`, `VIPCustomerDiscount`, `BlackFridayDiscount` — customer type অনুযায়ী আলাদা discount logic।

### 🏢 Industry Use Case Examples (2)
1. **Form Validation Strategies:** Input field এর type অনুযায়ী আলাদা validation strategy ব্যবহার করা —
   ```javascript
   class ValidationStrategy {
     validate(value) { throw new Error("Implement"); }
   }
   class EmailValidation extends ValidationStrategy {
     validate(value) { return /\S+@\S+\.\S+/.test(value); }
   }
   class PhoneValidation extends ValidationStrategy {
     validate(value) { return /^\d{11}$/.test(value); }
   }
   class FormField {
     constructor(strategy) { this.strategy = strategy; }
     isValid(value) { return this.strategy.validate(value); }
   }
   const emailField = new FormField(new EmailValidation());
   console.log(emailField.isValid("test@example.com")); // true
   console.log(emailField.isValid("invalid-email"));      // false
   ```
2. **Compression Algorithm Selection (file upload systems):** একটা file upload service যেখানে file type (image, video, document) অনুযায়ী আলাদা compression strategy (`JPEGCompression`, `VideoCompression`, `ZipCompression`) ব্যবহার হয়, এবং নতুন file format support করতে হলে নতুন strategy class যুক্ত করলেই হয়।

### ✅ Pros
- Algorithm গুলো independent class এ থাকায় easily test, maintain, এবং extend করা যায়।
- Runtime এ algorithm swap করা যায়, conditional (`if-else`) এড়িয়ে।
- **Open/Closed Principle** মেনে চলে — নতুন strategy যুক্ত করতে existing code পরিবর্তন লাগে না।

### ❌ Cons
- যদি strategy এর সংখ্যা কম থাকে এবং পরিবর্তনের সম্ভাবনা না থাকে, তাহলে এই pattern অতিরিক্ত class তৈরি করে অপ্রয়োজনীয় জটিলতা বাড়ায়।
- Client কে জানতে হয় কোন strategy কখন ব্যবহার করতে হবে — এই decision logic কোথাও না কোথাও থাকতেই হবে।

### 🤔 When to Use
- যখন একই কাজ করার একাধিক উপায়/algorithm আছে এবং runtime এ যেকোনোটা বেছে নেওয়ার প্রয়োজন।
- যখন কোডে multiple related class এ একই রকম `if-else`/`switch` দিয়ে আলাদা আলাদা algorithm select হচ্ছে দেখা যায়।

### 🚫 When NOT to Use
- যখন algorithm/behavior পরিবর্তনের কোনো সম্ভাবনা নেই, ভবিষ্যতেও না।
- যখন strategy এর সংখ্যা মাত্র একটা বা দুটো এবং সেগুলো খুবই simple — সরাসরি function parameter দিয়েও কাজ চলে যাবে।

### 💡 Extra Interview Tips
- JavaScript এ Strategy pattern প্রায়ই **function/callback** দিয়েও implement করা হয় (class ছাড়াই) — যেমন `array.sort(compareFunction)`, `array.map(callback)` — এগুলো নিজেরাই Strategy pattern এর lightweight version। এই connection বললে interview এ ভালো লাগবে।
- **Strategy vs State পার্থক্য** আগেই #19 এ আলোচনা করা হয়েছে — এটা পুনরায় মনে রাখা জরুরি কারণ এই দুটো pattern সবচেয়ে বেশি গুলিয়ে ফেলা হয় interview এ।

---

## 21. Template Method Pattern

### 📖 Definition
**English:** Template Method defines the **skeleton of an algorithm in a base class**, deferring some specific steps to subclasses, without changing the algorithm's overall structure.

**বাংলা:** Template Method pattern একটা algorithm এর **মূল skeleton/structure base class এ fix করে রাখে**, কিন্তু কিছু specific step subclass এর জন্য ছেড়ে দেয় (override করার জন্য) — algorithm এর overall sequence/order কখনো বদলায় না। যেমন — চা আর কফি বানানোর process একই রকম (পানি গরম করো → ফুটানো → কাপে ঢালো → পান করো), কিন্তু "ফুটানো" step এ tea bag বা coffee — এই specific অংশটাই আলাদা।

### 💻 JavaScript Implementation

```javascript
// Abstract base class — algorithm এর skeleton/template রাখে
class Beverage {
  // Template method — এই method এর structure/order fix, override করা যাবে না (conceptually final)
  prepare() {
    this.boilWater();
    this.brew();       // subclass-specific step
    this.pourInCup();
    this.addCondiments(); // subclass-specific step
    return "Beverage ready!";
  }

  boilWater() {
    console.log("Boiling water...");
  }
  pourInCup() {
    console.log("Pouring into cup...");
  }
  // এই দুটো method subclass এ override হবে
  brew() {
    throw new Error("Subclass must implement brew()");
  }
  addCondiments() {
    throw new Error("Subclass must implement addCondiments()");
  }
}

// Concrete subclasses — শুধু specific steps override করছে
class Tea extends Beverage {
  brew() {
    console.log("Steeping the tea bag...");
  }
  addCondiments() {
    console.log("Adding lemon...");
  }
}

class Coffee extends Beverage {
  brew() {
    console.log("Brewing the coffee grounds...");
  }
  addCondiments() {
    console.log("Adding sugar and milk...");
  }
}

// ---- USAGE / TEST ----
const tea = new Tea();
console.log(tea.prepare());
// Boiling water...
// Steeping the tea bag...
// Pouring into cup...
// Adding lemon...
// "Beverage ready!"

const coffee = new Coffee();
console.log(coffee.prepare());
// Boiling water...
// Brewing the coffee grounds...
// Pouring into cup...
// Adding sugar and milk...
// "Beverage ready!"
```

### 🔍 Deep Explanation
**বাংলা ব্যাখ্যা:** `Beverage` base class এর `prepare()` method এ পুরো algorithm এর **fixed order/sequence** define করা আছে: boil water → brew → pour → add condiments। এই order কখনো বদলায় না, যেকোনো subclass ব্যবহার করুন না কেন। কিন্তু `brew()` আর `addCondiments()` — এই দুটো step এর actual implementation subclass (`Tea`, `Coffee`) এ আলাদা। এটাকে বলা হয় **Hollywood Principle** — "Don't call us, we'll call you" — base class টাই control করছে কখন কোন step call হবে, subclass শুধু নিজের specific part fill করছে। এর ফলে algorithm এর overall structure consistent থাকে, কিন্তু individual step গুলো customize করা যায়।

**English:** The base class's `prepare()` method fixes the overall algorithm sequence — subclasses cannot reorder these steps. Only specific steps (`brew()`, `addCondiments()`) are deferred to subclasses via overriding. This follows the "Hollywood Principle" — the base class controls the flow and "calls" the subclass-specific hooks when needed, rather than the subclass driving the process.

### 🧪 Simple Examples (2)
1. **Data Export Template:** `exportData()` এর fixed steps (fetch → format → write), কিন্তু "format" step `CSVExporter`, `JSONExporter` এ আলাদা।
2. **Game AI Turn Template:** `takeTurn()` এর fixed steps (collect resources → build → attack), কিন্তু "attack" strategy আলাদা character type এর জন্য আলাদা।

### 🏢 Industry Use Case Examples (2)
1. **API Request Lifecycle (HTTP Client Library):** একটা common pattern যেখানে request এর lifecycle (auth check → build request → send → parse response → log) fixed, কিন্তু "build request" আর "parse response" আলাদা API ভেদে আলাদা —
   ```javascript
   class APIRequestTemplate {
     async execute() {
       this.authenticate();
       const request = this.buildRequest();
       console.log("Sending request:", request);
       const response = this.mockSend(request);
       return this.parseResponse(response);
     }
     authenticate() { console.log("Attaching auth token..."); }
     mockSend(req) { return { raw: `response for ${req.endpoint}` }; }
     buildRequest() { throw new Error("Implement buildRequest()"); }
     parseResponse(res) { throw new Error("Implement parseResponse()"); }
   }
   class UserAPIRequest extends APIRequestTemplate {
     buildRequest() { return { endpoint: "/users" }; }
     parseResponse(res) { return `Parsed user data: ${res.raw}`; }
   }
   const userRequest = new UserAPIRequest();
   userRequest.execute().then(console.log);
   ```
2. **Unit Testing Frameworks (Jest/Mocha setup-test-teardown):** Test framework গুলোর lifecycle (`beforeEach` → test body → `afterEach`) Template Method এর একটা practical উদাহরণ — framework টা flow control করে, আপনি শুধু specific test logic লেখেন।

### ✅ Pros
- Code duplication কমে — common algorithm logic একবার লেখা হয়, base class এ।
- Subclass গুলোকে শুধু specific, varying part নিয়ে কাজ করতে হয় — focus বাড়ে।
- Algorithm এর overall structure/flow control হয়ে যায়, ভুলভাবে order বদলে ফেলার ঝুঁকি থাকে না।

### ❌ Cons
- **Inheritance-based** pattern হওয়ায় (composition না), এটা rigid হতে পারে — JavaScript এ multiple inheritance নেই, তাই flexibility সীমিত।
- যদি অনেক step override করার প্রয়োজন হয়, subclass গুলো জটিল হয়ে যেতে পারে।
- Liskov Substitution Principle ভাঙার ঝুঁকি থাকে যদি subclass ভুলভাবে base class এর expected behavior পরিবর্তন করে ফেলে।

### 🤔 When to Use
- যখন একাধিক class এর মধ্যে একই algorithm structure আছে, কিন্তু কিছু step ভিন্ন।
- Framework/library design এ যেখানে user কে নির্দিষ্ট hook point override করতে দিতে চান, পুরো flow নিজে লিখতে না দিয়ে।

### 🚫 When NOT to Use
- যখন algorithm এর সব step সব জায়গায় একই রকম — তখন template বানানোর দরকার নেই।
- যখন composition (Strategy pattern) দিয়ে সমাধান করা বেশি flexible হবে inheritance এর চেয়ে।

### 💡 Extra Interview Tips
- **Template Method vs Strategy পার্থক্য:** Template Method **inheritance** ব্যবহার করে (subclass base class এর কিছু method override করে), Strategy **composition** ব্যবহার করে (একটা আলাদা strategy object inject করা হয়)। Interview এ এই trade-off (inheritance vs composition) নিয়ে কথা বলতে পারলে ভালো।
- React এর lifecycle methods (পুরনো class component এ `componentDidMount`, `componentDidUpdate`) Template Method pattern এর একটা practical উদাহরণ — React framework পুরো render cycle control করে, আপনি শুধু specific lifecycle hook গুলো override করেন।

---

## 22. Visitor Pattern

### 📖 Definition
**English:** Visitor lets you define a new operation without changing the classes of the elements on which it operates. You separate an algorithm from the object structure it operates on by moving the algorithm into a separate "visitor" object.

**বাংলা:** Visitor pattern দিয়ে আপনি existing class structure না বদলেই নতুন operation/behavior যোগ করতে পারেন। Algorithm টা element class এর ভেতরে না রেখে, একটা আলাদা "visitor" object এ রাখা হয় — element গুলো শুধু visitor কে "accept" করে, এবং visitor সিদ্ধান্ত নেয় কী করতে হবে।

### 💻 JavaScript Class Example
```javascript
// Element classes — এদের নিজের ভেতরে আলাদা operation logic নেই,
// শুধু accept(visitor) method আছে যা visitor কে call করে
class Circle {
  constructor(radius) {
    this.radius = radius;
  }
  accept(visitor) {
    return visitor.visitCircle(this);
  }
}

class Rectangle {
  constructor(width, height) {
    this.width = width;
    this.height = height;
  }
  accept(visitor) {
    return visitor.visitRectangle(this);
  }
}

class Triangle {
  constructor(base, height) {
    this.base = base;
    this.height = height;
  }
  accept(visitor) {
    return visitor.visitTriangle(this);
  }
}

// Visitor 1: Area calculation
class AreaVisitor {
  visitCircle(circle) {
    return Math.PI * circle.radius ** 2;
  }
  visitRectangle(rect) {
    return rect.width * rect.height;
  }
  visitTriangle(tri) {
    return 0.5 * tri.base * tri.height;
  }
}

// Visitor 2: Export to JSON (নতুন operation, কিন্তু shape class গুলো একদম untouched)
class JSONExportVisitor {
  visitCircle(circle) {
    return JSON.stringify({ type: "circle", radius: circle.radius });
  }
  visitRectangle(rect) {
    return JSON.stringify({ type: "rectangle", width: rect.width, height: rect.height });
  }
  visitTriangle(tri) {
    return JSON.stringify({ type: "triangle", base: tri.base, height: tri.height });
  }
}

// ---- USAGE / TEST ----
const shapes = [new Circle(5), new Rectangle(4, 6), new Triangle(3, 8)];

const areaVisitor = new AreaVisitor();
shapes.forEach(shape => {
  console.log(`Area: ${shape.accept(areaVisitor).toFixed(2)}`);
});
// Area: 78.54
// Area: 24.00
// Area: 12.00

const exportVisitor = new JSONExportVisitor();
shapes.forEach(shape => {
  console.log(shape.accept(exportVisitor));
});
// {"type":"circle","radius":5}
// {"type":"rectangle","width":4,"height":6}
// {"type":"triangle","base":3,"height":8}
```

### 🔍 Deep Explanation
**বাংলা ব্যাখ্যা:** এখানে মূল trick হলো **"double dispatch"** — `shape.accept(visitor)` কল হয়, যা ভেতরে `visitor.visitCircle(this)` কল করে। মানে দুইটা object (shape আর visitor) মিলে ঠিক করছে কোন method run হবে, একটা না। এর সুবিধা হলো — ধরুন আজ আপনার `Circle`, `Rectangle`, `Triangle` class আছে, এবং কাল আপনাকে "perimeter calculation" বা "render to SVG" নতুন operation যোগ করতে হলো। Visitor pattern ছাড়া আপনাকে প্রতি shape class এ গিয়ে নতুন method যোগ করতে হতো (Open/Closed Principle ভাঙতো)। Visitor দিয়ে আপনি শুধু একটা নতুন Visitor class লিখবেন (`PerimeterVisitor`), shape class গুলো একদম untouched থাকবে। এটা সবচেয়ে useful হয় যখন element/object structure stable (কম বদলায়) কিন্তু তার উপর operation/algorithm প্রায়ই নতুন যোগ হয়।

**English:** The key mechanism is "double dispatch" — `shape.accept(visitor)` calls back into `visitor.visitCircle(this)`, so the actual method executed depends on both the shape's type and the visitor's type together. This lets you add new operations (area, JSON export, perimeter, rendering) just by writing new Visitor classes, without ever touching the existing element classes — respecting the Open/Closed Principle. It's the inverse trade-off of normal OOP: easy to add new operations, harder to add new element types (every visitor must implement a method for each element type).

### 🧪 Simple Examples (2)
1. **Visitor on Composite tree (file system):** Pattern #8 (Composite) এর `File`/`Folder` tree এ একটা `SizeCalculatorVisitor` আর `SearchVisitor` যোগ করা — tree structure না বদলে।
2. **Zoo Animal Visitor:** `Lion`, `Elephant`, `Bird` classes, এবং `FeedingVisitor` ও `SoundVisitor` — প্রতি visitor আলাদা behavior প্রয়োগ করে animal type অনুযায়ী।

### 🏢 Industry Use Case Examples (2)
1. **AST (Abstract Syntax Tree) Processing — Compilers/Linters (ESLint, Babel):** Code কে parse করে একটা tree বানানো হয় (variable, function, loop node ইত্যাদি), তারপর বিভিন্ন Visitor (`TypeCheckVisitor`, `MinifyVisitor`, `LintRuleVisitor`) সেই একই tree তে ঘুরে আলাদা আলাদা কাজ করে — এটা real-world Visitor pattern এর সবচেয়ে বড় example।
   ```javascript
   class NumberNode {
     constructor(value) { this.value = value; }
     accept(visitor) { return visitor.visitNumber(this); }
   }
   class BinaryOpNode {
     constructor(left, op, right) { this.left = left; this.op = op; this.right = right; }
     accept(visitor) { return visitor.visitBinaryOp(this); }
   }
   class EvaluatorVisitor {
     visitNumber(node) { return node.value; }
     visitBinaryOp(node) {
       const l = node.left.accept(this);
       const r = node.right.accept(this);
       if (node.op === "+") return l + r;
       if (node.op === "*") return l * r;
     }
   }
   // Represents: (3 + 4) * 2
   const ast = new BinaryOpNode(new BinaryOpNode(new NumberNode(3), "+", new NumberNode(4)), "*", new NumberNode(2));
   console.log(ast.accept(new EvaluatorVisitor())); // 14
   ```
2. **E-commerce Order Processing:** `Order` object এর উপর বিভিন্ন visitor — `TaxCalculatorVisitor`, `InvoiceGeneratorVisitor`, `ShippingLabelVisitor` — order class না বদলেই নতুন business rule যোগ করা যায়।

### ✅ Pros
- নতুন operation যোগ করা সহজ — existing element class touch করতে হয় না (Open/Closed Principle)।
- Related operation গুলো এক জায়গায় (visitor class এ) গুছানো থাকে, ছড়িয়ে থাকে না।
- Complex object structure (tree, graph) এর উপর বিভিন্ন algorithm আলাদা আলাদা ভাবে maintain করা সহজ হয়।

### ❌ Cons
- নতুন element type যোগ করলে **সব** visitor class এ নতুন method যোগ করতে হয় — উল্টো দিক থেকে এটা costly।
- Double dispatch এর কারণে কোড একটু indirect/complex মনে হতে পারে, beginner দের জন্য পড়তে কষ্ট হয়।
- Encapsulation কিছুটা ভাঙে — visitor কে element এর internal data access করতে দিতে হয়।

### 🤔 When to Use
- যখন object structure (class hierarchy) প্রায় fixed, কিন্তু তার উপর নতুন operation প্রায়ই যোগ করতে হয়।
- Compiler, AST processing, complex tree/graph traversal এর মতো জায়গায়।

### 🚫 When NOT to Use
- যখন element class গুলো প্রায়ই বদলায়/নতুন type যোগ হয় — তখন প্রতিবার সব visitor আপডেট করা painful হবে।
- Simple object structure এর জন্য এই pattern এর overhead মানায় না।

### 💡 Extra Interview Tips
- Visitor pattern প্রায়ই **Composite pattern** (#8) এর সাথে একসাথে ব্যবহার হয় — Composite দিয়ে tree বানানো হয়, Visitor দিয়ে সেই tree তে ঘুরে আলাদা আলাদা operation চালানো হয়। Interview এ এই combo mention করলে ভালো impression হয়।
- "Double dispatch" শব্দটা explain করতে পারা — অনেক interviewer এটা specifically জিজ্ঞেস করে কারণ এটাই Visitor কে অন্য pattern থেকে আলাদা করে।

---

## 23. Interpreter Pattern

### 📖 Definition
**English:** Interpreter defines a representation for a language's grammar along with an interpreter that uses this representation to interpret sentences in that language. It's used to evaluate expressions written in a small, domain-specific language.

**বাংলা:** Interpreter pattern দিয়ে একটা ছোট language/grammar এর rule define করা হয়, এবং সেই grammar অনুযায়ী লেখা expression/sentence কে evaluate (interpret) করার জন্য একটা structure বানানো হয়। সাধারণত ছোট, specific-purpose language (DSL — Domain Specific Language) এর জন্য ব্যবহার হয়, যেমন calculator expression, query language ইত্যাদি।

### 💻 JavaScript Class Example
```javascript
// Grammar: একটা simple arithmetic expression interpreter
// Expression interface — সবার common method: interpret()

class NumberExpression {
  constructor(value) {
    this.value = value;
  }
  interpret() {
    return this.value;
  }
}

class AddExpression {
  constructor(left, right) {
    this.left = left;
    this.right = right;
  }
  interpret() {
    return this.left.interpret() + this.right.interpret();
  }
}

class SubtractExpression {
  constructor(left, right) {
    this.left = left;
    this.right = right;
  }
  interpret() {
    return this.left.interpret() - this.right.interpret();
  }
}

class MultiplyExpression {
  constructor(left, right) {
    this.left = left;
    this.right = right;
  }
  interpret() {
    return this.left.interpret() * this.right.interpret();
  }
}

// একটা ছোট "parser" — string expression কে Expression tree তে রূপান্তর করে
// Simplified version: শুধু "num op num op num..." ফরম্যাট (left-to-right, no precedence)
function parseExpression(tokens) {
  let result = new NumberExpression(Number(tokens[0]));
  for (let i = 1; i < tokens.length; i += 2) {
    const operator = tokens[i];
    const nextNum = new NumberExpression(Number(tokens[i + 1]));
    if (operator === "+") result = new AddExpression(result, nextNum);
    else if (operator === "-") result = new SubtractExpression(result, nextNum);
    else if (operator === "*") result = new MultiplyExpression(result, nextNum);
  }
  return result;
}

// ---- USAGE / TEST ----
const tokens = "5 + 3 - 2 * 4".split(" ");
const expressionTree = parseExpression(tokens);
console.log(expressionTree.interpret());
// Step by step (left to right, no precedence): ((5+3)-2)*4 = 24

const tokens2 = "10 + 20 + 30".split(" ");
console.log(parseExpression(tokens2).interpret());
// 60
```

### 🔍 Deep Explanation
**বাংলা ব্যাখ্যা:** Interpreter pattern এ একটা grammar কে object tree (এক ধরনের mini-AST) দিয়ে represent করা হয় — প্রতিটা grammar rule এর জন্য একটা class (এখানে `NumberExpression` "terminal" rule, `AddExpression`/`SubtractExpression`/`MultiplyExpression` "non-terminal" rule)। প্রতি class এর একটা common `interpret()` method থাকে যেটা recursively নিজের child expression গুলোকে interpret করে এবং নিজের logic apply করে ফলাফল return করে। এটা অনেকটা Composite pattern এর মতোই দেখতে (tree of objects, recursive operation), কিন্তু এর মূল purpose আলাদা — Composite object hierarchy represent করে, Interpreter grammar/language represent করে।

**English:** Each grammar rule maps to a class with a common `interpret()` method; complex expressions are built by composing simpler ones into a tree, and interpretation happens recursively bottom-up. It looks structurally similar to Composite (tree of objects, recursive calls) but the *intent* differs: Composite models part-whole object hierarchies, Interpreter models language grammar and evaluation.

### 🧪 Simple Examples (2)
1. **Boolean Expression Interpreter:** `AndExpression`, `OrExpression`, `NotExpression`, `VariableExpression` — `(true AND false) OR true` এর মতো logical expression evaluate করা।
2. **Roman Numeral Interpreter:** "III", "XIV" এর মতো Roman numeral string কে interpret করে integer এ রূপান্তর করা, প্রতিটা symbol এর জন্য rule define করে।

### 🏢 Industry Use Case Examples (2)
1. **SQL Query Parsers / Query Builders:** কিছু lightweight ORM বা query builder internally simple expression tree বানিয়ে condition গুলো evaluate করে, যেমন `WHERE age > 18 AND city = 'Dhaka'` কে expression tree তে ভেঙে interpret করা।
   ```javascript
   class GreaterThanExpression {
     constructor(field, value) { this.field = field; this.value = value; }
     interpret(row) { return row[this.field] > this.value; }
   }
   class EqualsExpression {
     constructor(field, value) { this.field = field; this.value = value; }
     interpret(row) { return row[this.field] === this.value; }
   }
   class AndExpression {
     constructor(left, right) { this.left = left; this.right = right; }
     interpret(row) { return this.left.interpret(row) && this.right.interpret(row); }
   }
   // WHERE age > 18 AND city = 'Dhaka'
   const condition = new AndExpression(
     new GreaterThanExpression("age", 18),
     new EqualsExpression("city", "Dhaka")
   );
   console.log(condition.interpret({ age: 25, city: "Dhaka" })); // true
   console.log(condition.interpret({ age: 15, city: "Dhaka" })); // false
   ```
2. **Regular Expression Engines / Template Engines:** Regex engine বা templating language (যেমন Handlebars/EJS) internally তাদের syntax কে একটা expression tree তে parse করে, তারপর সেই tree কে interpret/evaluate করে actual output বানায় — এটাও Interpreter pattern এর একটা practical, বহুল ব্যবহৃত প্রয়োগ।

### ✅ Pros
- Grammar/language এর প্রতিটা rule আলাদা class এ থাকায়, grammar পরিবর্তন বা বাড়ানো (নতুন rule যোগ) তুলনামূলক সহজ।
- Complex expression কে ছোট ছোট, reusable, composable part এ ভাঙা যায়।
- Domain-specific language (DSL) বানানোর জন্য একটা পরিষ্কার, structured approach।

### ❌ Cons
- Grammar জটিল হলে (অনেক rule, অনেক precedence) class সংখ্যা অনেক বেড়ে যায় — maintain করা কঠিন হয়ে পড়ে।
- বড় বা production-grade language এর জন্য সাধারণত dedicated parser generator tool (ANTLR, PEG.js) ব্যবহার করা হয়, হাতে Interpreter pattern লেখা practical না।
- Performance খারাপ হতে পারে বড় expression tree তে, কারণ recursive interpretation প্রতিবার পুরো tree walk করে।

### 🤔 When to Use
- যখন আপনাকে একটা ছোট, well-defined grammar/DSL বানিয়ে তা বারবার evaluate করতে হবে (calculator, simple rule engine, simple query language)।
- Educational/interview purpose এ grammar আর parsing এর concept বোঝানোর জন্য একটা ভালো উদাহরণ।

### 🚫 When NOT to Use
- Production-level, complex language/grammar এর জন্য — তখন established parser/lexer tool ব্যবহার করা উচিত (hand-written Interpreter pattern না)।
- যখন simple string parsing বা regex দিয়েই কাজ চলে যায়, তখন এত structure লাগানোর প্রয়োজন নেই (over-engineering)।

### 💡 Extra Interview Tips
- ২৩টা GoF pattern এর মধ্যে Interpreter সবচেয়ে কম ব্যবহৃত হয় real-world day-to-day coding এ — কিন্তু interview এ concept question আসতে পারে, তাই **Composite vs Interpreter** পার্থক্যটা স্পষ্টভাবে বলতে পারা গুরুত্বপূর্ণ: গঠনে (structurally) একই রকম দেখতে হলেও, Composite এর intent হলো object hierarchy (part-whole) represent করা, আর Interpreter এর intent হলো grammar/language evaluate করা।
- বললে ভালো লাগবে যে modern day তে hand-written Interpreter pattern এর বদলে সাধারণত parser generator (ANTLR) বা existing library (math.js, jsep) ব্যবহার করা হয় — এটা দেখায় আপনি practical trade-off সম্পর্কে aware।

---
