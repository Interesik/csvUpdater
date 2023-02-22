package kazusek.csvupdater.Services;

import kazusek.csvupdater.model.Client;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileStorage {
    public void save(MultipartFile file);

    List<Client> loadAll();
}
