package vip.huhailong.shirobyjwt.config.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

    @Bean
    public CustomRealmA realmA(){
        CustomRealmA customRealmA = new CustomRealmA();
        customRealmA.setCredentialsMatcher(hashedCredentialsMatcher());
        return customRealmA;
    }

    @Bean
    public CacheManager cacheManager(){
        return new MemoryConstrainedCacheManager();
    }

    @Bean
    public SessionsSecurityManager sessionsSecurityManager(){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realmA());
        return manager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SessionsSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, Filter> customFilters = shiroFilterFactoryBean.getFilters();
        customFilters.put("authc",new CustomFormAuthenticationFilter());
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/shirobyjwt/login","anon");
        filterMap.put("/shirobyjwt/user/register","anon");
        filterMap.put("/shirobyjwt/api/**","anon");
        filterMap.put("/shirobyjwt/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    private HashedCredentialsMatcher hashedCredentialsMatcher() {
        //shiro hash credential
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //use MD5
        hashedCredentialsMatcher.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);
        hashedCredentialsMatcher.setHashIterations(16); //加密16次
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(false); //通过base64保存
        return hashedCredentialsMatcher;
    }
}
