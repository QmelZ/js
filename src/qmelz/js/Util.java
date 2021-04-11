package qmelz.js;

import arc.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Util{

    // java version differences are h, and this class breaks in some cases so dont use it

    public void set(Class<?> type, String name, Object value) throws Throwable{
        Field field = type.getDeclaredField(name);
        field.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(null, value);
    }

    public Object get(Class<?> type, String name){
        try{
            Field field = type.getDeclaredField(name);
            field.setAccessible(true);

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

            return field.get(null);
        }catch(Throwable c){
            Log.err(c);
            return null;
        }
    }
}
