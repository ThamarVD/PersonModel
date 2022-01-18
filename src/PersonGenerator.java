import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static ArrayList<String> people = new ArrayList<String>();
    public static Scanner userIn = new Scanner(System.in);

    public static void main(String[] args) {
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "/PersonTestData.txt");
        String id = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int yearOfBirth = 0;

        do{
            id = SafeInput.getNonZeroLenString(userIn, "What is this person's id number");
            firstName = SafeInput.getNonZeroLenString(userIn, "What is this person's First Name");
            lastName = SafeInput.getNonZeroLenString(userIn, "What is this person's Last Name");
            title = SafeInput.getNonZeroLenString(userIn, "What is this person's title (Mr., Mrs., Ms., Dr., etc.)");
            yearOfBirth = SafeInput.getInt(userIn, "What year was this person born");

            people.add(id + ", " + firstName + ", " + lastName + ", " + title + ", " + yearOfBirth);
        }while(SafeInput.getYNConfirm(userIn, "Would you like to add another person"));

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for(String rec : people)
            {
                writer.write(rec, 0, rec.length());
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
