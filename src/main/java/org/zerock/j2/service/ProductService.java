package org.zerock.j2.service;

import jakarta.transaction.Transactional;
import org.zerock.j2.dto.PageRequestDTO;
import org.zerock.j2.dto.PageResponseDTO;
import org.zerock.j2.dto.ProductDTO;
import org.zerock.j2.dto.ProductListDTO;

@Transactional
public interface ProductService {

    PageResponseDTO<ProductListDTO> list(PageRequestDTO requestDTO);
    Long register(ProductDTO productDTO);
    ProductDTO readOne(Long pno);

    void remove(Long pno);

    void modify(ProductDTO productDTO);



}
