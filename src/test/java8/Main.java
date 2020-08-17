package test.java8;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String ags[]) {
    }

    public static String valueOfString(Object obj) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (!Optional.ofNullable(obj).isPresent()) {
            return null;
        } else {
            Class<?> clazz = obj.getClass();
            if (String.class.isAssignableFrom(clazz)) {
                return String.valueOf(obj);
            } else if (Long.class.isAssignableFrom(clazz)) {
                return String.valueOf(obj);
            } else {
                return Date.class.isAssignableFrom(clazz) ? sdf.format(obj) : String.valueOf(obj);
            }
        }
    }

    public static Object invokeGet(Class<?> clazz, Object obj, String propertyName) {
        Object value = null;

        try {
            PropertyDescriptor descriptor = getPropertyDescriptor(clazz, propertyName);
            value = descriptor.getReadMethod().invoke(obj);
        } catch (InvocationTargetException | IntrospectionException | IllegalAccessException var5) {
            System.out.println("获取参数异常: " + value.toString());
        }

        return value;
    }

    private static PropertyDescriptor getPropertyDescriptor(Class<?> clazz, String propertyName) throws IntrospectionException {
        assert clazz != null;
        assert propertyName != null;
        String readMethodName = "get" + capitalize(propertyName);
        if (clazz == Boolean.TYPE) {
            readMethodName = "is" + capitalize(propertyName);
        }

        String writeMethodName = "set" + capitalize(propertyName);
        return new PropertyDescriptor(propertyName, clazz, readMethodName, writeMethodName);
    }

    public static String capitalize(final String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }

        final int firstCodepoint = str.codePointAt(0);
        final int newCodePoint = Character.toTitleCase(firstCodepoint);
        if (firstCodepoint == newCodePoint) {
            // already capitalized
            return str;
        }

        final int newCodePoints[] = new int[strLen]; // cannot be longer than the char array
        int outOffset = 0;
        newCodePoints[outOffset++] = newCodePoint; // copy the first codepoint
        for (int inOffset = Character.charCount(firstCodepoint); inOffset < strLen; ) {
            final int codepoint = str.codePointAt(inOffset);
            newCodePoints[outOffset++] = codepoint; // copy the remaining ones
            inOffset += Character.charCount(codepoint);
        }
        return new String(newCodePoints, 0, outOffset);
    }

}

class Person {
    private String name;
    private Date birthday;

    public Person(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}