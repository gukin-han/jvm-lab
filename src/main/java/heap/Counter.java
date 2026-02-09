package heap;

public class Counter {
    private int instanceCount = 0;      // Heap (Instance)
    private static int staticCount = 0; // Heap/Method Area (Static)

    public void compare() {
        int localCount = 0;             // Stack (Local)

        localCount++;
        this.instanceCount++;
        staticCount++;
    }
}