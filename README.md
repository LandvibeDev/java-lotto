# 💰로또 과제 제출 💵

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
<summary>💻 NumberGame</summary>
<div markdown="1">

### NumberGame

```java
public interface NumberGame {
	void play();
}
```

숫자 게임 인터페이스입니다.
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
<br>
<br>
<br>

</div>
</details>