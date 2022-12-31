package lu.atozdigital.api.Services;


import lu.atozdigital.api.DTO.ArticleDTO;
import lu.atozdigital.api.DTO.OrderDTO;
import lu.atozdigital.api.Models.Order;

import java.util.List;

public interface IOrderService {
    List<OrderDTO> getAllOrders();

    OrderDTO addOrder(List<ArticleDTO> articlesDTO);

    Order updateOrder(Long id, List<ArticleDTO> articlesDTO);
}
