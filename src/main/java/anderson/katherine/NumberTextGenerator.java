package anderson.katherine;

import java.util.ArrayList;

public class NumberTextGenerator {

    public String numberToText(String input) {
        ArrayList<Integer> digits = createDigits(input);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = digits.size() - 1; i >= 0; i--) {
            if(i > 0 && (i - 1) % 3 == 0 && digits.get(i) == 1) {
                stringBuilder.append(digitToText(digits.get(i - 1) + 10, i - 1, digits.size() - 1 - i));
                i--;
            }
            else {
                stringBuilder.append(digitToText(digits.get(i), i, digits.size() - 1 - i));
            }
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public ArrayList<Integer> createDigits(String input) {
        ArrayList<Integer> digits = new ArrayList<>();
        Integer number = Integer.parseInt(input);

        while(number > 0) {
            int remainder = number % 10;
            digits.add(remainder);
            number -= remainder;
            number /= 10;
        }

        return digits;
    }

    public String digitToText(int digit, int index, int indexFromEnd) {
        if(digit > 0 || index == 0 || indexFromEnd < 3) {
            if (index % 3 == 0) {
                return ones[digit] + powers[index / 3 + 1];
            } else if (index % 3 == 1) {
                return tens[digit];
            } else {
                return ones[digit] + powers[0];
            }
        }
        else {
            return "";
        }
    }

    String[] ones = {
            "",
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten",
            "Eleven",
            "Twelve",
            "Thirteen",
            "Fourteen",
            "Fifteen",
            "Sixteen",
            "Seventeen",
            "Eighteen",
            "Nineteen"
    };

    String[] tens = {
            "",
            "Ten",
            "Twenty",
            "Thirty",
            "Forty",
            "Fifty",
            "Sixty",
            "Seventy",
            "Eighty",
            "Ninety"
    };

    String[] powers = {
            "Hundred",
            "Dollars",
            "Thousand",
            "Million"
    };
}
