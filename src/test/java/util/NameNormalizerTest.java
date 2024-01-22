package util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameNormalizerTest {

   private final NameNormalizer normalizer = new NameNormalizer();

   @Test
   public void singleName() {
      assertEquals("Plato", normalizer.normalizeName("Plato"));
   }

   @Test
   public void firstNameLastName() {
      assertEquals("Cohen, Leonard", normalizer.normalizeName("Leonard Cohen"));
   }

   // START:fixedTests
   @Test
   public void initializesMiddleName() {
      assertEquals("Jackson, Samuel L.", normalizer.normalizeName("Samuel Leroy Jackson"));
   }

   @Test
   public void multipleMiddleNames() {
      assertEquals("Martin, George R. R.", normalizer.normalizeName("George Raymond Richard Martin"));
      assertEquals("Hackley, Emma A. S.", normalizer.normalizeName("Emma Azalia Smith Hackley"));
   }
   // END:fixedTests
}
