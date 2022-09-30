package type;

import org.apache.ibatis.reflection.TypeParameterResolver;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TestType {

    SubClassA<Long> sa = new SubClassA<>();

    @Test
    public void testCase() throws NoSuchFieldException {
        Field f = ClassA.class.getDeclaredField("map");
        System.out.println(f.getGenericType()); //java.util.Map<K, V>
        System.out.println(f.getGenericType() instanceof ParameterizedType);//true

        Type type = TypeParameterResolver.resolveFieldType(f, ParameterizedTypeImpl.make(SubClassA.class, new Type[]{Long.class}, TestType.class));
//        Type type = TypeParameterResolver.resolveFieldType(f, TestType.class.getDeclaredField("sa").getGenericType());
        System.out.println(type.getClass()); //class org.apache.ibatis.reflection.TypeParameterResolver$ParameterizedTypeImpl

        ParameterizedType p = (ParameterizedType) type;
        System.out.println(p.getRawType()); //interface java.util.Map
        System.out.println(p.getOwnerType());//null
        for (Type t : p.getActualTypeArguments()) { //class java.lang.Long,class java.lang.Long
            System.out.println(t);
        }
    }
}
