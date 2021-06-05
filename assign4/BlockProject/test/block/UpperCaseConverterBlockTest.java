package block;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.*;
import java.util.stream.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UpperCaseConverterBlockTest implements BaseBlockTest {
  @Test
  void canary() {
    assert(true);
  }

  @Override
  public String blockFunction(String character) {
    return Block.upperCaseConverterBlock(character);
  }

  @Override
  public Stream<Arguments> specificCaseArguments() {
    return Stream.of(
      Arguments.of("6", "A"),
      Arguments.of("A", "A"),
      Arguments.of("1", "1"),
      Arguments.of("~", "~"),
      Arguments.of("", "")
    );
  }
}