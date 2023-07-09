# 🎱 로또 미션 진행

<br>

## 🗒 구현 기능 목록

### 1️⃣ [입력] 구입할 로또 금액 입력받기

- 천원 단위로 입력받아 *MyLottoData*의 *money*에 금액을 저장합니다.
- 예외처리
-  **inputPurchasingMoney()**: void

<br>

### 2️⃣ [계산] 로또 발행하기

- 구입할 로또 금액으로부터 로또 개수를 계산해서 개수를 *MyLottoData*의 *quantity*에 저장합니다.
- 개수만큼 로또를 여러개 발행해서 *MyLottoData*의 *lottoSet*에 저장합니다.
- **issueLottoMultiSet()**: void 

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



## 🗂 폴더링

```
📦 src/main/java/
|
+ 🗂 lotto/
│        
+-------🅲 Application
|          : main() 존재, LottoManager 호출
|
+-------🅲 LottoManager
|          : 로또가 진행되는 클래스
|
+-------🅲 Lotto
|          : 6개의 로또 숫자가 저장되는 클래스
|
+-------🅲 MyLottoData
|          : 구입 금액과 발행된 로또 수량과 번호가 저장되는 클래스
|
+-------🅲 WinnerLottoData
|          : 당첨 번호와 보너스 번호가 저장되는 클래스
|
+-------🅲 ResultLottoData
|          : 로또 당첨 결과와 수익률이 저장되는 클래스
|
+-------🅲 Message
|          : 상수 메세지들을 모아놓은 클래스
|
+-------🅲 Number
|          : 상수 숫자들을 모아놓은 클래스          

```
