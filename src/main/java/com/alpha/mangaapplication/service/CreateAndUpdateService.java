package com.alpha.mangaapplication.service;

public interface CreateAndUpdateService<I,V>{
    Object create(V value);

    V update(I id,V value);
}
