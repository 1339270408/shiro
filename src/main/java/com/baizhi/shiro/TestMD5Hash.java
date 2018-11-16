package com.baizhi.one;

import org.apache.shiro.crypto.hash.Md5Hash;

public class TestMD5Hash {
    public static void main(String[] args) {

        //md5     e10adc3949ba59abbe56e057f20f883e
        //salt    71e412acc9c83e7971338ffe80e7313e
        //散列     3d53b73c485f523ef2fe45f2b8dd3c58

        //参数1 原始密码   参数2 salt 盐值   参数 3  散列次数

        Md5Hash md5Hash=new Md5Hash("123456","ABCD",1024);
        String s = md5Hash.toHex();
        System.out.println(s);
    }
}
