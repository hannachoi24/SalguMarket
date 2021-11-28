package com.ApricotMarket.repository;

import com.ApricotMarket.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

@Transactional
public class checkMemoryRepository implements checkRepository{

    public checkMemoryRepository(EntityManager em) {
        this.em = em;
    }

    private final EntityManager em;
    @Modifying
    @Override
    public int UserLogin(Long UserId) {
        int m = em.createQuery("update User w set w.log=1 where w.id =:id")
                .setParameter("id", UserId)
                .executeUpdate();
        return m;
    }

    @Modifying
    @Override
    public int UserLogout(Long UserId) {
        int m = em.createQuery("update User w set w.log=0 where w.id =:id")
                .setParameter("id", UserId)
                .executeUpdate();

        return m;
    }

    @Override
    public Optional<User> finduser(String username) {
        Optional<User> resultList = em.createQuery("select i from User i where i.username =:username", User.class)
                .setParameter("username",username)
                .getResultList().stream().findFirst();

        return resultList;
    }

    @Override
    public Optional<User> findloguser() {
        Optional<User> resultList = em.createQuery("select i from User i where i.log = 1", User.class)
                .getResultList().stream().findFirst();

        return resultList;
    }
}
