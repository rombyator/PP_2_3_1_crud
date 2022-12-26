package ru.rombyator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rombyator.dao.UserDao;
import ru.rombyator.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    @Override
    public List<User> getAll() {
        return dao.getAll();
    }

    @Override
    @Transactional
    public void add(User user) {
        dao.add(user);
    }

    @Override
    public User getById(long id) {
        return dao.getById(id);
    }

    @Override
    @Transactional
    public void update(User user) {
        dao.update(user);
    }

    @Override
    @Transactional
    public void delete(long id) {
        dao.delete(id);
    }
}
