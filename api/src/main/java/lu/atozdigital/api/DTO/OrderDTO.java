package lu.atozdigital.api.DTO;

import lu.atozdigital.api.Models.Article;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

public class OrderDTO {
    private Long id;

    public Long getId() {
        return id;
    }

    public OrderDTO() {
    }

    public OrderDTO(Long id, String reference, List<Article> articles, Date date) {
        this.id = id;
        this.reference = reference;
        this.articles = articles;
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private String reference ;

    private List<Article> articles ;

    private Date date ;
}
