package ConfigurationHelper.Utilites;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReaderUtils {
    private static final Logger log = Logger.getLogger(ExcelReaderUtils.class);
    private static final String filePath = "src/test/resources/TestData/UtilFiles/ClientLoginCred.xlsx";

    public Map<String, String> getLoginCredential(int rowIndex) throws IOException {
        Map<String, String> loginCredentials = new HashMap<String, String>();
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        Row row = sheet.getRow(rowIndex);
        loginCredentials.put("username", row.getCell(0).getStringCellValue());
        loginCredentials.put("password", row.getCell(1).getStringCellValue());

        workbook.close();
        file.close();

        return loginCredentials;

    }
}
