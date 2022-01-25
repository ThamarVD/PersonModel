import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static ArrayList<Person> people = new ArrayList<Person>();
    public static Scanner userIn = new Scanner(System.in);

    public static void main(String[] args) {
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "/PersonTestData.txt");

        String firstName;
        String lastName;
        String ID;
        String title;
        int YOB;

        do{
            ID = SafeInput.getNonZeroLenString(userIn, "What is this person's id number");
            firstName = SafeInput.getNonZeroLenString(userIn, "What is this person's First Name");
            lastName = SafeInput.getNonZeroLenString(userIn, "What is this person's Last Name");
            title = SafeInput.getNonZeroLenString(userIn, "What is this person's title (Mr., Mrs., Ms., Dr., etc.)");
            YOB = SafeInput.getInt(userIn, "What year was this person born");

            people.add(new Person(firstName, lastName, ID, title, YOB));
        }while(SafeInput.getYNConfirm(userIn, "Would you like to add another person"));

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for(Person rec : people)
            {
                writer.write(rec.toCSVDataRecord(), 0, rec.toCSVDataRecord().length());
                writer.newLine();

            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
