package block;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class z_BlockerBlockTest implements BaseBlockTest {
  @Override
  public String blockFunction(String character) {
    return Block.createCharacterBlocker("z").apply(character);
  }

  @Override
  public Stream<Arguments> specificCaseArguments() {
    return Stream.of(
      Arguments.of("z", ""),
      Arguments.of("Z", "Z"),
      Arguments.of("1", "1"),
      Arguments.of("~", "~"),
      Arguments.of("", "")
    );
  }
}
