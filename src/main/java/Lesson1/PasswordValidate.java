package Lesson1;

import java.util.regex.Pattern;

public class PasswordValidate {
    public boolean validate(String password) throws Exception {
        String strPwd = "(?=.*[a-z])(?=.*[A-Z]+)(?=.*[0-9]+)(?=.*[!@#$%^&*]+).{6,}$";
        Pattern passwordPattern = Pattern.compile(strPwd);
        return passwordPattern.matcher(password).find();
//        if(password.length() < 6) {
//            return false;
//        }
//        else
//        {
//            Pattern pwdlowerCasePattern = Pattern.compile("[a-z]+");
//            boolean hasLowerCase = pwdlowerCasePattern.matcher(password).find();
//
//            Pattern pwdupperCasePattern = Pattern.compile("[A-Z]+");
//            boolean hasUpperCaseCase = pwdupperCasePattern.matcher(password).find();
//
//            Pattern numberPattern = Pattern.compile("[0-9]+");
//            boolean hasNumber = numberPattern.matcher(password).find();
//
//            Pattern special = Pattern.compile("[!@#\\$%\\^\\&\\*\\(\\)]+");
//            boolean hasSpecial = special.matcher(password).find();
//            return hasLowerCase && hasUpperCaseCase && hasNumber && hasSpecial;
//        }
    }
}
