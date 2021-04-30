package com.example.cafeserver.api;
import com.example.cafeserver.model.DeliveryBill;
import com.example.cafeserver.model.Export;
import com.example.cafeserver.model.Material;
import com.example.cafeserver.service.DeliveryBillService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/delivery")
public class DeliveryBillController {

    @Autowired
    private DeliveryBillService deliveryBillService;

    @GetMapping(path="all")
    public @ResponseBody
    List<DeliveryBill> getAllDelivery(){
        return deliveryBillService.getAllBill();
    }

    @PostMapping(path="create")
    public @ResponseBody
    List<Export> createDelivery(@RequestBody List<Material> materialList){
        return deliveryBillService.create(materialList);
    }

    @GetMapping(path="{id}/all")
    public @ResponseBody
    List<Export> getAllExportInBill(@PathVariable(name="id") Integer delivery_id){
        return deliveryBillService.getAllExportInBill(delivery_id);
    }

    @DeleteMapping(path="{id}/delete")
    public @ResponseBody
    String deleteBill(@PathVariable(name="id")Integer delivery_id){
        return deliveryBillService.deleteBill(delivery_id);
    }
}
