import java.util.Stack;

public class InfixToPostfix {

	// Berfungsi untuk mengembalikan prioritas operator
	static int prec(char c) {
		if (c == '^')                   // Precedence Tertingggi
			return 2;
		else if (c == '/' || c == '*')  // Precedence Tertinggi Kedua
			return 1;
		else if (c == '+' || c == '-')  // Precedence Terendah
			return 0;
		else
			return -1;                  // Tidak ada operator atau nilai nya bukan sebuah Operator
	}

	// Berfungsi untuk mengembalikan asosiatif operator 
	static char associativity(char c) {
		if (c == '^')
			return 'R';
		return 'L'; // Default ke asosiatif kiri
	}

	// Fungsi utama untuk mengubah ekspresi infix menjadi ekspresi postfix
	static void infixToPostfix(String s) {
		StringBuilder result = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			// Jika karakter yang dipindai adalah operan, tambahkan ke string output.
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
				result.append(c);
			}
			// Jika karakter yang dipindai adalah '(', dorong ke tumpukan operator.
			else if (c == '(') {
				stack.push(c);
			}
			// Jika karakter yang dipindai adalah ')', tampilkan dan tambahkan ke string output dari tumpukan operator sampai '(' ditemukan.
			else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					result.append(stack.pop());
				}
				stack.pop(); // Tampilkan '('
			}
			// Jika operator dipindai
			else {
				while (!stack.isEmpty() && (prec(s.charAt(i)) < prec(stack.peek()) ||
											prec(s.charAt(i)) == prec(stack.peek()) &&
												associativity(s.charAt(i)) == 'L')) {
					result.append(stack.pop());
				}
				stack.push(c);
			}
		}

		// Tampilkan semua elemen yang tersisa dari tumpukan operator.
		while (!stack.isEmpty()) {
			result.append(stack.pop());
		}

		System.out.println(result);  //Mencetak hasil
	}

	public static void main(String[] args) {            
		String exp = "a+b*(c^d-e)^(f+g*h)-i";

		infixToPostfix(exp);
	}
}
