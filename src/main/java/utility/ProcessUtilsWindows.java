package utility;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class ProcessUtilsWindows {
    public ProcessUtilsWindows() {
    }

    public static List<String> listRunningProcessesWin() {

        List<String> processList = new ArrayList<>();
        try {
            File file = File.createTempFile("realhowto", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new java.io.FileWriter(file);

            String vbs = "Set WshShell = WScript.CreateObject(\"WScript.Shell\")\n"
                    + "Set locator = CreateObject(\"WbemScripting.SWbemLocator\")\n"
                    + "Set service = locator.ConnectServer()\n"
                    + "Set processes = service.ExecQuery _\n"
                    + " (\"select name from Win32_Process\")\n"
                    + "For Each process in processes\n"
                    + "wscript.echo process.Name \n"
                    + "Next\n"
                    + "Set WSHShell = Nothing\n";

            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
            BufferedReader input =
                    new BufferedReader
                            (new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                processList.add(line);
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(processList.size() + " killable app\n\n");
        return processList;
    }

    public static void execKillWin(List<String> killApp, boolean isHard) throws InterruptedException {
        try {
            if (isHard) {
                for (int i = 0; i < killApp.size(); i++) {
                    System.out.print("Killing " + killApp.get(i));
                    //Runtime.getRuntime().exec("TASKKILL /F /IM " + killApp.get(i));
                    TimeUnit.MILLISECONDS.sleep(10);
                    System.out.println("-----> KILLED");
                }
                System.out.println("\n\nKilled " + killApp.size() + " app");
            } else {
                String killSkype = "Skype.exe";
                System.out.print("Killing " + killSkype);
                Runtime.getRuntime().exec("TASKKILL /F /IM " + killSkype);
                TimeUnit.MILLISECONDS.sleep(10);
                System.out.println("-----> KILLED");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}