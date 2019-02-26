package cn.sxt.shiro._04userRealm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * 自定义realm 该realm类提供了2个方法 doGetAuthorizationInfo 获取认证信息 doGetAuthenticationInfo
 * 获取权限信息
 * 
 * @author yuanjinqiao
 *
 */
public class UserRealm extends AuthorizingRealm {
	@Override
	public String getName() {
		return super.getName();
	}
	/**
	 * 完成身份认证，返回身份信息如果身份认证失败返回null
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获取用户输入的用户名
		String username = (String)token.getPrincipal();
		System.out.println("username="+username);
		//根据用户名到数据库获取密码和盐----模拟
		String pwd = "96c0335dbdd59d920980f1c6a74ed1b0";
		String salt="sxt";
		//将数据库查询到的数据封装到SimpleAuthenticationInfo中
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(token.getPrincipal(), pwd, ByteSource.Util.bytes(salt),getName());
		return info;
	} 

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

}
