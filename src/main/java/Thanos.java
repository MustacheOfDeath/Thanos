import java.util.*;

import static utility.processUtils.*;

public class Thanos {

    public static void main(String[] args) throws InterruptedException {
        List<String> randomList = createRandomList(listRunningProcesses());
        execKill(randomList);
    }
}
