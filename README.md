# 🚀 Spring Boot 3 스터디

스프링 부트 3.2.0 버전으로 백엔드 개발 기초를 다지는 리포지토리입니다.

## 🛠️ Tech Stack
* **Java:** 17 (LTS)
* **Spring Boot:** 3.2.0
* **Gradle:** 8.5

## 📝 Trouble Shooting

<details>
<summary>👉 1. Gradle 버전 호환성 문제 해결 (클릭해서 보기)</summary>

* **문제:** Gradle 9.x와 Spring Boot 3.2.0 호환 불가 (`NoSuchMethodError`)
* **해결:** `gradle-wrapper.properties`에서 버전을 `8.5`로 다운그레이드.

</details>

<details>
<summary>👉 2. Java 버전 불일치 해결 (클릭해서 보기)</summary>

* **문제:** 로컬(Java 25) vs 프로젝트(Java 17) 불일치
* **해결:** `build.gradle`에 `sourceCompatibility = '17'` 명시.

</details>
