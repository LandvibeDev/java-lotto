package lotto;

import java.text.DecimalFormat;

public class Number {
    public enum Rule {
        MIN(1),
        MAX(45),
        SIZE(6),
        PRICE(1000);

        private final int rule;

        Rule(int number) {
            this.rule = number;
        }

        public int toNumber() {
            return rule;
       }
    }

    public enum Prize {
        THREE_MATCH(5000),
        FOUR_MATCH(50000),
        FIVE_MATCH(1500000),
        FIVE_BONUS_MATCH(30000000),
        SIX_MATCH(2000000000);

        private final int prize;

        Prize(int number) {
            this.prize = number;
        }

        public int toNumber() {
            return prize;
        }

        public String toDecimalFormat() {
            DecimalFormat decimalFormat = new DecimalFormat("#,###");
            String formattedNumber = decimalFormat.format(prize);
            return formattedNumber;
        }
    }
}