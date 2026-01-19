package memory;

/**
 * VM 옵션: -Xss180k
 * -Xss: 각 스레드의 스택 메모리 크기를 설정
 * 자바 가상 머신 버전 운영체제 혹은 JDK 환경에 따라 최소 스택 크기와 최대 스택 크기가 다를 수 있음
 *
 * @author gukin-han
 */
public class JavaVMStackSOF_1 {
  private int stackLength = 1;

  public void stackLeak() {
    stackLength++;
    stackLeak();
  }

  public static void main(String[] args) throws Throwable {
    JavaVMStackSOF_1 oom = new JavaVMStackSOF_1();

    try {
      oom.stackLeak();
    } catch (Throwable e) {
      System.out.println("stack length : " + oom.stackLength);
      throw e;
    }

  }


}
