package com.java.academy.gym.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LocaleTest {

    @Test
    public void shouldReturnThatLocalesAreEqual() {
        Locale locale1 = new Locale("pl_PL", "polish", "Poland");
        Locale locale2 = new Locale("pl_PL", "polish", "Poland");

        assertEquals(locale1, locale2);
    }

    @Test
    public void shouldReturnThatLocalesAreDifferent() {
        Locale locale1 = new Locale("pl_PL", "polish", "Poland");
        Locale locale2 = new Locale("fr_FR", "french", "France");

        assertNotEquals(locale1, locale2);
    }

    @Test
    public void shouldReturnEqualHashCodeForEqualLocales() {
        Locale locale1 = new Locale("pl_PL", "polish", "Poland");
        Locale locale2 = new Locale("pl_PL", "polish", "Poland");

        assertEquals(locale1.hashCode(), locale2.hashCode());
    }

}