package com.hargeliya.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIgnoreProperties
public class Theme implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotEmpty
    @Size(max = 50)
    private String themeName;
    @OneToMany(mappedBy = "theme", cascade = CascadeType.ALL)

    private List<ThemeOption> options = new ArrayList<>();
    @Column
    private String option1;
    @Column
    private String option2;
    @Column
    private int quantity1;

    @Column
    private int quantity2;

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public int getQuantity1() {
        return quantity1;
    }

    public void setQuantity1(int quantity1) {
        this.quantity1 = quantity1;
    }

    public int getQuantity2() {
        return quantity2;
    }

    public void setQuantity2(int quantity2) {
        this.quantity2 = quantity2;
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date resolveDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public List<ThemeOption> getOptions() {
        return options;
    }

    public void setOptions(List<ThemeOption> options) {
        this.options = options;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.themeName);
        hash = 73 * hash + Objects.hashCode(this.options);
        hash = 73 * hash + Objects.hashCode(this.createDate);
        hash = 73 * hash + Objects.hashCode(this.resolveDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Theme other = (Theme) obj;
        if (!Objects.equals(this.themeName, other.themeName)) {
            return false;
        }
        if (!Objects.equals(this.options, other.options)) {
            return false;
        }
        return Objects.equals(this.createDate, other.createDate);
    }

    @Override
    public String toString() {
        return "Theme{" + "id=" + id
                + ", themeName=" + themeName
                + ", options=" + options
                + ", createDate=" + createDate
                + ", resolveDate=" + resolveDate + '}';
    }
}
