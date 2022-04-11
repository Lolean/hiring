package t9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

class T9TranslatorTest {

    @Test
    void testSimpleStringWithoutSpecificities() throws IOException {

        String expectedString = "salut";
        byte[] input = encode(expectedString, 0);

        InputStream stream = new ByteArrayInputStream(input);
        String result = new T9Translator().translate(stream);

        Assertions.assertEquals(expectedString, result);
    }

    @Test
    void testSimpleStringWithDuplicateKeys() throws IOException {

        String expectedString = "bonjour";
        byte[] input = encode(expectedString, 0);

        InputStream stream = new ByteArrayInputStream(input);
        String result = new T9Translator().translate(stream);

        Assertions.assertEquals(expectedString, result);
    }

    @Test
    void testSimpleStringWithDuplicateKeysAndSpaces() throws IOException {

        String expectedString = "bonjour candidat";
        byte[] input = encode(expectedString, 0);

        InputStream stream = new ByteArrayInputStream(input);
        String result = new T9Translator().translate(stream);

        Assertions.assertEquals(expectedString, result);
    }

    @Test
    void testStringWithDuplicateKeysAndSpacesAndVariousPauses() throws IOException {

        String expectedString = "lorem ipsum dolor sit amet ea dicta quia et obcaecati fugit ut enim sapiente aut similique modi et libero aliquid aut dolores officiis aut minus autem ut nesciunt perspiciatis in ratione magni non ducimus quia ut dolores quam a nulla numquam ut numquam doloribus est dolore commodi sed nostrum cumque hic minima facere sit beatae dolorem";
        byte[] input = encode(expectedString, 0.33);

        InputStream stream = new ByteArrayInputStream(input);
        String result = new T9Translator().translate(stream);

        Assertions.assertEquals(expectedString, result);
    }

    private byte[] encode(String text, double pauseProbability){
        /**
         * don't look at this method. It's nasty as f*ck. I was lazy
         */
        ByteBuffer buffer = ByteBuffer.allocate(text.length()*5);
        byte last = 42;
        for (char c:text.toCharArray()){
            byte[] toAdd = null;
            switch (c){
                case 'a':
                    toAdd = new byte[]{50};
                    break;
                case 'b':
                    toAdd = new byte[]{50, 50};
                    break;
                case 'c':
                    toAdd = new byte[]{50, 50, 50};
                    break;
                case 'd':
                    toAdd = new byte[]{51};
                    break;
                case 'e':
                    toAdd = new byte[]{51, 51};
                    break;
                case 'f':
                    toAdd = new byte[]{51, 51, 51};
                    break;
                case 'g':
                    toAdd = new byte[]{52};
                    break;
                case 'h':
                    toAdd = new byte[]{52, 52};
                    break;
                case 'i':
                    toAdd = new byte[]{52, 52, 52};
                    break;
                case 'j':
                    toAdd = new byte[]{53};
                    break;
                case 'k':
                    toAdd = new byte[]{53, 53};
                    break;
                case 'l':
                    toAdd = new byte[]{53, 53, 53};
                    break;
                case 'm':
                    toAdd = new byte[]{54};
                    break;
                case 'n':
                    toAdd = new byte[]{54, 54};
                    break;
                case 'o':
                    toAdd = new byte[]{54, 54, 54};
                    break;
                case 'p':
                    toAdd = new byte[]{55};
                    break;
                case 'q':
                    toAdd = new byte[]{55, 55};
                    break;
                case 'r':
                    toAdd = new byte[]{55, 55, 55};
                    break;
                case 's':
                    toAdd = new byte[]{55, 55, 55, 55};
                    break;
                case 't':
                    toAdd = new byte[]{56};
                    break;
                case 'u':
                    toAdd = new byte[]{56, 56};
                    break;
                case 'v':
                    toAdd = new byte[]{56, 56, 56};
                    break;
                case 'w':
                    toAdd = new byte[]{57};
                    break;
                case 'x':
                    toAdd = new byte[]{57, 57};
                    break;
                case 'y':
                    toAdd = new byte[]{57, 57, 57};
                    break;
                case 'z':
                    toAdd = new byte[]{57, 57, 57, 57};
                    break;
                case ' ':
                    toAdd = new byte[]{48};
                    break;
            }

            if(last == toAdd[0]){
                buffer.put((byte)32);
            }

            for (int i = 0; i < 3; i++) {
                if(Math.random() < pauseProbability){
                    buffer.put((byte)32);
                }
            }

            buffer.put(toAdd);

            last = toAdd[toAdd.length-1];
        }

        byte[] a = new byte[buffer.position()];
        buffer.rewind();
        buffer.get(a);
        return a;
    }
}