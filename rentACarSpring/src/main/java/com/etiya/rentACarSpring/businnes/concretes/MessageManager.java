package com.etiya.rentACarSpring.businnes.concretes;

import com.etiya.rentACarSpring.businnes.abstracts.MessageService;
import com.etiya.rentACarSpring.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.SuccesDataResult;
import com.etiya.rentACarSpring.dataAccess.abstracts.MessageDao;
import com.etiya.rentACarSpring.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageManager implements MessageService {

    MessageDao messageDao;
    ModelMapperService modelMapperService;

    @Autowired
    public MessageManager(MessageDao messageDao, ModelMapperService modelMapperService) {
        this.messageDao = messageDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<Message> getbyId(int messageId) {
        return new SuccesDataResult<Message>(this.messageDao.getById(messageId));
    }

    @Override
    public String getByEnglishMessageByMessageId(int messageId) {
        return this.messageDao.getEnglishMessageByMessageId(messageId);
    }

    @Override
    public String getByTurkishMessageByMessageId(int messageId) {
        return this.messageDao.getTurkishMessageByMessageId(messageId);
    }
}
