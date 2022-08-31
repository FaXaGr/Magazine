package Magazine.service.Impl;

import Magazine.dto.ProductDto;
import Magazine.service.ExcelService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;
@Service
@RequiredArgsConstructor
public class Excel implements ExcelService {

    @Transactional
    public void export(Stream<ProductDto> productDtoStream, HttpServletRequest request, HttpServletResponse response) throws IOException {
        File file = new File("src\\main\\resources\\templates\\Excel.xlsx");
        file.createNewFile();
        XSSFWorkbook wob = new XSSFWorkbook(new FileInputStream(file));
        SXSSFWorkbook workbook =new SXSSFWorkbook(wob,1000);
        AtomicReference<SXSSFSheet> sheet = new AtomicReference<>(workbook.createSheet("Product"));
        AtomicInteger i = new AtomicInteger(sheet.get().getLastRowNum()+1);
        Row row1 = sheet.get().createRow(i.getAndIncrement());
        row1.createCell(0).setCellValue("id");
        row1.createCell(1).setCellValue("type_id");
        row1.createCell(2).setCellValue("name");
        row1.createCell(3).setCellValue("price");
        row1.createCell(4).setCellValue("amount");
        AtomicInteger k = new AtomicInteger(1);
        productDtoStream.forEach(productDto -> {
            Row row = sheet.get().createRow(i.getAndIncrement());
            if (i.get() == 1000000) {
                sheet.set(workbook.createSheet("Product" + k.getAndIncrement()));
                i.set(0);
                row = sheet.get().createRow(i.getAndIncrement());
                row.createCell(0).setCellValue("id");
                row.createCell(1).setCellValue("type_id");
                row.createCell(2).setCellValue("name");
                row.createCell(3).setCellValue("price");
                row.createCell(4).setCellValue("amount");

            }

            row.createCell(0).setCellValue(productDto.getId());
            row.createCell(1).setCellValue(productDto.getTypeId());
            row.createCell(2).setCellValue(productDto.getName());
            row.createCell(3).setCellValue(productDto.getPrice());
            row.createCell(4).setCellValue(productDto.getAmount());
        });
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=\"Excel.xlsx\"");
            workbook.write(response.getOutputStream());
            response.getOutputStream().close();
            workbook.close();
    }
}
