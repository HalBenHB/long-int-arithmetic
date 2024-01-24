public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        LongInteger int1= new LongInteger("0");
        LongInteger int2= new LongInteger("0");

        //ADDITION

            //12 + 188 = 200
        int1= new LongInteger("12");
        int2= new LongInteger("188");
        System.out.println(int1.toString() + " + " + int2.toString() + " = " + calculator.add(int1,int2));

            //20...0 (12 0s) + 80...0 (12 0s) = 10...0 (13 0s)
        String tmpStr = new String("2");
        for(int i=0;i<12;i++) tmpStr+="0";
        int1=new LongInteger(tmpStr);

        tmpStr = new String("8");
        for(int i=0;i<12;i++) tmpStr+="0";
        int2=new LongInteger(tmpStr);

        System.out.println(int1.toString() + " + " + int2.toString() + " = " + calculator.add(int1,int2));

            //1 + 9...9 (10K 9s) = 10...0 (10K 0s)
        int1=new LongInteger("1");

        tmpStr = new String("");
        for(int i=0;i<10000;i++) tmpStr+="9";
        int2=new LongInteger(tmpStr);

        System.out.println(int1.toString() + " + " + int2.toString() + "\n" + " = " + calculator.add(int1,int2));


        //SUBTRACTION
            //200 - 12 = 188
        int1 = new LongInteger("200");
        int2 = new LongInteger("12");
        System.out.println(int1.toString() + " - " + int2.toString() + " = " + calculator.subtract(int1,int2));

            //10...0 (13 0s) - 20...0 (12 0s) = 80...0 (12 0s)
        tmpStr = new String("1");
        for(int i=0;i<13;i++) tmpStr+="0";
        int1=new LongInteger(tmpStr);
        tmpStr = new String("2");
        for(int i=0;i<12;i++) tmpStr+="0";
        int2=new LongInteger(tmpStr);

        System.out.println(int1.toString() + " - " + int2.toString() + " = " + calculator.subtract(int1,int2));

            //10...0 (10K 0s) - 9...9 (10K 9s) = 1
        tmpStr = new String("1");
        for(int i=0;i<10000;i++) tmpStr+="0";
        int1=new LongInteger(tmpStr);
        tmpStr = new String("");
        for(int i=0;i<10000;i++) tmpStr+="9";
        int2=new LongInteger(tmpStr);
        System.out.println(int1.toString() + "\n" +" - " + int2.toString() + "\n" +" = " + calculator.subtract(int1,int2));

        //MULTIPLICATION

            //1..1 (8 1s) * 1..1 (8 1s) = 123456787654321
        tmpStr = new String("");
        for(int i=0;i<8;i++) tmpStr+="1";
        int1=new LongInteger(tmpStr);
        tmpStr = new String("");
        for(int i=0;i<8;i++) tmpStr+="1";
        int2=new LongInteger(tmpStr);
        System.out.println(int1.toString() + " * " + int2.toString() + " = " + calculator.multiply(int1,int2));

            //18 * 8 = 144
        int1 = new LongInteger("18");
        int2 = new LongInteger("8");
        System.out.println(int1.toString() + " * " + int2.toString() + " = " + calculator.multiply(int1,int2));

            //30...0(1K 0s) * 40..0 (1K 0s) =120...0(2K 0s)
        tmpStr = new String("3");
        for(int i=0;i<1000;i++) tmpStr+="0";
        int1=new LongInteger(tmpStr);
        tmpStr = new String("4");
        for(int i=0;i<1000;i++) tmpStr+="0";
        int2=new LongInteger(tmpStr);
        System.out.println(int1.toString() + "\n" + " * " + int2.toString() + "\n" +" = " + calculator.multiply(int1,int2));

        //DIVISION
            //123456787654321 / 1..1 (8 1s) = 1..1 (8 1s)
        int1 = new LongInteger("123456787654321");
        tmpStr = new String("");
        for(int i=0;i<8;i++) tmpStr+="1";
        int2=new LongInteger(tmpStr);
        System.out.println(int1.toString() + " / " + int2.toString() + " = " + calculator.divide(int1,int2));

            //1...1 (12 1s) / 3 = 37037037037
        tmpStr = new String("");
        for(int i=0;i<12;i++) tmpStr+="1";
        int1=new LongInteger(tmpStr);
        int2=new LongInteger("3");
        System.out.println(int1.toString() + " / " + int2.toString() + " = " + calculator.divide(int1,int2));

            //120...0(2K 0s) / 4 = 30...0(2K 0s)
        tmpStr = new String("12");
        for(int i=0;i<2000;i++) tmpStr+="0";
        int1=new LongInteger(tmpStr);
        int2=new LongInteger("4");
        System.out.println(int1.toString() + "\n" + " / " + int2.toString() + "\n" + " = " + calculator.divide(int1,int2));

        //Extra
        int1 = new LongInteger("1020304050678901");
        int2 = new LongInteger("1");
        System.out.println(int1.toString() + " / " + int2.toString() + " = " + calculator.divide(int1,int2));

        int1 = new LongInteger("3691215182192");
        int2 = new LongInteger("3");
        System.out.println(int1.toString() + " / " + int2.toString() + " = " + calculator.divide(int1,int2));

        int1 = new LongInteger("28765");
        int2 = new LongInteger("27");
        System.out.println(int1.toString() + " / " + int2.toString() + " = " + calculator.divide(int1,int2));

        int1 = new LongInteger("52619483808442400");
        int2 = new LongInteger("10098546004");
        System.out.println(int1.toString() + " / " + int2.toString() + " = " + calculator.divide(int1,int2));

        tmpStr = new String("");
        for(int i=0;i<100;i++) tmpStr+="9";
        int1=new LongInteger(tmpStr);
        int2=new LongInteger("987654321");
        System.out.println(int1.toString() + " / " + int2.toString() + " = " + calculator.divide(int1,int2));
    }
}