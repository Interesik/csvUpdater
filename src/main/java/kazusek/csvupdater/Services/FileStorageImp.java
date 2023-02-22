package kazusek.csvupdater.Services;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import kazusek.csvupdater.ClientRepository;
import kazusek.csvupdater.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class FileStorageImp implements FileStorage{
    @Autowired
    ClientRepository clientRepository;

    @Override
    public void save(MultipartFile file) {
        try {
            InputStreamReader reader = new InputStreamReader(file.getInputStream());
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            List<String[]> rows = csvReader.readAll();
            for(String[] row : rows) {
             clientRepository.save(new Client(row[0],row[1],row[2]));
            }
        } catch (IOException e) {
            throw new RuntimeException("File already exists");
        }
    }

    @Override
    public List<Client> loadAll() {
        return (List<Client>) clientRepository.findAll();
    }
}
