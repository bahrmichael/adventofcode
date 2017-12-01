/*
 * Santa.java
 *
 * Created on 2017-12-01
 *
 * Copyright (C) 2017 Volkswagen AG, All rights reserved.
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Challenge1Test {

    @Test
    void one() {
        assertEquals(3, Challenge1.solve("1122"));
    }

    @Test
    void two() {
        assertEquals(4, Challenge1.solve("1111"));
    }

    @Test
    void three() {
        assertEquals(0, Challenge1.solve("1234"));
    }

    @Test
    void four() {
        assertEquals(9, Challenge1.solve("91212129"));
    }

    @Test
    void challenge() {
        System.out.println(Challenge1.solve(Challenge1.NUMBERS));
    }
}
