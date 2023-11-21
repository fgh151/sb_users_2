package SkillBox.com.users.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "subscription")
@NoArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subscriber_id")
    private User subscriber;

    @Column(name = "subscriber_id", insertable = false, updatable = false  )
    private Long subscriberId;

    @Column(name = "user_id")
    private Long userId;
}
