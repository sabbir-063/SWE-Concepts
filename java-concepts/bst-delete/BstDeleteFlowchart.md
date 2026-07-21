# BST Delete ফ্লো-চার্ট (Flowchart)

যখন আমরা একটি Binary Search Tree (BST) থেকে কোনো ডেটা ডিলিট করতে চাই, তখন কোডটি ঠিক কীভাবে সিদ্ধান্ত নেয়, তা নিচের ফ্লো-চার্টের মাধ্যমে ধাপে ধাপে দেখানো হলো:

```mermaid
graph TD
    Start(["Start: deleteNode root, key"]) --> CheckNull{"root কি null?"}
    
    CheckNull -- "হ্যাঁ" --> ReturnNull(["Return null"])
    CheckNull -- "না" --> CheckLess{"key কি root থেকে ছোট?"}
    
    CheckLess -- "হ্যাঁ" --> GoLeft["বামে যাও: <br> root.left = deleteNode"]
    GoLeft --> ReturnRoot(["Return root"])
    
    CheckLess -- "না" --> CheckGreater{"key কি root থেকে বড়?"}
    
    CheckGreater -- "হ্যাঁ" --> GoRight["ডানে যাও: <br> root.right = deleteNode"]
    GoRight --> ReturnRoot
    
    CheckGreater -- "না" --> FoundNode(("নোড পাওয়া গেছে!"))
    
    FoundNode --> CheckLeftNull{"Left Child কি null?"}
    
    CheckLeftNull -- "হ্যাঁ" --> ReturnRight(["Return Right Child<br/>Case 1 & 2"])
    
    CheckLeftNull -- "না" --> CheckRightNull{"Right Child কি null?"}
    
    CheckRightNull -- "হ্যাঁ" --> ReturnLeft(["Return Left Child<br/>Case 1 & 2"])
    
    CheckRightNull -- "না" --> Case3[["Case 3: দুটোই চাইল্ড আছে!"]]
    
    Case3 --> Step1["ধাপ ১: In-order Successor খুঁজুন <br> ডান দিকের সবচেয়ে ছোট নোড"]
    Step1 --> Step2["ধাপ ২: বর্তমান নোডে <br> Successor-এর ভ্যালু কপি করুন"]
    Step2 --> Step3["ধাপ ৩: ডান দিকের সাব-ট্রি থেকে <br> আসল Successor-কে ডিলিট করুন"]
    Step3 --> ReturnRoot
```

## ফ্লো-চার্টটি কীভাবে পড়বেন?
১. **ডায়মন্ড আকৃতির বক্সগুলো (Rhombus):** এগুলো হলো কন্ডিশন বা শর্ত (if-else)। এখানে কোড চেক করে দেখছে কোনদিকে যেতে হবে।
২. **চারকোনা বক্সগুলো (Rectangle):** এগুলো হলো কাজ বা অ্যাকশন। 
৩. **গোলাকার বক্সগুলো (Oval/Circle):** এগুলো হলো রিটার্ন পয়েন্ট বা টার্মিনাল।

এই ফ্লো-চার্টটি মূলত আমাদের আগের লেখা জাভা কোডটিরই একটি ভিজ্যুয়াল বা গ্রাফিক্যাল রূপ। এটি দেখে আপনি খুব সহজেই বুঝতে পারবেন যে কোডটি কখন কোন ধাপে কাজ করছে!
