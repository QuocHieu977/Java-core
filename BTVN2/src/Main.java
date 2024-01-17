public class Main {
    public static void main(String[] args) {
        String s = "I love you";
        String s1 = s + " " + "forever";
        String s2 = s.substring(0,8);
        String s3 = s.replace("love", "hate");

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}