import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateRegisteredAndUnderLimit() {

        BonusService service = new BonusService();

        long amount = 100060;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }


    @Test
    void shouldCalculateNotRegisteredAndUnderLimit() {

        BonusService service = new BonusService();

        long amount = 100060;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegisteredAndOverLimit() {

        BonusService service = new BonusService();

        long amount = 2000060;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateNotRegisteredAndOverLimit() {

        BonusService service = new BonusService();

        long amount = 6000060;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegisteredAndRounding() {

        BonusService service = new BonusService();

        long amount = 169999;
        boolean registered = true;
        long expected = 50;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateNotRegisteredAndRounding() {

        BonusService service = new BonusService();

        long amount = 169999;
        boolean registered = false;
        long expected = 16;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegisteredAndMinusAmount() {

        BonusService service = new BonusService();

        long amount = -169999;
        boolean registered = false;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegisteredAndOverFlow() {

        BonusService service = new BonusService();

        long amount = Long.MAX_VALUE / 3 + 1;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
}