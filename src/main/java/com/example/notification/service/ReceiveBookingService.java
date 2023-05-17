package com.example.notification.service;

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

    @RabbitListener(queues = {"notificacionQueue"})
    public void sendMessage(NotificationDTO notification) throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(notification.getEmail());
        helper.setSubject("Mascota lista para ser recogida");
        helper.setText("<html>" +
                "<head>" +
                "<style>" +
                "body { font-family: Arial, sans-serif; }" +
                "h1 { text-align: center; }" +
                "p { text-align: left; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<h1>¡Tu mascota está lista para ser recogida!</h1>" +
                "<p>Hola "+notification.getClient()+" ,</p>" +
                "<p>Tu mascota <strong>" + notification.getPet() + "</strong> ya está disponible para ser recogida en nuestra guardería canina.</p>" +
                "<p>Por favor, ven a recogerla en el horario de atención establecido.</p>" +
                "<p>Horario: "+notification.getDate()+", "+notification.getTime()+" </p>" +
                "<p>Gracias y esperamos verte pronto.</p>" +
                "<p>Equipo de la Guardería Canina</p>" +
                "</body>" +
                "</html>", true);

        try{
            sender.send(message);
            System.out.println("Se envio el correo.");
        } catch (MailException e) {
            System.out.println("Error: "+ e.getMessage());
        }

    }


}
