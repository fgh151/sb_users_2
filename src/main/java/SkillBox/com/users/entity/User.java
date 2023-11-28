package SkillBox.com.users.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user")
@SQLDelete(sql = "UPDATE user SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "father_name")
    private String fatherName;

    private String gender;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    // Ссылка на картинку-аватар.
    @Column(name = "avatar_url")
    private String avatarUrl;

    // Информация о пользователе (небольшое поле о себе)
    @Column(columnDefinition = "TEXT")
    private String about;

    // Hard skills (навыки)
    @Column(name = "hard_skills", columnDefinition = "TEXT")
    private String hardSkills;

    // Никнейм
    private String nikname;

    // Почта
    private String email;

    // Номер телефона.
    private String phone;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = Boolean.FALSE;

    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<Subscription> subscriptionSet;

    //    Информация о подписках на других пользователей.
    public User(String firstName, String lastName, String fatherName, String gender, Date birthday, Date createdAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.gender = gender;
        this.birthday = birthday;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}