package vip.huhailong.shirobyjwt.config.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.mgt.*;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/17.
 */
@Configuration
public class ShiroConfig {

//    @Bean
//    public CustomRealmA realmA(){
//        CustomRealmA customRealmA = new CustomRealmA();
//        customRealmA.setCredentialsMatcher(hashedCredentialsMatcher());
//        return customRealmA;
//    }

    @Bean
    public CustomRealmB realmB(){
        return new CustomRealmB();
    }

    @Bean
    public CacheManager cacheManager(){
        return new MemoryConstrainedCacheManager();
    }

    @Bean("securityManager")
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realmB());
        //关闭session
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator sessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        sessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(sessionStorageEvaluator);
        manager.setSubjectDAO(subjectDAO);
        return manager;
    }

    @Bean
    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        return cookieRememberMeManager;
    }

    @Bean
    public SimpleCookie rememberMeCookie(){
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setMaxAge(259200);
        return simpleCookie;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, Filter> customFilters = shiroFilterFactoryBean.getFilters();
//        customFilters.put("authc",new CustomFormAuthenticationFilter());
        customFilters.put("jwt",new JwtFilter());
        Map<String,String> filterMap = new LinkedHashMap<>();
//        filterMap.put("/login","anon");
//        filterMap.put("/user/register","anon");
//        filterMap.put("/api/**","anon");
        filterMap.put("/**","jwt");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);   //强制使用glib代理
        return defaultAdvisorAutoProxyCreator;

    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultSecurityManager defaultSecurityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(defaultSecurityManager);
        return authorizationAttributeSourceAdvisor;
    }

//    private HashedCredentialsMatcher hashedCredentialsMatcher() {
//        //shiro hash credential
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        //use MD5
//        hashedCredentialsMatcher.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);
//        hashedCredentialsMatcher.setHashIterations(16); //加密16次
//        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(false); //通过base64保存
//        return hashedCredentialsMatcher;
//    }
}
