package com.etiya.rentACarSpring.businnes.abstracts;

import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.entities.Message;

public interface MessageService {
    DataResult<Message> getbyId(int messageId);
    String getByEnglishMessageByMessageId(int messageId);
    String getByTurkishMessageByMessageId(int messageId);
}
