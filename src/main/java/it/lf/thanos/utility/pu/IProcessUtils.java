package it.lf.thanos.utility.pu;

import java.util.List;

public interface IProcessUtils {

	List<String> listRunningProcesses();

	void execKill(List<String> killApp, boolean isHard) throws InterruptedException;

}
