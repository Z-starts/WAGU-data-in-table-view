/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examples.set2;

import wagu.Board;
import wagu.Table;
import wagu.TableHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Thedath Oudarya
 */
public class A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> headersList = Arrays.asList("NAME", "GENDER", "MARRIED", "AGE", "SALARY($)");
        List<List<String>> rowsList = Arrays.asList(
                Arrays.asList("Eddy", "Male", "No", "23", "1200.27"),
                Arrays.asList("Libby", "Male", "No", "17", "800.50"),
                Arrays.asList("Rea", "Female", "No", "30", "10000.00"),
                Arrays.asList("Deandre", "Female", "No", "19", "18000.50"),
                Arrays.asList("Alice", "Male", "Yes", "29", "580.40"),
                Arrays.asList("Alyse", "Female", "No", "26", "7000.89"),
                Arrays.asList("Venessa", "Female", "No", "22", "100700.50")
        );
        Board board = new Board(75);
        String tableString = board.setInitialBlock(new Table(board, 75, headersList, rowsList).tableToBlocks()).build()
                .getPreview();
        System.out.println(tableString);

        List<BeanA> rowsList2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            BeanA a = new BeanA();
            a.setAge(i);
            a.setName(String.format("name %d", i * 8));
//            a.setGender(String.format("name %d", i));
            a.setMarried(String.format("name %d", i));
            a.setSalary(133.33D * i);
            rowsList2.add(a);
        }

        TableHelper.getInstance().printOut(headersList, rowsList2, 200, 100);
    }


    public static class BeanA {
        private String name;
        private String gender;
        private String married;
        private int age;
        private double salary;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getMarried() {
            return married;
        }

        public void setMarried(String married) {
            this.married = married;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }
    }

}
