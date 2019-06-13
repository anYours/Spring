package wul;

import com.Application;
import com.service.impl.MailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MailTest {

    @Resource
    private MailServiceImpl mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void simpleMail(){
        mailService.sendSimpleMail("wul@koal.com", "test simple mail", "hello this is simple mail");
    }

    @Test
    public void sendAttachmentsMail(){
        String filePath = "D:\\HexTest.java";
        mailService.sendAttachmentsMail("wul@koal.com", "test simple mail", "hello this is Attachment mail", filePath);
    }

    @Test
    public void sendInlineMail(){
        String rscId = "neo006";
        String content = "<html><body><img src=\'cid:"+rscId+"\'/></body></html>";
        String path = "C:\\Users\\admin\\Pictures\\Camera Roll\\1556163835447.jpeg";
        mailService.sendOnlineResourceMail("wul@koal.com", "test simple mail", content, path, rscId);
    }

    @Test
    public void sendTemplateMail(){
        Context context = new Context();
        context.setVariable("id", "006");
        String emailTemplate = templateEngine.process("emailTemplate", context);
        mailService.sendSimpleMail("wul@koal.com", "这是模板邮件", emailTemplate);
    }
}
