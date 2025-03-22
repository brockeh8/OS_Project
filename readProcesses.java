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
        
        int pid 
        int arrival 
        int burst
        int priority

        list.add(new Process(pid, arrival, burst, priority));
      }
  ]
  
  catch ()
        
          
