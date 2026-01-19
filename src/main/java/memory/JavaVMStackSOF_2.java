package memory;

/**
 * @author gukin-han
 * 실험: 스택 프레임 크기에 따른 StackOverflow 발생 시점 비교
 */
public class JavaVMStackSOF_2 {

  private static int stackDepth = 0;

  // 실험 1: 지역 변수가 없는 "얇은" 스택 프레임
  public static void thinMethod() {
    stackDepth++;
    thinMethod();
  }

  // 실험 2: 지역 변수가 많은 "두꺼운" 스택 프레임 (사용자님 코드)
  public static void thickMethod() {
    long v1, v2, v3, v4, v5, v6, v7, v8, v9, v10,
        v11, v12, v13, v14, v15, v16, v17, v18, v19, v20,
        v21, v22, v23, v24, v25, v26, v27, v28, v29, v30,
        v31, v32, v33, v34, v35, v36, v37, v38, v39, v40,
        v41, v42, v43, v44, v45, v46, v47, v48, v49, v50,
        v51, v52, v53, v54, v55, v56, v57, v58, v59, v60,
        v61, v62, v63, v64, v65, v66, v67, v68, v69, v70,
        v71, v72, v73, v74, v75, v76, v77, v78, v79, v80,
        v81, v82, v83, v84, v85, v86, v87, v88, v89, v90,
        v91, v92, v93, v94, v95, v96, v97, v98, v99, v100;

    stackDepth++;
    thickMethod();

    // 최적화 방지용 (실행되지는 않음)
    v1 = v2 = v3 = v4 = v5 = v6 = v7 = v8 = v9 = v10 =
        v11 = v12 = v13 = v14 = v15 = v16 = v17 = v18 = v19 = v20 =
            v21 = v22 = v23 = v24 = v25 = v26 = v27 = v28 = v29 = v30 =
                v31 = v32 = v33 = v34 = v35 = v36 = v37 = v38 = v39 = v40 =
                    v41 = v42 = v43 = v44 = v45 = v46 = v47 = v48 = v49 = v50 =
                        v51 = v52 = v53 = v54 = v55 = v56 = v57 = v58 = v59 = v60 =
                            v61 = v62 = v63 = v64 = v65 = v66 = v67 = v68 = v69 = v70 =
                                v71 = v72 = v73 = v74 = v75 = v76 = v77 = v78 = v79 = v80 =
                                    v81 = v82 = v83 = v84 = v85 = v86 = v87 = v88 = v89 = v90 =
                                        v91 = v92 = v93 = v94 = v95 = v96 = v97 = v98 = v99 = v100 = stackDepth;
  }

  public static void main(String[] args) {
    // === 실험 1: 얇은 책 (변수 없음) ===
    try {
      stackDepth = 0; // 초기화
      thinMethod();
    } catch (StackOverflowError e) {
      System.out.println("========== [실험 1 결과] ==========");
      System.out.println("Condition: 얇은 스택 프레임 (지역변수 없음)");
      System.out.println("Max Depth: " + stackDepth);
      System.out.println("==================================");
    }

    // === 실험 2: 두꺼운 책 (변수 많음) ===
    try {
      stackDepth = 0; // 초기화 (중요!)
      thickMethod();
    } catch (StackOverflowError e) {
      System.out.println("\n\n========== [실험 2 결과] ==========");
      System.out.println("Condition: 두꺼운 스택 프레임 (long 변수 100개)");
      System.out.println("Max Depth: " + stackDepth);
      System.out.println("==================================");
    }
  }
}