package by.bntu.fitr.util;

import by.bntu.fitr.constant.Constant;
import by.bntu.fitr.entity.User;

public class AuthenticationUtil {

    public static boolean isValidSignIn(String password, User user) {
        return user == null ? false : (user.getPassword().equals(password) && user.getEnabled() == Constant.ACTIVE)
                ? true : false;
    }

    public static boolean isValidSignUp(User user) {
        return user.getPassword().equals(user.getRepeatPassword());
    }
}

