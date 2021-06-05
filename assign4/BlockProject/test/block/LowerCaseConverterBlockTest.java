package block;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LowerCaseConverterBlockTest implements BaseBlockTest {
  @Override
  public String blockFunction(String character) {
    return Block.lowerCaseConverterBlock(character);
  }

  @Override
  public Stream<Arguments> specificCaseArguments() {
    return Stream.of(
      Arguments.of("Z", "z"),
      Arguments.of("z", "z"),
      Arguments.of("1", "1"),
      Arguments.of("~", "~"),
      Arguments.of("", "")
    );
  }
}