package anderson.katherine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class NumberTextGeneratorByThree {

    public String numberToText(String input) {
        ArrayList<String> groupsOfThree = groupByThree(input);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = groupsOfThree.size() - 1; i >= 0; i--) {
            stringBuilder.append(groupOfThreeToText(groupsOfThree.get(i), i));
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public ArrayList<String> groupByThree(String input) {
        ArrayList<String> groupsOfThree = new ArrayList<>();

        for(int i = input.length(); i > 0; i-=3) {
            if(i - 3 > 0) {
                groupsOfThree.add(input.substring(i - 3, i));
            }
            else {
                groupsOfThree.add(input.substring(0, i));
            }
        }
        return groupsOfThree;
    }

    public String groupOfThreeToText(String group, int index) {
        if("000".equals(group) && index != 0) {
            return "";
        }
        else {
            String textOutput = "";
            ArrayList<Integer> digits = new ArrayList<>();
            String[] textDigits = group.split("");
            for(int i = 0; i < textDigits.length; i++) {
                digits.add(Integer.parseInt(textDigits[i]));
            }
            int number = Integer.parseInt(group);
            if(group.length() == 1) {
                textOutput += ones[digits.get(0)] + powers[index + 1];
            }
            else if(group.length() == 2) {
                if(number >= 10 && number <= 19) {
                    textOutput += ones[number] + powers[index + 1];
                }
                else {
                    textOutput += tens[digits.get(0)] + ones[digits.get(1)] + powers[index + 1];
                }
            }
            else {
                int lastTwo = number - 100*digits.get(0);
                if(digits.get(0) != 0) {
                    textOutput += ones[digits.get(0)] + powers[0];
                }
                if(lastTwo >= 10 && lastTwo <= 19) {
                    textOutput += ones[lastTwo] + powers[index + 1];
                }
                else {
                    textOutput += tens[digits.get(1)] + ones[digits.get(2)] + powers[index + 1];
                }
            }
            return textOutput;
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
