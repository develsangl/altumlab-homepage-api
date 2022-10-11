package kr.altumlab.homepage.domain;

import kr.altumlab.homepage.domain.enums.FileType;
import kr.altumlab.homepage.entity.AuditEntity;
import kr.altumlab.homepage.utils.FileUtils;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString(callSuper = true, of = {})
@Table(name = "attachment")
public class Attachment extends AuditEntity {

    /**
     * 저장경로
     */
    @Column(nullable = false)
    private String storedPath;

    /*
    * 파일 종류
    * */
    @Enumerated(EnumType.STRING)
    FileType fileType;
    /**
     * 원본 이름
     */
    @Column(nullable = false)
    private String originalFilename;
    /**
     * 저장된 이름
     */
    @Column(nullable = false)
    private String storedFilename;
    /**
     * 사이즈
     */
    @Column(nullable = false)
    private long size;
    /**
     * MIME TYPE
     */
    @Column(nullable = false, length = 127)
    private String mimeType;
    /**
     * HASH
     */
    @Column(nullable = false, updatable = false, length = 255)
    private String hash;



    @Builder
    public Attachment(String storedPath, FileType fileType, String originalFilename, String storedFilename, long size, String mimeType, String hash) {
        this.storedPath = storedPath;
        this.fileType = fileType;
        this.originalFilename = originalFilename;
        this.storedFilename = storedFilename;
        this.size = size;
        this.mimeType = mimeType;
        this.hash = hash;
    }

    public Attachment(Long id) {
        super.id = id;
    }

    @PrePersist
    protected void onCreated() {
        super.setCreated(LocalDateTime.now());
//        super.setCreatedBy(SecurityHolder.getLoginUser());
    }
    @PreUpdate
    protected void onUpdated() {
        super.setUpdated(LocalDateTime.now());
//        super.setUpdatedBy(SecurityHolder.getLoginUser());
    }

    public static Attachment create(String storedPath, FileType fileType, String originalFilename, String storedFilename, long size, String mimeType) {
        return Attachment.builder()
                .storedPath(storedPath)
                .fileType(fileType)
                .originalFilename(originalFilename)
                .storedFilename(storedFilename)
                .size(size)
                .mimeType(mimeType)
                .hash(FileUtils.makeHash(UUID.randomUUID().toString()))
                .build();
    }

}
