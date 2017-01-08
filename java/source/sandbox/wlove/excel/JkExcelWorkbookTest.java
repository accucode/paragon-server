package sandbox.wlove.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class JkExcelWorkbookTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args) throws Exception
    {
        new JkExcelWorkbookTest().run();
        System.out.println("ok.");
    }

    //##################################################
    //# run
    //##################################################

    private void run() throws Exception
    {
        try (Workbook book = new XSSFWorkbook())
        {
            createWith(book);
        }
    }

    private void createWith(Workbook book) throws IOException, FileNotFoundException
    {
        CreationHelper creationHelper = book.getCreationHelper();

        Sheet sheet = book.createSheet();

        DataFormat df = book.createDataFormat();

        Font font1 = createFont1(book);
        Font font2 = createFont2(book);

        CellStyle style1 = createStyle1(book, df, font1);
        CellStyle style2 = createStyle2(book, df, font2);

        for ( int rownum = 0; rownum < 30; rownum++ )
        {
            Row r = sheet.createRow(rownum);
            {
                Cell cell1;
                cell1 = r.createCell(0);
                cell1.setCellType(Cell.CELL_TYPE_STRING);
                cell1.setCellValue(rownum + .1);
                cell1.setCellStyle(style1);

                Cell cell2;
                cell2 = r.createCell(1);
                cell2.setCellValue(creationHelper.createRichTextString("Hello!"));
                cell2.setCellStyle(style2);
            }
        }

        save(book);
    }

    private Font createFont1(Workbook book)
    {
        Font e;
        e = book.createFont();
        e.setFontHeightInPoints((short)12);
        e.setColor(IndexedColors.BLACK.getIndex());
        e.setBoldweight(Font.BOLDWEIGHT_BOLD);
        return e;
    }

    private Font createFont2(Workbook book)
    {
        Font e;
        e = book.createFont();
        e.setFontHeightInPoints((short)10);
        e.setColor(IndexedColors.RED.getIndex());
        e.setBoldweight(Font.BOLDWEIGHT_BOLD);
        return e;
    }

    private CellStyle createStyle1(Workbook book, DataFormat df, Font font1)
    {
        CellStyle e;
        e = book.createCellStyle();
        e.setFont(font1);
        e.setDataFormat(df.getFormat("#,##0.0"));
        return e;
    }

    private CellStyle createStyle2(Workbook book, DataFormat df, Font font2)
    {
        CellStyle e;
        e = book.createCellStyle();
        e.setBorderBottom(e.BORDER_THIN);
        e.setDataFormat(df.getFormat("text"));
        e.setFont(font2);
        return e;
    }

    private void save(Workbook book) throws IOException, FileNotFoundException
    {
        String filename = "/temp/workbook.xlsx";
        try (FileOutputStream out = new FileOutputStream(filename))
        {
            book.write(out);
        }
    }
}
