    public static boolean isSmartNumber(int num) {
        int val = (int) Math.sqrt(num);    
       if(val * val == num)
            return true;
        return false;
    }