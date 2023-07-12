package org.zerock.j2.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@ToString
public class ProductDTO {

    private Long pno;
    private String pname;
    private String pdesc;
    private int price;

    private List<String> images;

    // 등록, 수정시 업로드된 파일을 수집하는 용도
    private List<MultipartFile> files;


}
