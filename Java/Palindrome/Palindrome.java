package com.company;

public class Palindrome {
    public String toUpperString(String text)
    {
        return text.toUpperCase();
    }
    public int Polindromemethod(String palindrome)
    {
        palindrome=toUpperString(palindrome);
        for (int i = 0; i <palindrome.length() ; i++) {
            if(palindrome.charAt(i)==palindrome.charAt(palindrome.length()-i)){
                System.out.println("Bu bir palindrome!");
                break;
            }
            else
            {
                System.out.println("Bu bir palindrome değil!");
                break;
            }
        }
        return 0 ;
    }
}
