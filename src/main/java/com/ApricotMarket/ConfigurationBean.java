package com.ApricotMarket;

import com.ApricotMarket.repository.*;
import com.ApricotMarket.service.ItemService;
import com.ApricotMarket.service.ItemServiceImpl;
import com.ApricotMarket.service.checkService;
import com.ApricotMarket.service.checkServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class ConfigurationBean {
    private final DataSource datasource;
    private EntityManager em;
    private final UserRepository userRepository;
    public ConfigurationBean(DataSource datasource, EntityManager em, UserRepository userRepository) {
        this.datasource = datasource;
        this.em = em;
        this.userRepository = userRepository;

    }

//    @Bean
//    public UserService userService(){ return new UserServiceImpl(userRepository);
//    }
    @Bean
    public ItemRepository itemRepository() { return new ItemMemoryRepository(em);
    }
    @Bean
    public ItemService itemService(){ return new ItemServiceImpl(itemRepository());
    }

    @Bean
    public checkRepository checkRepository() { return new checkMemoryRepository(em);
    }
    @Bean
    public checkService checkService(){ return new checkServiceImpl(checkRepository());
    }

}
