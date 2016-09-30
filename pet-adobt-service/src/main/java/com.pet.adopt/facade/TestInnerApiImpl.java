package com.pet.adopt.facade;

import com.pet.adopt.innerapi.TestInnerApi;
import org.springframework.stereotype.Service;

/**
 * Created by mengfei on 2016/9/29.
 */
@Service
public class TestInnerApiImpl implements TestInnerApi{
    @Override
    public void test() {
        System.out.print("testdubbo");
    }
}
