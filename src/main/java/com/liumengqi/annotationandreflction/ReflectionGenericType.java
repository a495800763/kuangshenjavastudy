package com.liumengqi.annotationandreflction;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
/**
 * 通过反射获取泛型
 */
public class ReflectionGenericType {
    public void test01(Map<String,User>map, List<User>List){
        System.out.println("test01");
    }

    public Map<String,User> test02(){
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = ReflectionGenericType.class.getMethod("test01", Map.class, List.class);
        //得到泛型参数的类型
        Type[] methodParameterTypes = method.getGenericParameterTypes();
        for (Type methodParameterType : methodParameterTypes) {
            //得到泛型参数，带泛型的类型，即可以得到 Map<String,User>
            // 但仍得不到泛型参数中的String和User类型
            System.out.println(methodParameterType);

            //得到泛型中的参数类型的真实类型
            if(methodParameterType instanceof ParameterizedType) {
                //得到真实的"Actual"类型
                Type[] actualTypeArguments = ((ParameterizedType) methodParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        }

        System.out.println("----------");
        //得到方法2的返回值类型
        method = ReflectionGenericType.class.getMethod("test02",null);
        Type genericReturnType = method.getGenericReturnType();
        //得到泛型中的参数类型的真实类型
        if(genericReturnType instanceof ParameterizedType){
            //得到真实的"Actual"类型
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }

    }
}
