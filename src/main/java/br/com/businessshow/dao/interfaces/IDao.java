package br.com.businessshow.dao.interfaces;

import java.util.List;

public interface IDao<T> {

    void save(T obj);

    void update(T obj);

    void delete(Integer id);

    T findById(Integer id);

    List<T> findAll();

}
