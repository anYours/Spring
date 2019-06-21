package com.service;

/**
 * 邮件服务
 *
 */
public interface MailService {

    /**
     * 发送一般邮件
     * @param to
     * @param subject
     * @param content
     */
    public void sendSimpleMail(String to, String subject, String content);

    /**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePath
     */
    public void sendAttachmentsMail(String to, String subject, String content, String filePath);

    /**
     * 发送在线资源邮件
     * @param to
     * @param subject
     * @param content
     * @param resourcePath
     * @param id
     */
    public void sendOnlineResourceMail(String to, String subject, String content, String resourcePath, String id);
}
