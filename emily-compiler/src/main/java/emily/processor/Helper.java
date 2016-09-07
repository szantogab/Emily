package emily.processor;

import com.squareup.javapoet.TypeName;

/**
 * Created by szantogabor on 07/09/16.
 */

public class Helper {
    public static boolean isSharedPrefPrimitive(TypeName typeName) {
        return typeName == TypeName.INT || typeName == TypeName.FLOAT || typeName == TypeName.BOOLEAN || typeName == TypeName.LONG || (typeName.toString().equals("java.lang.String"));
    }

    public static String toFirstCharLower(String fieldName)
    {
        char c[] = fieldName.toCharArray();
        c[0] = Character.toLowerCase(c[0]);
        return new String(c);
    }
}
