package org.zerock.j2.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long pno;
    private String pname;
    private String pdesc;
    private int price;

    @Builder.Default
    private List<String> images = new ArrayList<>();

    // 등록, 수정시 업로드된 파일을 수집하는 용도
    @Builder.Default
    private List<MultipartFile> files = new ArrayList<>();


}
