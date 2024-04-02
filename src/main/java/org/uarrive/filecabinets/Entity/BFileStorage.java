package org.uarrive.filecabinets.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "b_file_storage")
public class BFileStorage {
    @Id
    @Column(name = "id", nullable = false, length = 32)
    private String id;

    @Column(name = "originName", length = 200)
    private String originName;

    @Column(name = "givenName", length = 200)
    private String givenName;

    @Column(name = "fileSize")
    private Double fileSize;

    @Column(name = "fileType", length = 20)
    private String fileType;

    @Column(name = "fileDirectory", length = 200)
    private String fileDirectory;

    @Column(name = "createTime")
    private Long createTime;

    @Column(name = "creatorId", length = 32)
    private String creatorId;

    @Column(name = "expireDate")
    private Long expireDate;

    @Column(name = "isDel")
    private Integer isDel;

    @Column(name = "delTime")
    private Long delTime;

}