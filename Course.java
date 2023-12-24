import java.util.*;
class Course {
    String courseCode;
    String title;
    String description;
    int capacity;
    String schedule;
    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return courseCode + " - " + title + " (" + schedule + ") - Capacity: " + capacity;
    }
}
 class Student {
    int studentID;
    String name;
    List<Course> registeredCourses = new ArrayList<>();

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }
}
class CourseRegistrationSystem {
    public static void main(String[] args) {
        List<Course> courseDatabase = new ArrayList<>();
        List<Student> studentDatabase = new ArrayList<>();
        courseDatabase.add(new Course("CSE101", "Introduction to Computer Science", "Fundamental concepts of programming", 50, "Mon-Wed-Fri, 9:00 AM"));
        courseDatabase.add(new Course("MAT201", "Linear Algebra", "Study of linear equations and matrices", 40, "Tue-Thu, 1:00 PM"));
        courseDatabase.add(new Course("AIML301", "Introduction to AI", "Fundamental concepts of AI programming", 55, "sat-Sun, 9:00 AM"));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Course Listing");
            System.out.println("2. Student Registration");
            System.out.println("3. Course Removal");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Available Courses:");
                    for (Course course : courseDatabase) {
                        System.out.println(course);
                    }
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    int studentID = scanner.nextInt();
                    System.out.print("Enter student name: ");
                    scanner.nextLine(); 
                    String studentName = scanner.nextLine();
                    Student student = new Student(studentID, studentName);
                    studentDatabase.add(student);
                    System.out.println("Available Courses:");
                    for (Course course : courseDatabase) {
                        System.out.println(course);
                    }
                    System.out.print("Enter the course code to register: ");
                    String courseCode = scanner.next();

                    Course selectedCourse = null;
                    for (Course course : courseDatabase) {
                        if (course.courseCode.equals(courseCode)) {
                            selectedCourse = course;
                            break;
                        }
                    }
                    if (selectedCourse != null && selectedCourse.capacity > 0) {
                        student.registeredCourses.add(selectedCourse);
                        selectedCourse.capacity--;
                        System.out.println("Registration successful.");
                    } else {
                        System.out.println("Invalid course code or course is full.");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
