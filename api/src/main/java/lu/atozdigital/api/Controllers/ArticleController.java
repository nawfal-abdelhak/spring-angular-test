package lu.atozdigital.api.Controllers;

import lu.atozdigital.api.DTO.ArticleDTO;
import lu.atozdigital.api.Services.IArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/articles")
@CrossOrigin("*")
@RestController
public class ArticleController {

    private  final IArticleService articleService;

    public ArticleController(IArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("")
    public ResponseEntity<?> addArticle(@RequestParam("name") String name ,@RequestParam("price") String price ,@RequestParam("image") MultipartFile image) throws IOException {
        return ResponseEntity.ok().body(articleService.addArticle(name,price,image));
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?> getArticle( @PathVariable Long id){
        ArticleDTO articleDTO = articleService.getArticle(id);
        if(articleDTO==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("not found");
        }
        else {
            return ResponseEntity.ok().body(articleDTO);
        }
    }

    @GetMapping ("")
    public ResponseEntity<?> getAllArticles(){
        List<ArticleDTO> articles = articleService.getAllArticles();
        return ResponseEntity.ok().body(articles);
    }
}
