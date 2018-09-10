package com.javarush.task.MVC.task3608.model;

/**
 * Created by Alexander on 03.02.2018.
 */
public interface Model {
    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();
    void loadUserById(long userId);
    void deleteUserById(long id);
    void changeUserData(String name, long id, int level);
}
