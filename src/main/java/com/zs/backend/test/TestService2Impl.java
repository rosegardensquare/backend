package com.zs.backend.test;

import org.springframework.stereotype.Service;

@Service
public class TestService2Impl implements TestService{
    @Override
    public void add() {
        System.out.println("----");
    }
}
