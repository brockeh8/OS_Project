import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Two_Scheduler {

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
    //main
    public static void main(String[] args) {

        List<Process> fcfsProcesses = readProcesses("processes.txt");
        if (fcfsProcesses.isEmpty()) {
            System.out.println("Could not read");
            return;
        }
        fcfsSchedule(fcfsProcesses);
        System.out.println("\nFCFS");
        printGanttChart(fcfsProcesses);
        printTimes(fcfsProcesses);

        List<Process> sjfProcesses = readProcesses("processes.txt");
        if (sjfProcesses.isEmpty()) {
            System.out.println("Could not read");
            return;
        }
        sjfSchedule(sjfProcesses);
        System.out.println("\nSJF");
        printGanttChart(sjfProcesses);
        printTimes(sjfProcesses);
    }
    //Read
    private static List<Process> readProcesses(String fileName) {
        List<Process> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean skipHeader = true;
            while ((line = br.readLine()) != null) {
                if (skipHeader) {
                    skipHeader = false; 
                    continue;
                }
                String[] parts = line.trim().split("\\s+");
                if (parts.length < 4) continue;

                int pid = Integer.parseInt(parts[0]);
                int arrival = Integer.parseInt(parts[1]);
                int burst = Integer.parseInt(parts[2]);
                int priority = Integer.parseInt(parts[3]);

                list.add(new Process(pid, arrival, burst, priority));
            }
        } catch (IOException e) {
            System.out.println("Read error");
        }
        return list;
    }
    //FCFS
    private static void fcfsSchedule(List<Process> processes) {
        processes.sort((p1, p2) -> Integer.compare(p1.arrivalTime, p2.arrivalTime));

        int currentTime = 0;
        for (Process p : processes) {
            if (currentTime < p.arrivalTime) {
                currentTime = p.arrivalTime;
            }
            p.startTime = currentTime;
            p.finishTime = p.startTime + p.burstTime;
            p.waitingTime = p.startTime - p.arrivalTime;
            p.turnaroundTime = p.finishTime - p.arrivalTime;
            currentTime = p.finishTime;
        }
    }
    //SJF
    private static void sjfSchedule(List<Process> processes) {
        processes.sort((p1, p2) -> {
            if (p1.arrivalTime != p2.arrivalTime) {
                return Integer.compare(p1.arrivalTime, p2.arrivalTime);
            }
            return Integer.compare(p1.burstTime, p2.burstTime);
        });

        int n = processes.size();
        boolean[] visited = new boolean[n];
        int finished = 0;
        int currentTime = 0;

        while (finished < n) {
            int idx = -1;
            int minBurst = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                Process p = processes.get(i);
                if (!visited[i] && p.arrivalTime <= currentTime) {
                    if (p.burstTime < minBurst) {
                        minBurst = p.burstTime;
                        idx = i;
                    }
                }
            }
            if (idx == -1) {
                int earliestArrival = Integer.MAX_VALUE;
                int earliestIdx = -1;
                for (int i = 0; i < n; i++) {
                    if (!visited[i] && processes.get(i).arrivalTime < earliestArrival) {
                        earliestArrival = processes.get(i).arrivalTime;
                        earliestIdx = i;
                    }
                }
                currentTime = processes.get(earliestIdx).arrivalTime;
                idx = earliestIdx;
            }
            visited[idx] = true;
            Process p = processes.get(idx);
            p.startTime = currentTime;
            p.finishTime = p.startTime + p.burstTime;
            p.waitingTime = p.startTime - p.arrivalTime;
            p.turnaroundTime = p.finishTime - p.arrivalTime;
            currentTime = p.finishTime;
            finished++;
        }
    }
    //Gantt chart 
    private static void printGanttChart(List<Process> processes) {
        processes.sort((p1, p2) -> Integer.compare(p1.startTime, p2.startTime));
        StringBuilder top = new StringBuilder();
        StringBuilder bottom = new StringBuilder();
        for (int i = 0; i < processes.size(); i++) {
            Process p = processes.get(i);
            top.append("| P").append(p.pid).append(" ");
            bottom.append(p.startTime).append("    ");
            if (i == processes.size() - 1) {
                bottom.append(p.finishTime);
            }
        }
        top.append("|");
        System.out.println(top);
        System.out.println(bottom);
    }
    //Wait times
    private static void printTimes(List<Process> processes) {
        processes.sort((p1, p2) -> Integer.compare(p1.pid, p2.pid));
        int totalWait = 0;
        int totalTAT = 0;
        System.out.println("PID\tStart\tFinish\tWait\tTAT");
        for (Process p : processes) {
            System.out.println(p.pid + "\t" + p.startTime + "\t" + p.finishTime + "\t" + p.waitingTime + "\t" + p.turnaroundTime);
            totalWait += p.waitingTime;
            totalTAT += p.turnaroundTime;
        }
        double avgWT = (double) totalWait / processes.size();
        double avgTAT = (double) totalTAT / processes.size();
        System.out.printf("Avg Waiting: %.2f\n", avgWT);
        System.out.printf("Avg TAT: %.2f\n", avgTAT);
    }
}
