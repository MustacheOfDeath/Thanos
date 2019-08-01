package utility;

import org.apache.commons.lang3.SystemUtils;

import java.util.List;

import static utility.ProcessUtilsWindows.*;
import static utility.ProcessUtilsLinux.*;
import static utility.ProcessUtilsCommon.*;

public class OsSwitch {
    public static void searchOs(boolean isHard) throws InterruptedException {
        List<String> randomList;
        if (SystemUtils.IS_OS_WINDOWS) {
            randomList = createRandomList(listRunningProcessesWin());
            execKillWin(randomList, isHard);
        } else if (SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_MAC) {
            randomList = createRandomList(listRunningProcessLinux());
            execKillLinux(randomList, isHard);
        }
    }
}
