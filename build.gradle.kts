plugins {
    id("java")
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")


    // 1. JOL (Java Object Layout)
    // 객체가 메모리에서 실제로 몇 바이트를 차지하는지, 헤더가 어떻게 생겼는지 보여줍니다.
    // 책 2장(메모리) 학습 시 필수입니다.
    implementation("org.openjdk.jol:jol-core:0.17")

    // 2. JMH (Java Microbenchmark Harness)
    // GC 변경이나 코드 최적화에 따른 성능 차이를 '나노초' 단위로 정확히 측정해줍니다.
    // 단순 System.currentTimeMillis()는 JVM 웜업 등을 반영하지 못해 부정확합니다.
    implementation("org.openjdk.jmh:jmh-core:1.37")
    annotationProcessor("org.openjdk.jmh:jmh-generator-annprocess:1.37")

    // (선택) 바이트코드 조작용 (책 후반부 예제용)
    implementation("org.ow2.asm:asm:9.6")
}

tasks.test {
    useJUnitPlatform()
}