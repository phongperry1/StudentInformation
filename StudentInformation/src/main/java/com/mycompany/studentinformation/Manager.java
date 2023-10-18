
package com.mycompany.studentinformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Manager {
    public int checkInputIntLimit(int min, int max) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                if(result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please check input");
            }
        }
    }
    
    public String checkInputString() {
        Scanner sc = new Scanner(System.in);
        while(true) {
        String result = sc.nextLine();
        if(result.length() == 0) {
            System.err.println("Not empty");
        } else {
            return result;
        }
    }
    }
    
    
    public boolean checkInputYN() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String result = sc.nextLine();
            if(result.length() == 1 && result.equalsIgnoreCase("Y")) {
                return true;
            } else if(result.length() == 1 && result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input again");
        }
    }
    
    
    public float checkInputFloat() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                float result = Float.parseFloat(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input again");
            }
        }
    }
    
    public void addStudent(ArrayList<Student> lt) {
        System.out.println("Please input student information: ");
        System.out.print("Name: ");
        String name = checkInputString();
        System.out.print("Classes: ");
        String classes = checkInputString();
        System.out.print("Mark: ");
        float mark = checkInputFloat();
        lt.add(new Student(name, mark, classes));
    }
    
    public void print(ArrayList<Student> lt) {
        if(lt.isEmpty()) {
            System.err.println("List empty");
            return;
        }
        Collections.sort(lt);
        for(int i = 0; i < lt.size(); i++) {
            System.out.println("-------Student " + i + 1 + "----------");
            System.out.println("Name: " + lt.get(i).getName());
            System.out.println("Classes: " + lt.get(i).getClasses());
            System.out.println("Mark: " + lt.get(i).getMark());
        }
    }
    
    public void display() {
        ArrayList<Student> lt = new ArrayList<>();
        addStudent(lt);
        while(true) {
            System.out.print("Do you want to enter more student information(Y/N): ");
            if(checkInputYN()) {
                addStudent(lt);
            } else {
                break;
            }
    }
        print(lt);
    }
}
