# Iterator Design Practice
Designing an iterator that iterates through a list of assignments that contain
respective due dates, and returns the assignments in the order that they are due.

### Given Classes and Interfaces
`AssignmentImpl` - Implementation of `Assignment` interface that contains these fields
```
private final String name;
private final String courseName;
private LocalDate dueDate;
private final LocalDate currentDate;  
```
and implements these methods

```
/**Returns the name of the assignment **/
String getName();

/**Returns the name of the course that the assignment is for**/
String getCourseName();

/**Returns the due date of the assignment **/
LocalDate getDueDate();

/**Returns the current date**/
LocalDate getCurrentDate();

/**Changes the due date**/
void setDueDate(LocalDate dueDate);

/**Gets days left to complete**/
int getDaysTilDue();
```
## Objective
Create an iterator class `AssignmentIterator` that implements
`Iterator<Assignment>` with constructor
```java
public AssignmentIterator(Iterable<Assignment> assignments) {}
```
Where `assignments` is the list of assignments that we will iterate through.

An `AssignmentIterator` should first look for assignments that are due today (0 days away),
and after all the assignments due today  are returned, the iterator should start
over and start searching for assignments that are due in 1 day, then 2 days, etc...

Keep iterating until ALL assignments have been returned

An `AssignmentIterator` should contain private instance fields for:
1) An iterator of assignment objects
2) An iterable list of assignment objects
3) An assignment field to hold the next assignment
4) An integer to see how many days away our iterator will check
5) An integer to represent the total count of assignments in the iterable list
6) An integer to represent the assignments we have RETURNED.
#### Creating an Assignment Object for Testing
make sure to 'import java.time.LocalDate;'
```java
LocalDate dueDate = LocalDate.of(2022, 3, 14);
String assignmentName = "A05-Driver";
String courseName = "COMP 301";
AssignmentImpl assignment1 = new AssignmentImpl(assignmentName, courseName, dueDate);
```
