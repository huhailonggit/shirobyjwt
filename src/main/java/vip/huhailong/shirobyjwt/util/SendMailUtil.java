package vip.huhailong.shirobyjwt.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/17.
 */
@Slf4j
@Component
@EnableAsync
public class SendMailUtil {
    @Resource
    JavaMailSender javaMailSender;
    @Value("${server-mail.form}")
    private String formEmail;

    @Async
    public void sendSimpleMail(String toEmail, String subject, String content) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setFrom(formEmail);
        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(content,true);
        javaMailSender.send(message);
        log.info("邮件发送成功");
    }
}
