package lotto.checkexception;

public class CheckCharException {
    public void checkCharException(String input){
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) >= '0' && input.charAt(i) <= '9'){
                continue;
            }
            throw new IllegalArgumentException("[ERROR]숫자만 입력하세요.");
        }
    }
}
