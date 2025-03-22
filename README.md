# OS_Project
Write a program that simulates how an Operating System schedules processes using different algorithms.

Step 1: Read Process Data from a File
1. Create a text file (e.g., processes.txt) with a list of processes.
2. Each process should have:
o Process ID (PID)
o Arrival Time (When the process arrives in the system)
o Burst Time (How long the process needs the CPU)
o Priority (If using Priority Scheduling)
Example of processes.txt:
PID Arrival_Time Burst_Time Priority
1 0 5 2
2 2 3 1
3 4 2 3
4. Your program should read this file and store the data in memory.
   
✅Step 2: Implement Two Scheduling Algorithms
You must write code for at least two of these CPU scheduling algorithms:
✅ First-Come, First-Served (FCFS) → The first process that arrives runs first.
✅ Shortest Job First (SJF) → The process with the smallest burst time runs first.
✅ Round Robin (RR) → Each process gets a fixed time (time quantum), then the next process runs.
✅ Priority Scheduling → Processes with a higher priority run first.
Each algorithm should:
✔ Sort the processes based on the algorithm's rule.
✔ Simulate execution (decide which process runs at each step).
✔ Calculate Waiting Time (WT) and Turnaround Time (TAT).

✅Step 3: Display a Gantt Chart (Execution Order)
1. Your program should show the order in which processes run.
2. Display a simple text-based Gantt chart in the console.
Example Output:
| P1 | P2 | P3 | P1 | P4 |
0 2 5 7 12 15
3. At the end, print:
o Waiting Time (WT) for each process
o Turnaround Time (TAT) for each process
o Average WT and TAT
