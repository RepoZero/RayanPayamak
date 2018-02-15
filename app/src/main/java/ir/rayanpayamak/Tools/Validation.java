package ir.rayanpayamak.Tools;

import java.util.regex.Pattern;

public class Validation {

    public boolean ValidPhoneNumber(String PhoneNumber) {
//        String PN = PhoneNumber;
//        switch (PN.charAt(0)) {
//            case '+':
//                PN = PN.substring(1);
//                break;
//            case '0':
//                PN = PN.substring(1);
//                PN = "98" + PN;
//                break;
//            default:
//                if (!PN.matches("^98.*")) PN = "98" + PN;
//                break;
//        }
//
//        if (PN.length() > 7 && PN.length() < 15) return true;
//        return false;

        return Pattern.compile("(0|\\+98)?([ ]|-|[()]){0,2}9[1|2|3|4]([ ]|-|[()]){0,2}(?:[0-9]([ ]|-|[()]){0,2}){8}").matcher(PhoneNumber).matches();


    }







        public Boolean isValidationNationalCode(String meli_code) {

        if (meli_code.length() == 10) {
            if (meli_code == "1111111111" || meli_code == "0000000000" || meli_code == "2222222222" || meli_code == "3333333333" || meli_code == "4444444444" || meli_code == "5555555555" || meli_code == "6666666666" || meli_code == "7777777777" || meli_code == "8888888888" || meli_code == "9999999999") {
                return false;
            }
           int c = Integer.parseInt(String.valueOf(meli_code.charAt(9)));
            int n = Integer.parseInt(String.valueOf(meli_code.charAt(0))) * 10 + Integer.parseInt(String.valueOf(meli_code.charAt(1))) * 9 + Integer.parseInt(String.valueOf(meli_code.charAt(2))) * 8 + Integer.parseInt(String.valueOf(meli_code.charAt(3))) * 7 + Integer.parseInt(String.valueOf(meli_code.charAt(4))) * 6 + Integer.parseInt(String.valueOf(meli_code.charAt(5))) * 5 + Integer.parseInt(String.valueOf(meli_code.charAt(6))) * 4 + Integer.parseInt(String.valueOf(meli_code.charAt(7))) * 3 + Integer.parseInt(String.valueOf(meli_code.charAt(8))) * 2;
            int r = n - Integer.parseInt(String.valueOf(n / 11)) * 11;
            if ((r == 0 && r == c) || (r == 1 && c == 1) || (r > 1 && c == 11 - r)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }



    }
