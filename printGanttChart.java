private static void printGanttChart(List<Process> processes) {
  processes.sort((p1,p2) -> Integer.compare(p1.startTime, p2.startTime));

  StringBuilder top = new StringBuilder();
  StringBuilder bottom = new StringBuilder();

  for (int i = 0; i < processes.size(); i++) {
    Process p = processes.get(i);
    top.append(str:"| P").append(p.pid).append(str:" "); // prints "| P# "
    bottom.append(p.startTime).append(str:"   "); // prints spacing for times
    if (i == processes.size() - 1) {
      bottom.append(p.finishTime);
    }
  }

  System.out.println(top);
  System.out.println(bottom);
}
