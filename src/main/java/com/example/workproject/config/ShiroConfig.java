package com.example.workproject.config;

import com.example.workproject.Filter.redirectFilter;
import com.example.workproject.config.ShiroRealm.IndexRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.*;

@Configuration
public class ShiroConfig {
    //1. 创建Realm
    @Bean
    public IndexRealm indexRealm(){
        return new IndexRealm();
    }

    //2. DefaultWebSecurityManager
    @Bean(name = "WebSecurityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("indexRealm") IndexRealm indexRealm){ //注解中的是方法名
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(indexRealm);

        //设置Cookie
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.getCookie().setMaxAge(86400);
        cookieRememberMeManager.getCookie().setHttpOnly(false);
        securityManager.setRememberMeManager(cookieRememberMeManager);
        return securityManager;
    }

    //3. ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("WebSecurityManager") DefaultWebSecurityManager WebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(WebSecurityManager);
        bean.setLoginUrl("/page/login");
        bean.setUnauthorizedUrl("/unauth");
//        bean.setSuccessUrl("/");
        //添加shiro内置过滤器
        /**
         * anon     无需认证即可访问
         * authc    认证后才可访问
         * user     拥有remember me功能才可访问
         * perms    拥有对某个资源的权限才能访问
         * role     拥有某个角色权限才可访问
         * **/
        //拦截
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/page/*", "user");
        filterMap.put("/index1", "perms[1]");
        filterMap.put("/index2", "perms[2]");
        filterMap.put("/index3", "perms[3]");
        bean.setFilterChainDefinitionMap(filterMap);
        Map<String, Filter> filters = new LinkedHashMap<>();
        filters.put("redirectFilter", new redirectFilter());
        bean.setFilters(filters);
        return bean;
    }
}
