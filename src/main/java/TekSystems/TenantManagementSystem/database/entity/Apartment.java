package TekSystems.TenantManagementSystem.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "apartment")
public class Apartment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "apartment")
    private List<Assignments> assignments;

    @Column(name = "status", nullable = true, unique = false)
    private String status;

    @Column(name = "floor_plan", nullable = false, unique = false)
    private String floorPlan;

    @Column(name = "baths", nullable = true, unique = false)
    private String baths;

    @Column(name = "beds", nullable = true, unique = false)
    private String beds;

    @Column(name = "rent", nullable = true, unique = false)
    private String rent;

    @Column(name = "square_Feet", nullable = true, unique = false)
    private String squareFeet;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate = new Date();

}