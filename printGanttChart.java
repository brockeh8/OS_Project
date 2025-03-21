private static void printGanttChart(List<Process> processes) {
  processes.sort((p1,p2) -> Integer.compare(p1.startTime, p2.startTime));
