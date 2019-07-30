package utility;

import java.util.List;

import static utility.processUtilsWindows.*;
import static utility.processUtilsLinux.*;
import static utility.processUtilsCommon.*;

public class osSwitch {
    public static void searchOs() throws InterruptedException {
        List<String> randomList;
        switch (System.getProperty("os.name")) {

            case "Windows XP":
            case "Windows 2003":
            case "Windows":
            case "Windows 2000":
            case "Windows 98":
            case "Windows NT":
            case "Windows Me":
            case "Windows 7":
            case "Windows 10":
                randomList = createRandomList(listRunningProcessesWin());
                execKillWin(randomList);
                break;

            //TODO test on MacOs
            case "Mac OS X":
            case "Linux":
                randomList = createRandomList(listRunningProcessLinux());
                execKillLinux(randomList);
                break;

            default:
                break;
        }
    }
}
