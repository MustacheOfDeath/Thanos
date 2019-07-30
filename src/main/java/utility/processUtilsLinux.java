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

    public static void execKillLinux(List<String> killApp) throws InterruptedException {
        for (int i = 0; i < killApp.size(); i++) {
            try {
                System.out.print("Killing " + killApp.get(i));
                String killSkype = "0000";
                Runtime.getRuntime().exec("kill -19 " + killSkype);
                /*
                 *
                 *Runtime.getRuntime().exec("kill -19 "+killApp.get(i));
                 *
                 */
                TimeUnit.MILLISECONDS.sleep(10);
                System.out.println("-----> KILLED");
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        System.out.println("\n\nKilled " + killApp.size() + " app");
    }
}
