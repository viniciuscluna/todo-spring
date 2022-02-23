package br.com.letscode.todolist.model;


import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
        @Id @GeneratedValue
        private Integer id;
        private UUID userId;
        private String title;
        private String description;
        private State state;
        private Date createdAt;
        private Date updateA;
        @OneToMany(mappedBy = "task")
        private Collection<Comment> comments;

        @PrePersist
        void createdAt() {
                this.createdAt = new Date();
        }

        @PreUpdate
        void updatedAt() {
                this.updateA = new Date();
        }
}
