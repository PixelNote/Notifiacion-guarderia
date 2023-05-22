package com.example.notification.service;

import com.example.notification.model.Email;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class ReceiveBookingService {

    private JavaMailSender sender;

    public ReceiveBookingService(JavaMailSender sender) {
        this.sender = sender;
    }
    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(JsonMessageConverter());
        return rabbitTemplate;
    }
    @Bean
    public Jackson2JsonMessageConverter JsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @RabbitListener(queues = {"notificationQueue"})
    public void sendMessage(NotificationDTO notification) throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(notification.getEmail());
        helper.setSubject("Mascota lista para ser recogida");
        helper.setText(new Email(notification.getClient(), notification.getPet(), notification.getDate(),notification.getTime()).getContent(), true);

        try{
            sender.send(message);
            System.out.println("Se envio el correo.");
        } catch (MailException e) {
            System.out.println("Error: "+ e.getMessage());
        }

    }


}
