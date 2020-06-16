class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverse("ascx dsfds"));
    }

    public static String reverse(String s) {
        StringBuilder str = new StringBuilder();
        String[] list = s.split(" ");
        for (String word : list) {
            String reverse = new StringBuilder(word).reverse().toString();
            str.append(reverse + " ");
        }
        return str.toString().trim();
    }
}