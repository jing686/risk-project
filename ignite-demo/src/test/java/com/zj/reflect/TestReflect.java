package com.zj.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author: zj
 * @Date: 2023/2/18 22:23
 * @Version: 1.0
 */
/*本类用于反射的测试*/
public class TestReflect {
    //1.可以创建程序的入口函数main()--此处不用
    //2.通过单元测试方法，获取目标类Student对应的字节码对象
    @Test
    public void getClazz() throws ClassNotFoundException {
        //练习获取字节码对象的3种方式
        Class<?> clazz1 = Class.forName("com.zj.reflect.Student");
        Class<?> clazz2 = Student.class;
        Class<?> clazz3 = new Student().getClass();

        //打印的是Student类对应的字节码对象
        System.out.println(clazz1);//class com.reflection.Student
        //获取Student类对应的字节码对象clazz1的名字
        System.out.println(clazz1.getName());//com.reflection.Student
        //通过Student类对应的字节码对象，获取Student类的类名
        System.out.println(clazz1.getSimpleName());
        //通过Student类对应的字节码对象，获取Student类对应的包对象
        System.out.println(clazz1.getPackage());
        //通过Student类对应的字节码对象，先获取Student类对应的包对象，再获取这个包对象的名字
        System.out.println(clazz1.getPackage().getName());
    }

    //4.通过单元测试方法，获取Student类中的成员变量
    @Test
    public void getFie() throws ClassNotFoundException, NoSuchFieldException {
        //1.获取Student类对应的字节码对象
        Class<?> clazz = Class.forName("com.zj.reflect.Student");
        //2.通过Student类对应的字节码对象获取Student类中的成员变量们
        Field[] fs = clazz.getFields();
        //3.遍历数组，获取Student类中的每个成员变量的具体信息
        /*注意！目前成员变量的修饰符必须是public的才能获取到*/
        for (Field f : fs) {
            System.out.println(f.getName());//通过本轮循环到的字段对象获取字段名
            System.out.println(f.getType());//通过本轮循环到的字段对象获取字段的类型
        }
        Field name = clazz.getDeclaredField("name");
        System.out.println(name.getName());
        System.out.println(name.getType());
    }

    //5.通过单元测试方法，获取Student类中的成员方法
    @Test
    public void getFunction() throws ClassNotFoundException {
        //1.获取Student类对应的字节码对象
        Class<?> clazz = Class.forName("com.zj.reflect.Student");
        //2.通过Student类对应的字节码对象获取Student类中的成员方法们
        Method[] ms = clazz.getMethods();
        //3.通过高效for循环遍历数组，拿到每一个方法对象
        for (Method m : ms) {
            System.out.println(m);//直接打印遍历到的方法对象
            System.out.println(m.getName());//通过方法对象获取方法名
            Class<?>[] pt = m.getParameterTypes();//通过方法对象获取方法所有参数的数组
            System.out.println(Arrays.toString(pt));//打印方法参数的数组
        }

    }

    //7.通过单元测试方法，创建Student目标类的对象
    @Test
    public void getObject() throws Exception {
        //1.获取字节码对象
        Class<?> clazz = Class.forName("com.zj.reflect.Student");

        //2.通过反射技术创建目标类的对象,注意抛出异常
        /*反射创建对象方案1：
            使用 目标类 的 无参构造 创建对象
        */
        Object o = clazz.newInstance();
        System.out.println(o);//这一步已经获取到了对象Student{name='null', age=0}

        /*反射创建对象方案2：
            使用 目标类 的 全参构造 创建对象
        * 思路：
        * 1.先获取指定的构造函数对象,注意需要指定构造函数的参数，传入的是.class字节码对象
        * 2.通过刚刚获取到的构造函数对象创建Student目标类的对象，并且给对象的属性赋值
        * */

        //3.获取目标类中指定的全参构造
        Constructor<?> c = clazz.getConstructor(String.class, int.class);
        //System.out.println(c);

        //4.通过获取到的构造函数：创建对象 + 给对象的属性赋值
        Object o2 = c.newInstance("赵六", 6);
        System.out.println(o2);
    }

    @Test
    public void methodInvokeTest() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> clazz = Class.forName("com.zj.reflect.Student");
        Method method = clazz.getDeclaredMethod("play");
        method.setAccessible(true);
        Object result = method.invoke(clazz.newInstance());
        System.out.println("result = " + result);
    }
}
