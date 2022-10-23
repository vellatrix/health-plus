package org.healthplus.vendor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

  public static void main(String[] args) {

    Checker checker = new Checker(1,
            Arrays.asList(new Check(2, Arrays.asList(new CheckSecond(1), new CheckSecond(2), new CheckSecond(4))),
                          new Check(3, Arrays.asList(new CheckSecond(4), new CheckSecond(5)))));

    int i = checker.getChecks().stream()
            .map(s -> s.checkSeconds.size())
            .reduce(0, Integer::sum)
            .intValue();

    System.out.println("값 = " + i);

  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  static class Checker {
    private int age;
    private List<Check> checks;
  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  static class Check {
    private int age;
    private List<CheckSecond> checkSeconds;
  }

  @NoArgsConstructor
  @Data
  @AllArgsConstructor
  static class CheckSecond {
    private int age;
  }
}
