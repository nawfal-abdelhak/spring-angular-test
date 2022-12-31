package lu.atozdigital.api.Services;

import lu.atozdigital.api.DTO.ArticleDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IArticleService {


    ArticleDTO getArticle(Long id);

    List<ArticleDTO> getAllArticles();

    ArticleDTO addArticle(String name, String price, MultipartFile image) throws IOException;
}
