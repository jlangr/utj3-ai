package util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NameNormalizer {

   private String[] nameParts;

   // START:fixedCode
   public String normalizeName(String name) {
      this.nameParts = name.split(" ");
      if (nameParts.length == 1) {
         return name;
      }

      return formatLastNameFirst();
   }
   // ...
   // END:fixedCode

   private String firstName() {
      return nameParts[0];
   }

   private String lastName() {
      return nameParts[nameParts.length - 1];
   }

   private String[] middleNames() {
      return Arrays.copyOfRange(nameParts, 1, nameParts.length - 1);
   }

   // START:fixedCode
   // START_HIGHLIGHT
   private String formatLastNameFirst() {
      // END_HIGHLIGHT
      var middleInitials = Arrays.stream(middleNames())
         .map(this::initial)
         .collect(Collectors.joining(" "));
      return middleInitials.isEmpty() ?
         // START_HIGHLIGHT
         String.format("%s, %s", lastName(), firstName()) :
         String.format("%s, %s %s", lastName(), firstName(), middleInitials);
         // END_HIGHLIGHT
   }

   // START_HIGHLIGHT
   private String initial(String name) {
      // END_HIGHLIGHT
      return name.charAt(0) + ".";
   }
   // END:fixedCode
}
