package models;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Worker
{
    private String name;
    private String phone;
    private String salary;
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

    public String getPhone()
    {
        return phone;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getSalary()
    {
        return salary;
    }
    public void setSalary(String salary)
    {
        this.salary = salary;
    }

    public Worker(Document doc)
    {
        this.setId((ObjectId)doc.get("_id"));
        this.setName((String)doc.get("name"));
        this.setPhone((String)doc.get("phone"));
        this.setSalary((String)doc.get("salary"));
    }
}
