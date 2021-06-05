package block;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.*;
import java.util.stream.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ASCIIValueConverterBlockTest implements BaseBlockTest {
  @Override
  public String blockFunction(String character) {
    return ThirdPartyBlock.ASCIIValueConverterBlock(character);
  }

  @Override
  public Stream<Arguments> specificCaseArguments() {
    return Stream.of(
      Arguments.of("a", "97 "),
      Arguments.of("Z", "90 "),
      Arguments.of("1", "49 "),
      Arguments.of("~", "126 "),
      Arguments.of("", "0 ")
    );
  }
}