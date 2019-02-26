package cn.sxt.shiro._05authorization;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class AuthorizationDemo {
	public static void main(String[] args) {
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:_05shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("zhang","1111");
		try {
			subject.login(token);
			if(subject.isAuthenticated()) {
				System.out.println("验证通过");
			}
		} catch (AuthenticationException e) {
			e.printStackTrace();
			System.out.println("验证失败");
		}
		//基于角色授权
		subject.hasRole("role2");
		//可以通过checkRole来判断是偶否权限，如果没有则抛出UnauthorizedException
		//subject.checkRole("role2");
		//基于资源的授权
		boolean flag = subject.isPermitted("user:add");
		//可以通过checkPermission来判断是否有权限，如果没有则抛出UnauthorizedException
		subject.checkPermission("user:aa");
		System.out.println(flag);
	}
}
