package ru.rombyator.dao;

import ru.rombyator.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAll();
    public void add(User user);
    public User getById(long id);
    public void update(User user);
    public void delete(long id);
}
