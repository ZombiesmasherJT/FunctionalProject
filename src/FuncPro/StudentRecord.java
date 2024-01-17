package FuncPro;

import java.util.List;

public record StudentRecord(

        int studentID,

        String firstName,

        String LastName,

        String course,

        String Module,

        int age,

        List<Integer> moduleMarks,

        int courseYear

)

{}