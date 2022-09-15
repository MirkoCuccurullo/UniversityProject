public class Student extends Person{
    private String group;
    private int[] grades = new int[4];
    private boolean hasPassed = true;
    private int numberOfRetakes;


    public Student(String firstName, String lastName, int ID, String birthDate, String group, String username, String password){
        super(firstName, lastName, ID, birthDate);
        this.group = group;
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getGroup(){
        return group;
    }
    public int getGrade(String subjectName){
        switch (subjectName){
            case "Java":
                return grades[0];
            case "CSharp":
                return grades[1];
            case "Python":
                return grades[2];
            case "PHP":
                return grades[3];
            default: return -1;
        }
    }
    public void setGrade(int grade, String subjectName) {
        switch (subjectName) {
            case "Java" :
                grades[0] = grade;
                break;
            case "CSharp" :
                grades[1] = grade;
                break;
            case "Python" :
                grades[2] = grade;
                break;
            case "PHP" :
                grades[3] = grade;
                break;
            default :

        }
    }

@Override
    public String toString(){
        return super.toString() + "         " + group;
    }

    public int getNumberOfRetakes(){
        int numberOfRetakes = 0;
        for (int grade : grades){
            if (grade < 55){
                numberOfRetakes++;
            }
        }
        return numberOfRetakes;
    }

    public String getHasPassedAsString(){
        for (int grade : grades){
            if (grade < 55){
                hasPassed = false;
                break;
            }
        }
        if (hasPassed){
            return "Passed";
        }
        else{
            return "Not Passed";
        }
    }

    public String toStringWithGrades(){
        return this + "          " + grades[0] + "          " + grades[1] + "           " + grades[2] + "          " + grades[3];
    }
}
