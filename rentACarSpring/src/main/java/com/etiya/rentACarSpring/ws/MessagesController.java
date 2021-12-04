package com.etiya.rentACarSpring.ws;

import com.etiya.rentACarSpring.businnes.abstracts.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/messages")
public class MessagesController {
    private MessageService messageService;
    @Autowired
    public MessagesController(MessageService messageService) {
        this.messageService = messageService;
    }



}
