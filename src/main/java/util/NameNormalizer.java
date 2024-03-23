package util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NameNormalizer {

   private String[] nameParts;
   private String suffix = "";

   // START:fix
   public String normalizeName(String name) {
      extractSuffix(name);
      // Handle case for 1 name w/ no middle names but possible a suffix
      // START_HIGHLIGHT
      if (nameParts.length == 1) {
         return nameParts[0] + suffix;
      }
      // END_HIGHLIGHT

      return formatLastNameFirst() + suffix;
   }
   // END:fix

   private void extractSuffix(String name) {
      if (name.contains(",")) {
         var parts = name.split(", ", 2);
         this.nameParts = parts[0].split(" ");
         this.suffix = ", " + parts[1];
      } else {
         this.nameParts = name.split(" ");
      }
   }

   private String formatLastNameFirst() {
      var firstName = firstName();
      var lastName = lastName();
      var middleInitials = middleInitialsString();

      return String.format("%s, %s%s", lastName, firstName, middleInitials);
   }

   private String firstName() {
      return nameParts[0];
   }

   private String lastName() {
      return nameParts[nameParts.length - 1];
   }

   private String middleInitialsString() {
      if (nameParts.length > 2) {
         return " " + Arrays.stream(middleNames())
            .map(this::initial)
            .collect(Collectors.joining(" "));
      }
      return "";
   }

   private String[] middleNames() {
      if (nameParts.length > 2) {
         return Arrays.copyOfRange(nameParts, 1, nameParts.length - 1);
      }
      return new String[]{};
   }

   private String initial(String name) {
      return name.charAt(0) + ".";
   }
}
