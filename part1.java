import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Part1_ReadFile {

    // Reads "processes.txt" and returns a list of Process objects
    public static ArrayList<Process> readProcesses(String filename) {
        ArrayList<Process> processList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean skipHeader = true;

            while ((line = br.readLine()) != null) {
                // Skip the header line if present
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }
                // Each line: PID Arrival_Time Burst_Time Priority
                String[] parts = line.trim().split("\\s+");
                if (parts.length < 4) {
                    continue; // skip malformed lines
                }

                int pid = Integer.parseInt(parts[0]);
                int arrival = Integer.parseInt(parts[1]);
                int burst = Integer.parseInt(parts[2]);
                int priority = Integer.parseInt(parts[3]);

                Process p = new Process(pid, arrival, burst, priority);
                processList.add(p);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return processList;
    }

    // Main method to test reading and printing the processes.
    public static void main(String[] args) {
        String fileName = "processes.txt";  // Adjust path if needed
        ArrayList<Process> processes = readProcesses(fileName);

        // Print out what we read
        if (processes.isEmpty()) {
            System.out.println("No processes found in " + fileName);
        } else {
            System.out.println("Processes read from " + fileName + ":");
            for (Process p : processes) {
                System.out.println(p);
            }
        }
    }
}
