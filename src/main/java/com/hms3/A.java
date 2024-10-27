package com.hms3;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class A {
    public static void main(String[] args) {
        String enPwd = BCrypt.hashpw("testing", BCrypt.gensalt(4));
        System.out.println(enPwd);
//        String str="$05$2h1mbyaW1I8S3PgbOVfdG.vSBc51AeTFc7EyNud54QVXEA9BHuk6K";
//        System.out.println(str.length());
    }
}
