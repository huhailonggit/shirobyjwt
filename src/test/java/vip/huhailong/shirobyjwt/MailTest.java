package vip.huhailong.shirobyjwt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import vip.huhailong.shirobyjwt.util.SendMailUtil;

import javax.mail.MessagingException;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/23.
 */
@SpringBootTest
public class MailTest {

    @Autowired
    SendMailUtil mailUtil;

    @Test
    public void test() throws MessagingException {
        String html = "<!DOCTYPE html><html><head>\t<title>邮箱验证</title>\t<style>\t\t.box{\t\t\ttext-align: center;\t\t}\t\timg{\t\t\twidth:20%;\t\t}\t</style></head><body>\t<div class=\"box\">\t\t<h3>欢迎注册<a href=\"https://www.huhailong.vip\">huhailong.vip</a></h3>\t\t<img src=\"https://www.huhailong.vip/img/wx.jpg\"><br>\t\t<p>点击下面的链接进行验证注册，如果过期请重新注册</p>\t\t<a href=\"https://www.huhailong.vip?token=\">sdfskflsanmfsa;lkdfnmsalksdlskdlfkslkdflskdnfsdijfwoeinldsknflsiejflskdnflwiejfoksndlfwiejofifnlskdnfowe</a>\t\t</div></body></html>";
        mailUtil.sendSimpleMail("1976884704@qq.com","Huhailong-注册验证信息",html);
    }
}
