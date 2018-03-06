package kz.kaznitu.lesson.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String familia;
    private String imia;
    private int baga;


    public Student(String familia, String imia, int baga) {
        this.familia = familia;
        this.imia = imia;
        this.baga = baga;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
