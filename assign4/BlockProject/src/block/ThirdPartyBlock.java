package block;

public interface ThirdPartyBlock {
    static String addUnderScore(String input) {
        return input.concat("_");
    }

    static String ASCIIValueConverterBlock(String input) {
      return input.equals("") ? "0 " : String.valueOf((int) input.charAt(0)).concat(" ");
    }
}
