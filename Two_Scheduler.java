import java.io. *;
import java.util.ArrayList;
import java.util.List;

public class Two_Scheduler.java {
    static class Process {
        int pid;
        int arrivalTime;
        int burstTime;
        int priority;
        int startTime;
        int finishTime; 
        int waitingTime;
        int turnaroundTime; 

        Process(int pid, int arrivalTime, int burstTime, int priority) {
            this.pid = pid; 
            this.arrivalTime = arrivalTime;
            this.burstTime = burstTime; 
            this.priority = priority; 
        }
    }
