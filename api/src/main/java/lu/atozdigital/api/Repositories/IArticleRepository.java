package lu.atozdigital.api.Repositories;


import lu.atozdigital.api.Models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArticleRepository extends JpaRepository<Article,Long> {
}
