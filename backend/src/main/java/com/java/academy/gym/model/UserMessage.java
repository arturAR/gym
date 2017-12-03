package com.java.academy.gym.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "userMessages")
public class UserMessage extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locale_id", nullable = false)
    private Locale locale;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String messageKey;

    private String messageText;

    public UserMessage() {
    }

    public UserMessage(Locale locale, String messageKey, String messageText) {
        this.locale = locale;
        this.messageKey = messageKey;
        this.messageText = messageText;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
