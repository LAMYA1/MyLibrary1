package com.app.mylibrary.Modle;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "books")
public class Books {

    @PrimaryKey(autoGenerate = true)
    private int id ;
    private String image ;
    private String name ;

    public Books() {
    }

    public Books(String image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
