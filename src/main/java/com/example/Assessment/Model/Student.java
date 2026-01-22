package com.example.Assessment.Model;

public class Student {

    private String name;
    private int age;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age =age;
    }

    public int getAge(){
        return age;
    }

    public Student( String name, int age){
        this.age=age;
        this.name=name;
    }
    public Student( ){        
    }



    
}
