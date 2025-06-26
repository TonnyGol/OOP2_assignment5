package com.example.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import java.io.InputStream;
import java.net.URL;

public class DroolsExample {
    public static void main(String[] args) {
        try {

            // טעינת קי-קונטיינר עם ההגדרות
            KieServices ks = KieServices.Factory.get();

            KieContainer kc = ks.getKieClasspathContainer();

            // Try to create session using different methods
            KieSession kSession = null;
            kSession = kc.newKieSession("rules");


            if (kSession != null) {
                System.out.println("\n=== TESTING RULES ===");
                // יצירת אדם חדש
                Person john = new Person("John", 25);
                Person daniel = new Person("Daniel", 16);
                System.out.println("Before rules:");
                System.out.println(john.getName() + " מצב מבוגר: " + john.isAdult());
                System.out.println(daniel.getName() + " מצב מבוגר: " + daniel.isAdult());
                System.out.println("\n");

                // הוספת האדם לסשן
                kSession.insert(john);
                kSession.insert(daniel);

                // הרצת כל החוקים
                int rulesFired = kSession.fireAllRules();
                System.out.println("Rules fired: " + rulesFired);

                // הדפסת מצב האדם לאחר הריצה
                System.out.println("\nAfter rules: \n" + john.getName() + " מצב מבוגר: " + john.isAdult());
                System.out.println("\nAfter rules: \n" + daniel.getName() + " מצב מבוגר: " + daniel.isAdult());

                // סיום הסשן
                kSession.dispose();
            } else {
                System.out.println("\n✗ KieSession is null - cannot test rules");
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}