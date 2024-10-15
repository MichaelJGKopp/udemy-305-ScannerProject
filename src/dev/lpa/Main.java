package dev.lpa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    // work with different inputs in a standardized way
    try (Scanner scanner = new Scanner(new File("file.txt"))) {

      while (scanner.hasNext()) {
        System.out.println(scanner.nextLine());
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

  }
}
