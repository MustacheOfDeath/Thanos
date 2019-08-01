package it.lf.thanos.utility;

import static it.lf.thanos.utility.Randomizer.createRandomList;

import java.util.List;

import org.apache.commons.lang3.SystemUtils;

import it.lf.thanos.utility.pu.IProcessUtils;
import it.lf.thanos.utility.pu.ProcessUtilsFactory;
import it.lf.thanos.utility.pu.ProcessUtilsFactory.OS;

public class OsSwitch {
	public static void searchOs(boolean isHard) throws InterruptedException {
		OS os = SystemUtils.IS_OS_WINDOWS ? OS.WIN : (SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_MAC) ? OS.LINUX : null;

		IProcessUtils utils = ProcessUtilsFactory.getProcessUtils(os);

		List<String> randomList = createRandomList(utils.listRunningProcesses());
		utils.execKill(randomList, isHard);
	}
}
