package util;

import java.util.Arrays;
import java.util.stream.Collectors;

// START:suffix
public class NameNormalizer {

   private String[] nameParts;
   // START_HIGHLIGHT
   private String suffix = "";
   // END_HIGHLIGHT

   public String normalizeName(String name) {
      // START_HIGHLIGHT
      if (name.contains(",")) {
         var parts = name.split(", ");
         this.nameParts = parts[0].split(" ");
         this.suffix = ", " + parts[1];
      } else {
         this.nameParts = name.split(" ");
      }

      if (nameParts.length == 1) {
         return name;
      }

      return formatLastNameFirst() + suffix;
      // END_HIGHLIGHT
   }
   // ...
// END:suffix

   private String firstName() {
      return nameParts[0];
   }

   private String lastName() {
      return nameParts[nameParts.length - 1];
   }

   private String[] middleNames() {
      return Arrays.copyOfRange(nameParts, 1, nameParts.length - 1);
   }

   private String formatLastNameFirst() {
      var middleInitials = Arrays.stream(middleNames())
         .map(this::initial)
         .collect(Collectors.joining(" "));
      return middleInitials.isEmpty() ?
         String.format("%s, %s", lastName(), firstName()) :
         String.format("%s, %s %s", lastName(), firstName(), middleInitials);
   }

   private String initial(String name) {
      return name.charAt(0) + ".";
   }
   // START:suffix
}
// END:suffix
