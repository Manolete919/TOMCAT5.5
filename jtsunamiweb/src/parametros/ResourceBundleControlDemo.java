package parametros;
import java.util.Locale;
import java.util.ResourceBundle;
//import java.util.ResourceBundle.Control;

public class ResourceBundleControlDemo {

   public static void main(String[] args) {

      // create a new ResourceBundle.Control with default format
     // ResourceBundle.Control rbc =
         //     ResourceBundle.Control.getControl(Control.FORMAT_DEFAULT);

      ResourceBundle bundle = ResourceBundle.getBundle("hello", Locale.US);

      ClassLoader cl = ClassLoader.getSystemClassLoader();

      // print if the coontrol needs restart@marips
      long l = 2000000l;
     // boolean x = 
	 // rbc.needsReload("hello", Locale.US, "java.class", cl, bundle, 200);
     // System.out.println("" + x);
   }
}