package com.example.notification.service;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO {

    String client;
    String email;
    String pet;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate date;

    @JsonDeserialize(using = LocalTimeDeserializer.class)
    LocalTime time;

}
