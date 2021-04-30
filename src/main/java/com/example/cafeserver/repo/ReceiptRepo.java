package com.example.cafeserver.repo;
import com.example.cafeserver.model.Receipt;
import org.springframework.data.jpa.repository.*;

public interface ReceiptRepo extends JpaRepository<Receipt, Integer>{

    Receipt findReceiptById(Integer id);
}
