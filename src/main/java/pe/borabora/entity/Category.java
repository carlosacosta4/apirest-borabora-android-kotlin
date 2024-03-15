package pe.borabora.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_category;

    @Column(name = "name", length = 180)
    private String name;

    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy="category")
    @JsonManagedReference("id_category")
    private Collection<Product> products = new ArrayList<>();

}

