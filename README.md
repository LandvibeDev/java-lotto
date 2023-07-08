# Lotto

1. Lotto 샘플을 복사해온다.
2. 우승 복권과 비교하여 몇개의 숫자가 맞았는지 확인하는 로직을 만든다.
3. 보너스가 일치하는지를 확인하는 로직을 만든다.
4. Lotto의 값을 출력하는 로직을 구현.

# WinningLotto

1. 우승 복권의 정보를 저장한다.
2. 여기엔 Lotto의 객체와, bonus 정보를 저장한다.

# ENUM 

1. Lotto에 대한 상수값들을 정의하는 class RandomRange 생성
2. 상금에 대한 상수값들을 정의하는 class Prize 생성

# CheckException

1. winningLotto를 입력받을때, 잘못 받는지 확인하기위한 인터페이스

# CheckExceptionImpl

1. CheckException인터페이스를 구현한 클래스

# BuyMoney

1. 구매 금액을 입력받고, 형식을 검증한다.
2. 금액이 입력되면 금액으로 몇장을 구매했는지 출력한다.

# InputWinningLotto

1. 우승 로또를 입력받는다.
2. CheckException으로 오류를 확인한다.

# Rank

1. lotto와 win lotto를 전달받아서 몇개가 match인지, bonus가 맞았는지를 확인한다.

## rankValue()

1. 1~5등까지 해당하는 횟수를 증가시킨다.

# EarnMoney

## addMoney()

1. 당첨된 금액만큼 현재 소지금을 증가시킨다.

# PrintCorrectCount

## print()

1. 각각의 등수별로 몇회 당첨되었는지 출력한다.
2. 총 수익률을 출력한다.

# Game, LottoGame
1. Game은 단순한 인터페이스
2. LottoGame 에 Game을 구현
3. LottoGame에서 게임 로직 진행.



