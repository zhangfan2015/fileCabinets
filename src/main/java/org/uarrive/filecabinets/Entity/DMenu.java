package org.uarrive.filecabinets.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "d_menu")
public class DMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "url", length = 200)
    private String url;

    @Column(name = "method", length = 200)
    private String method;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pId")
    private DMenu p;

    @Column(name = "type", length = 1)
    private String type;

    @Column(name = "route", length = 20)
    private String route;

    @Column(name = "menuIndex")
    private Integer menuIndex;

}