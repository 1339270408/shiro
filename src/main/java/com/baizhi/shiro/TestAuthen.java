package com.baizhi.one;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
public class TestAuthen {
    public static void main(String[] args) {
        IniSecurityManagerFactory iniSecurityManagerFactory=new IniSecurityManagerFactory("classpath:shiro.ini");
        //创建安全管理器
        SecurityManager securityManager=iniSecurityManagerFactory.getInstance();
        //分配安全管理器到主体
        SecurityUtils.setSecurityManager(securityManager);
        //获取主体
        Subject subject=SecurityUtils.getSubject();
        //构建token
        AuthenticationToken authentication=new UsernamePasswordToken("zhangsan","123456");
        //用户拿着数据做认证
        try {
            subject.login(authentication);
        } catch (UnknownAccountException e){
            System.out.println("账号异常");
        }catch (IncorrectCredentialsException e){
            System.out.println("密码异常");
        }
        boolean authenticated = subject.isAuthenticated();
        System.out.println(authenticated);

    }
}
