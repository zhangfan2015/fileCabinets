package org.uarrive.filecabinets.DTO;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.uarrive.filecabinets.Entity.DSysSetting}
 */
@Data
public class DSysSettingDto implements Serializable {
    private Integer id;
    private String key;
    private String value;
}