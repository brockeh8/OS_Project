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
