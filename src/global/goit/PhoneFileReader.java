package global.goit;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneFileReader {
    public void printPhone() {
        String file = "C:\\homeworkspacegoit\\PhoneReader\\src\\global\\goit\\files\\file.txt";

        try (FileReader is = new FileReader(file)) {
            Scanner scanner = new Scanner(is);
            String oneLine;

            while (scanner.hasNext()) {
                oneLine = scanner.nextLine();

                if (phoneValidator(oneLine)) {
                    System.out.println(oneLine);
                }
            }
        } catch (IOException e) {
            System.out.println("False file name");
        }
    }

    private boolean phoneValidator(String string) {
        Pattern pattern = Pattern.compile("^((\\(\\d{3}\\) ?)|(\\d{3}-?))\\d{3}-?\\d{4}$");
        Matcher matcher = pattern.matcher(string);

        return matcher.matches();
    }
}
