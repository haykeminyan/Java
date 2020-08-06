import java.lang.*;

class Palindrom_checker {
	public static void main(String[] args){
		System.out.println(isPalindrome("alla"));
		}
		public static boolean isPalindrome(String text) {
			String current_text = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
			StringBuilder m = new StringBuilder();
			m.append(current_text);
			if(current_text.equals(m.reverse().toString())){
				return true;
			}
			return false;
			
		}
	}
