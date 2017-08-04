package io.aera.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Arrays;

@Entity
@Table(name = "DOCUMENTS")
public class Document {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "DOC_ID", columnDefinition = "CHAR(32)")
    private String documentId;

    @Column(name = "name", length = 100)
    @NotEmpty
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "extension")
    @NotEmpty
    private String extension;

    @Column(name = "type", length = 100)
    @NotEmpty
    private String type;

    @Column(name="date_modified")
    private LocalDateTime dateModified = LocalDateTime.now();

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "document_content")
    @NotEmpty
    private byte[] content;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public LocalDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDateTime dateModified) {
        this.dateModified = dateModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Document)) return false;

        Document document = (Document) o;

        if (!getDocumentId().equals(document.getDocumentId())) return false;
        if (!getName().equals(document.getName())) return false;
        if (getDescription() != null ? !getDescription().equals(document.getDescription()) : document.getDescription() != null)
            return false;
        if (!getExtension().equals(document.getExtension())) return false;
        if (!getType().equals(document.getType())) return false;
        if (!getDateModified().equals(document.getDateModified())) return false;
        return Arrays.equals(getContent(), document.getContent());
    }

    @Override
    public int hashCode() {
        int result = getDocumentId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + getExtension().hashCode();
        result = 31 * result + getType().hashCode();
        result = 31 * result + getDateModified().hashCode();
        result = 31 * result + Arrays.hashCode(getContent());
        return result;
    }
}
