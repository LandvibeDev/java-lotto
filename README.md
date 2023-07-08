### 복권 구매 금액 입력 (1,000 원 단위) x * 1000 
   - "자동 x개요~"
   - x 개의 랜덤 숫자배열 생성 
   - 6개의 랜덤 숫자 생성 -> 배열로 
   - 배열 x개 
### 복권 당첨 번호 입력
- 당첨 번호 1~45 6개 정수 
- 보너스 번호 1~45 1개의 정수 
### x 개의 랜덤 숫자배열가지고 x번 반복 
   - 복권 당첨 번호랑 비교
   - ***비교 결과 대로 당첨내역 저장 (1~5등)***
     - [1등] _6개 일치 : 20억_
     - [2등] _5개 일치, 보너스 번호 일치 : 3000만_
     - [3등] _5개 일치 : 150만_
     - [4등] _4개 일치 : 5만_
     - [5등] _3개 일치 : 5천_ 
     - _그외 낙첨_
   - 당첨내역 총 당첨금에 합산

### 수익률
* 수익률 = 당첨금/구매액
* 백분율로 표기 
* 소수점 아래 첫째자리까지 반올림

#### 예외처리
    "[ERROR]" 로 시작하는 메시지와 함께 종료




## 폴더링

### config
  - LottoConfig
  - Message (enum)
  - SettingValues (enum)
### lotto
  - Application
  - Lotto
  - Printer
  - UserController
### machines
  - interfaces
      - Machine (interface)
      - JudgeMachine (interface)
      - NumberCompareMachine (interface)
  - AutoLottoMachine
  - LottoCompareMachine
  - RewardMeasuringMachine
### validate
  - ErrorMessages (enum)
  - LottoValidator
  - Validator (interface)
