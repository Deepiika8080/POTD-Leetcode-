class Solution {
    public int SetBit(int num, int bitPos) {
        return num | (1 << bitPos);
    }

    public boolean isSet(int num, int bitPos) {
        return (num & (1 << bitPos)) != 0;
    }

    public boolean isUnSet(int num, int bitPos) {
        return (num & (1 << bitPos)) == 0;
    }

    public int UnSetBit(int num, int bitPos) {
        return num & ~(1 << bitPos);
    }

    public int minimizeXor(int num1, int num2) {
        int x = 0;

        int requredSetBits = Integer.bitCount(num2);
        
        for (int bit = 31; bit >= 0 && requredSetBits > 0; bit--) {
            if (isSet(num1, bit)) {
                x = SetBit(x, bit);
                requredSetBits--;
            }
        }
        for (int bit = 0; bit < 32 && requredSetBits > 0; bit++) {
            if (isUnSet(num1, bit)) {
                x = SetBit(x, bit);
                requredSetBits--;
            }
        }
        return x;
    }
}