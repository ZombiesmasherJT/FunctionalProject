package FuncPro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentList {



        private static void addstudents(List<StudentRecord> studentRecords) {
            Scanner scanner = new Scanner(System.in);

            // Use a Supplier to create new StudentRecord instances based on console input
            Supplier<StudentRecord> recordSupplier = () -> {



                System.out.print("Enter StudentID: ");
                int studentID = Integer.parseInt(scanner.nextLine());

                if(studentID == -1) {
                    return new StudentRecord(-1, "", "", "",  "",0, new ArrayList<Integer>(), 0);
                }

                System.out.print("Enter firstname: ");
                String firstname = scanner.nextLine();


                System.out.print("Enter lastname: ");
                String lastname = scanner.nextLine();


                System.out.print("Enter coursename: ");
                String Coursename = scanner.nextLine();

                System.out.println("enter module: ");
                String module = scanner.nextLine();

                System.out.print("Enter age: ");
                int age = Integer.parseInt(scanner.nextLine());


                System.out.print("Enter comma-separated modulemarks(): ");
                List<Integer> moduleMarks = Stream.of(scanner.nextLine().split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()

                        );

                System.out.print("Enter courseYear: ");
                int courseYear = Integer.parseInt(scanner.nextLine());

                return new StudentRecord( studentID, firstname, lastname ,Coursename, module,age, moduleMarks, courseYear);
            };

            // Infinite stream of new records until the user decides to stop
            studentRecords.addAll(
                    Stream.generate(recordSupplier)
                            .takeWhile(record -> record.studentID() != -1)
                            .collect(Collectors.toList())
            );
        }



        private static void removeStudent(List<StudentRecord> studentRecords, int studentIDToRemove) {



            Predicate<StudentRecord> studentIDPredicate = student -> student.studentID() == studentIDToRemove;

            boolean removed = studentRecords.removeIf(studentIDPredicate);

            if (removed) {
                System.out.println("Student with ID " + studentIDToRemove + " removed successfully.");
            } else {
                System.out.println("Student with ID " + studentIDToRemove + " not found in the records.");
            }
        }








        public static void main(String[] args) {
            // write your code here



            //student info = student
            // var ListView = new ListView<StudentRecord>();



            List<StudentRecord> students = new ArrayList<>(List.of(
                    new StudentRecord(
                            1991,
                            "jordam",
                            "meech",
                            "Computer science",
                            "into to programming",
                            19,
                            List.of(74, 98, 45),
                            1
                    ),

                    new StudentRecord(
                            4001,
                            "Gabriel",
                            "Taylour",
                            "Art",
                            "group project ",
                            23,
                            List.of(65, 98, 24),
                            2

                    ),



                    new StudentRecord(
                            8906,
                            "jack",
                            "welsh",
                            "IT",
                            "intro to data systems",
                            21,
                            List.of(65, 98, 24),
                            1

                    ),



                    new StudentRecord(
                            7567,
                            "Daisy",
                            "Mills",
                            "Design",
                            "filter",
                            13,
                            List.of(65, 98, 24),
                            3

                    ),




                    new StudentRecord(
                            7,
                            "Gabriel",
                            "Taylour",
                            "Design",
                            "templates",
                            18,
                            List.of(65, 98, 24),
                            4



                    ),


                    new StudentRecord(
                            626204,
                            "jESSIQA",
                            "Alex",
                            "Art",
                            "des",
                            22,
                            List.of(65, 47, 24),
                            1



                    ),


                    new StudentRecord(
                            7890,
                            "mary",
                            "anne",
                            "History",
                            "intro to history",
                            25,
                            List.of(65, 98, 24),
                            3



                    ),


                    new StudentRecord(
                            1256,
                            "gracie",
                            "fisher",
                            "Bioligly",
                            "intordcution to the humane body",
                            22,
                            List.of(65, 98, 24),
                            2



                    ),

                    new StudentRecord(
                            3267,
                            "abi",
                            "mayor",
                            "Art",
                            "templates",
                            20,
                            List.of(65, 98, 24),
                            4



                    ),

                    new StudentRecord(
                            8360,
                            "Dan",
                            "Marc",
                            "Art",
                            "design view",
                            24,
                            List.of(65, 98, 24),
                            6

                    )

            )


            );




            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter a student ID to search on this console:");
            int queryStudentID = scanner.nextInt();

            students.stream()
                    .filter(r -> r.studentID() == queryStudentID)
                    .map(student -> queryStudentID + " from our records we have found: " + student)
                    .forEach(System.out::println);


            System.out.println("Enter a student  to search on this console:");
            String Queryname = scanner.next();

            students.stream()
                    .filter(student -> student.firstName().equalsIgnoreCase(Queryname))
                    .map(student -> Queryname + "from our records we have found: " + student)
                    .forEach(System.out::println);


            System.out.println("enter students course");
            String CourseName = scanner.next();

            students.stream()
                    .filter(student -> student.course().equalsIgnoreCase(CourseName))
                    .map(student -> CourseName + "from our records we have found " + student)
                    .forEach(System.out::println);

            System.out.println("enter a students module");
            String Module = scanner.next();

            students.stream()
                    .filter(student -> student.Module().equalsIgnoreCase(Module))
                    .map(student -> Module + "from our records we have found" + student)
                    .forEach(System.out::println);




            System.out.println("Enter a single letter to filter students:");
            String queryLetter = scanner.next();

            students.stream()
                    .filter(student -> student.firstName().toLowerCase().startsWith(queryLetter)
                            && student.firstName().length() == 1)
                    .map(student -> queryLetter + " - Student found: " + student.firstName())
                    .forEach(System.out::println);


            //Query of interest

            Predicate<StudentRecord> courseBefore2 =
                    student -> student.courseYear() < 2; // 20 - > The year filter

            students.stream()
                    .filter(courseBefore2)
                    .forEach(item -> System.out.println(item));


            addstudents(students);


            int studentIDToRemove = 1991;                                // Replace with the actual ID you want to remove
            removeStudent(students, studentIDToRemove);


            System.out.println(students);

        }


    }


