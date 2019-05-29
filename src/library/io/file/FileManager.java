package library.io.file;

import library.model.Library;

public interface FileManager {
    Library importData();
    void ExportData(Library library);
}
