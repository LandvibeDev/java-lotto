# 🎱 로또 미션 진행

<br>

## 🗒 구현 기능 목록

### 1️⃣ [입력] 구입할 로또 금액 입력받기

- 천원 단위로 입력받아 *MyLottoData*의 *money*에 금액을 저장합니다.
- 예외처리
-  **inputPurchasingMoney**(): void

<br>

### 2️⃣ [계산] 로또 발행하기

- 구입할 로또 금액으로부터 로또 개수를 계산해서 개수를 *MyLottoData*의 *quantity*에 저장합니다.
- 개수만큼 로또를 여러개 발행해서 *MyLottoData*의 *lottoSet*에 저장합니다.
- **issueLottoMultiSet**: void // 로또 여러개 발행
  - **issueLottoOneSet**: void  // 로또 한장 발행 (숫자 6개)


<br>

### 2️⃣ [출력] 구입한 로또 출력하기

- *MyLottoData*의 *lottoSet*에 저장된 구입한 로또의 번호들을 출력합니다.
- **printPurchasedLotto()**: void

<br>

### 3️⃣ [입력] 당첨 번호와 보너스 번호 입력받기

- 당첨 번호와 보너스 번호를 입력받아 *WinnerLottoData*에 저장합니다.
- 예외처리
- **inputWinnerNumber()**: void
- **inputBonusNumber()**: void

<br>

### 4️⃣ [계산] 로또 당첨 결과 계산하기

- 발행한 로또와 당첨 번호, 보너스 번호를 비교하여 *ResultLottoData*에 저장합니다.
- **calculateResultLotto()**: void
  - **countNumberOfLottoMatches(**Lotto**)**: int
  - **isMatchWithBonusNumber(**Lotto**)**: boolean


<br>

### 5️⃣ [출력] 로또 당첨 결과 출력하기

- *ResultLottoData*에 저장된 데이터를 바탕으로 당첨 결과와 수익률을 출력합니다.
- **printResultLotto()**: void

<br>

------

<br>

