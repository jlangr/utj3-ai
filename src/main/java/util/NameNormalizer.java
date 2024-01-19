package util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NameNormalizer {

   public String normalizeName(String name) {
      var nameParts = name.split(" ");
      if (nameParts.length == 1) {
         return name;
      }

      // START_HIGHLIGHT
      return formatLastNameFirst(
         firstName(nameParts),
         lastName(nameParts),
         middleNames(nameParts));
      // END_HIGHLIGHT
   }

   // START_HIGHLIGHT
   private String firstName(String[] nameParts) {
      return nameParts[0];
   }
   // END_HIGHLIGHT

   // START_HIGHLIGHT
   private String lastName(String[] nameParts) {
      return nameParts[nameParts.length - 1];
   }
   // END_HIGHLIGHT

   // START_HIGHLIGHT
   private String[] middleNames(String[] nameParts) {
      return Arrays.copyOfRange(
         nameParts, 1, nameParts.length - 1);
   }
   // END_HIGHLIGHT

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
