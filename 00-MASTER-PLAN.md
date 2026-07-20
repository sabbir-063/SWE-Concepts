# WellDev — Trainee Software Engineer MCQ Prep — Master Content Generation Plan

> **এই ফাইলটা কী:** এটা কোনো পড়ার কনটেন্ট না। এটা একটা **নির্দেশনা/স্পেসিফিকেশন ডকুমেন্ট**, যেটা Antigravity (বা যেকোনো content-generation agent)-কে দিলে ও ধাপে ধাপে, চ্যাপ্টার বাই চ্যাপ্টার, ফোল্ডার বেইজড `.md` ফাইল বানিয়ে দিবে — WellDev-এর Trainee Software Engineer MCQ টেস্টের জন্য (Level: Intermediate/Advanced — refresher + heavy MCQ practice, full comprehensive resource)।
>
> **Antigravity-কে এই পুরো ফাইলটা system/task prompt হিসেবে দিয়ে বলবে:** "এই প্ল্যান অনুযায়ী পুরো কারিকুলাম জেনারেট করো, একবারে সব না — চ্যাপ্টার বাই চ্যাপ্টার, ফাইল বাই ফাইল।"

---

## 0. High-Level Goal

Generate a self-contained, folder-organized study course (all `.md` files, plus diagrams/images where instructed) covering exactly the 4 modules from the WellDev job poster:

1. **Programming**
2. **Data Structures & Algorithms (DSA)**
3. **CS Fundamentals**
4. **Logical Reasoning**

Audience level: **Intermediate/Advanced** developer (already knows the basics, needs a structured refresher + deep-dive on tricky/interview-style points + heavy MCQ drilling). So: don't over-explain trivial basics — mention them briefly for completeness, then spend most depth on the parts that actually trip people up in interviews/MCQ tests (edge cases, "gotchas," comparisons, complexity trade-offs, common misconceptions).

Every leaf topic file must end with **20-30 MCQs** in a click-to-reveal dropdown format (spec in Section 4).

---

## 1. Global Rules for EVERY File Antigravity Generates

Antigravity should follow these rules for every single topic `.md` file, no exceptions:

### 1.1 Language & Teaching Style
- Explain in **mixed Bangla + English** (Banglish is fine), the way a teacher explains to a student — step by step, beginner-friendly framing even for advanced points, but don't waste words on things an intermediate dev already knows.
- Technical terms, code, keywords stay in **English**; explanations/connective narration in Bangla.
- Use **concrete examples and real-world analogies** for every concept (e.g., explain a Stack using a "plate stack" analogy, explain Mutex using a "single bathroom key" analogy) — but analogies should feel natural, not forced.
- After every concept, add a short **"Interview/MCQ Angle"** callout — 2-3 lines on what examiners usually twist this concept into (e.g., "MCQ-তে সাধারণত এইটা জিজ্ঞেস করে...").

### 1.2 Source Attribution (Instruction to Antigravity — this is HOW to write, not content to insert)
For every topic, before writing content, Antigravity should ground the explanation using (in priority order):
1. Official docs/specs where they exist (MDN for HTML/CSS/JS, PostgreSQL/MySQL official docs for DB, RFCs for networking/HTTP, language official docs for Python/Java/JS)
2. Well-known CS references: *CLRS (Introduction to Algorithms)* for DSA proofs/complexity, *Operating System Concepts (Silberschatz)* for OS, *Computer Networking: A Top-Down Approach (Kurose & Ross)* for networking, *Design Patterns (GoF)* for design patterns
3. Reputable tutorial sites for practical/applied framing: GeeksforGeeks, freeCodeCamp, Refactoring.Guru (design patterns specifically), OWASP (security topics only)
4. General software-engineering best practice knowledge for "General Knowledge" / SDLC / Git-type topics
- **Do not fabricate specific statistics, benchmark numbers, or named case studies.** If unsure of a fact, state the general well-established version of it instead of inventing specifics.
- No need to cite inline like a paper — just write correct, well-grounded explanations as if the writer had actually studied from these sources.

### 1.3 Code Examples
- Default code language per module (keep consistent so the learner isn't context-switching every paragraph):
  - **DSA & Algorithms module:** Java (as per user update)
  - **OOP & Design Patterns:** Python (fallback: show the same short example in Java too, only when a concept is clearer in a statically-typed language, e.g. interfaces/abstract classes)
  - **API / HTTP / Networking (Programming module):** JavaScript/Node.js or plain `curl` examples + JSON payloads
  - **Database:** raw SQL (ANSI-standard, PostgreSQL flavor if a choice must be made)
  - **HTML/CSS:** plain HTML5 + CSS3 (no framework), then 1 note on how the same thing looks in a utility framework like Tailwind if relevant
  - **OS/Security/General CS Fundamentals:** pseudocode or command-line snippets, not tied to one language
- Every code example must be **complete and runnable/copy-pasteable** — not a fragment with `...`. Keep examples short (10-25 lines) and focused on the one concept being taught.
- Add a 1-2 line comment above tricky lines explaining *why*, not just *what*.

### 1.4 Diagrams
- Use **Mermaid diagram code blocks** (` ```mermaid `) inside the `.md` files wherever a visual helps — this renders directly in most modern markdown viewers (VSCode, Obsidian, GitHub, Antigravity itself) with zero extra image files needed:
  - Data structures → tree/graph/linked-list diagrams (`graph TD` or `flowchart`)
  - Algorithms → flowcharts of the algorithm steps
  - Networking → sequence diagrams (`sequenceDiagram`) for request/response flows (TCP handshake, HTTP request lifecycle, DNS resolution)
  - OS → state diagrams (`stateDiagram-v2`) for process states, scheduling
  - Design Patterns → class diagrams (`classDiagram`)
- Only fall back to an actual generated image file (`.png`/`.svg`, stored in a topic's `assets/` subfolder) when Mermaid genuinely can't express it (e.g., a memory layout diagram, a specific UI mockup for HTML/CSS box model). Reference the image with normal markdown `![alt](assets/filename.png)`.

### 1.5 File Structure Per Topic
Every leaf topic file follows this internal structure, in this order:
```
# <Topic Title>

## Learning Objectives
(2-4 bullet points: what you should be able to answer after this)

## Core Concept
(the teaching content: explanation + analogy)

## Deep Dive / Gotchas
(the intermediate/advanced-level nuance, comparisons, edge cases, common mistakes)

## Code Example(s)
(per section 1.3 rules)

## Diagram
(per section 1.4 rules, if applicable to this topic)

## Quick Recap
(3-5 bullet summary)

## Practice MCQs (20-30 Questions)
(per section 4 format below)
```

---

## 2. Folder & File Structure (create exactly this layout)

```
welldev-prep/
├── 00-MASTER-PLAN.md                  ← this file, kept as reference/instructions
├── 01-programming/
│   ├── 00-module-overview.md
│   ├── 01-programming-fundamentals/
│   │   ├── 01-variables-datatypes.md
│   │   ├── 02-control-flow.md
│   │   ├── 03-functions-scope.md
│   │   └── 04-error-handling.md
│   ├── 02-oop/
│   │   ├── 01-classes-objects.md
│   │   ├── 02-encapsulation.md
│   │   ├── 03-inheritance.md
│   │   ├── 04-polymorphism.md
│   │   ├── 05-abstraction-interfaces.md
│   │   └── 06-solid-principles.md
│   ├── 03-design-patterns/
│   │   ├── 01-creational-patterns.md   (Singleton, Factory, Builder)
│   │   ├── 02-structural-patterns.md   (Adapter, Decorator, Facade)
│   │   └── 03-behavioral-patterns.md   (Observer, Strategy, Command)
│   ├── 04-api/
│   │   ├── 01-rest-fundamentals.md
│   │   ├── 02-http-methods-status-codes.md
│   │   ├── 03-api-design-versioning.md
│   │   └── 04-auth-jwt-oauth.md
│   ├── 05-database/
│   │   ├── 01-sql-basics-crud.md
│   │   ├── 02-joins.md
│   │   ├── 03-normalization.md
│   │   ├── 04-indexing.md
│   │   └── 05-transactions-acid.md
│   ├── 06-networking/
│   │   ├── 01-osi-tcpip-model.md
│   │   ├── 02-tcp-vs-udp.md
│   │   └── 03-dns-http-basics.md
│   └── 07-html-css/
│       ├── 01-semantic-html.md
│       ├── 02-box-model.md
│       ├── 03-flexbox-grid.md
│       └── 04-responsive-design.md
├── 02-dsa/
│   ├── 00-module-overview.md
│   ├── 01-data-structures/
│   │   ├── 01-arrays-strings.md
│   │   ├── 02-linked-lists.md
│   │   ├── 03-stacks-queues.md
│   │   ├── 04-trees-bst.md
│   │   ├── 05-graphs.md
│   │   ├── 06-hash-tables.md
│   │   └── 07-heaps-priority-queues.md
│   ├── 02-algorithms/
│   │   ├── 01-sorting-algorithms.md
│   │   ├── 02-searching-algorithms.md
│   │   ├── 03-graph-traversal-bfs-dfs.md
│   │   ├── 04-greedy-algorithms.md
│   │   └── 05-dynamic-programming-intro.md
│   ├── 03-complexity-analysis/
│   │   ├── 01-big-o-notation.md
│   │   └── 02-time-space-tradeoffs.md
│   └── 04-recursion/
│       ├── 01-recursion-basics.md
│       ├── 02-recursion-vs-iteration.md
│       └── 03-backtracking.md
├── 03-cs-fundamentals/
│   ├── 00-module-overview.md
│   ├── 01-database-deep/
│   │   ├── 01-sql-vs-nosql.md
│   │   └── 02-cap-theorem.md
│   ├── 02-networking-deep/
│   │   ├── 01-https-tls.md
│   │   └── 02-load-balancing-cdn.md
│   ├── 03-operating-systems/
│   │   ├── 01-process-vs-thread.md
│   │   ├── 02-scheduling-algorithms.md
│   │   ├── 03-memory-management.md
│   │   ├── 04-deadlock.md
│   │   └── 05-concurrency-sync.md
│   ├── 04-security/
│   │   ├── 01-encryption-hashing.md
│   │   ├── 02-common-vulnerabilities-owasp.md
│   │   └── 03-authn-vs-authz.md
│   ├── 05-api-http-deep/
│   │   ├── 01-http-headers-caching.md
│   │   └── 02-rest-vs-graphql.md
│   └── 06-general-knowledge/
│       ├── 01-git-version-control.md
│       ├── 02-sdlc-agile.md
│       └── 03-testing-types.md
├── 04-logical-reasoning/
│   ├── 00-module-overview.md
│   ├── 01-analytical-challenges/
│   │   ├── 01-pattern-sequences.md
│   │   ├── 02-syllogisms-logic-puzzles.md
│   │   └── 03-blood-relations-directions.md
│   └── 02-simple-mathematics/
│       ├── 01-arithmetic-percentages.md
│       ├── 02-ratios-proportions.md
│       └── 03-probability-basics.md
└── progress-tracker.md
```

**Note on overlap (important instruction to Antigravity):** Database & Networking appear in both `01-programming` (practical/applied: "how do I write a query," "how does a request travel") and `03-cs-fundamentals` (theoretical/conceptual: normalization theory, CAP theorem, TLS handshake internals). Antigravity must NOT duplicate the same content — the `01-programming` versions stay hands-on/applied, the `03-cs-fundamentals` versions go deeper into theory/internals. Cross-link them with a one-line note ("বিস্তারিত থিওরি জানতে দেখো: `03-cs-fundamentals/01-database-deep/`").

Each `00-module-overview.md` should contain: what this module covers, why it matters for this specific test, and a checklist of its chapters (as literal markdown checkboxes `- [ ]`) so it doubles as a progress tracker for that module.

`progress-tracker.md` at the root: one master checklist of all ~55 leaf topic files, checkbox style, so it's used as an overall "% complete" tracker.

---

## 3. Generation Order (Instruction to Antigravity: don't generate everything in one go)

Generate **one topic file at a time**, in this order, and pause/confirm after each chapter (not each file) so the plan stays reviewable:

1. `02-dsa/03-complexity-analysis/` (Big-O first — it's the foundation everything else references)
2. `02-dsa/01-data-structures/`
3. `02-dsa/02-algorithms/`
4. `02-dsa/04-recursion/`
5. `01-programming/02-oop/`
6. `01-programming/03-design-patterns/`
7. `01-programming/01-programming-fundamentals/`
8. `01-programming/04-api/`
9. `01-programming/05-database/`
10. `01-programming/06-networking/`
11. `01-programming/07-html-css/`
12. `03-cs-fundamentals/03-operating-systems/`
13. `03-cs-fundamentals/04-security/`
14. `03-cs-fundamentals/01-database-deep/`
15. `03-cs-fundamentals/02-networking-deep/`
16. `03-cs-fundamentals/05-api-http-deep/`
17. `03-cs-fundamentals/06-general-knowledge/`
18. `04-logical-reasoning/` (both subfolders — quick, no heavy grounding needed)

---

## 4. MCQ Section Spec (applies to every topic file — this is the exact format to use)

Each topic file ends with a `## Practice MCQs (20-30 Questions)` section. Requirements:

- **20-30 MCQs per topic**, numbered, 4 options each (A-D), only one correct answer.
- Mix of difficulty: ~40% direct recall, ~40% applied/scenario-based ("যদি এমন হয়... তাহলে কী হবে?"), ~20% tricky/gotcha or code-output questions.
- Where relevant, include **code-snippet-based questions** ("এই কোডের আউটপুট কী হবে?") and **diagram-based questions** (referencing a small inline Mermaid diagram or ASCII diagram).
- Answer + explanation must be hidden by default behind a **clickable dropdown**, using this exact HTML (works natively in GitHub-flavored Markdown, Antigravity's preview, VSCode, and most `.md` renderers — no JS needed):

```markdown
**Q1. এই প্রশ্নের বিষয়বস্তু এখানে লিখতে হবে?**

A) Option A
B) Option B
C) Option C
D) Option D

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

এখানে ব্যাখ্যা — কেন B সঠিক, এবং কেন বাকি অপশনগুলো ভুল (each wrong option gets 1 line on why it's a trap).

</details>

---
```

- After a wrong-option explanation, if the wrong option represents a common misconception, flag it explicitly: "⚠️ Common trap: ..."
- The last 3-5 MCQs of each topic should intentionally be the **hardest** ones (combining this topic with a previously covered one), to push past "intermediate" into "advanced" territory.

---

## 5. Definition of Done (per topic file)

A topic file is complete only when it has: learning objectives, core concept with an analogy, a deep-dive/gotchas section, at least one complete runnable code example (unless the topic is purely conceptual like CAP theorem — then a diagram substitutes), at least one Mermaid diagram where applicable, a quick recap, and exactly 20-30 MCQs in the dropdown format above.

When all ~55 leaf files + 4 module overviews + the root progress tracker exist and pass this checklist, the course is complete.
