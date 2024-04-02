package org.uarrive.filecabinets.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link org.uarrive.filecabinets.Entity.DMenu}
 */
@Data
public class DMenuDto implements Serializable {
    Integer id;
    String name;
    String url;
    String method;
    String type;
    String route;
    Integer menuIndex;


}