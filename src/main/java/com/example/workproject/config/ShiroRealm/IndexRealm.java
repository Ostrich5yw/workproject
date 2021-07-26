package com.example.workproject.config.ShiroRealm;

import com.example.workproject.entity.Mapper.MysqlMapper;
import com.example.workproject.entity.Mapper.OperatorMapper;
import com.example.workproject.entity.PoJo.operatorBean;
import com.example.workproject.entity.PoJo.userBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;


public class IndexRealm extends AuthorizingRealm {
    @Autowired
    private OperatorMapper operatorMapper;

    /** 授权 **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //认证时获取的登录对象，通过principal参数传给了授权方法，这里将其取出进行权限检验
        Subject subject = SecurityUtils.getSubject();
        operatorBean currentUser = (operatorBean)subject.getPrincipal();      //获取session中的用户
        //如果这个登录对象含有对应的权限（stu_authorization等于指定的权限字段值：即在ShiroConfig中定义的stu:2），则会通过权限认证
        authorizationInfo.addStringPermission(currentUser.getCzyjs());
        return authorizationInfo;
    }
    /** 认证
     * @return**/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException{
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        operatorBean currentUser = null;

        currentUser = operatorMapper.getOperator(token.getUsername());
        if(currentUser == null)
            return null;
        return new SimpleAuthenticationInfo(currentUser, currentUser.getCzykl(), "");
        //Shiro 只需要我们验证用户名，密码会由shiro下面代码自动认证
        //同时把bean加入principal，供授权操作拿取当前登录的对象
//        return new SimpleAuthenticationInfo(bean, bean.getStu_password(), "");
    }
}


