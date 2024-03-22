import java.io.FileWriter;

public class FIleWriteApp {
    public static void main(String[] args) {
        try{
            // Specify the file name and path
            String fileName = "example.txt";

            // Create FileWriter object with the file name
            FileWriter fileWriter = new FileWriter(fileName);

            // Write some text into the file
            fileWriter.write("Hello, this is a simple example of file writing in Java.");

            // Close the FileWriter to release resources
            fileWriter.close();

            System.out.println("Data has been written to the file successfully.");
        }catch(

                Exception e)
        {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
