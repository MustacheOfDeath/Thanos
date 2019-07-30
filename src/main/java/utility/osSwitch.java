package utility;

import sun.plugin2.util.SystemUtil;
import java.util.List;

import static utility.processUtilsWindows.*;
import static utility.processUtilsLinux.*;
import static utility.processUtilsCommon.*;

public class osSwitch {
    public static void searchOs(boolean isHard) throws InterruptedException {
        List<String> randomList;
        switch (SystemUtil.getOSType()) {

            case SystemUtil.WINDOWS:
                randomList = createRandomList(listRunningProcessesWin());
                execKillWin(randomList, isHard);
                break;


            case SystemUtil.MACOSX:
            case SystemUtil.UNIX:
                randomList = createRandomList(listRunningProcessLinux());
                execKillLinux(randomList, isHard);
                break;

            default:
                break;
        }
    }
}
