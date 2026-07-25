# 02. CPU Scheduling (Code & Implementations)

এই ফাইলে আমরা জাভাতে FCFS (First Come First Serve) এবং SJF (Shortest Job First) অ্যালগরিদমগুলো কীভাবে কাজ করে তা সিমুলেট করে দেখবো। এতে করে Waiting Time এবং Turnaround Time কীভাবে ক্যালকুলেট হয় তা ক্লিয়ার হবে।

---

## 1. Important Terminologies
- **Burst Time (BT):** একটি প্রসেস শেষ হতে CPU এর কত সময় লাগবে।
- **Waiting Time (WT):** একটি প্রসেস লাইনে কতক্ষণ দাঁড়িয়ে ছিল। 
- **Turnaround Time (TAT):** লাইনে দাঁড়ানো + কাজ করা = টোটাল কত সময় লাগলো। (TAT = WT + BT)

---

## 2. First Come First Serve (FCFS)
এটি সিম্পল লজিক। যে আগে আসবে, সে আগের প্রসেসগুলোর কাজ শেষ হওয়া পর্যন্ত ওয়েট করবে।

```java
public class FCFS {
    public static void main(String[] args) {
        // প্রসেস আইডি (1, 2, 3)
        int[] processes = {1, 2, 3}; 
        
        // কে কতক্ষণ কাজ করবে (Burst Time)
        // P1 লাগবে 24 সেকেন্ড, P2 লাগবে 3 সেকেন্ড, P3 লাগবে 3 সেকেন্ড
        int[] burst_time = {24, 3, 3}; 
        
        int n = processes.length;
        int[] waiting_time = new int[n];
        int[] turnaround_time = new int[n];
        
        // ১. Waiting Time ক্যালকুলেট করা
        // প্রথম প্রসেসকে ওয়েট করতে হয় না, তাই WT = 0
        waiting_time[0] = 0; 
        
        for (int i = 1; i < n; i++) {
            // পরের প্রসেসের ওয়েটিং টাইম = আগের প্রসেসের ওয়েটিং টাইম + আগের প্রসেসের কাজের সময়
            waiting_time[i] = waiting_time[i-1] + burst_time[i-1];
        }
        
        // ২. Turnaround Time (TAT = WT + BT)
        for (int i = 0; i < n; i++) {
            turnaround_time[i] = waiting_time[i] + burst_time[i];
        }
        
        // ৩. রেজাল্ট প্রিন্ট করা
        System.out.println("Process | Burst Time | Waiting Time | Turnaround Time");
        float total_wt = 0;
        
        for (int i = 0; i < n; i++) {
            total_wt += waiting_time[i];
            System.out.println("   P" + processes[i] + "   |      " + burst_time[i] + 
                             "     |      " + waiting_time[i] + "       |      " + turnaround_time[i]);
        }
        
        System.out.println("\nAverage Waiting Time: " + (total_wt / n));
    }
}
```
**Output Explanation (The Convoy Effect):**
যেহেতু P1 অনেক বড় (24s), তাই P2 এবং P3 কে অনেকক্ষণ ওয়েট করতে হয়েছে। 
P2 এর ওয়েটিং টাইম 24s, P3 এর ওয়েটিং টাইম 27s। 
অ্যাভারেজ ওয়েটিং টাইম: `(0 + 24 + 27) / 3 = 17 seconds`।

---

## 3. Shortest Job First (SJF) - Non-Preemptive
একই প্রসেসগুলো যদি আমরা SJF দিয়ে সলভ করি, তবে আগে ছোট কাজগুলোকে সুযোগ দেওয়া হবে।
এর জন্য আমাদেরকে শুধু **Burst Time অনুযায়ী প্রসেসগুলোকে Sort (ছোট থেকে বড়) করে নিতে হবে**। এরপর পুরো কোড FCFS এর মতোই!

```java
import java.util.Arrays;

// প্রসেসগুলোকে অবজেক্ট হিসেবে রাখছি যেন সহজে সর্ট করা যায়
class Process implements Comparable<Process> {
    int id;
    int burstTime;
    
    public Process(int id, int burstTime) {
        this.id = id;
        this.burstTime = burstTime;
    }
    
    // সর্ট করার লজিক: Burst Time যার ছোট সে আগে যাবে
    @Override
    public int compareTo(Process p) {
        return this.burstTime - p.burstTime;
    }
}

public class SJF {
    public static void main(String[] args) {
        Process[] processes = {
            new Process(1, 24),
            new Process(2, 3),
            new Process(3, 3)
        };
        
        // ম্যাজিক: Burst time অনুযায়ী সর্ট করে ফেলা হলো (P2, P3, P1)
        Arrays.sort(processes);
        
        int n = processes.length;
        int[] waiting_time = new int[n];
        
        waiting_time[0] = 0; // প্রথম প্রসেস (সবচেয়ে ছোট) ওয়েট করবে না
        
        for (int i = 1; i < n; i++) {
            waiting_time[i] = waiting_time[i-1] + processes[i-1].burstTime;
        }
        
        // রেজাল্ট প্রিন্ট করা
        System.out.println("Process | Burst Time | Waiting Time");
        float total_wt = 0;
        
        for (int i = 0; i < n; i++) {
            total_wt += waiting_time[i];
            System.out.println("   P" + processes[i].id + "   |      " + processes[i].burstTime + 
                             "     |      " + waiting_time[i]);
        }
        
        System.out.println("\nAverage Waiting Time: " + (total_wt / n));
    }
}
```
**Output Explanation:**
সর্ট করার পর সিরিয়াল হবে: P2 (3s), P3 (3s), P1 (24s)।
এখন P2 এর ওয়েটিং টাইম 0s, P3 এর ওয়েটিং টাইম 3s, আর P1 (বড় প্রসেস) ওয়েট করবে 6s।
অ্যাভারেজ ওয়েটিং টাইম: `(0 + 3 + 6) / 3 = 3 seconds`!!

**Conclusion:** 
দেখুন, FCFS এ ওয়েটিং টাইম ছিল **17 সেকেন্ড**, আর SJF এ সেটা কমে মাত্র **3 সেকেন্ড** হয়ে গেলো! একারণেই SJF কে গাণিতিকভাবে সবচেয়ে অপ্টিমাল বা বেস্ট অ্যালগরিদম ধরা হয় (Waiting time কমানোর ক্ষেত্রে)।
