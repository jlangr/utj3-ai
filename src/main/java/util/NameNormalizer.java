package util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NameNormalizer {

   public String normalizeName(String name) {
      var nameParts = name.split(" ");
      if (nameParts.length == 1) {
         return name;
      }

      return formatLastNameFirst(nameParts[0],
         nameParts[nameParts.length - 1],
         Arrays.copyOfRange(
            nameParts, 1, nameParts.length - 1));
   }

   private String formatLastNameFirst(
      String firstName, String lastName, String[] middleNames) {
      var middleInitials = Arrays.stream(middleNames)
         .map(this::extractInitial)
         .collect(Collectors.joining(" "));

      return middleInitials.isEmpty() ?
         String.format("%s, %s", lastName, firstName) :
         String.format("%s, %s %s", lastName, firstName, middleInitials);
   }

   private String extractInitial(String name) {
      return name.charAt(0) + ".";
   }
}
