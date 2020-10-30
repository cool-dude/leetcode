import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
public class PrintLastKLines {
    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(System.in);
            String strFilePath = reader.nextLine();
            Scanner fileReader = new Scanner(new FileReader(strFilePath));
            int kLines = Integer.parseInt(reader.nextLine());
            String[] strArrayLines =
                    new String[kLines];
            int nLines = 0;
            //Total number of
            //lines in file
            int ind = 0;
            //running index
            if( kLines > 0) {
                while( fileReader.hasNext()) {
                    strArrayLines[ind] = fileReader.nextLine();
                    ind = (ind + 1)%kLines;
                    nLines++;
                }
            }
            //If file contains less number of lines than kLines
            if( nLines < kLines ) {
                //print from the beginning of the array
                for( i = 0; i < nLines; i++) {
                    System.out.println( strArrayLines[i] );
                }
            }
            else {
                for( i = 0; i < kLines; i++ ) {
                    System.out.println( strArrayLines[ind] );
                    ind = (ind+1) % kLines;
                }
            }
        }
        catch (FileNotFoundException fnfe) {
            System.out.println( fnfe.getMessage() );
        }
        catch(NumberFormatException nfe) {
            System.out.println( nfe.getMessage() );
        }
    }
}