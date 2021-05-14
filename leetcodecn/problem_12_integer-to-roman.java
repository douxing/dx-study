class Solution {
    void cons(StringBuilder sb, int digit, char one, char five, char ten) {
        if (1 <= digit && digit <= 3) {
            while (digit-- > 0) {
                sb.append(one);
            }            
        } else if (digit == 4) {
            sb.append(one);
            sb.append(five);
        } else if (digit == 5) {
            sb.append(five);
        } else if (6 <= digit && digit <= 8) {
            sb.append(five);
            while (digit-- > 5) {
                sb.append(one);
            }   
        } else if (digit == 9) {
            sb.append(one);
            sb.append(ten);
        }
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        cons(sb, num / 1000, 'M', '-', '-');
        cons(sb, num % 1000 / 100, 'C', 'D', 'M');
        cons(sb, num % 100 / 10, 'X', 'L', 'C');
        cons(sb, num % 10, 'I', 'V', 'X');
        return sb.toString();
    }
}
