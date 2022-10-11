package kr.altumlab.homepage.domain;

import kr.altumlab.homepage.domain.enums.BoardType;
import kr.altumlab.homepage.entity.AuditEntity;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 게시판
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString(callSuper = true, of = {})
@Table(name = "board")
public class Board extends AuditEntity {

    /**
     * 게시판 종류
     */
    @Enumerated(EnumType.STRING)
    @Column(length = 7)
    BoardType boardType;

    /**
     * 제목
     */
    @NotEmpty()
    String title;

    /**
     * 본문
     */
    @Column(columnDefinition = "text")
    String contents;

    /**
     * 첨부파일
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    List<Attachment> attachmentList = new ArrayList<>();
    @Transient
    List<MultipartFile> tempFileList;
    @Transient
    List<Long> delAttachIdList;

}
