package fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FizzBuzzTest {

    @Test
    void pickOne() {
        for (int i = 1; i < 100; i++) {
            String res = new FizzBuzz().pickOne(i);
            switch (i) {
                case 3:
                case 6:
                case 9:
                case 12:
                case 18:
                case 21:
                case 24:
                case 27:
                case 33:
                case 36:
                case 39:
                case 42:
                case 48:
                case 51:
                case 54:
                case 57:
                case 63:
                case 66:
                case 69:
                case 72:
                case 78:
                case 81:
                case 84:
                case 87:
                case 93:
                case 96:
                case 99:
                    Assertions.assertEquals("fizz", res);
                    break;
                case 5:
                case 10:
                case 20:
                case 25:
                case 35:
                case 40:
                case 50:
                case 55:
                case 65:
                case 70:
                case 80:
                case 85:
                case 95:
                case 100:
                    Assertions.assertEquals("buzz", res);
                    break;
                case 15:
                case 30:
                case 45:
                case 60:
                case 75:
                case 90:
                    Assertions.assertEquals("fizzbuzz", res);
                    break;
                default:
                    Assertions.assertEquals(Integer.toString(i), res);
            }
        }
    }
}