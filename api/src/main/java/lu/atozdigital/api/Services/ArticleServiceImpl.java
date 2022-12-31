package lu.atozdigital.api.Services;

import lu.atozdigital.api.DTO.ArticleDTO;
import lu.atozdigital.api.Models.Article;
import lu.atozdigital.api.Repositories.IArticleRepository;
import lu.atozdigital.api.Utils.ImageHandler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements  IArticleService{

    private final IArticleRepository articleRepository;

    private final ModelMapper modelMapper;

    public ArticleServiceImpl(IArticleRepository articleRepository, ModelMapper modelMapper) {
        this.articleRepository = articleRepository;
        this.modelMapper = modelMapper;
    }



    @Override
    public ArticleDTO addArticle(String name, String price, MultipartFile image) throws IOException {
        Article article = new Article();
        article.setPicture(ImageHandler.uploadFile(image));
        article.setName(name);
        article.setPrice(Integer.parseInt(price));

        ArticleDTO articledto = modelMapper.map(article,ArticleDTO.class);
        articleRepository.save(article);
        return articledto ;


    }

    @Override
    public ArticleDTO getArticle(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        if(article.isPresent()){
            ArticleDTO articledto= modelMapper.map(article, ArticleDTO.class);
            return articledto;
        }

        return null;

    }

    @Override
    public List<ArticleDTO> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        List<ArticleDTO> articlesDTO= articles.stream().map(article -> modelMapper.map(article,ArticleDTO.class)).collect(Collectors.toList());
        return articlesDTO;
    }


}
