package com.example.cafeserver.service;

import com.example.cafeserver.model.Export;
import com.example.cafeserver.model.Material;
import com.example.cafeserver.repo.DeliveryBillRepo;
import com.example.cafeserver.repo.ExportRepo;
import com.example.cafeserver.repo.MaterialRepository;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import com.example.cafeserver.model.DeliveryBill;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
@Service
public class DeliveryBillService {
    @Autowired
    private ExportRepo exportRepo;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private DeliveryBillRepo deliveryBillRepo;

    @Autowired
    private MaterialRepository materialRepository;

    public DeliveryBill generateBill(){
        DeliveryBill deliveryBill = deliveryBillRepo.save(
                new DeliveryBill(
                        LocalDate.now(),
                        DeliveryBill.PROCESS
                )
        );
        return deliveryBill;
    }

    public List<Export> create(List<Material> materialList){
        DeliveryBill deliveryBill = generateBill();
        List<Export> exportList = new ArrayList<Export>();
        for (Material i : materialList){
            if(materialService.isExistMaterial(i.getMaterialname()) == false){
                return null;
            } else {
                Material material = materialRepository.findMaterialByMaterialname(i.getMaterialname());
                if (material.getQuantity() == 0 || material.getQuantity() < i.getQuantity()){
                    i.setQuantity(material.getQuantity());
                    material.setQuantity(0);
                } else {
                    material.setQuantity(material.getQuantity() - i.getQuantity());
                }
                materialRepository.save(material);
                Export forsave = new Export(
                        deliveryBill,
                        material,
                        i.getQuantity()
                );
                exportList.add(forsave);
            }
        }
        exportRepo.saveAll(exportList);
        return exportList;
    }

    public DeliveryBill check(Integer delivery_id){
        DeliveryBill deliveryBill = deliveryBillRepo.findDeliveryBillById(delivery_id);
        deliveryBill.setStatus(DeliveryBill.DONE);
        deliveryBillRepo.save(deliveryBill);
        return deliveryBill;
    }


    public List<DeliveryBill> getAllBill(){
        return deliveryBillRepo.findAll();
    }

    public List<Export> getAllExportInBill(Integer delivery_id){
        List<Export> exportList = new ArrayList<Export>();
        for (Export i : exportRepo.findAll()){
            if(i.getDeliveryBill().getId() == delivery_id){
                exportList.add(i);
            }
        }
        return exportList;
    }

    public String deleteBill(Integer delivery_id){
        if(deliveryBillRepo.findDeliveryBillById(delivery_id) == null) {
            return "Id not found !";
        }
        List<Export> exportList = getAllExportInBill(delivery_id);
        exportRepo.deleteInBatch(exportList);
        deliveryBillRepo.deleteById(delivery_id);
        return "Deleted !";
    }
}
