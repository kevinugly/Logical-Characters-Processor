package block;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.*;
import java.util.stream.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MultiplierBlockTest implements BaseBlockTest {
  @Override
  public String blockFunction(String character) {
    return Block.multiplierBlock(character);
  }

  @Override
  public Stream<Arguments> specificCaseArguments() {
    return Stream.of(
      Arguments.of("a", "aa"),
      Arguments.of("Z", "ZZ"),
      Arguments.of("1", "11"),
      Arguments.of("~", "~~"),
      Arguments.of("", "")
    );
  }
}
