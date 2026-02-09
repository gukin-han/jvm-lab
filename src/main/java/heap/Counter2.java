package heap;

public class Counter2 {
    private int instanceCount = 0;      // Heap (Instance)
    private static int staticCount = 0; // Heap/Method Area (Static)

    public void compare() {
        int localCount = 0;             // Stack (Local)

        // 반복문을 사용하여 각 카운트를 5번 증가시킴
        for (int i = 0; i < 5; i++) {
            localCount++;
            this.instanceCount++;
            staticCount++;
        }
    }
}