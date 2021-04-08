package vip.huhailong.shirobyjwt.log;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import vip.huhailong.shirobyjwt.entity.LogEntity;
import vip.huhailong.shirobyjwt.mapper.LogMapper;
import vip.huhailong.shirobyjwt.service.IUserService;
import vip.huhailong.shirobyjwt.util.AddressUtil;
import vip.huhailong.shirobyjwt.util.IPUtil;
import vip.huhailong.shirobyjwt.util.JwtUtil;
import vip.huhailong.shirobyjwt.util.TimeUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.*;

@Slf4j
@Aspect
@Component
public class LogAspect {
    @Value("${log.location}")
    private boolean openLocation;   //是否开启记录ip来源配置
    @Resource
    AddressUtil addressUtil;
    @Resource
    LogMapper logMapper;
    @Autowired
    IUserService userService;

    @Pointcut("@annotation(vip.huhailong.shirobyjwt.log.Log)")
    public void pointcut(){}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point){
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try{
            result = point.proceed();
        }catch (Throwable e){
            log.info(e.getMessage());
        }
        long time = System.currentTimeMillis() - beginTime;
        //保存日志
        saveLog(point,time);
        return result;
    }

    public void saveLog(ProceedingJoinPoint point, Long time){
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        String username = JwtUtil.getUsername(token);
        if(username==null){
            username = "0";
        }
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        LogEntity log = new LogEntity();
        Log logAnnotation = method.getAnnotation(Log.class);
        if(logAnnotation != null){
            log.setLogDescribe(logAnnotation.value()); //如果有注解则获取注解的描述
        }
        String className = point.getTarget().getClass().getName();  //获取注解的当前类名
        String methodName = signature.getName();    //获取使用注解的方法名称
        log.setMethod(className+"."+methodName+"()");
        Object[] args = point.getArgs();    //获取参数
        LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = discoverer.getParameterNames(method);
        if(args != null && paramNames != null){
            List<Map<String,Object>> paramList = new ArrayList<>();
            for(int i=0; i<args.length; i++){
                Map<String,Object> map = new HashMap<>();
                map.put("paramName",paramNames[i]);
                map.put("paramValue",args[i]);
                paramList.add(map);
            }
            log.setParam(JSONObject.toJSONString(paramList));    //获取参数
        }
        String ipAddress = IPUtil.getIpAddress(request);    //获取ip地址
        log.setIpAddress(ipAddress);    //设置IP地址
        if(openLocation){
            String location = addressUtil.getLocation(ipAddress);
            log.setLocation(location);
        }
        log.setCreateTime(TimeUtil.getDateTime());
        log.setRunTime(time);
        log.setUserId(username);
        logMapper.insert(log);
    }

}
