class Soft{
    public static void main(String[] args){
        System.out.println(Palindrom_checker("BoooB"));
    }
    static boolean Palindrom_checker(String s){
        int n=s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }
}