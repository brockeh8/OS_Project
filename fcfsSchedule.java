private static void fcfsSchedule(List<Process> processes) {
  processes.sort((p1,p2) -> Integer.compare(p1.arrivalTime, p2.arrivalTime));

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
