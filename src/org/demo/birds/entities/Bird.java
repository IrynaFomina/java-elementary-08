package org.demo.birds.entities;

/**
 * Bird.
 *
 * Должны быть следущие свойства:
 *
 * name  тип String
 * livingArea тип String
 * size – число с плавающей точкой, может быть незаполненным (Double).
 *
 */
public class Bird {
    private String name;
    private String livingArea;
    private Double size;

    public Bird(String name, String livingArea, Double size) {
        this.name = name;
        this.livingArea = livingArea;
        this.size = size;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Bird{");
        sb.append("name='").append(name).append('\'');
        sb.append(", livingArea='").append(livingArea).append('\'');
        sb.append(", size=").append(size);
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLivingArea() {
        return livingArea;
    }

    public void setLivingArea(String livingArea) {
        this.livingArea = livingArea;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}
