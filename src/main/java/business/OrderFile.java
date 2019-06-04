/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author Marcela
 */
public class OrderFile {

    public void execute(String rute) {
        try {
            Stream<Path> _listFile = Files.list(Paths.get(rute));

            Path directory = Paths.get(rute + "\\pdf");
            if (Files.notExists(directory)) {
                Files.createDirectories(directory);
            }
            _listFile.forEach(path -> {
                if (isPDF(path)) {
                    System.out.println(path.toFile().getName());
                    try {
                        Path fileReplace = Files.createFile(Paths.get(rute + "\\pdf\\" + path.toFile().getName()));
                        Files.copy(path, fileReplace, StandardCopyOption.REPLACE_EXISTING);
                        path.toFile().delete();
                    } catch (IOException ex) {
                        Logger.getLogger(OrderFile.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isPDF(Path file) {
        boolean result = false;
        result = file.toFile().getName().contains(".pdf");
        return result;
    }

}
