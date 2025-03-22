private static List<Process> readProcesses(String fileNAme) {
  List<Process> list = new ArrayList<>():
  try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      string line;
      string line;
      //SKIPS HEADER
      boolean skipHeader = true;
      while ((line = br.readLine()) != null) {
        if (skipHeader) { 
            //CHANGES VALUE
            skipHeader = false;
            continue;
        }
        //SPLIT LINE
        String[] parts = line.trim().split("\\s+");
        if (parts.length < 4) {
            continue;
        }
        
        int pid = Integer.parseInt(parts[0]);
        int arrival = Integer.parseInt(parts[1]);
        int burst = Integer.parseInt(parts[2]);
        int priority = Integer.parseInt(parts[3]);

        list.add(new Process(pid, arrival, burst, priority));
      }
  ]
  
  catch (IOException e)  {
      system.out.println("Read error");
  }
  return list;
}
        
          
