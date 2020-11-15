package models;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Country {
    private String name;
    private String shortName;
    private ObjectId id;

    public ObjectId getId()
    {
        return id;
    }
    private void setId(ObjectId id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getShortName()
    {
        return shortName;
    }
    public void setAmount(String shortName)
    {
        this.shortName = shortName;
    }

    public Country(Document doc)
    {
        this.setId((ObjectId)doc.get("_id"));
        this.setName((String)doc.get("name"));
        this.setAmount((String) doc.get("shortName"));
    }
}
