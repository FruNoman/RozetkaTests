package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class MailSender {

    private String header = "Rozetka Test";
    private String text = "Describe Rozetka product";



    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    private List<String> getEmailsList() throws IOException {
        List<String> emails = new ArrayList<String>();
        FileInputStream fstream = new FileInputStream(ClassLoader.getSystemClassLoader().getResource("emails.txt").getPath());
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;

        while ((strLine = br.readLine()) != null)   {
            emails.add(strLine);
        }

        br.close();
        return emails;
    }

    public void sendMail(File sendFile) throws IOException, MessagingException {
        final String username = "frolovtest2017";
        final String password = "Froyman98_!";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            for(String emails:getEmailsList()) {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("aa@aa.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emails));
                message.setSubject(header);
                message.setText(text);

                MimeBodyPart messageBodyPart = new MimeBodyPart();

                Multipart multipart = new MimeMultipart();

                String file = sendFile.getAbsolutePath();
                String fileName = "products";
                DataSource source = new FileDataSource(file);
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(fileName);
                multipart.addBodyPart(messageBodyPart);

                message.setContent(multipart);

                Transport.send(message);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
