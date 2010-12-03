/**
 * Unit tests for CategoryImpl.
 *
 * @see CategoryImpl.
 * @author Tzafrir Rehan (tzafrir@cs.technion.ac.il)
 */

package aig.donations;

import aig.donations.exceptions.CategoryNotFoundException;

import junit.framework.TestCase;
import org.junit.Test;

public class CategoryTest extends TestCase {
  @Test
  public void testPassesParametersInRetrieveWithoutTouching() {
    Category category = new Category(new StubCategoryDbGateway());
    try {
      category.retrieveCategory(StubCategoryDbGateway.EXPECTED_INPUT_1);
    } catch (FailException e) {
      fail(e.getMessage());
    } catch (CategoryNotFoundException e) {
      fail("Unexpected exception: " + e.getMessage());
    }

    try {
      category.retrieveCategory(925086);
      fail("Did not throw exception when given arbitrary parameter");
    } catch (FailException e) {
    } catch (CategoryNotFoundException e) {
      fail("Unexpected exception: " + e.getMessage());
    }
  }

  @Test
  public void testPassesParametersInAddWithoutTouching() {
    Category category = new Category(new StubCategoryDbGateway());
    try {
      category.addToDB(StubCategoryDbGateway.EXPECTED_INPUT_3,
          StubCategoryDbGateway.EXPECTED_INPUT_4, StubCategoryDbGateway.EXPECTED_INPUT_2);
    } catch (FailException e) {
      fail(e.getMessage());
    }

    try {
      category.addToDB("", StubCategoryDbGateway.EXPECTED_INPUT_4,
          StubCategoryDbGateway.EXPECTED_INPUT_2);
      fail("Did not throw exception when given arbitrary parameter");
    } catch (FailException e) {
    }

    try {
      category.addToDB(StubCategoryDbGateway.EXPECTED_INPUT_3, "",
          StubCategoryDbGateway.EXPECTED_INPUT_2);
      fail("Did not throw exception when given arbitrary parameter");
    } catch (FailException e) {
    }

    try {
      category.addToDB(StubCategoryDbGateway.EXPECTED_INPUT_3,
          StubCategoryDbGateway.EXPECTED_INPUT_4, -15);
      fail("Did not throw exception when given arbitrary parameter");
    } catch (FailException e) {
    }

  }

  private class StubCategoryDbGateway implements CategoryDatabaseGateway {
    static final long EXPECTED_INPUT_1 = 101010;
    static final long EXPECTED_INPUT_2 = 101100;
    static final String EXPECTED_INPUT_3 = "IMOK";
    static final String EXPECTED_INPUT_4 = "2IMOK2";
    public Category fetchCategory(long categoryId) {
      if (categoryId != EXPECTED_INPUT_1) {
        throw new FailException("Wrong parameter passed to fetchCategory(). Received: " +
            categoryId);
      }
      return null;
    }

    public long insertCategory(String name, String description, long parentId) {
      // Notice: Test ensures that CategoryImpl passes on its parameters, therefore the strings are
      // checked using "!=" and not using hte equals() method, which only checks equality, not
      // identity.
      if (name != EXPECTED_INPUT_3) {
        throw new FailException("Wrong parameter name passed to insertCategory(). Received: " +
            name);
      }

      if (description != EXPECTED_INPUT_4) {
        throw new FailException(
            "Wrong parameter description passed to insertCategory(). Received: " + name);
      }

      if (parentId != EXPECTED_INPUT_2) {
        throw new FailException("Wrong parameter parentId passed to insertCategory(). Received: " +
            parentId);
      }
      return 0;
    }
  }

  private class FailException extends RuntimeException {
    public FailException(String message) {
      super(message);
    }
  }
}
