🎮 ChatPG - 텍스트 기반 RPG 게임
Spring Boot + State Pattern을 활용한 콘솔 RPG 게임
토이 프로젝트

📌 프로젝트 개요
ChatPG는 터미널에서 즐기는 클래식한 텍스트 기반 RPG 게임입니다. 
Spring Boot를 활용하여 객체지향 설계 원칙과 디자인 패턴을 실습하기 위한 교육용 프로젝트로 제작되었습니다.

🎯 학습 목표
디자인 패턴 적용: State Pattern, Factory Pattern 실전 활용
계층형 아키텍처: Domain-Service-State 레이어 분리 설계
객체지향 설계: 도메인 주도 설계(DDD) 개념 적용
Spring Framework: DI/IoC 컨테이너를 활용한 느슨한 결합

🛠️ 기술 스택
Backend
  - Java 21
  - Spring Boot 3.5.6
  - Gradle 8.14.3
  - Lombok 1.18.40

Development Tools
  - IntelliJ IDEA
  - Git

🎲 주요 기능
1️⃣ 플레이어 시스템
  - 캐릭터 생성 (이름 설정)
  - 레벨 & 경험치 시스템
  - 스탯 관리 (HP, 공격력, 방어력, 속도)
  - 기본/추가/현재 스탯 분리 관리

2️⃣ 전투 시스템
  - 턴제 전투 메커니즘
  - 플레이어 vs 몬스터 전투
  - 실시간 전투 로그
  - 데미지 계산 (공격력 - 방어력)
  - 전투 결과 처리 (승리/패배)

3️⃣ 인벤토리 & 장비
  - 아이템 획득/관리
  - 장비 착용/해제
  - 아이템 타입 분류 (소비/장비)
  - 장비 부위별 관리 (헬멧, 무기, 갑옷, 신발, 악세서리)

4️⃣ 던전 탐험
  - 던전 진입
  - 몬스터 조우
  - 보상 획득
