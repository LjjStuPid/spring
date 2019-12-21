package com.ljj.demo;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setUsername("rewrewr");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        HessianOutput hessianOutput = new HessianOutput(bos);
        hessianOutput.writeObject(user);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        HessianInput hessianInput = new HessianInput(bis);
        User user1 = (User) hessianInput.readObject();
        System.out.println(user1);
    }
}
