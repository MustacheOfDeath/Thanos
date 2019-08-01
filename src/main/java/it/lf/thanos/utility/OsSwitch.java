package it.lf.thanos.utility;

import org.apache.commons.lang3.SystemUtils;

import static it.lf.thanos.utility.ProcessUtilsCommon.*;
import static it.lf.thanos.utility.ProcessUtilsLinux.*;
import static it.lf.thanos.utility.ProcessUtilsWindows.*;

import java.util.List;

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
