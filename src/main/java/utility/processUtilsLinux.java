package utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class processUtilsLinux {
    public processUtilsLinux() {
    }

    public static List<String> listRunningProcessLinux() {
        List<String> processList = new ArrayList<>();
        try {
            String process;
            String tempProcess = "";
            Process p = Runtime.getRuntime().exec("ps -ax");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while ((process = input.readLine()) != null) {
                tempProcess = prepareString(process);
                processList.add(tempProcess);
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
        System.out.println(processList.size() + " killable app\n\n");
        return processList;
    }

    public static void execKillLinux(List<String> killApp, boolean isHard) throws InterruptedException {

        try {
            if (isHard) {
                for (int i = 0; i < killApp.size(); i++) {
                    System.out.print("Killing " + killApp.get(i));
                    //Runtime.getRuntime().exec("killall "+killApp.get(i));
                    System.out.println(" -----> KILLED");
                }
                System.out.println("\n\nKilled " + killApp.size() + " app");
            } else {
                String killSkype = "Skype";
                System.out.print("Killing " + killSkype);
                Runtime.getRuntime().exec("killAll" + killSkype);
                System.out.println(" -----> KILLED");
            }
            TimeUnit.MILLISECONDS.sleep(10);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static String prepareString(String process) {
        String tempProcess = "";
        int endIndex = process.lastIndexOf("/");
        if (endIndex != -1) {
            tempProcess = process.substring(endIndex + 1);
        }
        tempProcess = tempProcess.split("-")[0];

        return tempProcess;
    }
}

