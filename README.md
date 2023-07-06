# 💰로또 과제💵

---
<details>
<summary>🗂️ 폴더링</summary>
<div markdown="1">

``` java
📦 game/
    |
    + 🗂 NumberGame
    | : 숫자 게임 인터페이스

📦 lotto/
    |
    + 🗂 Application
    | : 숫자 게임을 시작하는 애플리케이션
    |
    + 🗂 Constant
    | : 로또 게임에 필요한 상수들을 Enum에 저장하는 클래스
    |
    + 🗂 Lotto 
    | : 로또 클래스
    |
    + 🗂 LottoGame 
    | : 로또 게임을 관리하는 클래스
    |
    + 🗂 LottoGameAnalyzer 
    | : 로또 게임의 결과를 분석하는 클래스
    |
    + 🗂 Rule 
    | : 로또 게임에 적용되는 룰을 저장하는 클래스
    |          
    + 🗂 Score 
    | : 로또 게임의 결과를 저장하는 클래스
    |
    + 🗂 Validator 
    | : 로또 게임 중 요구되는 사용자의 입력의 유효성을 검사하는 클래스
    |
    + 🗂 View 
    | : 로또 게임 중 사용자에게 보여지는 출력을 담당하는 클래스
    |
```

</div>
</details>

<details>
<summary>💻 Application</summary>
<div markdown="1">

```java
public static void main(String[] args) {
   Rule lottoGameRule = new Rule(START_NUMBER.get(), END_NUMBER.get(), NUMBER_SIZE.get());
   NumberGame lottoGame = new LottoGame(lottoGameRule);
   lottoGame.play();
}
```
어플리케이션을 시작합니다.

로또 게임의 규칙을 생성합니다.

규칙을 로또 게임의 생성자에 넘겨줘 숫자 게임을 생성합니다.

로또 게임을 시작합니다.

---

</div>
</details>

<details>
<summary>💻 NumberGame</summary>
<div markdown="1">

### NumberGame

```java
public interface NumberGame {
	void play();
}
```

숫자 게임 인터페이스입니다.\
어떠한 숫자 게임이든 게임을 시작해야 하는 공통적인 특성이 있기에 play() 메서드를 선언했습니다.

Application 클래스에서 NumberGame someNumberGame = new SomeNumberGame();의 형태로 임의의 숫자 게임을 실행할 수 있도록 했습니다.

---
</div>
</details>


<details>
<summary>💻 Rule</summary>
<div>


```java
private int startNumber; //로또 숫자 범위의 첫번째 수
private int endNumber; //로또 번호 범위의 마지막 수
private int numberSize; //로또 번호의 개수
```

인스턴스 변수로 로또 숫자 범위의 첫번째 수, 로또 숫자 범위의 마지막 수, 로또 번호의 개수를 갖습니다.

```java
public Rule(int startNumber, int endNumber, int numberSize) {
    this.startNumber = startNumber;
    this.endNumber = endNumber;
    this.numberSize = numberSize;
}

public int getStartNumber() {
	return startNumber;
}

public int getEndNumber() {
	return endNumber;
}

public int getNumberSize() {
	return numberSize;
}

```
위와 같이 생성자와 각 인스턴스 변수에 대한 getter가 존재합니다.

---
</div>
</details>

<details>
<summary> 💻 Constant</summary>
<div markdown="1">


```java
public enum Rule {
	START_NUMBER(1), //로또 숫자 범위의 첫번째 수
	END_NUMBER(45), //로또 숫자 범위의 마지막 수
	NUMBER_SIZE(6), //로또 번호의 개수
	LOTTO_PRICE(1000), //로또의 가격
	WINNING_RANGE(5), //몇 등까지 수상할지 
	AMOUNT_OF_MONEY_1st(200000000), //1등 당첨 금액
	AMOUNT_OF_MONEY_2nd(3000000), //2등 당첨 금액
	AMOUNT_OF_MONEY_3rd(1500000), //3등 당첨 금액
	AMOUNT_OF_MONEY_4th(50000), //4등 당첨 금액
	AMOUNT_OF_MONEY_5th(5000), //5등 당첨 금액
	MATCH_COUNT_1st(6), // 1등 당첨 시 일치해야 하는 번호 개수
	MATCH_COUNT_2nd(5), // 2등 당첨 시 일치해야 하는 번호 개수
	MATCH_COUNT_3rd(5), // 3등 당첨 시 일치해야 하는 번호 개수
	MATCH_COUNT_4th(4), // 4등 당첨 시 일치해야 하는 번호 개수
	MATCH_COUNT_5th(3), // 5등 당첨 시 일치해야 하는 번호 개수
	ZERO(0),
	ONE(1),
	HUNDRED(100);

	private final int number;

	Rule(int number) {
		this.number = number;
	}

	public int get() {
		return number;
	}
}
```

게임 룰 정의에 필요한 정수들을 저장한 Enum입니다.

<br>
<br>
<br>

```java
public enum RequestMessage {
	REQUEST_INPUT_PURCHASE_MONEY("구입금액을 입력해 주세요."),
	REQUEST_INPUT_WINNING_LOTTO("\n당첨 번호를 입력해 주세요."),
	REQUEST_INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.");
	private final String requestMessage;

	RequestMessage(String message) {
		this.requestMessage = message;
	}

	@Override
	public String toString() {
		return requestMessage;
	}
}
```

사용자에게 입력을 요청하는 메시지들을 저장한 Enum입니다.
<br>
<br>
<br>

```java
public enum ResponseMessage {
    LOTTO_COUNT_MESSAGE("\n%d개를 구매했습니다."),
    WINNING_STATISTICS_MESSAGE("\n당첨 통계\n---"),
    MATCH_MESSAGE("%d개 일치 (%s원) - %d개"),
    MATCH_MESSAGE_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    RATE_OF_RETURN_MESSAGE("총 수익률은 %.1f%%입니다.");
    private final String responseMessage;

    ResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getMessage(int lottoCount) {
        return String.format(responseMessage, lottoCount);
    }

    public String getMessage(double rateOfReturn) {
        return String.format(responseMessage, rateOfReturn);
    }

    public String getMatchMessage(int lottoCount, String price, int matchCount) {
        return String.format(responseMessage, lottoCount, price, matchCount);
    }
}
```

사용자에게 출력할 응답 메시지들을 저장한 Enum입니다.

필요에 따라 getMessage() 메서드를 오버로딩했습니다.
<br>
<br>
<br>

```java
public enum ErrorMessage {
    ONLY_NUMBER_MESSAGE("숫자만 입력해 주세요."),
    INVALID_PRICE_MESSAGE("로또 가격 단위로 로또를 구매할 수 없습니다."),
    INVALID_FORMAT_MESSAGE("올바른 형식으로 입력해 주세요."),
    INVALID_NUMBER_COUNT_MESSAGE("올바른 개수의 번호를 입력해 주세요"),
    INVALID_RANGE_MESSAGE("올바른 범위의 번호를 입력해 주세요");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String get() {
        return "[ERROR] " + errorMessage;
    }
}

```

사용자가 잘못된 값을 입력했을 때 출력할 에러 메시지들을 저장한 Enum입니다.

get() 메서드는 "[ERROR]"과 에러 메시지를 합쳐서 반환합니다.
<br>
<br>
<br>

```java
public enum Format {
    DELIMITER(", "),
    PREFIX("["),
    SUFFIX("]"),
    REGEX(","),
    DECIMAL_PATTERN("#,###");
    private final String format;

    Format(String format) {
        this.format = format;
    }

    public String get() {
        return format;
    }
}

```
로또 게임을 진행하는 메서드 내에서 필요한 형식들을 저장한 Enum입니다.

---
<br>
<br>
<br>

</div>
</details>

<details>
<summary>💻 Score</summary>
<div markdown="1">

```java
int winFirstPlace; //1등 당첨 횟수
int winSecondPlace; //2등 당첨 횟수
int winThirdPlace; //3등 당첨 횟수
int winFourthPlace; //4등 당첨 횟수
int winFifthPlace; //5등 당첨 횟수
```
Rule 클래스의 인스턴스 변수입니다.
<br>
<br>

```java
public Score() {
    this.winFirstPlace = ZERO.get();
    this.winSecondPlace = ZERO.get();
    this.winThirdPlace = ZERO.get();
    this.winFourthPlace = ZERO.get();
    this.winFifthPlace = ZERO.get();
}
```
생성자에서 모든 인스턴스 변수들을 0으로 초기화합니다.
<br>
<br>

```java
public void increaseScore(int matchCount, boolean isBonusNumberMatch) {
    if (matchCount == MATCH_COUNT_1st.get()) {
        winFirstPlace++;
    }
    if (matchCount == MATCH_COUNT_2nd.get() && isBonusNumberMatch) {
        winSecondPlace++;
    }
    if (matchCount == MATCH_COUNT_3rd.get()) {
        winThirdPlace++;
    }
    if (matchCount == MATCH_COUNT_4th.get()) {
        winFourthPlace++;
    }
    if (matchCount == MATCH_COUNT_5th.get()) {
        winFifthPlace++;
    }
}
```
당첨 로또와 일치하는 번호 개수 및 보너스 번호가 일치하는지에 따라 당첨 횟수를 증가시킵니다.
<br>
<br>

```java
public List<Integer> getScoresAsList() {
    return Arrays.asList(winFirstPlace, winSecondPlace, winThirdPlace, winFourthPlace, winFifthPlace);
}
```
등수별 당첨 횟수를 리스트 형태로 반환합니다.

<br>
<br>

```java
public int getWinFirstPlace() {
    return winFirstPlace;
}

public int getWinSecondPlace() {
    return winSecondPlace;
}

public int getWinThirdPlace() {
    return winThirdPlace;
}

public int getWinFourthPlace() {
    return winFourthPlace;
}

public int getWinFifthPlace() {
    return winFifthPlace;
}
```
등수별 당첨 횟수에 대한 getter입니다.

---
</div>
</details>

<details>
<summary>💻 Lotto</summary>
<div markdown="1">

```java
private final List<Integer> numbers;
```
로또의 인스턴스 변수입니다.

로또 번호들을 리스트 형태로 저장합니다.
<br>
<br>
```java
public Lotto(Rule lottoGameRule) {
    int startNumber = lottoGameRule.getStartNumber();
    int endNumber = lottoGameRule.getEndNumber();
    int numberSize = lottoGameRule.getNumberSize();
    numbers = Randoms.pickUniqueNumbersInRange(startNumber, endNumber, numberSize);
}

public Lotto(List<Integer> winningNumbers) {
    this.numbers = winningNumbers;
}

public Lotto() {
    numbers = new ArrayList<>();
}
```
로또 클래스의 생성자들입니다.

1. 매개변수로 Rule을 받아 Rule에 맞게 로또 생성
2. 당첨 로또 번호들을 리스트로 받아 당첨 로또를 생성
3. 기본 생성자
   <br>
   <br>

```java
@Override
public String toString() {
    return numbers.stream()
        .sorted()
        .map(Object::toString)
        .collect(Collectors.joining(Format.DELIMITER.get(), Format.PREFIX.get(), Format.SUFFIX.get()));
}
```
toString() 메서드를 오버라이드하여, 형식에 맞게 출력합니다.
<br>
<br>

```java
public List<Integer> getNumbers() {
    return numbers;
}
```
로또 번호 리스트를 반환합니다.
<br>
<br>

```java
public int countMatchingNumbers(Lotto winningLotto) {
    List<Integer> winningNumbers = winningLotto.getNumbers();

    return (int)numbers.stream()
        .filter(winningNumbers::contains)
        .count();
}
```
발행된 로또와 당첨 로또를 비교하여 일치하는 번호의 개수를 반환합니다.

---
</div>
</details>




<details>
<summary>💻 LottoGame</summary>
<div markdown="1">


```java
public class LottoGame implements NumberGame
```
LottoGame 클래스는 NumberGame 인터페이스를 구현합니다.
<br>
<br>

```java
private int purchaseMoney; //로또 구매 금액
private int lottoCount; //발행된 로또 개수
private List<Lotto> lottoList; //발행된 로또를 저장하는 리스트
private Rule lottoGameRule; //로또 게임 룰
private Lotto winningLotto; //우승 로또
private int bonusNumber; //보너스 번호
private LottoGameAnalyzer lottoGameAnalyzer; //로또 게임 분석기
private Validator validator; //사용자 입력 유효성 검증기
private View view; // 화면 출력기
```
로또 게임 클래스의 인스턴스 변수들입니다.
<br>
<br>


```java
public LottoGame(Rule lottoGameRule) {
    this.lottoGameRule = lottoGameRule;

    purchaseMoney = ZERO.get();
    lottoCount = ZERO.get();
    bonusNumber = ZERO.get();

    lottoList = new ArrayList<>();
    winningLotto = new Lotto();
    lottoGameAnalyzer = new LottoGameAnalyzer();
    validator = new Validator();
    view = new View();
}
```
생성자에서는 Rule을 넘겨 받고 인스턴스 변수들을 초기화합니다.
<br>
<br>

```java
@Override
public void play() {
    try {
        inputPurchaseMoney();
        calculateLottoCount();
        issueLotto();
        view.printIssuedLottoList(lottoCount, lottoList);
        inputWinningLotto();
        inputBonusNumber();
        lottoGameAnalyzer.analyze(winningLotto, bonusNumber, lottoList, purchaseMoney);
    } catch (IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }
}
```
NumberGame 인터페이스의 play() 메서드를 오바라이딩합니다.

게임의 흐름은 다음과 같습니다.
1. 로또 구매 금액 입력
2. 발행할 로또 개수 계산
3. 로또 발행
4. 발행된 로또 출력
5. 당첨 로또 입력
6. 보너스 번호 입력
7. 당첨 통계 출력
8. 수익률 출력

만약 이 과정에서 IllegalArgumentException이 발생한다면 예외 메시지를 출력하고 프로그램을 종료합니다.

<br>
<br>

```java
private void inputPurchaseMoney() {
    view.printRequestPurchaseMoney();
    String input = Console.readLine();
    validator.validatePurchaseMoney(input);
    purchaseMoney = Integer.parseInt(input);
}
```
로또 구입 금액을 입력 받는 메서드입니다.

메서드의 실행 순서는 다음과 같습니다.
1. 사용자에게 입력 요청 메시지 출력
2. 사용자에게 입력 받기
3. 사용자의 입력에 대한 유효성 검사
4. 문자열 형태의 입력을 정수로 변환하여 로또 구입 금액에 저장
<br>
<br>

```java
private void calculateLottoCount() {
    lottoCount = purchaseMoney / LOTTO_PRICE.get();
}
```
발행할 로또 개수를 계산합니다.

로또 구매 금액을 로또의 가격으로 나눕니다.
<br>
<br>

```java
private void issueLotto() {
    for (int iterator = ZERO.get(); iterator < lottoCount; iterator++) {
        lottoList.add(new Lotto(lottoGameRule));
    }
}
```
발행할 로또의 개수만큼 반복문을 통해 로또 리스트에 새로운 로또를 추가합니다.
<br>
<br>

```java
private void inputWinningLotto() {
    view.printRequestWinningLotto();
    String input = Console.readLine();
    validator.validateWinningLotto(input);

    List<Integer> winningNumbers = Arrays.stream(input.split(Format.REGEX.get()))
        .map(Integer::parseInt)
        .collect(Collectors.toList());

    winningLotto = new Lotto(winningNumbers);
}
```
우승 로또를 입력 받는 메서드입니다.

메서드의 실행 순서는 다음과 같습니다.
1. 사용자에게 입력 요청 메시지 출력
2. 사용자에게 입력 받기
3. 사용자의 입력에 대한 유효성 검사
4. 문자열 형태의 입력을 스트림과 람다식을 통해 정수형 리스트 형태로 변환
5. 변환된 리스트를 로또 클래스 생성자의 매개변수로 넘겨 우승 로또 생성 


<br>
<br>

```java
private void inputBonusNumber() {
    view.printRequestBonusNumber();
    String input = Console.readLine();
    validator.validateBonusNumber(input);
    bonusNumber = Integer.parseInt(input);
}
```
보너스 번호를 입력 받는 메서드입니다.

메서드의 실행 순서는 다음과 같습니다.
1. 사용자에게 입력 요청 메시지 출력
2. 사용자에게 입력 받기
3. 사용자의 입력에 대한 유효성 검사
4. 문자열 형태의 입력을 정수로 변환하여 보너스 번호에 저장

---


</div>
</details>


<details>
<summary>💻 LottoGameAnalyzer</summary>
<div markdown="1">

```java
private View view; //화면 출력기

public LottoGameAnalyzer() {
    view = new View();
}
```
로또 게임 분석기의 인스턴스 변수와 생성자입니다.
<br>
<br>

```java
public void analyze(Lotto winningLotto, int bonusNumber, List<Lotto> lottoList, int purchaseMoney) {
   Score score = calculateScore(winningLotto, bonusNumber, lottoList);
   double rateOfReturn = calculateReteOfReturn(purchaseMoney, score);
   view.printWinningStatistics(score);
   view.printRateOfReturn(rateOfReturn);
}
```
로또 게임의 결과를 분석하는 메서드입니다.
분석의 흐름은 다음과 같습니다.
1. 스코어 계산하기
2. 수익룰 계산하기
3. 당첨 통계 출력하기
4. 수익률 출력하기

굳이 분석기에서 View를 사용해야 할까? 라는 생각에 3, 4번은 Lotto 클래스의 play() 메서드로 옮기고 싶은데 그렇게 하려면 analyze() 메서드가 스코어와 수익률을 반환해야 합니다.

그래서 Score 클래스에 rateOfReturn 인스턴스 변수를 추가할까 고민 중입니다.

이에 대해서 답변해주시면 감사하겠습니다!
<br>
<br>


```java
private Score calculateScore(Lotto winningLotto, int bonusNumber, List<Lotto> lottoList) {
     Score score = new Score();

     for (Lotto lotto : lottoList) {
         int matchCount = lotto.countMatchingNumbers(winningLotto);
         boolean isBonusNumberMath = lotto.getNumbers().contains(bonusNumber);
         score.increaseScore(matchCount, isBonusNumberMath);
     }

     return score;
 }
```
스코어를 계산하는 메서드입니다.

로또 리스트를 순회하며 당첨 로또와 일치하는 번호의 개수 및 보너스 번호 일치 여부를 계산하고,
그 결과에 따라 스코어를 증가시킵니다.

계산된 스코어를 반환합니다.

<br>
<br>


```java
private double calculateReteOfReturn(int purchaseMoney, Score score) {
     List<Integer> prizeList = Arrays.asList(AMOUNT_OF_MONEY_1st.get(), AMOUNT_OF_MONEY_2nd.get(),
         AMOUNT_OF_MONEY_3rd.get(), AMOUNT_OF_MONEY_4th.get(), AMOUNT_OF_MONEY_5th.get());
     List<Integer> scoreList = score.getScoresAsList();
     long totalWonMoney = ZERO.get();

     for (int iterator = ZERO.get(); iterator < WINNING_RANGE.get(); iterator++) {
         totalWonMoney += scoreList.get(iterator) * prizeList.get(iterator);
     }

     double rateOfReturn = ((double)totalWonMoney / (double)purchaseMoney) * HUNDRED.get();

     return rateOfReturn;
 }
```
1등 당첨 금액부터 5등 당첨 금액까지 순서대로 리스트에 저장합니다.

스코어의 등수별 당첨 횟수를 리스트 형태로 저장합니다.

상금의 총합을 0으로 초기화합니다.

반복문을 순회하며 (각 등수별 당첨 금액 * 각 등수별 당첨 횟수) 값을 상금의 총합에 더합니다.

(상금의 총합 * 로또 구매 금액) * 100을 통해 수익률을 계산합니다.

수익률을 반환합니다.

---

</div>
</details>

<details>
<summary>💻 Validator</summary>
<div markdown="1">

```java
public void validatePurchaseMoney(String input) {
  for (char digit : input.toCharArray()) {
      if (!Character.isDigit(digit)) {
          throw new IllegalArgumentException(ONLY_NUMBER_MESSAGE.get());
      }
  }

  int purchaseMoney = Integer.parseInt(input);

  if (purchaseMoney < LOTTO_PRICE.get()) {
      throw new IllegalArgumentException(INVALID_PRICE_MESSAGE.get());
  }

  if (purchaseMoney % LOTTO_PRICE.get() != ZERO.get()) {
      throw new IllegalArgumentException(INVALID_PRICE_MESSAGE.get());
  }
}
```
사용자가 입력한 로또 구매 금액의 유효성을 검사합니다.

1. 입력 문자열이 숫자로만 이루어져 있는지 검사합니다.
2. 구매 금액이 로또의 가격보다 작은지 검사합니다.
3. 거스름돈이 존재하는지 검사합니다.

만약 1, 2, 3 중 하나의 검사라도 통과하지 못하면 에러 메시지와 함께 IllegalArgumentException을 발생시킵니다.
<br>
<br>

```java
public void validateWinningLotto(String input) {
     List<Integer> winningNumbers = new ArrayList<>();
     try {
         winningNumbers = Arrays.stream(input.split(Format.REGEX.get()))
             .map(Integer::parseInt)
             .collect(Collectors.toList());
     } catch (Exception e) {
         throw new IllegalArgumentException(INVALID_FORMAT_MESSAGE.get());
     }

     if (winningNumbers.size() != NUMBER_SIZE.get()) {
         throw new IllegalArgumentException(INVALID_NUMBER_COUNT_MESSAGE.get());
     }

     for (int number : winningNumbers) {
         if (number < START_NUMBER.get() || number > END_NUMBER.get()) {
             throw new IllegalArgumentException(INVALID_RANGE_MESSAGE.get());
         }
     }
 }
```
숫자,숫자,...,숫자의 형태로 입력 받은 우승 로또 번호들의 유효성을 검사합니다.

1. ","로 분리한 문자들을 정수로 변환하고 정수형 리스트에 저장하는 과정을 try/catch문으로 검사합니다.
2. 정수형으로 변환한 우승 로또 번호들을 저장하는 리스트의 크기가 6인지 확인합니다.
3. 우승 로또 번호들이 올바른 범위 내의 숫자로 구성되어 있는지 확인합니다.

만약 1, 2, 3 중 하나의 검사라도 통과하지 못하면 에러 메시지와 함께 IllegalArgumentException을 발생시킵니다.
<br>
<br>


```java
public void validateBonusNumber(String input) {
     try {
         Integer.parseInt(input);
     } catch (NumberFormatException e) {
         throw new IllegalArgumentException(ONLY_NUMBER_MESSAGE.get());
     }

     int bonusNumber = Integer.parseInt(input);
     if (bonusNumber < START_NUMBER.get() || bonusNumber > END_NUMBER.get()) {
         throw new IllegalArgumentException(INVALID_RANGE_MESSAGE.get());
     }
 }
```
보너스 번호의 유효성을 검사합니다.

1. 문자열 형태의 입력이 정수형으로 변환 가능한지 검사합니다.
2. 보너스 번호가 올바른 범위 내의 숫자인지 확인합니다.

만약 1, 2, 3 중 하나의 검사라도 통과하지 못하면 에러 메시지와 함께 IllegalArgumentException을 발생시킵니다.
<br>
<br>

</div>
</details>

<details>
<summary>💻 View</summary>
<div markdown="1">

```java
public void printRequestPurchaseMoney() {
     System.out.println(RequestMessage.REQUEST_INPUT_PURCHASE_MONEY);
 }
```
사용자에게 구매 금액 입력 요청 메시지를 출력합니다.
<br>
<br>


```java
public void printIssuedLottoList(int lottoCount, List<Lotto> lottoList) {
     System.out.println(ResponseMessage.LOTTO_COUNT_MESSAGE.getMessage(lottoCount));

     for (Lotto lotto : lottoList) {
         System.out.println(lotto);
     }
 }
```
사용자에게 발행된 로또 개수를 출력합니다.

발행된 로또들을 출력합니다.
<br>
<br>

```java
public void printRequestWinningLotto() {
     System.out.println(RequestMessage.REQUEST_INPUT_WINNING_LOTTO);
 }
```
사용자에게 우승 로또 번호 입력 요청 메시지를 출력합니다.
<br>
<br>

```java
 public void printRequestBonusNumber() {
     System.out.println(RequestMessage.REQUEST_INPUT_BONUS_NUMBER);
 }
```
사용자에게 보너스 번호 입력 요청 메시지를 출력합니다.
<br>
<br>

```java
public void printWinningStatistics(Score score) {
     System.out.println(ResponseMessage.WINNING_STATISTICS_MESSAGE);

     System.out.println(ResponseMessage.MATCH_MESSAGE.getMatchMessage(MATCH_COUNT_5th.get(),
         formatNumber(AMOUNT_OF_MONEY_5th.get()), score.getWinFifthPlace()));

     System.out.println(ResponseMessage.MATCH_MESSAGE.getMatchMessage(MATCH_COUNT_4th.get(),
         formatNumber(AMOUNT_OF_MONEY_4th.get()), score.getWinFourthPlace()));

     System.out.println(ResponseMessage.MATCH_MESSAGE.getMatchMessage(MATCH_COUNT_3rd.get(),
         formatNumber(AMOUNT_OF_MONEY_3rd.get()), score.getWinThirdPlace()));

     System.out.println(ResponseMessage.MATCH_MESSAGE_WITH_BONUS.getMatchMessage(MATCH_COUNT_2nd.get(),
         formatNumber(AMOUNT_OF_MONEY_2nd.get()), score.getWinSecondPlace()));

     System.out.println(ResponseMessage.MATCH_MESSAGE.getMatchMessage(MATCH_COUNT_1st.get(),
         formatNumber(AMOUNT_OF_MONEY_1st.get()), score.getWinFirstPlace()));
 }
```
사용자에게 당첨 통계를 출력합니다.

이 부분은.. 최대한 변화에 쉽게 대처할 수 있도록 코드를 작성한다고 한건데.. 가독성이 최악입니다..
어떻게 해결해야 할지 조언해주시면 감사하겠습니다!
<br>
<br>


```java
public String formatNumber(int amountOfMoney) {
     DecimalFormat decimalFormat = new DecimalFormat(Format.DECIMAL_PATTERN.get());
     String formattedNumber = decimalFormat.format(amountOfMoney);
     return formattedNumber;
 }
```
당첨 금액을 형식에 따라 천원 단위로 ","를 추가하고 반환합니다.
<br>
<br>


```java
public void printRateOfReturn(double rateOfReturn) {
     System.out.println(ResponseMessage.RATE_OF_RETURN_MESSAGE.getMessage(rateOfReturn));
 }
```
사용자에게 수익률 메시지를 출력합니다.

---
</div>
</details>
