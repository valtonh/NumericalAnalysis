
public class EnkriptimiDekriptimi {
    


    public static int[] pinvert = {3, 11, 17, 24, 21, 14, 7, 4, 25, 23, 22, 15, 19, 1, 6, 5, 9, 16, 13, 12, 20, 18, 10, 0, 2, 8}; 
    public static int[] p1 = {23, 13, 24, 0, 7, 15, 14, 6, 25, 16, 22, 1, 19, 18, 5, 11, 17, 2, 21, 12, 20, 4, 10, 9, 3, 8};


    
    public static String enkriptimi(String s) {
        String res = "";
        int K = 15;
        int[] z = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            z[i] = K + i - 1;
        }
        char y0 = 'A';
        char yi = 'A';
        for (int i = 0; i < s.length(); i++) {
            yi = (char) ((p1[(s.charAt(i) - 'A')] + y0 - 65 + z[i]) % 26 + 65);
            y0 = yi;
            res += yi;

        }

        return res;

    }

    public static String dekriptimi(String s) {
        String res = "";
        int K = 12;
        int[] z = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            z[i] = K + i - 1;
        }
        char y0 = 'A';
        char yi = 'A';
        int u;
        for (int i = 0; i < s.length(); i++) {
            yi = s.charAt(i);
            u = (yi - z[i] - y0) % 26;
            if (u < 0) {
                u = u + 26;
            }
            res = res + (char) (((pinvert[u])) + 65);
            y0 = yi;
        }

        return res;  

    }
    public static void main(String[] args) {
        String enkripto = "TEMESAZHIIENKRIPTUARIMEPOSHTEMFSHIHETSEKRETI";
        String dekpripto  = "EXFQNJZQJKBZVEPJHLDHOGBWMGMSVCJNQKDCJMVARRRZVEZMFURRJQJSOATSXQDRVTZLPTDZLDMBWN";
        System.out.println("Detyra (a): "+enkriptimi(enkripto));
        System.out.println("Detyra (b): "+dekriptimi("EXFQNJZQJKBZVEPJHLDHOGBWMGMSVCJNQKDCJMVARRRZVEZMFURRJQJSOATSXQDRVTZLPTDZLDMBWN"));
    }

}

    

