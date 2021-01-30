package com.example.OnlineBankingSystemAPJ2.services;

import java.util.List;

public interface EntityService<V> {
    V save(V entity);

    void update(V entity);

    void remove(V entity);
}
