package io.aera.model.impl;

import io.aera.model.Message;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Qualifier("message")
public class MessageImpl implements Message {
    private String messageInfo;

    public String getMessageInfo() {
        return messageInfo;
    }

    @Override
    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }

    @Override
    public String getMessage() {
        return getMessageInfo();
    }
}
