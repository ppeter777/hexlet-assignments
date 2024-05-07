package exercise;

import java.util.ArrayList;
import java.util.List;

class SafetyList {
    // BEGIN
    private final List<String> list;

    public SafetyList() {
        this.list = new ArrayList<>();
    }

    public synchronized void add(String e) {
        list.add(e);
    }

    public int getSize() {
        return list.size();
    }

    public String get(int index) {
        return list.get(index);
    }

    // END
}
