import java.time.LocalDate;
import java.time.Period;


public class AssignmentImpl implements Assignment{
    private final String name;
    private final String courseName;
    private LocalDate dueDate;
    private final LocalDate currentDate;

    public AssignmentImpl(String name, String courseName, LocalDate dueDate) {
        if (name == null) {
            throw new IllegalArgumentException("Name is null");
        }
        if (courseName == null) {
            throw new IllegalArgumentException("Course Name is null");
        }
        if (dueDate == null) {
            throw new IllegalArgumentException("Due Date is null");
        }

        this.name = name;
        this.courseName = courseName;
        this.dueDate = dueDate;
        this.currentDate = LocalDate.now();

        if (dueDate.isBefore(currentDate)) {
            throw new IllegalArgumentException("Due date can't be before current date");
        }
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCourseName() {
        return courseName;
    }

    @Override
    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public LocalDate getCurrentDate() {
        return currentDate;
    }

    @Override
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public int getDaysTilDue() {
    return Period.between(getCurrentDate(), getDueDate()).getDays();
    }
}
