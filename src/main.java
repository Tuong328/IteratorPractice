import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class main {
  public static void main(String[] args) {
    /**See outputs after implementation**/

    // Due Dates
    LocalDate dueDate1 = LocalDate.of(2022, 3, 20);
    LocalDate dueDate2 = LocalDate.of(2022, 3, 14);
    LocalDate dueDate3 = LocalDate.of(2022, 3, 15);
    // Assignments
    AssignmentImpl assignment1 = new AssignmentImpl("A04", "COMP 301", dueDate2);
    AssignmentImpl assignment2 = new AssignmentImpl("Lab 2", "COMP 211", dueDate3);
    AssignmentImpl assignment3 = new AssignmentImpl("Worksheet 3", "PSYC 101", dueDate1);
    // Assignment List (Iterable object);
    List<Assignment> assignmentList = new ArrayList<>();
    assignmentList.add(assignment1);
    assignmentList.add(assignment2);
    assignmentList.add(assignment3);

    //Create the iterator
    AssignmentIterator iterator = new AssignmentIterator(assignmentList);

    //Printing output
    while (iterator.hasNext()) {
      Assignment nextAssignment = iterator.next();
      System.out.println(
              nextAssignment.getCourseName()
              + " "
              + nextAssignment.getName()
              + " due in "
              + nextAssignment.getDaysTilDue()
              + " days.");
    }
  }
}
