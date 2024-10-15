package dev.lpa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    // work with different inputs in a standardized way
//    try (Scanner scanner = new Scanner(new File("file.txt"))) {
    try (Scanner scanner = new Scanner(new File("fixedWidth.txt"))) {
//      while (scanner.hasNext()) {
//        System.out.println(scanner.nextLine());
//      }
//      System.out.println(scanner.delimiter());
//      scanner.useDelimiter("$");   // there is no $ so only 1 token
//      scanner.tokens().forEach(System.out::println);

//      scanner.findAll("[A-Za-z]{10,}")  // 10 or more letters
//        .map(MatchResult::group)
//        .distinct()
//        .sorted()
//        .forEach(System.out::println);
      var results = scanner.findAll(
        "(.{15})(.{3})(.{12})(.{8})(.{2}).*")
                .skip(1)  // skip header, first element
//                .map(m -> m.group(5)) // state
                .map(m -> m.group(3).trim())
                .distinct()
                .sorted()
                .toArray(String[]::new);
      System.out.println(Arrays.toString(results));
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

  }
}
