/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package varianta.seven.action;

import java.util.Scanner;

/**
 *
 * @author Sukhocheva Maryana
 */
public class Action {
    
    String pattern = "(\\s)+|($)";

    /**
     *
     * @return
     */
    public String[] Numbers() {
        boolean result;
        float number;
        String[] masNum = null;
        try (Scanner scan = new Scanner(System.in)) {
            result = false;
            String str = scan.nextLine();
            for (String retval : str.split(pattern)) {
                try {
                    if (!retval.isEmpty()) {
                        number = Float.valueOf(retval);
                        result = true;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Неверный формат чисел!");
                    result = false;
                    break;
                }
            }
            scan.close();
            if (result) {
                masNum = str.split(pattern);
            }
        }
        return masNum;
    }
    
    public boolean uniqueNumber(String str) {
          int[] nums = new int[10]; 
          boolean result = true;
          for (int i = 0; i < str.length(); i++) {
              nums[Character.getNumericValue(str.charAt(i))]++;
           }
                  for (int i = 0; i < 10; i++) {
                    if (nums[i] >1) {
                        result=false;
                    }
                  }
          return result;
              }
        
    /**
     *
     * @param mas
     */
    public void CompareNumbers(String[] mas) {
       String uniqueCount="";
       for (int i = 0; i < mas.length; i++) {
           if (this.uniqueNumber(mas[i])) {
               uniqueCount=mas[i];
               break;
           }
        }
       if (!uniqueCount.isEmpty()){
            System.out.println("Число, состоящее только из различных цифр "+uniqueCount);
        } else {
            System.out.println("Чисел, состоящих только из различных цифр, нет!");
       }
    }
}
