package com.java.academy.gym.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserMessageTest {

    @Test
    public void shouldReturnThatUserMessagesAreEqual() {
        Locale locale1 = new Locale("pl_PL", "polish", "Poland");
        Locale locale2 = new Locale("pl_PL", "polish", "Poland");
        UserMessage userMessage1 = new UserMessage(locale1, "MK1", "Message1");
        UserMessage userMessage2 = new UserMessage(locale2, "MK1", "Message1");

        assertEquals(userMessage1, userMessage2);
    }

    @Test
    public void shouldReturnThatUserMessagesAreDifferent() {
        UserMessage userMessage1 = new UserMessage(null, "MK1", "Message1");
        UserMessage userMessage2 = new UserMessage(null, "MK2", "Message2");

        assertNotEquals(userMessage1, userMessage2);
    }

    @Test
    public void shouldReturnEqualHashCodeForEqualUserMessages() {
        Locale locale1 = new Locale("pl_PL", "polish", "Poland");
        Locale locale2 = new Locale("pl_PL", "polish", "Poland");
        UserMessage userMessage1 = new UserMessage(locale1, "MK1", "Message1");
        UserMessage userMessage2 = new UserMessage(locale2, "MK1", "Message1");

        assertEquals(userMessage1.hashCode(), userMessage2.hashCode());
    }

}