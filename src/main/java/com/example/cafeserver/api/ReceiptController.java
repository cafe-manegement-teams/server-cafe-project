package com.example.cafeserver.api;

import com.example.cafeserver.model.Import;
import com.example.cafeserver.model.Material;
import com.example.cafeserver.model.Receipt;
import com.example.cafeserver.service.ReceiptService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/receipt")
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @GetMapping(path="all")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    List<Receipt> getAllReceipt(){
        return receiptService.getAllReceipt();
    }

    @PostMapping(path="create")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    Receipt generateReceipt(@RequestBody List<Material> materialList){
        return receiptService.create(materialList);
    }

    @PostMapping(path="{id}/check")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    Receipt check(@PathVariable(name="id") Integer receipt_id){
        return receiptService.check(receipt_id);
    }

    @GetMapping(path="{id}/all")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    List<Import> getAllImportInReceipt(@PathVariable(name="id") Integer id){
        return receiptService.getAllImportInReceipt(id);
    }

    @DeleteMapping(path="{id}/delete")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    String deleteBill(@PathVariable(name="id")Integer receipt_id){
        return receiptService.deleteReceipt(receipt_id);
    }
}
