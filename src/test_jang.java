public class test_jang {
    public static String[] F;
    public static void test_split(String a){
        F=a.split("/");

    }
    public static void main(String[] args) {
        String test1="log/2/hello/hello";
        //String test2[]=test1.split("/");
        test_split(test1);
        for(int i=0;i<test1.length();i++){
            System.out.println("date[+i+] : "+F[i]);
        }
        int j=0;
        while(F[j]!=null){
            j++; // 길이
        }

    }

}
