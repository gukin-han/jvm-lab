package memory;
/**
 * VM 옵션: -Xss2M (32비트 시스템에서 실행)
 * @author gukin-han
 */
public class JavaVMStackOOM {
  public static void main(String[] args) {
    JavaVMStackOOM oom = new JavaVMStackOOM();
    oom.stackLeakByThread();
  }

  public void stackLeakByThread() {
    while (true) {
      Thread thread = new Thread(this::dontStop);
      thread.start();
    }
  }

  private void dontStop() {
    while (true) {
      // 무한 루프
    }
  }
}
