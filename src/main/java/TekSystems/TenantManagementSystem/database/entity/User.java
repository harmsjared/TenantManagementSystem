package TekSystems.TenantManagementSystem.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "first", nullable = false)
    private String firstName;

    @Column(name = "last", nullable = false)
    private String lastName;

    @Column(name = "contact", nullable = true)
    private String contactNumber;

    @Column(name = "email" , nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "status", nullable = false)
    private String status;

    private Date createdAt;
    private Date updatedAt;
    @PrePersist
    protected void onCreate() {this.createdAt = new Date();}
    @PreUpdate
    protected void onUpdate() {this.updatedAt = new Date();}
}
