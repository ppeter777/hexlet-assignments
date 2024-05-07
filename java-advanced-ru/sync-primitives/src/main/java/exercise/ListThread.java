package exercise;

// BEGIN
public class ListThread extends Thread{
    SafetyList safetyList;
    ListThread(SafetyList safetyList) {
        this.safetyList = safetyList;
    }
    @Override
    public void run() {
        try {
            for (var i = 0; i < 1000; i++) {
                Thread.sleep(1);
                safetyList.add("a");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
// END
