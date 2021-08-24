package com.larkas.springit.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Link extends Auditable {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String url;

    @OneToMany(mappedBy = "link")
    @ToString.Exclude
    private List<Comment> comments = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Link link = (Link) o;

        return Objects.equals(id, link.id);
    }

    @Override
    public int hashCode() {
        return 1900957211;
    }
}
