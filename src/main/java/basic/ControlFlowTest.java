package basic;

public class ControlFlowTest {
  // [실험 1] If-Else: 분기와 점프
  public int ifElse(int a, int b) {
    if (a < b) {
      return a + b;
    } else {
      return a - b;
    }
  }

  // [실험 2] For vs While: 구조적 동일성 증명
  public int forLoop() {
    int sum = 0;
    for (int i = 0; i < 10; i++) {
      sum += i;
    }
    return sum;
  }

  public int whileLoop() {
    int sum = 0;
    int i = 0;
    while (i < 10) {
      sum += i;
      i++;
    }
    return sum;
  }

  // [실험 3] Switch: Table vs Lookup (O(1) vs O(log n))
  public int switchDense(int val) {
    // 케이스가 조밀함 (1, 2, 3, 4, 5) -> tableswitch 예상
    switch (val) {
      case 1: return 10;
      case 2: return 20;
      case 3: return 30;
      case 4: return 40;
      case 5: return 50;
      default: return 0;
    }
  }

  public int switchSparse(int val) {
    // 케이스가 듬성듬성함 (1, 100, 1000) -> lookupswitch 예상
    switch (val) {
      case 1: return 10;
      case 100: return 20;
      case 1000: return 30;
      default: return 0;
    }
  }

  public int switchSparseV2(int val) {
    switch (val) {
      case 1000: return 30;
      case 1: return 10;
      case 100: return 20;
      default: return 0;
    }
  }
}
