import org.junit.Test;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
/** Some test may fail because current day changes**/
public class UnitTest {

  @Test
  public void testAssignmentDueDate() {
    LocalDate dueDate1 = LocalDate.of(2022, 3, 15);
    AssignmentImpl assignment1 = new AssignmentImpl("Homework 4", "COMP 301", dueDate1);

    assertEquals(assignment1.getDaysTilDue(), Period.between(assignment1.getCurrentDate(), assignment1.getDueDate()).getDays());
  }

  @Test
  public void testAssignmentDueDateBeforeCurrent() {
    LocalDate dueDate1 = LocalDate.of(2022, 2, 28);
    try {
      AssignmentImpl assignment1 = new AssignmentImpl("Homework 4", "COMP 301", dueDate1);
    } catch (IllegalArgumentException e) {
      System.out.println("due date before actual date caught");
    }
  }

  @Test
  public void testAssignmentIterator() {
    //Due Dates
    LocalDate dueDateEarliest = LocalDate.of(2022, 3, 25);
    LocalDate dueDateMiddle = LocalDate.of(2022, 3, 27);
    LocalDate dueDateLatest = LocalDate.of(2022, 3, 29);
    //Assignments
    AssignmentImpl assignment1 = new AssignmentImpl("A01", "COMP 301", dueDateLatest);
    AssignmentImpl assignment2 = new AssignmentImpl("Lab 2", "COMP 211", dueDateEarliest);
    AssignmentImpl assignment3 = new AssignmentImpl("Worksheet 3", "PSYC 101", dueDateMiddle);
    //Assignment List
    List<Assignment> assignmentList = new ArrayList<>();
    assignmentList.add(assignment1);
    assignmentList.add(assignment2);
    assignmentList.add(assignment3);

    AssignmentIterator iterator = new AssignmentIterator(assignmentList);

    //Expected order is based on due date
    //Expect: assignment2, assignment3, assignment1
    assertTrue(iterator.hasNext());
    assertEquals(iterator.next(), assignment2);
    assertTrue(iterator.hasNext());
    assertEquals(iterator.next(), assignment3);
    assertTrue(iterator.hasNext());
    assertEquals(iterator.next(), assignment1);
    assertFalse(iterator.hasNext());
    try {
      iterator.next();
    } catch (NoSuchElementException e) {
      System.out.println("Caught NoSuchElementException");
    }
  }
}
