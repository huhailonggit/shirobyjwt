package vip.huhailong.shirobyjwt.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/17.
 */
@Component
public class SendMailUtil {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendSimpleMail(String toEmail) {
        String time = LocalDateTime.now().toString();
        SimpleMailMessage message1 = new SimpleMailMessage();
        message1.setFrom("huhailong@huhailong.vip");
        message1.setTo(toEmail);
        message1.setSubject("注册激活验证");
        message1.setText("请在5分钟内激活账户");
        this.javaMailSender.send(message1);

    }
}
