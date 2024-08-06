package ConfigurationHelper.Utilites;

import java.io.*;

public class SequentialNumberUtil {
    private static final String FILE_PATH = System.getProperty("user.dir")+"/src/test/resources/TestData/UtilFiles/sequential_number.txt";

    //Method to get the next sequential number
    public static String getNextSequentialNumber() throws IOException {
        int currentNumber = 0;
    try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
        String line = bufferedReader.readLine();
        if(line != null && !line.trim().isEmpty()) {
            currentNumber = Integer.parseInt(line.trim());
        }
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    currentNumber++;
    try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH))){
        bufferedWriter.write(String.format("%03d", currentNumber)); //Format to 3 digit with leading zeros
    }catch (IOException e){
        throw new RuntimeException(e);
    }
    return String.format("%03d", currentNumber);
    }

}
