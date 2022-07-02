package ru.homework;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.homework.service.FileService;
import ru.homework.service.NumberService;
import ru.homework.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration
@AutoConfigureMockMvc
public class HomeworkTest {

    @Test
    public void testHomeworkRealisation() throws IOException {
        Path path = FileUtils.findFolderWithFiles();

        FileService fileService = new FileService();
        List<File> fileList = fileService.findAllCorrectFilesInFolder(path.toString());

        NumberService findNumbers = new NumberService();
        System.out.println(findNumbers.getAllActualPhoneNumbers(fileList));
    }
}
