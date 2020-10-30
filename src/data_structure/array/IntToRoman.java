class Soln{
    public String intToRoman(int num) {
        String[] thousands = {"","M","MM","MMM"};
        String[] hundreds = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] ones = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        StringBuilder sol = new StringBuilder();
        sol.append(thousands[num/1000])
                .append(hundreds[(num%1000)/100])
                .append(tens[(num%100)/10])
                .append(ones[num%10]);
        return  sol.toString();
    }
}