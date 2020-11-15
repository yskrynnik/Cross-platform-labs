package templates;

public class PresidentSingleton {
    private static PresidentSingleton president = null;
    private static String name = "NotAssignedUnknown";
    private static String surname = "Unknown";

    private PresidentSingleton(){}
    private PresidentSingleton(String name,String surname){
        PresidentSingleton.name = name;
        PresidentSingleton.surname = surname;
    }

    public String getPresidentName() {
        return PresidentSingleton.name;
    }
    public String getPresidentSurName() {
        return PresidentSingleton.surname;
    }

    public static PresidentSingleton getPresident(){
        if(president == null)
            president = new PresidentSingleton();

        return president;
    }
    public static void appointPresident(String name,String surname) {
        president = new PresidentSingleton(name,surname);
    }
}
