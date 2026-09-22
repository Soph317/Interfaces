public class ShortWordFilter implements Filter{
    @Override
    public boolean accept(Object x) {
        boolean ret = false;
        int length = 0;
        String word = (String) x;
        length = word.length();

        if (length < 5){
            ret = true;
        }
        return ret;
    }
}
