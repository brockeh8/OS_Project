private static List<Process> readProcesses(String fileNAme) {
  List<Process> list = new ArrayList<>():
  try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      string line;
      string line;
      boolean skipHeader = true;
      while ((line = br.readLine()) != null) {
        if (skipHeader) { 
            skipHeader = false;
            continue;
        }
        String[] parts = line.trim().split("\\s+");
        if 
