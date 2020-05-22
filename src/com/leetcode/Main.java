package com.leetcode;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    /* To use this leetcode catalog, simply run main and provide a parameter which is the #### of the problem associated to leetcode
    *
    */
    public static void main(String[] args) {
        Integer selectedProblem;
        Scanner myObj = new Scanner(System.in);
        if(args[0] != null){
            selectedProblem = ValidateInput(args[0]);
        }
        else{
            System.out.println("Please enter the leet code problem you want to run: ");
            String inputedIntger = myObj.nextLine();
            selectedProblem = ValidateInput(inputedIntger);
        }
        if(selectedProblem == -1){
            main(args);
        }
        else{
            Class classTemp = null;
            try {
                classTemp = Class.forName("com.leetcode.problems.Problem"+selectedProblem.toString());
                Object problemConstructor = classTemp.getConstructor();
                ((Constructor) problemConstructor).newInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }


    }

    public static Integer ValidateInput(String stringToCheck){
        Integer validatedInteger = 0;
        try{
            validatedInteger = Integer.valueOf(stringToCheck);
            Class.forName("com.leetcode.problems.Problem"+validatedInteger.toString());
        }
        catch(ClassNotFoundException e ) {
            System.out.println("Error: Problem "+validatedInteger.toString()+" does not exist");
            exit(-1);
        }
        catch(Exception e){
            System.out.println("Error: Invalid Integer value entered");
            exit(-1);
        }
        return validatedInteger;
    }
}
