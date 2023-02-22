package kazusek.csvupdater.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Files")
public class File {
    private String name;
    @Id
    private String url;

    public File(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public File() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
