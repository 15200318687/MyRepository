package cn.sxt.shiro._06userRealm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;


/**
 * 自定义realm 该realm类提供了2个方法 doGetAuthorizationInfo 获取认证信息 doGetAuthenticationInfo
 * 获取权限信息
 * 
 * @author yuanjinqiao111
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
		//根据用户名到数据库获取密码和盐----模拟
		String pwd = "1111";
		//将数据库查询到的数据封装到SimpleAuthenticationInfo中
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(token.getPrincipal(), pwd,getName());
		return info;
	} 
	//授权信息
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = principals.getPrimaryPrincipal().toString();
		//根据用户名到数据库查询对应的权限--模拟
		List<String> permissions = new ArrayList<String>();
		permissions.add("user:add");
		permissions.add("user:update");
		permissions.add("user:delete");
		permissions.add("user:find");
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		for (String permission : permissions) {
			info.addStringPermission(permission);
		}
		return info;
	}

}
