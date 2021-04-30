package com.example.cafeserver.service;
import com.example.cafeserver.model.Import;
import com.example.cafeserver.model.Material;
import com.example.cafeserver.model.Receipt;
import com.example.cafeserver.repo.ImportRepo;
import com.example.cafeserver.repo.MaterialRepository;
import com.example.cafeserver.repo.ReceiptRepo;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Service
public class ReceiptService {

    @Autowired
    private ReceiptRepo receiptRepo;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private ImportRepo importRepo;

    public Receipt generateReceipt(){
        Receipt result = receiptRepo.save(
                new Receipt(
                        LocalDate.now(),
                        Receipt.PROCESS,
                        0
                )
        );
        return result;
    }

    public Receipt create(List<Material> materialList){
        Receipt receipt = generateReceipt();
        List<Import> importList = new ArrayList<Import>();
        for (Material i : materialList){
            if(materialService.isExistMaterial(i.getMaterialname()) == false){
                return null;
            } else {
                Material material = materialRepository.findMaterialByMaterialname(i.getMaterialname());
                material.setQuantity(material.getQuantity() + i.getQuantity());
                materialRepository.save(material);
                Import forsave = new Import(
                  receipt,
                  material,
                  i.getQuantity(),
                  i.getQuantity() * material.getUnitprice()
                );
                importList.add(forsave);
            }
        }
        for (Import i : importList){
            receipt.setTotal(receipt.getTotal() + i.getSubtotal());
        }
        receiptRepo.save(receipt);
        importRepo.saveAll(importList);
        return receipt;
    }

    public Receipt check(Integer receipt_id){
        Receipt receipt = receiptRepo.findReceiptById(receipt_id);
        receipt.setStatus(Receipt.DONE);
        receiptRepo.save(receipt);
        return receipt;
    }

    public List<Import> getAllImportInReceipt(Integer receipt_id){
        List<Import> importList = new ArrayList<Import>();
        for (Import i : importRepo.findAll()){
            if(i.getReceipt().getId() == receipt_id){
                importList.add(i);
            }
        }
        return importList;
    }

    public String deleteReceipt(Integer receipt_id){
        if(receiptRepo.findReceiptById(receipt_id) == null) {
            return "Id not found !";
        }
        List<Import> importList = getAllImportInReceipt(receipt_id);
        importRepo.deleteInBatch(importList);
        receiptRepo.deleteById(receipt_id);
        return "Deleted !";
    }

    public List<Receipt> getAllReceipt(){
        return receiptRepo.findAll();
    }
}
