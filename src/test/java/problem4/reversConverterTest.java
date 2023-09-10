package problem4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class reversConverterTest {

    @Test
    void 단어글자_반복문돌면서_변환하는_기능() {
        String result = new Converter().reverseWord("I love you");
        assertThat(result).isEqualTo("R olev blf");
    }

}
