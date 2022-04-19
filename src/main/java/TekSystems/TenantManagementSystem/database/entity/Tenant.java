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
@Builder
@Entity
@Table(name = "tenant")
public class Tenant {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "tenant" )
    private List<Assignment> assignments;

    @Column(name = "first", nullable = false, unique = false)
    private String firstName;

    @Column(name = "last", nullable = false, unique = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = false)
    private String email;

    @Column(name = "password", nullable = false, unique = false)
    private String password;

    @Column(name = "contact", nullable = false, unique = false)
    private String contactNumber;

    @Column(name = "status", nullable=false, unique = false)
    private String status;

    private Date createdAt;
    private Date updatedAt;
    @PrePersist
    protected void onCreate() {this.createdAt = new Date();}
    @PreUpdate
    protected void onUpdate() {this.updatedAt = new Date();}
}
