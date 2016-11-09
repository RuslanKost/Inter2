package interMagg.controller;

import interMagg.model.Products;
import interMagg.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ProductsController {
    private ProductsService productsService;


    @Autowired
    @Qualifier(value = "productsService")
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping(value = "/prod", method = RequestMethod.GET)
    public String listBooks(Model model){
        model.addAttribute("products", new Products());
        model.addAttribute("listProducts", this.productsService.listProducts());

        return "produc";
    }

    @RequestMapping(value = "/produc/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("products") Products products){
        if(products.getId() == 0){
            this.productsService.addProducts(products);
        }else {
            this.productsService.updateProduct(products);
        }

        return "redirect:/prod";
    }

    @RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") int id){
        this.productsService.removeProduct(id);

        return "redirect:/prod";
    }

    @RequestMapping("/edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        model.addAttribute("product", this.productsService.getProductById(id));
        model.addAttribute("listProducts", this.productsService.listProducts());

        return "produc";
    }

    @RequestMapping("bookdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model){
        model.addAttribute("product", this.productsService.getProductById(id));

        return "bookdata";
    }


}
