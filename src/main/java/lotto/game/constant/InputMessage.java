package lotto.game.constant;

public enum InputMessage {

    INPUT_PURCHASE_PRICE("구입 금액을 입력해 주세요."),
    INPUT_NUMBERS("당첨 번호를 입력해 주세요"),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요");

    private final String string;

    InputMessage(String string){
        this.string = string;
    }

    public String getString(){
        return string;
    }
}
