private static void sjfSchedule(List<Process> processes) {
    processes.sort((p1,p2) -> {
      if (p1.arrivalTime != p2.arrivalTime) {
          return Integer.compare(p1.arrivalTime, p2.arrivalTime);
      }
      return Integer.compare(p1.burstTime, p2.burstTime);
    });

    int n = processes.size();
    bootlean[] visited = new boolean[n];
    int finished = 0;
    int currentTime = 0;

    while (finished < n) {
      int idx = -1
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
