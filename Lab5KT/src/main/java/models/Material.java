package models;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Material
{
    private String name;
    private int amount;
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

    public Integer getAmount()
    {
        return amount;
    }
    public void setAmount(Integer amount)
    {
        this.amount = amount;
    }

    public Material(Document doc)
    {
        this.setId((ObjectId)doc.get("_id"));
        this.setName((String)doc.get("name"));
        this.setAmount((Integer) doc.get("amount"));
    }
}