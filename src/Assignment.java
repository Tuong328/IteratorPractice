import java.time.LocalDate;

public interface Assignment {

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
}
