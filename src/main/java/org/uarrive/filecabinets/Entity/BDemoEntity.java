package org.uarrive.filecabinets.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;
@Data
@Entity(name = "b_demo")
@Table(name = "b_demo", schema = "paperless4cbu", catalog = "")
public class BDemoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = true, length = 200)
    private String name;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BDemoEntity that = (BDemoEntity) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
