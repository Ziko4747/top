package kz.kaznitu.lesson.models;

import javax.persistence.*;

@Entity
public class Zhurnal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String familia ;
    private String imia ;
    private String baga ;

    public Zhurnal(){}

    public Zhurnal(String familia, String imia, String baga) {
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

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getImia() {
        return imia;
    }

    public void setImia(String imia) {
        this.imia = imia;
    }

    public String getBaga() {
        return baga;
    }

    public void setBaga(String baga) {
        this.baga = baga;
    }
}
