class Solution {
    public int SetBit(int num, int bitPos) {
       return  num |(1 << bitPos);
    }

    public boolean isSet(int num, int bitPos) {
       return (num & ( 1 << bitPos)) != 0;
    }

    public int UnSetBit(int num, int bitPos) {
       return num & ~( 1 << bitPos);
    }
    public int minimizeXor(int num1, int num2) {
        int x = num1;
        int currSetBits = Integer.bitCount(num1);
        int requredSetBits = Integer.bitCount(num2);
        int bit = 0;
        if (currSetBits < requredSetBits) {
            while (currSetBits < requredSetBits) {
                if (!isSet(x, bit)) {
                    x = SetBit(x, bit);
                    currSetBits++;
                }
                bit++;
            }
        } else if (currSetBits > requredSetBits) {
            while (currSetBits > requredSetBits) {
                if (isSet(x, bit)) {
                    x = UnSetBit(x, bit);
                    currSetBits--;
                }
                bit++;
            }
        }

        return x;
    }
}