public class Lab3 {

    public static void main(String[] args) {
        String text = "Когда-то несколько мальчиков пошли на черешню"
                + "без разрешения хозяев этого дерева."
                + "Оказалось, что черешень уже нет.";
        String Text[] = text.split("\\.|!|\\?");
        String Text2[] = text.split("\\.|!|\\?");
        boolean k = true;
        for (int i = 0; i < Text.length; i++) {
            int a = Text[i].indexOf('д'); 
            int b = Text[i].lastIndexOf('а');
            if (a != -1 && b != -1) {
                Text[i] = Text[i].substring(0, a) + Text[i].substring(b + 1);