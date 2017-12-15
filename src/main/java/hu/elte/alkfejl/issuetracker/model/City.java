package hu.elte.alkfejl.issuetracker.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author Gabesz
 */

@Entity
@Table(name = "CITIES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class City extends BaseEntity implements Serializable{
    
    @Column(nullable = false, unique = true)
    private String name;
    
    @OneToMany(mappedBy="city")
    @JsonIgnore
    private List<Restaurant> restaurants;
}
