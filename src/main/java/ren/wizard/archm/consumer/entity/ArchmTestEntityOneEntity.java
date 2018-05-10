package ren.wizard.archm.consumer.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author uyangjie
 */
@Entity
@Table(name = "archm_test_entity_one")
public class ArchmTestEntityOneEntity {
    private int id;
    private String thisIsAString;
    private Timestamp createdTime;
    private Timestamp updatedTime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "this_is_a_string", nullable = true, length = 32)
    public String getThisIsAString() {
        return thisIsAString;
    }

    public void setThisIsAString(String thisIsAString) {
        this.thisIsAString = thisIsAString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArchmTestEntityOneEntity that = (ArchmTestEntityOneEntity) o;

        if (id != that.id) return false;
        if (thisIsAString != null ? !thisIsAString.equals(that.thisIsAString) : that.thisIsAString != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (thisIsAString != null ? thisIsAString.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "created_time", nullable = true, updatable = false)
    @CreationTimestamp
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    @Basic
    @Column(name = "updated_time", nullable = true)
    @UpdateTimestamp
    public Timestamp getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }
}
