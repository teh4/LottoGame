# 수동ㆍ자동 로또 게임 🎰

### 개발기간 
 - 2023.06.05 ~ 2023.06.11

### Language & Tool
<div>
	<img src="https://img.shields.io/badge/Java-007396?style=flat&logo=Java&logoColor=white" />
  <img src="https://img.shields.io/badge/IntelliJ-000000?style=flat&logo=intellijidea&logoColor=white" />
  </div>
<br>

## 📑 시나리오
<details>
  <summary><b>본문 확인 (👈 Click)</b></summary>
  <div markdown="1">
    <br>
	  
- 로또 게임을 진행 할 금액을 입력 받는다.
  - 로또는 한 게임 당 천원이다. (한 게임 당 여섯개의 번호가 발급된다.)
  - 입력 금액과 로또 한장의 금액이 나눠 떨어져야 한다. (검증로직)
  - 1회 구매 한도는 최소 천원이상이다.
 <br>
 
- 수동으로 발급 할 로또 게임 수를 입력 받는다. 그리고 그 수에 맞게 로또 번호를 입력 받는다.
  - 이어서 수동 발급 장수를 제외한 장수만큼 자동으로 로또 티켓을 생성한다.
  - 로또 한 게임에는 여섯 개의 정수가 중복 없이 존재한다.
    - 로또 번호는 1 ~ 45 이다.
    - 입력 받은 번호는 오름차순으로 정렬 된다.
 <br>
 
- 로또 티켓 구매가 완료 되면 게임을 시작한다.
  - 로또게임 한 회차당 여섯개의 당첨번호와 보너스 볼이 존재한다.
  - 당첨 번호는 중복되는 숫자가 없는 정수 값이다.
  - 보너스 볼 역시 당첨번호와 중복되면 안된다.
  - 상금은 아래와 같다.
    - 3개 일치 시 상금 : 5,000원
    - 4개 일치 시 상금 : 50,000원
    - 5개 일치 시 상금 : 1,500,000원
    - 5개 일치 + 보너스 볼 상금 : 30,000,000원
    - 6개 일치 상금 : 2,000,000,000원 (20억)
 <br>
 
- 당첨 결과를 기준으로 구체적인 수익률과 수익률에 대한 해석을 출력할 수 있다.
  - 수익률 = 당첨금액 / 구매금액
  - 수익률에 따른 해석은 아래를 따른다.
    - 수익률 < 1 : 손해
    - 수익률 = 1 : 본전
    - 수익률 > 1 : 이익
  - 수익률이 1 이상이 될 때, 게임은 자동 종료된다. 

 <br>
    </div>
</details>
<br>

## 🌀 시연

 > **게임**

<details>
  <summary><b> 수동 게임 (👈 Click)</b></summary>
  <div markdown="1">
    <br>
    
  ![수동게임](https://github.com/teh4/LottoGame/assets/131750928/60701630-fade-4756-a7cd-3c3ff99d2d57)
  <br>

  수동으로 게임을 진행할 시 6개의 번호를 하나하나 입력 받는다.<br>
  6개의 번호를 입력 하면 한 줄의 로또 번호가 리스트로 들어간다.<br>
  위의 시연 모습에서 수익률이 1 미만이기에 로또 게임이 자동 재시작된다. <br>
  
  </div>
</details>
<br>

<details>
  <summary><b> 자동 게임 (👈 Click)</b></summary>
  <div markdown="1">
    <br>
    
 ![자동게임](https://github.com/teh4/LottoGame/assets/131750928/ec4586ba-c666-40fc-a0b2-b082ebfaebe0)
<br>

자동으로 게임을 진행을 하기 위해서는 게임 진행을 위한 금액을 입력 후 0을 입력하면 게임 진행이 전체 자동 게임으로 진행 된다.<br>
0을 입력하면 바로 나의 로또 번호가 생성되어 당첨 결과를 바로 알 수 있다.<br>
위의 시연 모습에서 수익률이 1 로 로또 게임이 종료된다. <br>

  </div>
</details>
<br>

<details>
  <summary><b> 수동ㆍ자동 게임 (👈 Click)</b></summary>
  <div markdown="1">
    <br>
    
![수동자동게임](https://github.com/teh4/LottoGame/assets/131750928/2f267615-3ac1-4f59-a193-c28888b89e05)
 <br>
 
 로또 번호 수동 입력과 자동 번호 생성을 동시에 하고 싶다면, 게임 진행을 위한 금액 입력 후 수동으로 진행할 게임 횟수를 전체 게임 횟수 미만으로 입력하면 된다.<br>
 전체 게임에서 수동으로 진행할 게임을 제외한 게임들은 전부 자동으로 게임으로 진행되어 로또 번호들이 자동 생성된다.<br>
 수동으로 진행하는 게임의 번호 입력은 수동 게임과 동일한 방법으로 진행된다. <br>
 위의 시연 모습에서 수익률이 0.5로 로또 게임이 자동 재시작된다.<br>
 
  </div>
</details>
<br>

> **에러**
<details>
  <summary><b> 금액 입력 에러 (👈 Click)</b></summary>
  <div markdown="1">
    <br>
    
 ![금액에러](https://github.com/teh4/LottoGame/assets/131750928/38e4e4bf-b0e8-4f95-9e53-f0b390dea900)
  <br>
  금액 1000원 당 게임 1번 이기에 금액은 1000원 단위로 입력해야 한다.<br>
  1000원 단위로 잘못 입력하면 에러 메세지와 함께 재입력을 유도한다. <br>
  </div>
</details>
<br>

<details>
  <summary><b> 수동 게임 횟수 에러 (👈 Click)</b></summary>
  <div markdown="1">
    <br>
    
![수동횟수에러](https://github.com/teh4/LottoGame/assets/131750928/8739005d-0c62-4df4-856c-7e121cfea720)
<br>
수동으로 진행할 게임 횟수의 최대값은 전체 게임 횟수이다.<br>
따라서 전체 게임 횟수보다 큰 값을 입력하면 에러 메세지와 함께 재입력을 유도한다.<br>

  </div>
</details>
<br>

<details>
  <summary><b> 수동 번호 입력 에러 (👈 Click)</b></summary>
  <div markdown="1">
    <br>
    
![수동번호에러](https://github.com/teh4/LottoGame/assets/131750928/c97560b1-8fa0-43d9-8437-0b186cfeabda)
 <br>
 이전에 입력한 번호와 동일하게 입력하면 에러메세지와 함께 재입력을 유도한다.<br>
또한, 로또 번호는 1~45 사이로 입력해야 하며, 다른 범위의 숫자를 입력하면 에러 메세지와 함께 재입력을 유도한다.<br>
  </div>
</details>
<br>

## ✍🏻 회고
<details>
  <summary><b>본문 확인 (👈 Click)</b></summary>
  <div markdown="1">
    <br> 시나리오가 주어진 상태로 시나리오 조건에 맞게 구현하는 프로젝트였습니다.
    <br> 시나리오를 직접 구상하지 않았기에 시나리오 이해가 먼저였습니다.
    <br> 이번 프로젝트는 MVC를 공부하는 도중에 진행했기에 역할을 나누어 Controll, View, Service, Prize 4개의 단으로 나누어서 진행했습니다. 
    <br> 각 단에서 종속 관계에 대해 이해하고 추후 스프링에서 진행 할 MVC 패턴에 대한 이해도를 높였던 프로젝트였습니다.
    <br> 추후 시간이 된다면 자바 프로젝트가 아닌 스프링 프로젝트로 발전시키고 싶습니다.
    <br>
  </div>
</details>
<br>
