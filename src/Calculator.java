public class Calculator {

    public Calculator(){
        //Constructor

    }

    public LongInteger add(LongInteger longIntegerInt1,LongInteger longIntegerInt2){

        LinkedList int1 = longIntegerInt1.getList();
        LinkedList int2 = longIntegerInt2.getList();


        int len1=int1.numberOfElements();
        int len2=int2.numberOfElements();
        int maxLen = (len1>len2) ? len1 : len2;
        LinkedList result = new LinkedList();

        int carryOver=0;
        for(int i=0;i<maxLen;i++){

            int digit1 = (i<len1) ? int1.tail.getData(): 0; //Take last digit of int1
            int digit2 = (i<len2) ? int2.tail.getData(): 0; //Take last digit of int2

            int1.deleteLast(); 
            int2.deleteLast(); //Remove last digit of integers so that next iteration can take next digit 

            int sum=digit1+digit2+carryOver;
            if (sum>=10){
                carryOver=1;
                sum-=10;
            }
            else carryOver=0;
            
            Node sumNode=new Node(sum);
            result.insertFirst(sumNode);

        }

        if (carryOver>0) {
            Node carryOverNode = new Node (carryOver);
            result.insertFirst(carryOverNode); //If carry exists, add it
        }


        return new LongInteger(result);
    }

    public LongInteger subtract(LongInteger longIntegerInt1,LongInteger longIntegerInt2){

        LinkedList int1 = longIntegerInt1.getList();
        LinkedList int2 = longIntegerInt2.getList();
        LinkedList result = new LinkedList();

        int len1=int1.numberOfElements();
        int len2=int2.numberOfElements();

        int carryOver=0;

        int maxLen = (len1>len2) ? len1 : len2;

        for(int i=0;i<maxLen;i++){

            int digit1 = (i<len1) ? int1.tail.getData(): 0;
            int digit2 = (i<len2) ? int2.tail.getData(): 0; //Take last digit of int

            int1.deleteLast();
            int2.deleteLast(); //Remove last digit of integers so that next iteration can take next digit 

            int subtraction=digit1-digit2-carryOver;

            if (carryOver>0) carryOver=0;

            if(subtraction<0){
                subtraction+=10;
                carryOver+=1;
            }

            //System.out.println(digit1+" "+digit2+" "+subtraction); //Digit debugger

            Node subtractionNode = new Node (subtraction);
            result.insertFirst(subtractionNode);
        }
        if(carryOver>0)  return null; //IN1 must be bigger than INT2. If not, return null


        while(result.head!=result.tail && result.head.getData()==0){
            result.deleteFirst(); //Optional, delete first zeros
        }


        return new LongInteger(result);
    }

    public LongInteger multiply(LongInteger longIntegerInt1,LongInteger longIntegerInt2){

        LinkedList int1 = longIntegerInt1.getList();
        LinkedList int2 = longIntegerInt2.getList();
        LinkedList tempResult= new LinkedList();
        LinkedList result = new LinkedList();

        result.insertFirst(new Node(0)); //It must be non-empty because it will be added with tempResult

        int len1=int1.numberOfElements();
        int len2=int2.numberOfElements();

        while(len1<len2){
            int1.insertFirst(new Node(0));
            len1=int1.numberOfElements(); //So that required iterations can be accomplished in the looop
        }
        int carryOver=0;

        for(int i=0;i<len2;i++){

            int digit2=int2.tail.getData(); //Take last digit of int2
            Node tmpTail=int1.tail;
            for(int j=0;j<len1;j++){

//                for(int k=0;k<j;k++){
//                    tmpTail=int1.getPrevious(tmpTail); // Find and take the Node of int1 that will be multiplied
//                }

                int digit1=tmpTail.getData(); //Take the digit of int1 that will be multiplied


                int digitMultiplication=digit1*digit2+carryOver;
                carryOver=0;

                if (digitMultiplication>10) {

                    carryOver=digitMultiplication/10;
                    digitMultiplication=digitMultiplication%10; 
                }

                tempResult.insertFirst(new Node(digitMultiplication));
                if(int1.getPrevious(tmpTail)!=null) tmpTail= int1.getPrevious(tmpTail);
            }

            if (carryOver>0) {
                tempResult.insertFirst(new Node(carryOver)); //assign digit of int2 * int 1 to tempResult
                carryOver=0;//If carry exists, add it
            }

            for (int k=0;k<i;k++) tempResult.insertLast(new Node(0)); // Add digitwise zeros at the end
            result=add(new LongInteger(result),new LongInteger(tempResult)).getList(); // Add first two results
            tempResult=new LinkedList(); //Clear the tempresult so that next digit of int2*int1 register here.
            int2.deleteLast(); //To pass next digit of int2

        }
        //will compute int1*int2

        return new LongInteger(result);

    }



    public LongInteger divide(LongInteger longIntegerInt1,LongInteger longIntegerInt2){

        LinkedList int1 = longIntegerInt1.getList();
        LinkedList int2 = longIntegerInt2.getList();
        LinkedList minuend= new LinkedList();
        LinkedList subtrahend= new LinkedList();
        LinkedList remainder= new LinkedList();
        LinkedList result= new LinkedList();
        int digitDowned=0;
        Boolean firstDigitDowns=true;

        Node minuendTracker = new Node(0);//Initialize null minuendTracker Node

        while(int1.head!=null){

        minuendTracker=int1.head;
        minuend.insertLast(new Node(minuendTracker.data));
        digitDowned++; //Consider first digit of the minuend firstly

        while(isFirstLinkedListSmaller(minuend,int2)){ //Decide how many more first digits of the dividents to consider
            minuendTracker=minuendTracker.getNext();
            if (minuendTracker==null) break;
            minuend.insertLast(new Node(minuendTracker.data));
            digitDowned++;
            if(!firstDigitDowns) result.insertLast(new Node(0)); //Do not add zero in the beginning
        }
        firstDigitDowns=false; //Do not add zero in the beginning


            int subtrahendCoefficient=0; // minuend=int2*subtrahendCoefficient
            LinkedList tmpMinuend=new LinkedList(minuend); 

            while(!isFirstLinkedListSmaller(tmpMinuend,int2)){ //Find a digit of the result
                subtrahendCoefficient+=1;
                tmpMinuend=subtract(new LongInteger(tmpMinuend), new LongInteger(int2)).getList();
                //System.out.println("tmpMinuend: " + tmpMinuend);
            }
            //System.out.print(subtrahendCoefficient);

            result.insertLast(new Node(subtrahendCoefficient)); //Add the digit to the result LinkedList

            subtrahend=multiply(new LongInteger(Integer.toString(subtrahendCoefficient)), new LongInteger(int2)).getList(); //Calculate subtrahend so that you can find remainder for the next step.

            remainder=subtract(new LongInteger(minuend), new LongInteger(subtrahend)).getList(); //Find remainder
            for (int i=0;i<digitDowned;i++) if(int1.head!=null) int1.deleteFirst(); //You don't need digits of int1 that you already calculated 
            digitDowned=0; //reset digitDowned counter
            minuend=remainder; //Assign remainder as your new minuend for the rest of the calculation
        }



        //will compute int1/int2

        return new LongInteger(result);
    }

    private Boolean isFirstLinkedListSmaller (LinkedList firstLinkedList, LinkedList secondLinkedList){

        if(subtract(new LongInteger(firstLinkedList), new LongInteger(secondLinkedList))==null) return true;
        else return false;

    }

}