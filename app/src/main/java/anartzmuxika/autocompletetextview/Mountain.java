package anartzmuxika.autocompletetextview;

/**
 * Created by anartzmugika on 18/5/16.
 */
public class Mountain {
    private String id, name;

    public Mountain ()
    {

    }
    public Mountain (String id, String name)
    {
        setId(id);
        setName(name);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
