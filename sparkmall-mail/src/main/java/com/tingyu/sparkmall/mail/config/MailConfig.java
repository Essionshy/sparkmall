package com.tingyu.sparkmall.mail.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author essionshy
 * @Create 2020/12/3 16:32
 * @Version renren-fast
 */
@Configuration
public class MailConfig implements InitializingBean {


    /**
     * template.host=smtp.163.com
     * template.encoding=utf-8
     * template.username=xiaozhou89757@163.com
     * template.password=EUEUKILFEKNYMOCX
     * template.protocol=smtp
     * template.smtp.auth=true
     * template.smtp.timeout=25000
     */

    /**
     * SMTP server host. For instance, `smtp.example.com`.
     */
    @Value("${spring.mail.host}")
    private String host;

    /**
     * SMTP server port.
     */
    private int port;

    /**
     * Login user of the SMTP server.
     */
    @Value("${spring.mail.username}")
    private String username;

    /**
     * Login password of the SMTP server.
     */
    @Value("${spring.mail.password}")
    private String password;

    /**
     * Protocol used by the SMTP server.
     */
    @Value("${spring.mail.protocol}")
    private String protocol;

    /**
     * Default MimeMessage encoding.
     */
    @Value("${spring.mail.default-encoding}")
    private String defaultEncoding;

    /**
     * Additional JavaMail Session properties.
     */
    private Map<String, String> properties = new HashMap<>();

    /**
     * Session JNDI name. When set, takes precedence over other Session settings.
     */
    private String jndiName;


    public static String DEFAULT_CHARSET;

    public static String DEFAULT_HOST;
    public static int DEFAULT_PORT;
    public static String DEFAULT_USERNAME;
    public static String DEFAULT_PASSWORD;
    public static String DEFAULT_PROTOCOL;
    public static boolean DEFAULT_SMTP_AUTH;

    @Override
    public void afterPropertiesSet() throws Exception {
        DEFAULT_CHARSET = this.defaultEncoding;
        DEFAULT_USERNAME = this.username;
        DEFAULT_PASSWORD = this.password;
        DEFAULT_HOST = this.host;
        DEFAULT_PORT = this.port;
        DEFAULT_PROTOCOL = this.protocol;
    }
}
