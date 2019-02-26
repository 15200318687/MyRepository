package cn.sxt.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
/**
 * 完成认证功能
 * @author yuanjinqiao
 *
 */
public class AuthenticationDemo {
	public static void main(String[] args) {
		//1.创建SecurityManager工厂
		//1.创建SecurityManager工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		//2.通过SecurityManager工厂获取实例
		SecurityManager instance = factory.getInstance();
		//3.将SecurityManager设置到运行环境中
		SecurityUtils.setSecurityManager(instance);
		//4.通过SecurityManagerUtils获取主体Subject
		Subject subject = SecurityUtils.getSubject();
			//5.假定登陆时输入的用户名和密码是张三，1111
			UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
			//6.进行身份认证
			try {
				subject.login(token);
				if(subject.isAuthenticated()) {
					System.out.println("登陆成功");}
			} catch (AuthenticationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	
		
	}
}
