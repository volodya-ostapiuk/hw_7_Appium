package com.epam.utils;

import com.epam.model.MessageEntity;
import com.epam.model.UserEntity;
import com.epam.utils.json.JsonParser;
import com.epam.utils.properties.ConfigProperties;
import com.epam.utils.providers.MessageEntityProvider;

import java.util.List;
import java.util.Objects;

public interface Constants {
    String BASE_URL = ConfigProperties.getBaseUrl();
    int TIME_WAIT = ConfigProperties.getTimeWait();
    int EXPLICIT_WAIT = ConfigProperties.getExplicitWait();

    List<UserEntity> TEST_USERS = Objects.requireNonNull(JsonParser.getGmailJsonEntity()).getUsers();
    int FIRST_USER = 0;
    UserEntity TEST_USER = TEST_USERS.get(FIRST_USER);
    String TEST_USER_EMAIL = TEST_USER.getEmail();
    String TEST_USER_PASSWORD = TEST_USER.getPassword();

    MessageEntity TEST_MESSAGE = MessageEntityProvider.getMessageEntity();
    String TEST_RECEIVER = TEST_MESSAGE.getReceiver();
    String TEST_TOPIC = TEST_MESSAGE.getTopic();
    String TEST_LETTER_TEXT = TEST_MESSAGE.getLetterText();
    String IN_SENT_TEXT = "in:sent";

    String WRONG_LOGIN = "Wrong login.";
    String WRONG_SENT_TOPIC = "Field topic of last letter from sent folder doesn't match last sent message.";
    String WRONG_SENT_RECEIVER = "Field receiver of last letter from sent folder doesn't match last sent message.";
    String WRONG_SENT_TEXT = "Field letter text of last letter from sent folder doesn't match last sent message.";
}