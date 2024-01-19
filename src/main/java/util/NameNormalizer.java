package util;

// START:generated
import java.util.Arrays;
import java.util.stream.Collectors;

public class NameNormalizer {

   public static String normalizeName(String name) {
      var nameParts = name.split(" ");
      if (nameParts.length == 1) {
         return name;
      }

      var lastName = nameParts[nameParts.length - 1];
      var firstName = nameParts[0];
      var middleNames = Arrays.copyOfRange(nameParts, 1, nameParts.length - 1);

      return formatLastNameFirst(lastName, firstName, middleNames);
   }

   private static String formatLastNameFirst(String lastName, String firstName, String[] middleNames) {
      var middleInitials = Arrays.stream(middleNames)
         .map(NameNormalizer::extractInitial)
         .collect(Collectors.joining(" "));

      return middleInitials.isEmpty() ?
         String.format("%s, %s", lastName, firstName) :
         String.format("%s, %s %s", lastName, firstName, middleInitials);
   }

   private static String extractInitial(String name) {
      return name.charAt(0) + ".";
   }
}
// END:generated
