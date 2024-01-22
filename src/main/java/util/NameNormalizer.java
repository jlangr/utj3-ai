package util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NameNormalizer {

   private String[] nameParts;
   private String suffix = "";

   // START:ok
   public String normalizeName(String name) {
      var result = extractSuffix(name);
      this.nameParts = result[0].split(" ");
      this.suffix = result[1];

      if (nameParts.length == 1) {
         return nameParts[0] + suffix;
      }

      return formatLastNameFirst() + suffix;
   }

   private String[] extractSuffix(String name) {
      if (name.contains(",")) {
         var parts = name.split(", ", 2);
         return new String[] {parts[0], ", " + parts[1]};
      } else {
         return new String[] {name, ""};
      }
   }
   // END:ok

   private String formatLastNameFirst() {
      return lastName() + ", " + firstName() + middleInitialsString();
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
