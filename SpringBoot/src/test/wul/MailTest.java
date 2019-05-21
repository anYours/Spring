package wul;

import com.Application;
import com.wl.service.MailService;
import com.wl.service.impl.MailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MailTest {

    @Resource
    private MailServiceImpl mailService;

    @Test
    public void simpleMail(){
        mailService.sendSimpleMail("wul@koal.com", "test simple mail", "hello this is simple mail");
    }
}
