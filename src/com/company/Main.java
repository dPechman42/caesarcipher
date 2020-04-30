package com.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void encrypt(String sourceFile, String encodedFile, int shift) throws IOException
    {
        StringBuffer result = new StringBuffer();
        char c;
        File source = new File(sourceFile);
        File encode =new File(encodedFile);

        try (Scanner input = new Scanner(source);
             PrintStream output = new PrintStream(encode))
        {
            while (input.hasNextLine())
            {
                String text = input.nextLine();
                for (int i = 0; i < text.length(); i++)
                {
                    c = text.charAt(i);
                    if (Character.isLetter(c))
                    {
                        if (Character.isUpperCase(text.charAt(i)))
                        {
                            c = (char) (((int) text.charAt(i) +
                                    shift - 65) % 26 + 65);
                        } else
                            {
                            c = (char) (((int) text.charAt(i) +
                                    shift - 97) % 26 + 97);
                            }
                    }
                    result.append(c);

                }
                result.append("\n");
            }
            output.println(result + "\n");
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What shift would you like your Caesar cipher to be? ");
        int shift = scanner.nextInt();
        String sourceFile = "SourceFile.txt";
        String encodedFile = "encodedFile.txt";
        encrypt(sourceFile, encodedFile, shift);
    }
}

