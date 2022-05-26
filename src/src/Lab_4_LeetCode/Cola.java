package Lab_4_LeetCode;

public class Cola {

    //problema 1. N°1700. Number of Students Unable to Eat Lunch

    public int countStudents(int[] students, int[] sandwiches) {

        int zeros= 0;
        int unos= 0;

        for(int student: students){

            if(student==0){

                zeros++;

            }else{
                unos++;

            }
        }


        for (int sandwich: sandwiches){

            if(sandwich==0){

                if(zeros==0){
                    return unos;

                }zeros--;

            }else{

                if(unos==0){
                    return zeros;

                }unos--;
            }

        }return 0;
    }
}
