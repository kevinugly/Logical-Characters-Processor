package block.blockapp;

import block.*;
import java.io.*;
import java.util.*;
import java.util.function.*;

@SuppressWarnings("unchecked")
public class BlockApp {
  public static void main(String[] args) throws Exception {
    File file = new File(System.getProperty("user.dir") + "/input.txt");
    Scanner sc = new Scanner(file);

    var count = 1;
    ArrayList<Function<String, String>> listOfBlocks = new ArrayList<>();

    System.out.println("Blocks used:");

    while(sc.hasNext()) {
      String[] parts = sc.nextLine().split(":");

      if(parts.length == 3) {
        listOfBlocks.add(BlockAccess.getBlock(parts[0], parts[1], parts[2]));
        System.out.println(count + ") " + parts[1] + ":" + parts[2]);
      }
      else {
        listOfBlocks.add(BlockAccess.getBlock(parts[0], parts[1]));
        System.out.println(count + ") " + parts[1]);
      }

      count++;
    }

    sc = new Scanner(System.in);
    System.out.print("\nEnter word to process: ");
    String wordToProcess = sc.nextLine();
    System.out.println(Processor.process(wordToProcess, listOfBlocks.toArray(new Function[0])) + "\n");

    System.out.print("Enter another word to process: ");
    wordToProcess = sc.nextLine();
    System.out.println(Processor.process(wordToProcess, listOfBlocks.toArray(new Function[0])));
  }
}