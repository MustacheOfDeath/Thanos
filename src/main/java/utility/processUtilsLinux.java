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
            Process p = Runtime.getRuntime().exec("ps -p");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((process = input.readLine()) != null) {
                processList.add(process);
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
        return processList;
    }

    public static void execKillLinux(List<String> killApp, boolean isHard) throws InterruptedException {

        try {
            if (isHard) {
                for (int i = 0; i < killApp.size(); i++) {
                    System.out.print("Killing " + killApp.get(i));
                    //Runtime.getRuntime().exec("kill -19 "+killApp.get(i));
                    System.out.println("-----> KILLED");
                }
                System.out.println("\n\nKilled " + killApp.size() + " app");
            } else {
                String killSkype = "0000";
                System.out.print("Killing " + killSkype);
                Runtime.getRuntime().exec("kill -19 " + killSkype);
                System.out.println("-----> KILLED");
            }
            TimeUnit.MILLISECONDS.sleep(10);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

