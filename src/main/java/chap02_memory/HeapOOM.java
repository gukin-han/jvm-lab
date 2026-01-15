package chap02_memory;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * VM 옵션: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./oom_dump.hprof
 * -Xms: JVM이 시작할 때 할당하는 힙 메모리의 초기 크기
 * -Xmx: JVM이 사용할 수 있는 힙 메모리의 최대 크기
 * -XX:+HeapDumpOnOutOfMemoryError : 메모리 부족 오류가 발생할 때 힙 덤프를 생성
 * -XX:HeapDumpPath=./oom_dump.hprof : 힙 덤프 파일이 저장될 경로와 파일 이름을 지정 (루트)
 *
 * @author gukin-han
 */
public class HeapOOM {

  static class OOMObject {}

  public static void main(String[] args) {
    List<String> vmArgs = ManagementFactory.getRuntimeMXBean().getInputArguments();
    System.out.println("==== 적용된 VM 옵션 목록 ====");
    System.out.println(vmArgs);
    System.out.println("=========================");

    ArrayList<OOMObject> list = new ArrayList<>();

    while (true) {
      list.add(new OOMObject());
    }
  }
}
