# 01. HTTP Headers & Caching (Code & Implementations)

এই ফাইলে আমরা স্প্রিং বুট (Spring Boot / Java) ব্যবহার করে প্র্যাকটিক্যালি দেখবো কীভাবে একটি API-তে **Cache-Control** এবং **ETag** রেসপন্স হেডার সেট করে Caching ইমপ্লিমেন্ট করা যায়।

---

## 1. Setting Cache-Control in API Response

ধরা যাক, আমাদের একটি API আছে যা ওয়েবসাইটের কিছু স্ট্যাটিক ডেটা (যেমন Terms and Conditions) রিটার্ন করে। এই ডেটা বারবার চেঞ্জ হয় না। তাই আমরা চাই ক্লায়েন্ট এটি অন্তত ১ ঘণ্টা (৩৬০০ সেকেন্ড) ক্যাশ করে রাখুক।

```java
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.TimeUnit;

@RestController
public class CachingController {

    @GetMapping("/api/terms")
    public ResponseEntity<String> getTermsAndConditions() {
        
        String termsData = "These are the Terms and Conditions... (very long text)";
        
        // Response Header এ Cache-Control: max-age=3600 সেট করে দেওয়া হচ্ছে
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(3600, TimeUnit.SECONDS))
                .body(termsData);
    }
    
    // যদি আমরা চাই যে ক্লায়েন্ট একদমই ক্যাশ না করুক (যেমন ইউজারের ব্যাংক ব্যালান্স)
    @GetMapping("/api/balance")
    public ResponseEntity<String> getBankBalance() {
        
        String balanceData = "$5000.00";
        
        // Response Header এ Cache-Control: no-store সেট করে দেওয়া হচ্ছে
        return ResponseEntity.ok()
                .cacheControl(CacheControl.noStore())
                .body(balanceData);
    }
}
```

---

## 2. Implementing ETag (304 Not Modified)

ETag ইমপ্লিমেন্ট করা মানে হলো সার্ভার চেক করবে যে ক্লায়েন্টের পাঠানো `If-None-Match` হেডারের সাথে সার্ভারের বর্তমান ডেটার হ্যাশ (ETag) মিলে যায় কি না। যদি মিলে যায়, তবে সার্ভার ডেটা না পাঠিয়ে শুধু **304 Not Modified** স্ট্যাটাস কোড পাঠিয়ে দেবে।

```java
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.util.DigestUtils;

@RestController
public class ETagController {

    // ডাটাবেস থেকে আসা একটি ডেটা (ধরি এটি একটি ইউজারের প্রোফাইল ডেটা)
    private String userProfileData = "{\"name\": \"Sabbir\", \"age\": 25}";

    @GetMapping("/api/profile")
    public ResponseEntity<String> getUserProfile(
            // ক্লায়েন্ট আগেরবার সেভ করা ETag পাঠালে আমরা সেটি রিসিভ করবো
            @RequestHeader(value = "If-None-Match", required = false) String clientETag) {

        // ১. সার্ভার তার বর্তমান ডেটার একটি হ্যাশ (MD5 বা SHA) তৈরি করে ETag বানাবে
        String currentETag = "\"" + DigestUtils.md5DigestAsHex(userProfileData.getBytes()) + "\"";

        // ২. যদি ক্লায়েন্টের পাঠানো ETag এবং সার্ভারের বর্তমান ETag মিলে যায়!
        if (currentETag.equals(clientETag)) {
            System.out.println("ETag matched! Sending 304 Not Modified (No data sent)");
            // ডেটা পাঠাবো না! শুধু 304 স্ট্যাটাস কোড পাঠাবো, যাতে ক্লায়েন্ট তার ক্যাশ ইউজ করে
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED)
                    .eTag(currentETag)
                    .build();
        }

        // ৩. যদি ETag না মিলে (বা ক্লায়েন্ট প্রথমবার রিকোয়েস্ট করে)
        System.out.println("ETag did not match or First time request. Sending full data.");
        // পুরো ডেটা এবং নতুন ETag পাঠিয়ে দেবো (200 OK)
        return ResponseEntity.ok()
                .eTag(currentETag)
                .body(userProfileData);
    }
}
```

### 💡 Output Explanation
1. **First Request:** ক্লায়েন্ট যখন প্রথমবার `/api/profile` এ কল করবে, তখন সে কোনো `If-None-Match` পাঠাবে না। সার্ভার তাকে `200 OK` এর সাথে পুরো ডেটা এবং ETag `eTag: "a1b2c3d4..."` পাঠাবে।
2. **Second Request:** ক্লায়েন্ট এবার `If-None-Match: "a1b2c3d4..."` পাঠিয়ে কল করবে। 
3. **Magic:** সার্ভার দেখবে যে তার বর্তমান ডেটার হ্যাশও `"a1b2c3d4..."`। অর্থাৎ ডেটা চেঞ্জ হয়নি! তাই সার্ভার কনসোল প্রিন্ট করবে "ETag matched!" এবং শুধু `304 Not Modified` রিটার্ন করবে, কোনো বডি বা ডেটা পাঠাবে না! ব্যান্ডউইথ বেঁচে গেলো!
4. **Update:** যদি সার্ভারে `userProfileData` একটু চেঞ্জ হয়ে যায় (যেমন age: 26 হলো), তখন সার্ভারের নতুন হ্যাশ তৈরি হবে `"x9y8z7..."`। তখন আর ETag মিলবে না, এবং সার্ভার নতুন ডেটা পাঠিয়ে দেবে। 

*(নোট: স্প্রিং বুটে `ShallowEtagHeaderFilter` নামে একটি ফিল্টার আছে, যা জাস্ট এক লাইন কোড লিখলেই পুরো অ্যাপ্লিকেশনের জন্য অটোমেটিক ETag হ্যান্ডেল করে দেয়! এখানে লজিক বোঝানোর জন্য ম্যানুয়ালি করে দেখানো হয়েছে)।*
