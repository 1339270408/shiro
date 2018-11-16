package com.baizhi.one;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

public class MyRealm extends AuthenticatingRealm {
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String)authenticationToken.getPrincipal();
        //通过UserName查询数据库
       if (username.equals("zhangsan")){
           AuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo("zhangsan","3d53b73c485f523ef2fe45f2b8dd3c58",ByteSource.Util.bytes("ABCD"),this.getName());
           return authenticationInfo;
       }
        return null;
    }
}
