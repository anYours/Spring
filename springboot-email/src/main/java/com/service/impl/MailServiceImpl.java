package com.service.impl;

import com.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${mail.fromMail.addr}")
    private String from;

    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        //设置发送人
        message.setFrom(from);
        //接收者
        message.setTo(to);
        //标题
        message.setSubject(subject);
        //邮件内容
        message.setText(content);
        try {
            javaMailSender.send(message);
            System.out.println("to = [" + to + "], subject = [" + subject + "], content = [" + content + "]");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = getMessageHelper(message, to, subject, content, filePath);
            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = file.getFilename();
            helper.addAttachment(fileName, file);
            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendOnlineResourceMail(String to, String subject, String content, String resourcePath, String id) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = getMessageHelper(message, to, subject, content, resourcePath);
            FileSystemResource file = new FileSystemResource(new File(resourcePath));
            helper.addInline(id, file);
            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取MimeMessageHelper
     *
     * @param message      MimeMessage
     * @param to           接收者
     * @param subject      标题
     * @param content      邮件内容
     * @param resourcePath 附件地址
     * @return MimeMessageHelper
     * @throws Exception 异常
     */
    private MimeMessageHelper getMessageHelper(MimeMessage message, String to, String subject, String content, String resourcePath) throws Exception {
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        message.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        return helper;
    }
}
