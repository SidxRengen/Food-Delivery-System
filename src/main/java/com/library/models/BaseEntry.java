package main.java.com.library.models;

import java.time.LocalDateTime;

public abstract class BaseEntry {
    private Long id;
    private LocalDateTime createdBy;
    private LocalDateTime modifiedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getModifiedBy() {
        return modifiedBy;
    }

    public void setCreatedBy(LocalDateTime createdBy) {
        this.createdBy = createdBy;
    }

    public void setModifiedBy(LocalDateTime modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
