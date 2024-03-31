package MyException;

import java.util.InputMismatchException;

public class MyException extends Exception{

    public MyException(String mesg){
        super(mesg);
        System.out.println(mesg);


    }
    public static boolean isStringOnlyAlphabet(String str)
    {

        return ((str != null) && (!str.equals(""))
                && (str.matches("^[a-zA-Z]*$")));
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public static void PhoneNumberException(String mob_no)throws MyException {

        if (mob_no.length() != 10 || isStringOnlyAlphabet(mob_no) ){
            throw new MyException("PhoneNumberException \nEnter 10 Digit Phone number");


        }

    }
    public static void  agevalid(int age)throws MyException{

        if ( age<10 )
        {
            throw new MyException("Age is too Small\nEnter Valid age");
        }


    }
    public static void wrongInput(String input)throws MyException{
        if (!isStringOnlyAlphabet(input)){
            throw new MyException("---->Enter Valid Input<----");
        }
    }


    }

