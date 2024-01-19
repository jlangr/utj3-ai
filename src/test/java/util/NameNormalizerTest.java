package util;

// START:generated
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameNormalizerTest {

   @Test
   public void testSingleName() {
      assertEquals("Plato", NameNormalizer.normalizeName("Plato"));
   }

   @Test
   public void testFirstNameLastName() {
      assertEquals("Cohen, Leonard", NameNormalizer.normalizeName("Leonard Cohen"));
   }

   @Test
   public void testMultipleMiddleNames() {
      assertEquals("Jackson, Samuel L.", NameNormalizer.normalizeName("Samuel Leroy Jackson"));
      assertEquals("Martin, George R. R.", NameNormalizer.normalizeName("George Raymond Richard Martin"));
   }

   @Test
   public void testLongName() {
      assertEquals("Hackley, Emma A. S.", NameNormalizer.normalizeName("Emma Azalia Smith Hackley"));
   }
}
// END:generated
