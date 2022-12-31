package lu.atozdigital.api.Services;

import lu.atozdigital.api.DTO.ArticleDTO;
import lu.atozdigital.api.DTO.OrderDTO;
import lu.atozdigital.api.Models.Article;
import lu.atozdigital.api.Models.Order;
import lu.atozdigital.api.Repositories.IOrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements  IOrderService{

    private final IOrderRepository orderRepository;

    private final ModelMapper modelMapper;

    public OrderServiceImpl(IOrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDTO> ordersDTO= orders.stream().map(order -> modelMapper.map(order,OrderDTO.class)).collect(Collectors.toList());
        return ordersDTO;
    }

    @Override
    public OrderDTO addOrder(List<ArticleDTO> articlesDTO) {
        Order order = new Order();
        String generatedString = getRadmomString();
        order.setReference(generatedString);
        List<Article> articles= articlesDTO.stream().map(articleDTO -> modelMapper.map(articleDTO,Article.class)).collect(Collectors.toList());
        order.setArticles(articles);
        orderRepository.save(order);
        OrderDTO orderDTO= modelMapper.map(order, OrderDTO.class);
        return orderDTO;
    }

    @Override
    public Order updateOrder(Long id, List<ArticleDTO> articlesDTO) {

        List<Article> articles= articlesDTO.stream().map(articleDTO -> modelMapper.map(articleDTO,Article.class)).collect(Collectors.toList());
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent()){
         order.get().setArticles(articles);
            OrderDTO orderDTO= modelMapper.map(order, OrderDTO.class);
           return orderRepository.save(order.get());
        }
        else{
            return null;
        }

    }

    public  String getRadmomString() {
        String SALTCHARS = "abcdefghijklmnopqrstuvyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 9) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}
