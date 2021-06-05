package block;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.*;
import java.util.stream.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UnderScoreBlockTest implements BaseBlockTest {
  @Override
  public String blockFunction(String character) {
    return ThirdPartyBlock.addUnderScore(character);
  }

  @Override
  public Stream<Arguments> specificCaseArguments() {
    return Stream.of(
      Arguments.of("a", "a_"),
      Arguments.of("Z", "Z_"),
      Arguments.of("1", "1_"),
      Arguments.of("~", "~_"),
      Arguments.of("", "_")
    );
  }
}
