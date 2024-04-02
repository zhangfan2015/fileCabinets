package org.uarrive.filecabinets.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "d_sys_setting")
public class DSysSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "`key`", length = 200)
    private String key;

    @Column(name = "value", length = 500)
    private String value;

}