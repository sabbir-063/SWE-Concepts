# Chapter 2 Quiz: OSI & TCP/IP Reference Models

এই কুইজে মোট **৩০টি MCQ** রয়েছে যা আপনার OSI এবং TCP/IP Reference Models সম্পর্কিত জ্ঞান ঝালাই করতে সাহায্য করবে। প্রতিটি প্রশ্ন মনোযোগ দিয়ে পড়ুন এবং উত্তর দেওয়ার পর প্রশ্নের নিচের **👀 উত্তর ও ব্যাখ্যা** বাটনে ক্লিক করে সঠিক উত্তর ও ব্যাখ্যা দেখে নিন!

---

### ১. OSI Reference Model-এ মোট কয়টি লেয়ার বা স্তর রয়েছে?
- A) ৪টি
- B) ৫টি
- C) ৭টি
- D) ৯টি

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** C) ৭টি

**ব্যাখ্যা:** OSI (Open Systems Interconnection) মডেলে মোট ৭টি লেয়ার রয়েছে। নিচ থেকে উপরে এগুলো হলো: Physical, Data Link, Network, Transport, Session, Presentation, Application।
</details>

---

### ২. OSI মডেলটি কোন আন্তর্জাতিক সংস্থা দ্বারা তৈরি করা হয়েছে?
- A) IEEE
- B) ISO
- C) IETF
- D) ITU

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** B) ISO

**ব্যাখ্যা:** ১৯৮৪ সালে ISO (International Organization for Standardization) নেটওয়ার্কের সাধারণ ফ্রেমওয়ার্ক হিসেবে OSI মডেলটি তৈরি করে।
</details>

---

### ৩. নিচে দেওয়া লেয়ারগুলোর মধ্যে কোনটি OSI মডেলের সঠিক অনুক্রম (নিচ থেকে উপরে)?
- A) Physical -> Network -> Data Link -> Transport -> Session -> Presentation -> Application
- B) Physical -> Data Link -> Network -> Transport -> Session -> Presentation -> Application
- C) Application -> Presentation -> Session -> Transport -> Network -> Data Link -> Physical
- D) Physical -> Data Link -> Network -> Session -> Transport -> Presentation -> Application

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** B) Physical -> Data Link -> Network -> Transport -> Session -> Presentation -> Application

**ব্যাখ্যা:** OSI মডেলের লেয়ার গণনা নিচ থেকে শুরু হয় (Layer 1 = Physical, Layer 7 = Application)।
</details>

---

### ৪. ডেটা এনক্রিপশন, কম্প্রেশন এবং ফরম্যাটিং (যেমন: JSON, JPEG) OSI মডেলের কোন লেয়ারে করা হয়?
- A) Application Layer
- B) Session Layer
- C) Presentation Layer
- D) Transport Layer

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** C) Presentation Layer

**ব্যাখ্যা:** Presentation Layer (Layer 6) ডেটার সিনট্যাক্স ও ফরম্যাটিং নিয়ে কাজ করে। এর প্রধান কাজের মধ্যে রয়েছে অনুবাদ (translation), এনক্রিপশন ও কম্প্রেশন।
</details>

---

### ৫. OSI মডেলের কোন লেয়ারে সোর্স ও ডেস্টিনেশন পোর্ট নাম্বার (Port Numbers) ব্যবহার করা হয়?
- A) Network Layer
- B) Data Link Layer
- C) Transport Layer
- D) Application Layer

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** C) Transport Layer

**ব্যাখ্যা:** Transport Layer (Layer 4) প্রসেস-টু-প্রসেস ডেলিভারি নিশ্চিত করতে পোর্ট নম্বরের ব্যবহার শুরু করে (যেমন: HTTP-এর জন্য 80, HTTPS-এর জন্য 443)।
</details>

---

### ৬. Transport Layer-এর প্রোটোকল ডাটা ইউনিট (PDU)-কে কী বলা হয়?
- A) Data
- B) Segment (বা Datagram)
- C) Packet
- D) Frame

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** B) Segment (বা Datagram)

**ব্যাখ্যা:** Transport Layer-এ ডেটাকে ছোট ছোট ভাগে বিভক্ত করা হয়, যাকে TCP-র ক্ষেত্রে Segment এবং UDP-র ক্ষেত্রে Datagram বলা হয়।
</details>

---

### ৭. OSI মডেলের কোন লেয়ারে আইপি রাউটিং (IP Routing) এবং পাথ সিলেকশন (Path Selection) সম্পন্ন হয়?
- A) Transport Layer
- B) Network Layer
- C) Data Link Layer
- D) Physical Layer

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** B) Network Layer

**ব্যাখ্যা:** Network Layer (Layer 3) আইপি অ্যাড্রেসিং এবং প্যাকেটের জন্য সর্বোত্তম পথ নির্বাচন বা রাউটিং করার জন্য দায়ী।
</details>

---

### ৮. Network Layer-এর প্রোটোকল ডাটা ইউনিট (PDU)-কে কী বলা হয়?
- A) Segment
- B) Frame
- C) Packet
- D) Bits

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** C) Packet

**ব্যাখ্যা:** Network Layer-এ সেগমেন্টের সাথে আইপি হেডার যুক্ত করার পর সেই ডেটা ইউনিটটিকে Packet (প্যাকেট) বলা হয়।
</details>

---

### ৯. নেটওয়ার্ক সুইচ (Network Switch) সাধারণত OSI মডেলের কোন লেয়ারে কাজ করে?
- A) Layer 1 (Physical)
- B) Layer 2 (Data Link)
- C) Layer 3 (Network)
- D) Layer 4 (Transport)

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** B) Layer 2 (Data Link)

**ব্যাখ্যা:** সাধারণ সুইচ ম্যাক অ্যাড্রেস (MAC Address) দেখে ফ্রেম ফরোয়ার্ড করে, যা Data Link Layer (Layer 2)-এর অংশ। তবে কিছু অ্যাডভান্সড L3 সুইচও রয়েছে, তবে জেনারিক সুইচ বলতে L2 সুইচ বোঝায়।
</details>

---

### ১০. রাউটার (Router) OSI মডেলের কোন লেয়ারে কাজ করে?
- A) Layer 2 (Data Link)
- B) Layer 3 (Network)
- C) Layer 4 (Transport)
- D) Layer 7 (Application)

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** B) Layer 3 (Network)

**ব্যাখ্যা:** রাউটার আইপি অ্যাড্রেস বা লজিক্যাল অ্যাড্রেস প্রসেস করে প্যাকেট এক নেটওয়ার্ক থেকে অন্য নেটওয়ার্ক ফরোয়ার্ড করে, যা Network Layer (Layer 3)-এর কাজ।
</details>

---

### ১১. যোগাযোগের মাঝে চেকপয়েন্ট (Checkpoints) এবং সিনক্রোনাইজেশন পয়েন্ট তৈরি করার কাজটি কোন লেয়ার করে?
- A) Presentation Layer
- B) Session Layer
- C) Transport Layer
- D) Network Layer

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** B) Session Layer

**ব্যাখ্যা:** Session Layer (Layer 5) ডেটা স্ট্রিমের সাথে সিনক্রোনাইজেশন পয়েন্ট বা চেকপয়েন্ট যোগ করে যাতে ফাইল ট্রান্সফার মাঝপথে কেটে গেলে পুরো ফাইল নতুন করে না পাঠিয়ে চেকপয়েন্ট থেকে পুনরায় শুরু করা যায়।
</details>

---

### ১২. Data Link Layer কোন দুটি সাব-লেয়ারে (Sub-layers) বিভক্ত?
- A) MAC এবং IP
- B) LLC এবং MAC
- C) TCP এবং UDP
- D) Physical এবং Logical

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** B) LLC এবং MAC

**ব্যাখ্যা:** Data Link Layer দুটি সাব-লেয়ারে বিভক্ত: ১. Logical Link Control (LLC) এবং ২. Media Access Control (MAC)।
</details>

---

### ১৩. ফ্রেমিং (Framing), ফিজিক্যাল অ্যাড্রেসিং (MAC Address) এবং এরর ডিটেকশন (যেমন: CRC) কোন লেয়ারের প্রধান দায়িত্ব?
- A) Network Layer
- B) Physical Layer
- C) Data Link Layer
- D) Transport Layer

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** C) Data Link Layer

**ব্যাখ্যা:** Data Link Layer (Layer 2) প্যাকেটকে ফ্রেমে রূপান্তর করে, ম্যাক হেডার যুক্ত করে এবং CRC ব্যবহার করে ডেটায় কোনো ভুল আছে কিনা তা নির্ণয় করে।
</details>

---

### ১৪. Data Link Layer-এর প্রোটোকল ডাটা ইউনিট (PDU)-কে কী বলা হয়?
- A) Packet
- B) Segment
- C) Frame
- D) Bits

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** C) Frame

**ব্যাখ্যা:** Data Link Layer-এর ডেটা ইউনিটকে Frame (ফ্রেম) বলা হয়। এর সাথে ম্যাক হেডার এবং ট্রেইলার যুক্ত থাকে।
</details>

---

### ১৫. ক্যাবল, কানেক্টর (যেমন: RJ45) এবং বাইনারি বিট ট্রান্সমিশন নিয়ে কাজ করে কোন লেয়ার?
- A) Physical Layer
- B) Data Link Layer
- C) Network Layer
- D) Session Layer

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** A) Physical Layer

**ব্যাখ্যা:** Physical Layer (Layer 1) নেটওয়ার্কের ফিজিক্যাল কানেকশন ও সিগন্যালিং (বৈদ্যুতিক, আলোক বা রেডিও সংকেত) নিয়ে কাজ করে।
</details>

---

### ১৬. নেটওয়ার্ক হাব (Hub) এবং রিপিটার (Repeater) OSI মডেলের কোন লেয়ারে কাজ করে?
- A) Data Link Layer
- B) Physical Layer
- C) Network Layer
- D) Transport Layer

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** B) Physical Layer

**ব্যাখ্যা:** হাব ও রিপিটার ডেটার হেডার বা ম্যাক অ্যাড্রেস পড়তে পারে না, তারা কেবল সিগন্যাল বা বিট গ্রহণ করে বুস্ট করে ফরোয়ার্ড করে। তাই এগুলো Physical Layer (Layer 1)-এ কাজ করে।
</details>

---

### ১৭. ইন্টারনেটে বহুল ব্যবহৃত প্র্যাক্টিকাল TCP/IP মডেলে সাধারণত কয়টি লেয়ার থাকে?
- A) ৩টি
- B) ৪টি
- C) ৭টি
- D) ৮টি

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** B) ৪টি

**ব্যাখ্যা:** মূল TCP/IP মডেলে ৪টি লেয়ার থাকে: Application, Transport, Internet, এবং Network Access। (কিছু আধুনিক টেক্সটবুকে এটিকে ৫ লেয়ারের মডেল হিসেবেও দেখানো হয়)।
</details>

---

### ১৮. OSI মডেলের Network Layer টি TCP/IP মডেলের কোন লেয়ারের সমতুল্য?
- A) Application Layer
- B) Transport Layer
- C) Internet Layer
- D) Network Access Layer

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** C) Internet Layer

**ব্যাখ্যা:** OSI মডেলের Network Layer-এর কাজ এবং TCP/IP মডেলের Internet Layer-এর কাজ একই (আইপি অ্যাড্রেসিং ও রাউটিং)।
</details>

---

### ১৯. TCP/IP মডেলের Application Layer, OSI মডেলের কোন কোন লেয়ারের কাজকে একত্রে সম্পাদন করে?
- A) Application, Presentation, Session
- B) Application, Presentation, Transport
- C) Session, Presentation, Transport
- D) Transport, Network, Data Link

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** A) Application, Presentation, Session

**ব্যাখ্যা:** TCP/IP মডেলটি অত্যন্ত সরল। এটি OSI-এর ওপরের তিনটি লেয়ারকে (Application, Presentation, Session) একসাথে একক **Application Layer** হিসেবে ব্যবহার করে।
</details>

---

### ২০. ডেটা যখন প্রোটোকল স্ট্যাকের ওপরের লেয়ার থেকে নিচের লেয়ারে যায় এবং প্রতি লেয়ারে তার সাথে নতুন হেডার যুক্ত হয়, তখন এই প্রক্রিয়াকে কী বলা হয়?
- A) Decapsulation
- B) Encapsulation
- C) Segmentation
- D) Fragmentation

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** B) Encapsulation

**ব্যাখ্যা:** ডেটা প্যাক বা মোড়কীকরণ করার এই প্রক্রিয়াকে এনক্যাপসুলেশন (Encapsulation) বলে।
</details>

---

### ২১. ডেটা যখন রিসিভারের কাছে পৌঁছায় এবং নিচ থেকে উপরে যাওয়ার সময় প্রতিটি লেয়ারের হেডার বাদ দিয়ে আসল মেসেজ বের করা হয়, তখন তাকে কী বলে?
- A) Encapsulation
- B) Decapsulation
- C) Translation
- D) Demultiplexing

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** B) Decapsulation

**ব্যাখ্যা:** এটি এনক্যাপসুলেশনের বিপরীত প্রক্রিয়া, যাকে ডিক্যাপসুলেশন (Decapsulation) বলা হয়।
</details>

---

### ২২. এনক্যাপসুলেশন প্রক্রিয়ায় ফ্রেমের ভুল সনাক্তকরণের জন্য ট্রেইলার (যেমন: CRC) কোন লেয়ারে যুক্ত হয়?
- A) Network Layer
- B) Data Link Layer
- C) Physical Layer
- D) Transport Layer

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** B) Data Link Layer

**ব্যাখ্যা:** Data Link Layer-এ প্যাকেটের শুরুতে হেডার এবং শেষে ট্রেইলার (CRC) যুক্ত করে ফ্রেম তৈরি করা হয়।
</details>

---

### ২৩. OSI মডেলের কোন লেয়ারটি প্রসেস-টু-প্রসেস (Process-to-Process) ডেটা ট্রান্সমিশনের জন্য সরাসরি দায়ী?
- A) Network Layer
- B) Session Layer
- C) Transport Layer
- D) Data Link Layer

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** C) Transport Layer

**ব্যাখ্যা:** Transport Layer-এর মূল কাজ হলো দুটি ডিভাইসের ভেতরের নির্দিষ্ট দুটি রানিং অ্যাপ্লিকেশন বা প্রসেসের মধ্যে যোগাযোগ সম্পন্ন করা।
</details>

---

### ২৪. OSI মডেলের কোন লেয়ারটি হোস্ট-টু-হোস্ট (Host-to-Host) ডেটা রাউটিংয়ের জন্য সরাসরি দায়ী?
- A) Data Link Layer
- B) Network Layer
- C) Transport Layer
- D) Physical Layer

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** B) Network Layer

**ব্যাখ্যা:** Network Layer এক কম্পিউটার (Host) থেকে অন্য কম্পিউটারে ইন্টারনেটের মাধ্যমে প্যাকেট নিয়ে যাওয়ার জন্য দায়ী।
</details>

---

### ২৫. ডায়ালগ কন্ট্রোল (Dialogue Control) এবং সেশন টোকেন ম্যানেজমেন্ট কোন লেয়ারের কাজ?
- A) Presentation Layer
- B) Session Layer
- C) Transport Layer
- D) Application Layer

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** B) Session Layer

**ব্যাখ্যা:** সেশন লেয়ার নির্ধারণ করে কোন হোস্ট কখন কথা বলবে (Half-duplex, Full-duplex) এবং টোকেন ব্যবহার করে ডুপ্লিকেট অপারেশন প্রতিরোধ করে।
</details>

---

### ২৬. HTTP, DNS, SMTP এবং FTP প্রোটোকলসমূহ OSI মডেলের কোন লেয়ারে কাজ করে?
- A) Application Layer
- B) Presentation Layer
- C) Transport Layer
- D) Network Layer

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** A) Application Layer

**ব্যাখ্যা:** এগুলো সবই এন্ড-ইউজার সার্ভিস বা প্রোটোকল যা সরাসরি অ্যাপ্লিকেশন লেয়ারে (Layer 7) কাজ করে।
</details>

---

### ২৭. Physical Layer-এর প্রোটোকল ডাটা ইউনিট (PDU) কোনটি?
- A) Frame
- B) Packet
- C) Segment
- D) Bits

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** D) Bits

**ব্যাখ্যা:** Physical Layer ক্যাবলের মাধ্যমে কাঁচা বাইনারি বিট (`0` এবং `1`) আদান-প্রদান করে।
</details>

---

### ২৮. Data Link Layer-এর কোন সাব-লেয়ারটি Network Layer এবং Physical Media-এর মধ্যে ইন্টারফেস বা সংযোগকারী হিসেবে কাজ করে?
- A) MAC sub-layer
- B) LLC sub-layer
- C) IP sub-layer
- D) Frame sub-layer

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** B) LLC sub-layer

**ব্যাখ্যা:** LLC (Logical Link Control) হলো ডাটা লিংক লেয়ারের ওপরের সাব-লেয়ার যা নেটওয়ার্ক লেয়ার প্রোটোকলের সাথে সরাসরি সংযুক্ত থাকে।
</details>

---

### ২৯. সুরক্ষিত ওয়েব যোগাযোগের জন্য ব্যবহৃত HTTPS প্রোটোকলটি সাধারণত ট্রান্সপোর্ট লেয়ারের কোন পোর্ট ব্যবহার করে?
- A) Port 80
- B) Port 21
- C) Port 443
- D) Port 53

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** C) Port 443

**ব্যাখ্যা:** HTTPS পোর্ট ৪৪৩ ব্যবহার করে (TCP)। অন্যদিকে HTTP পোর্ট ৮০, FTP পোর্ট ২১ এবং DNS পোর্ট ৫৩ ব্যবহার করে।
</details>

---

### ৩০. নিচের কোনটি লেয়ারড নেটওয়ার্ক মডেল (যেমন: OSI বা TCP/IP) ব্যবহারের প্রধান সুবিধা?
- A) এটি ইন্টারনেটের গতি দ্বিগুণ করে দেয়
- B) এটি সব ধরনের ভাইরাস সরাসরি ব্লক করে
- C) এটি প্রমিতকরণ (Standardization) তৈরি করে এবং বিভিন্ন বিক্রেতার হার্ডওয়্যারকে একসাথে কাজ করতে সাহায্য করে
- D) এটি আইপি অ্যাড্রেসের প্রয়োজনীয়তা দূর করে

<details>
<summary>👀 উত্তর ও ব্যাখ্যা</summary>

**সঠিক উত্তর:** C) এটি প্রমিতকরণ (Standardization) তৈরি করে এবং বিভিন্ন বিক্রেতার হার্ডওয়্যারকে একসাথে কাজ করতে সাহায্য করে

**ব্যাখ্যা:** লেয়ারড মডেলের প্রধান উদ্দেশ্য হলো প্রমিতকরণ বা Standardization নিশ্চিত করা যাতে যেকোনো কোম্পানি স্ট্যান্ডার্ড মেনে রাউটার, ক্যাবল বা ব্রাউজার বানালে তা সবার সাথে কাজ করতে পারে।
</details>
