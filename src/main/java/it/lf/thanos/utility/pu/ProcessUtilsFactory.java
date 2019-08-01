package it.lf.thanos.utility.pu;

public class ProcessUtilsFactory {

	public enum OS {
		WIN, LINUX
	}

	private ProcessUtilsFactory() {
	}

	public static IProcessUtils getProcessUtils(OS os) {
		if (os == OS.WIN) {
			return new ProcessUtilsWindows();
		} else if (os == OS.WIN) {
			return new ProcessUtilsLinux();
		}
		throw new IllegalArgumentException("OS not valid: " + os);
	}

}
