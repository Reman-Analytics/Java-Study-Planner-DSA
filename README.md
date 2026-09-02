# Smart Study Planner (DSA-Based Intelligent System)

An intelligent, Data Structures & Algorithms (DSA) driven study planning system designed to manage daily lecture schedules, optimize task priorities, track syllabus dependencies, and maintain active study sessions seamlessly.

---

##  Core System Architecture & Workflow

The system is built on 4 core pillars using fundamental Data Structures & Algorithms to manage tasks intelligently rather than operating as a standard CRUD application:

### 1.Daily Planner & Queue Management (Queue Data Structure)
- **Time-Slot Queue:** Organizes daily tasks and assignments sequentially.
- **Automated Break Schedule:** Enforces a structured workflow by inserting break sessions automatically between study tasks (e.g., `Study Task 1` ➔ `Break` ➔ `Study Task 2`).

### 2. Task Optimization & Sorting (Priority Queue / Sorting Algorithms)
- **Smart Prioritization:** Automatically reorganizes pending tasks based on deadline urgency and subject weightage using backend sorting algorithms to keep critical tasks at the top.

### 3. Active Session & Safety Net (Stack Data Structure)
- **Focus Mode:** Displays only the current task sitting at the top of the Stack , minimizing distractions until the task is completed or popped.
- **Undo Functionality:** Uses Stack memory to immediately reverse accidental task completions or deletions.

### 4. Syllabus & Knowledge Mapping (Trees & Graphs)
- **Subject Tree Structure:** Represents subjects as parent nodes and sub-topics/chapters as child nodes in a hierarchical format.
- **Prerequisite Dependency Check (Graph Traversal - BFS/DFS):** Checks if prerequisite topics are completed before unlocking advanced topics (e.g., checks if "Basic Java" is complete before allowing access to "Advanced Java").

---

## User Interface & Frontend Layout

The frontend provides a clean, 4-page dashboard layout (accessible via tabs or separate routes):

1. **Dashboard (Main Command Center):** Displays today's schedule (Queue view), the active Focus Mode widget (Stack top), and quick-action buttons for "Start Break" and "Undo".
2. **Task & Assignment Manager:** Form input for adding tasks (Name, Deadline, Priority, Subject) with a real-time sorted task list.
3. **Syllabus & Learning Path:** Hierarchical Tree/Graph visualization showing topic relations and lock icons for unfulfilled prerequisites.
4. **History & Analytics:** Tracks uncompleted tasks via Linked List logs and provides a review panel for exam/quiz mistakes.

## Below  some Screen Shots are Attach:

<img width="897" height="478" alt="git1" src="https://github.com/user-attachments/assets/ad77caf7-f091-4147-b38b-29ae51428402" />

<img width="781" height="232" alt="git2" src="https://github.com/user-attachments/assets/6dab93c4-f7d7-4e28-8156-123c5a8644f9" />

<img width="1356" height="513" alt="git3" src="https://github.com/user-attachments/assets/5a837d2c-a648-4257-8744-5bbc99f5df45" />


