package com.java.academy.gym.model;

import javax.persistence.*;

@Entity
@Table(name = "USER_MESSAGES")
public class UserMessage extends BaseEntity {
    private static final long serialVersionUID = 7871352451627547465L;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LANG_CODE", nullable = false)
    private Locale locale;

    @Column(name = "MSG_KEY", nullable = false, length = 500)
    private String messageKey;

    @Column(name = "MSG_TEXT", nullable = false)
    private String messageText;

    public UserMessage() {}

    public UserMessage(Locale locale, String messageKey, String messageText) {
        this.locale = locale;
        this.messageKey = messageKey;
        this.messageText = messageText;
        this.version = 1;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserMessage that = (UserMessage) o;

        if (locale != null ? !locale.equals(that.locale) : that.locale != null) return false;
        if (!messageKey.equals(that.messageKey)) return false;
        return messageText != null ? messageText.equals(that.messageText) : that.messageText == null;
    }

    @Override
    public int hashCode() {
        int result = locale != null ? locale.hashCode() : 0;
        result = 31 * result + messageKey.hashCode();
        result = 31 * result + (messageText != null ? messageText.hashCode() : 0);
        return result;
    }
}
