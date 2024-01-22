package util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NameNormalizer {

   // START:bad
   public String normalizeName(String name) {
      var extractedResult = extractSuffix(name);
      var nameParts = extractedResult[0].split(" ");
      var suffix = extractedResult[1];

      if (nameParts.length == 1) {
         return nameParts[0] + suffix;
      }

      var middleInitials = Arrays.stream(middleNames(nameParts))
         .map(this::initial)
         .collect(Collectors.joining(" "));

      return (nameParts[nameParts.length - 1] + ", " + nameParts[0] +
         (middleInitials.isEmpty() ? "" : " " + middleInitials)) + suffix;
   }
   // END:bad

   private String[] extractSuffix(String name) {
      if (name.contains(",")) {
         var parts = name.split(", ", 2);
         return new String[]{parts[0], ", " + parts[1]};
      } else {
         return new String[]{name, ""};
      }
   }

   private String[] middleNames(String[] nameParts) {
      if (nameParts.length > 2) {
         return Arrays.copyOfRange(nameParts, 1, nameParts.length - 1);
      }
      return new String[]{};
   }

   private String initial(String name) {
      return name.charAt(0) + ".";
   }
}
