package sandbox.wlove.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class JkExcelStreamTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args) throws Exception
    {
        new JkExcelStreamTest().run();
        System.out.println("ok.");
    }

    //##################################################
    //# variables
    //##################################################

    private CellStyle _redStyle;

    //##################################################
    //# run
    //##################################################

    private void run() throws Exception
    {
        int bufferRows = 10;
        try (SXSSFWorkbook book = new SXSSFWorkbook(bufferRows))
        {
            installRedStyle(book);

            createSheet(book, "one");
            createSheet(book, "two");
            save(book);
            book.dispose();
        }
    }

    private void installRedStyle(Workbook book)
    {
        Font font;
        font = book.createFont();
        font.setFontHeightInPoints((short)12);
        font.setColor(IndexedColors.RED.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        DataFormat format;
        format = book.createDataFormat();
        format.getFormat("text");

        CellStyle style;
        style = book.createCellStyle();
        style.setDataFormat(format.getFormat("text"));
        style.setFont(font);
        _redStyle = style;
    }

    private void createSheet(SXSSFWorkbook book, String name)
    {
        SXSSFSheet sheet;
        sheet = book.createSheet(name);
        sheet.trackAllColumnsForAutoSizing();

        for ( int rowIndex = 0; rowIndex < 1000; rowIndex++ )
        {
            Row row = sheet.createRow(rowIndex);

            Cell cell;
            cell = row.createCell(0);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue("1111122222333334444455555");
            cell.setCellStyle(_redStyle);

            for ( int columnIndex = 1; columnIndex < 10; columnIndex++ )
            {
                cell = row.createCell(columnIndex);
                cell.setCellValue(formatCell(cell));
            }
        }

        sheet.autoSizeColumn(0);
    }

    private String formatCell(Cell cell)
    {
        return new CellReference(cell).formatAsString();
    }

    private void save(SXSSFWorkbook book) throws IOException, FileNotFoundException
    {
        try (OutputStream out = new FileOutputStream("/temp/stream.xlsx"))
        {
            book.write(out);
        }
    }
}
